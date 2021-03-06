/*******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2012 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.trans.steps.execprocess;

import org.pentaho.di.core.Const;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.row.RowDataUtil;
import org.pentaho.di.i18n.BaseMessages;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import org.pentaho.di.trans.step.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Execute a process *
 * 
 * @author Samatar
 * @since 03-11-2008
 */

public class ExecProcess extends BaseStep implements StepInterface {
	private static Class<?> PKG = ExecProcessMeta.class; // for i18n purposes,
															// needed by
															// Translator2!!
															// $NON-NLS-1$

	private ExecProcessMeta meta;
	private ExecProcessData data;

	public ExecProcess(StepMeta stepMeta, StepDataInterface stepDataInterface,
			int copyNr, TransMeta transMeta, Trans trans) {
		super(stepMeta, stepDataInterface, copyNr, transMeta, trans);
	}

	public boolean processRow(StepMetaInterface smi, StepDataInterface sdi)
			throws KettleException {
		meta = (ExecProcessMeta) smi;
		data = (ExecProcessData) sdi;

		Object[] r = getRow(); // Get row from input rowset & set row busy!
		if (r == null) // no more input to be expected...
		{
			setOutputDone();
			return false;
		}

		if (first) {
			first = false;
			// get the RowMeta
			data.previousRowMeta = getInputRowMeta().clone();
			data.NrPrevFields = data.previousRowMeta.size();
			data.outputRowMeta = data.previousRowMeta;
			meta.getFields(data.outputRowMeta, getStepname(), null, null, this);

			// Check is process field is provided
			if (Const.isEmpty(meta.getProcessField())) {
				logError(BaseMessages.getString(PKG,
						"ExecProcess.Error.ProcessFieldMissing"));
				throw new KettleException(BaseMessages.getString(PKG,
						"ExecProcess.Error.ProcessFieldMissing"));
			}

			// cache the position of the field
			if (data.indexOfProcess < 0) {
				data.indexOfProcess = data.previousRowMeta.indexOfValue(meta
						.getProcessField());
				if (data.indexOfProcess < 0) {
					// The field is unreachable !
					logError(BaseMessages.getString(PKG,
							"ExecProcess.Exception.CouldnotFindField") + "[" + meta.getProcessField() + "]"); //$NON-NLS-1$ //$NON-NLS-2$
					throw new KettleException(
							BaseMessages
									.getString(
											PKG,
											"ExecProcess.Exception.CouldnotFindField", meta.getProcessField())); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}// End If first

		Object[] outputRow = RowDataUtil.allocateRowData(data.outputRowMeta
				.size());
		for (int i = 0; i < data.NrPrevFields; i++) {
			outputRow[i] = r[i];
		}
		// get process to execute
		String processString = data.previousRowMeta.getString(r,
				data.indexOfProcess);

		ProcessResult processResult = new ProcessResult();

		try {
			if (Const.isEmpty(processString))
				throw new KettleException(BaseMessages.getString(PKG,
						"ExecProcess.ProcessEmpty"));

			// execute and return result
			execProcess(processString, processResult);

			if (meta.isFailWhenNotSuccess()) {
				if (processResult.getExistStatus() != 0) {
					String errorString = processResult.getErrorStream();
					if (Const.isEmpty(errorString)) {
						errorString = processResult.getOutputStream();
					}
					throw new KettleException(errorString);
				}
			}

			// Add result field to input stream
			int rowIndex = data.NrPrevFields;
			outputRow[rowIndex++] = processResult.getOutputStream();

			// Add result field to input stream
			outputRow[rowIndex++] = processResult.getErrorStream();

			// Add result field to input stream
			outputRow[rowIndex++] = processResult.getExistStatus();

			// add new values to the row.
			putRow(data.outputRowMeta, outputRow); // copy row to output
													// rowset(s);

			if (log.isRowLevel())
				logRowlevel(BaseMessages.getString(PKG,
						"ExecProcess.LineNumber", getLinesRead() + " : "
								+ getInputRowMeta().getString(r)));
		} catch (KettleException e) {

			boolean sendToErrorRow = false;
			String errorMessage = null;

			if (getStepMeta().isDoingErrorHandling()) {
				sendToErrorRow = true;
				errorMessage = e.toString();
			} else {
				logError(BaseMessages.getString(PKG,
						"ExecProcess.ErrorInStepRunning") + e.getMessage()); //$NON-NLS-1$
				setErrors(1);
				stopAll();
				setOutputDone(); // signal end to receiver(s)
				return false;
			}
			if (sendToErrorRow) {
				// Simply add this row to the error row
				putError(getInputRowMeta(), r, 1, errorMessage,
						meta.getResultFieldName(), "ExecProcess001");
			}
		}

		return true;
	}

	private void execProcess(String process, ProcessResult processresult)
			throws KettleException {

		Process p = null;
		try {
			String errorMsg = null;
			// execute process
			try {
				p = data.runtime.exec(process);
			} catch (Exception e) {
				errorMsg = e.getMessage();
			}
			;
			if (p == null) {
				processresult.setErrorStream(errorMsg);
			} else {

				StringBuffer errorString = new StringBuffer();
				getOutputThreed(errorString, p.getErrorStream());

				StringBuffer outputString = new StringBuffer();
				getOutputThreed(outputString, p.getInputStream());

				// Wait until end
				p.waitFor();

				// get output stream
				processresult.setOutputStream(outputString.toString());
				// get error message
				processresult.setErrorStream(errorString.toString());

				// get exit status
				processresult.setExistStatus(p.exitValue());
			}
		} catch (IOException ioe) {
			throw new KettleException("IO exception while running the process "
					+ process + "!", ioe);
		} catch (InterruptedException ie) {
			throw new KettleException(
					"Interrupted exception while running the process "
							+ process + "!", ie);
		} catch (Exception e) {
			throw new KettleException(e);
		} finally {
			if (p != null)
				p.destroy();
		}
	}

	private Thread getOutputThreed(final StringBuffer retvalBuff,
			final InputStream is) throws IOException {

		Thread t = new Thread() {
			public void run() {
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				try {
					String line1 = null;
					while ((line1 = br.readLine()) != null) {
						if (line1 != null) {
							retvalBuff.append(line1);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {

					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

					try {
						isr.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();

		return t;
	}

	public boolean init(StepMetaInterface smi, StepDataInterface sdi) {
		meta = (ExecProcessMeta) smi;
		data = (ExecProcessData) sdi;

		if (super.init(smi, sdi)) {
			if (Const.isEmpty(meta.getResultFieldName())) {
				logError(BaseMessages.getString(PKG,
						"ExecProcess.Error.ResultFieldMissing"));
				return false;
			}
			data.runtime = Runtime.getRuntime();
			return true;
		}
		return false;
	}

	public void dispose(StepMetaInterface smi, StepDataInterface sdi) {
		meta = (ExecProcessMeta) smi;
		data = (ExecProcessData) sdi;

		super.dispose(smi, sdi);
	}

}
