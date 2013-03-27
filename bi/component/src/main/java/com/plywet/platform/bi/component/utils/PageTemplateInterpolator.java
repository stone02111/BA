package com.plywet.platform.bi.component.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.xml.XMLHandler;
import org.w3c.dom.Node;

import com.plywet.platform.bi.core.exception.BIPageException;
import com.plywet.platform.bi.core.utils.XmlUtils;
import com.plywet.platform.bi.el.expression.Expression;
import com.plywet.platform.bi.el.expression.ExpressionString;
import com.plywet.platform.bi.el.parser.ELParser;

/**
 * 进行参数替换的工具类
 * 
 * @author PeterPan
 * 
 */
public class PageTemplateInterpolator {

	public static Object[] interpolate(String fileUrl, FLYVariableResolver attrs)
			throws BIPageException {
		return interpolate(fileUrl, new ArrayList<String>(), attrs, null);
	}

	public static Object[] interpolate(String fileUrl,
			FLYVariableResolver attrs, String nodeId) throws BIPageException {
		return interpolate(fileUrl, new ArrayList<String>(), attrs, nodeId);
	}

	/**
	 * 直接传入的url对应的文件内容进行参数替换
	 * 
	 * @param fileUrl
	 * @param attrs
	 * @return
	 * @throws IOException
	 */
	public static Object[] interpolate(String fileUrl, List<String> script,
			FLYVariableResolver attrs) throws BIPageException {
		return interpolate(fileUrl, script, attrs, null);
	}

	public static Object[] interpolate(String fileUrl, List<String> script,
			FLYVariableResolver attrs, String nodeId) throws BIPageException {
		try {
			String domString = PageTemplateCache.getDomByUrl(fileUrl);
			if (domString == null) {
				domString = FLYPageTemplateUtils
						.readPageTemplateFileContent(fileUrl);
				PageTemplateCache.put(fileUrl, domString);
			}

			if (domString == null) {
				return new Object[] { StringUtils.EMPTY, "" };
			}

			if (!StringUtils.contains(domString, HTML.COMPONENT_TYPE_FLY_PREFIX)) {
				String html = interpolateExpressions(domString, attrs);
				return new Object[] { html, script };
			}

			// 首先解析成dom对象进行替换
			Node doc = XMLHandler.loadXMLFile(new ByteArrayInputStream(
					domString.getBytes(Const.XML_ENCODING)));
			HTMLWriter html = HTMLWriter.instance();
			if (nodeId != null && !"".equals(nodeId)) {
				doc = XmlUtils.getSubNodeById(doc, nodeId);
				PageTemplateResolverType.replaceAll(doc, html, script, attrs,
						fileUrl);
			} else {
				PageTemplateResolver
						.resolver(doc, html, script, attrs, fileUrl);
			}

			return new Object[] { html.toString(), script };
		} catch (Exception e) {
			throw new BIPageException("解析页面标签出现错误.", e);
		}
	}

	/**
	 * 替换字符串中的表达式
	 * 
	 * @param string
	 *            目标替换的字符串
	 * @param attrs
	 *            参数
	 * @return
	 * @throws BIPageException
	 */
	public static String interpolateExpressions(String string,
			FLYVariableResolver attrs) throws BIPageException {
		StringTokenizer tokens = new StringTokenizer(string, "${}", true);
		StringBuilder builder = new StringBuilder(string.length());
		while (tokens.hasMoreTokens()) {
			String tok = tokens.nextToken();

			if (!"$".equals(tok) || !tokens.hasMoreTokens()) {
				builder.append(tok);
				continue;
			}

			// 1.如果是$
			String nextTok = tokens.nextToken();

			// 2.如果下一个也是$，将其进栈，待下次循环处理，直到最底层进行后续处理
			while (nextTok.equals("$") && tokens.hasMoreTokens()) {
				builder.append(tok);
				nextTok = tokens.nextToken();
			}

			// 3.如果下一个是{
			if ("{".equals(nextTok)) {
				String attr = tokens.nextToken();

				builder.append(evaluate("${" + attr + "}", attrs));

				// 丢弃后面一个}
				tokens.nextToken();

			}
			// 4.如果下一个是其他，则直接当做非关键字显示
			else {
				builder.append(tok).append(nextTok);
			}
		}

		return builder.toString();
	}

	public static String evaluate(String input, FLYVariableResolver resolver) {
		try {
			StringReader rdr = new StringReader(input);
			ELParser parser = new ELParser(rdr);
			Object result = parser.ExpressionString();
			if (result instanceof String) {
				return (String) result;
			} else if (result instanceof Expression) {
				Expression expr = (Expression) result;
				result = expr.evaluate(resolver, FLYFunctionMapper.singleton);
				return result == null ? null : result.toString();
			} else if (result instanceof ExpressionString) {
				ExpressionString expr = (ExpressionString) result;
				result = expr.evaluate(resolver, FLYFunctionMapper.singleton);
				return result == null ? null : result.toString();
			} else {
				throw new RuntimeException(
						"无效的解析类型：非 String、Expression、ExpressionString");
			}
		} catch (Exception pe) {
			throw new RuntimeException("解析EL表达式出现异常: " + pe.getMessage(), pe);
		}
	}

	public static Object evaluateObject(String input,
			FLYVariableResolver resolver) {
		try {
			if (input == null)
				return null;
			StringReader rdr = new StringReader(input);
			ELParser parser = new ELParser(rdr);
			Object result = parser.ExpressionString();
			if (result instanceof String) {
				return (String) result;
			} else if (result instanceof Expression) {
				Expression expr = (Expression) result;
				result = expr.evaluate(resolver, FLYFunctionMapper.singleton);
				return result;
			} else if (result instanceof ExpressionString) {
				ExpressionString expr = (ExpressionString) result;
				result = expr.evaluate(resolver, FLYFunctionMapper.singleton);
				return result;
			} else {
				throw new RuntimeException(
						"无效的解析类型：非 String、Expression、ExpressionString");
			}
		} catch (Exception pe) {
			throw new RuntimeException("解析EL表达式出现异常: " + pe.getMessage(), pe);
		}
	}

}