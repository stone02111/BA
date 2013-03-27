package com.plywet.platform.bi.component.resolvers.base;

import java.io.File;
import java.util.List;

import org.w3c.dom.Node;

import com.plywet.platform.bi.component.core.ComponentResolverInterface;
import com.plywet.platform.bi.component.resolvers.BaseComponentResolver;
import com.plywet.platform.bi.component.utils.FLYPageTemplateUtils;
import com.plywet.platform.bi.component.utils.FLYVariableResolver;
import com.plywet.platform.bi.component.utils.HTML;
import com.plywet.platform.bi.component.utils.HTMLWriter;
import com.plywet.platform.bi.component.utils.PageTemplateInterpolator;
import com.plywet.platform.bi.core.exception.BIPageException;

public class IncludeResolver extends BaseComponentResolver implements
		ComponentResolverInterface {

	@Override
	public void renderSub(Node node, HTMLWriter html, List<String> script,
			FLYVariableResolver attrs, String fileUrl) throws BIPageException {
		String src = HTML.getTagAttribute(node, HTML.ATTR_SRC, attrs);
		src = FLYPageTemplateUtils.reletivePathCal(
				new File(fileUrl).getParent(), src);
		Object[] includeText = PageTemplateInterpolator.interpolate(src,
				script, attrs);
		html.writeText((String) includeText[0]);
	}
}