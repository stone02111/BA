package com.flywet.platform.bi.component.components.tab;

import java.util.List;

import com.flywet.platform.bi.component.components.BaseComponentMeta;
import com.flywet.platform.bi.component.core.ComponentMetaInterface;
import com.flywet.platform.bi.component.utils.HTML;
import com.flywet.platform.bi.component.utils.HTMLWriter;

public class TabNode extends BaseComponentMeta implements
		ComponentMetaInterface {

	private String id;

	private String title;

	private HTMLWriter contentHtml;

	private List<String> contentScript;

	@Override
	public String[] getAttributesName() {
		return null;
	}

	@Override
	public String getComponentType() {
		return HTML.COMPONENT_TYPE_TAB;
	}

	public HTMLWriter getContentHtml() {
		return contentHtml;
	}

	public void setContentHtml(HTMLWriter contentHtml) {
		this.contentHtml = contentHtml;
	}

	public List<String> getContentScript() {
		return contentScript;
	}

	public void setContentScript(List<String> contentScript) {
		this.contentScript = contentScript;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
