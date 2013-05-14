package com.plywet.platform.bi.component.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.pentaho.di.core.Const;
import org.pentaho.di.core.exception.KettleXMLException;
import org.pentaho.di.core.xml.XMLHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.plywet.platform.bi.component.core.ComponentAttributeInterface;
import com.plywet.platform.bi.component.core.ComponentResolverInterface;
import com.plywet.platform.bi.component.resolvers.base.HTMLComponentResolver;
import com.plywet.platform.bi.component.vo.ComponentAttribute;
import com.plywet.platform.bi.component.vo.ComponentPlugin;
import com.plywet.platform.bi.core.exception.BIPageException;
import com.plywet.platform.bi.core.utils.FileUtils;
import com.plywet.platform.bi.core.utils.Utils;

public class PageTemplateResolverType {

	public static final String XML_FILE_FLY_COMPONENTS = "META-INF/fly-composition.xml";
	public static final String XML_FILE_FLY_COMPONENTS_ENTITY_PREFIX = "META-INF/entities/";
	public static final String XML_FILE_FLY_COMPONENTS_ATTRIBUTE_PREFIX = "META-INF/entities/attributes/";

	private static final ComponentResolverInterface htmlResolver = new HTMLComponentResolver();

	private static Map<String, ComponentPlugin> plugins;

	private static Map<String, List<ComponentPlugin>> categories;

	private static List<String> categoryNames;
	private static List<String> categoryCodes;

	private static AtomicBoolean init = new AtomicBoolean(false);

	public static void init() throws BIPageException {
		try {
			if (!init.get()) {
				plugins = new HashMap<String, ComponentPlugin>();
				categories = new HashMap<String, List<ComponentPlugin>>();
				categoryNames = new ArrayList<String>();
				categoryCodes = new ArrayList<String>();

				Document document = getXMLDocument(XML_FILE_FLY_COMPONENTS);
				Node componentsNode = XMLHandler.getSubNode(document,
						"components");
				List<Node> componentNodes = XMLHandler.getNodes(componentsNode,
						"component");
				for (Node componentNode : componentNodes) {
					initComponent(componentNode.getTextContent());
				}

				init.set(true);
			}
		} catch (Exception e) {
			throw new BIPageException("无法读取组件集成XML配置文件: "
					+ XML_FILE_FLY_COMPONENTS, e);
		}
	}

	private static void initComponent(String componentFilename)
			throws BIPageException {

		try {
			Document document = getComponentDocument(XML_FILE_FLY_COMPONENTS_ENTITY_PREFIX
					+ componentFilename);
			Node componentNode = XMLHandler.getSubNode(document, "component");
			String id = XMLHandler.getTagAttribute(componentNode, "id");
			ComponentPlugin p = ComponentPlugin.instance(componentNode);
			plugins.put(id.toLowerCase(), p);
			if (!categories.containsKey(p.getCategory())) {
				categories.put(p.getCategory(),
						new ArrayList<ComponentPlugin>());
				categoryNames.add(p.getCategorydesc());
				categoryCodes.add(p.getCategory());
			}
			categories.get(p.getCategory()).add(p);
		} catch (Exception e) {
			throw new BIPageException("无法读取组件XML配置文件: " + componentFilename, e);
		}
	}

	public static boolean containComponent(String pn) {
		if (pn == null) {
			return false;
		}
		return plugins.containsKey(pn.toLowerCase());
	}

	public static boolean containComponentAttribute(String pn, String attr) {
		if (pn == null || attr == null) {
			return false;
		}
		ComponentPlugin p = getPlugin(pn.toLowerCase());
		if (p != null) {
			return p.containAttribute(attr);
		}
		return false;
	}

	/**
	 * 获得组件属性的默认值
	 * 
	 * @param pn
	 * @param attr
	 * @return
	 */
	public static <T> T getComponentDefaultAttribute(String pn, String attr) {
		if (pn == null || attr == null) {
			return null;
		}
		ComponentPlugin p = getPlugin(pn);
		if (p != null) {
			ComponentAttributeInterface ca = p.getAttribute(attr);
			if (ca instanceof ComponentAttribute) {
				return ((ComponentAttribute) ca).getDefaultValue();
			}
		}
		return null;
	}

	/**
	 * 获得XML的Document对象
	 * 
	 * @param filename
	 * @return
	 * @throws KettleXMLException
	 * @throws FileNotFoundException
	 */
	private static Document getXMLDocument(String filename)
			throws KettleXMLException, FileNotFoundException {
		return XMLHandler.loadXMLFile(FileUtils.getInputStream(filename,
				PageTemplateResolverType.class), null, true, false);
	}

	/**
	 * 获得组件的XML的Document对象
	 * 
	 * @param filename
	 * @return
	 * @throws IOException
	 * @throws KettleXMLException
	 */

	private static Document getComponentDocument(String filename)
			throws IOException, KettleXMLException {
		return XMLHandler.loadXMLString(getComponentString(filename));
	}

	private static String getComponentString(String filename)
			throws IOException, KettleXMLException {
		// 获得输入流
		InputStream is = FileUtils.getInputStream(filename,
				PageTemplateResolverType.class);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			// 获得行，进行判断替换属性
			String xml = "", line;
			while ((line = br.readLine()) != null) {
				// 如果匹配，用具体内容替换
				line = Utils.trim(line);
				if (line.startsWith("&")) {
					line = getComponentString(XML_FILE_FLY_COMPONENTS_ATTRIBUTE_PREFIX
							+ line.substring(1) + ".xml");
				}
				xml += line;
			}
			return xml;

		} finally {
			br.close();
			isr.close();
			is.close();
		}

	}

	public static ComponentPlugin getPlugin(String name) {
		if (plugins != null && name != null) {
			return plugins.get(name.toLowerCase());
		}
		return null;
	}

	public static Map<String, ComponentPlugin> getPlugins()
			throws BIPageException {
		init();
		return plugins;
	}

	public static Map<String, List<ComponentPlugin>> getCategories()
			throws BIPageException {
		init();
		return categories;
	}

	public static List<String> getCategoryNames() throws BIPageException {
		init();
		return categoryNames;
	}

	public static List<String> getCategoryCodes() throws BIPageException {
		init();
		return categoryCodes;
	}

	public static void replaceAll(Node node, HTMLWriter html,
			List<String> script, FLYVariableResolver attrs, String fileUrl)
			throws BIPageException {

		String nodeName = node.getNodeName();
		if (nodeName.startsWith(HTML.COMPONENT_TYPE_FLY_PREFIX)) {
			if (getPlugins().containsKey(nodeName.toLowerCase())) {
				getPlugins().get(nodeName.toLowerCase()).getResolver().render(
						node, html, script, attrs, fileUrl);
				return;
			}
		} else if (nodeName.equals("#text")) {
			html.writeText(PageTemplateInterpolator.interpolateExpressions(
					Const.removeTAB(Const.removeCRLF(node.getNodeValue())),
					attrs));
			return;
		}
		htmlResolver.render(node, html, script, attrs, fileUrl);

	}

}