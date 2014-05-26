package com.flywet.platform.bi.pivot.model.data;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.xml.XMLHandler;
import org.w3c.dom.Node;

import com.flywet.platform.bi.core.exception.BIException;
import com.flywet.platform.bi.pivot.model.IJSONObjectable;
import com.tonbeller.wcf.controller.RequestContext;

public class NormalDataData implements IJSONObjectable {
	public static final String PROP_NAME_ROW = "row";
	public static final String PROP_NAME_CELL = "cell";

	List<List<NormalDataDataCell>> cells;

	public static NormalDataData instance(Node node) {
		NormalDataData b = new NormalDataData();

		b.cells = new ArrayList<List<NormalDataDataCell>>();

		List<Node> rowsNode = XMLHandler.getNodes(node, PROP_NAME_ROW);

		for (Node rowNode : rowsNode) {
			List<NormalDataDataCell> row = new ArrayList<NormalDataDataCell>();
			List<Node> cellsNode = XMLHandler.getNodes(rowNode, PROP_NAME_CELL);
			for (Node cellNode : cellsNode) {
				row.add(NormalDataDataCell.instance(cellNode));
			}
			b.cells.add(row);
		}

		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject renderJo(RequestContext context) throws BIException {
		JSONObject jo = new JSONObject();

		JSONArray rowsJa = new JSONArray();
		for (List<NormalDataDataCell> row : cells) {
			JSONArray rowJa = new JSONArray();
			for (NormalDataDataCell cell : row) {
				rowJa.add(cell.renderJo(context));
			}
			rowsJa.add(rowJa);
		}

		jo.put(PROP_NAME_ROW, rowsJa);

		return jo;
	}
}

class NormalDataDataCell implements IJSONObjectable {

	public static final String PROP_NAME_COLSPAN = "colspan";
	public static final String PROP_NAME_ROWSPAN = "rowspan";
	public static final String PROP_NAME_STYLE = "style";
	public static final String PROP_NAME_VALUE = "value";

	Integer colspan;
	Integer rowspan;
	String style;
	String val;

	public static NormalDataDataCell instance(Node node) {
		NormalDataDataCell cell = new NormalDataDataCell();

		String colspan = XMLHandler.getTagAttribute(node, PROP_NAME_COLSPAN);
		if (colspan != null) {
			cell.colspan = Integer.valueOf(colspan);
		}

		String rowspan = XMLHandler.getTagAttribute(node, PROP_NAME_ROWSPAN);
		if (rowspan != null) {
			cell.rowspan = Integer.valueOf(rowspan);
		}

		cell.style = Const.trim(XMLHandler.getTagAttribute(node,
				PROP_NAME_STYLE));
		cell.val = Const
				.trim(XMLHandler.getTagAttribute(node, PROP_NAME_VALUE));

		return cell;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject renderJo(RequestContext context) throws BIException {
		JSONObject jo = new JSONObject();

		if (colspan != null) {
			jo.put(PROP_NAME_COLSPAN, colspan);
		}
		if (rowspan != null) {
			jo.put(PROP_NAME_ROWSPAN, rowspan);
		}
		if (style != null) {
			jo.put(PROP_NAME_STYLE, style);
		}
		if (val != null) {
			jo.put(PROP_NAME_VALUE, val);
		}

		return jo;
	}
}