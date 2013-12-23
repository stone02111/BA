package com.flywet.platform.bi.pivot.model.olap.model.impl;

import java.text.DecimalFormat;

import com.flywet.platform.bi.pivot.model.olap.model.Cell;
import com.flywet.platform.bi.pivot.model.olap.model.CellFormatter;

/**
 * this is an example for the cell formatting exit returns hhh:mm:ss for the
 * value beeing number of seconds hhh = hours mm = minutes ss = seconds
 */
public class CF_hhhmmss implements CellFormatter {

	static DecimalFormat f00 = new DecimalFormat("00");

	public String formatCell(Cell cell) {
		long longVal = objToLong(cell.getValue());

		long hours = longVal / 3600;
		long secs = longVal % 3600;
		long mins = secs / 60;
		secs = secs % 60;
		String str = Long.toString(hours) + ":" + f00.format(mins) + ":"
				+ f00.format(secs);
		return str;
	}

	public static long objToLong(Object obj) {
		long longVal;
		if (obj instanceof Double)
			longVal = ((Double) obj).longValue();
		else if (obj instanceof Long)
			longVal = ((Long) obj).longValue();
		else if (obj instanceof Integer)
			longVal = ((Integer) obj).longValue();
		else if (obj instanceof String)
			longVal = Long.parseLong((String) obj);
		else
			longVal = 0;
		return longVal;
	}
} // CellFormat
