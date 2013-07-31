package com.flywet.platform.bi.component.resolvers.item;

import java.util.List;

import org.pentaho.di.core.Const;
import org.w3c.dom.Node;

import com.flywet.platform.bi.component.components.browse.BrowseMeta;
import com.flywet.platform.bi.component.core.ComponentResolverInterface;
import com.flywet.platform.bi.component.resolvers.BaseComponentResolver;
import com.flywet.platform.bi.component.utils.FLYVariableResolver;
import com.flywet.platform.bi.component.utils.HTML;
import com.flywet.platform.bi.core.exception.BIJSONException;
import com.flywet.platform.bi.core.exception.BIPageException;

public class FLYBrowseResolver extends BaseComponentResolver implements
		ComponentResolverInterface {

	public void renderScript(Node node, List<String> script,
			FLYVariableResolver attrs, String fileUrl) throws BIPageException {
		try {
			BrowseMeta browse = (BrowseMeta) HTML.getTagAttributeObject(node,
					HTML.ATTR_VALUE, attrs);
			String target = HTML.getTagAttribute(node, HTML.ATTR_TARGET, attrs);
			if (!Const.isEmpty(target)) {
				browse.setId(target);
				script
						.add("Flywet.cw(\"BrowsePanel\", \"" + target
								+ "_var\", "
								+ browse.getFormJo().toJSONString() + ");");
			}
		} catch (BIJSONException e) {
			throw new BIPageException(e);
		}

	}

}