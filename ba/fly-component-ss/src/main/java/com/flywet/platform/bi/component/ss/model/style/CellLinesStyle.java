package com.flywet.platform.bi.component.ss.model.style;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.flywet.platform.bi.component.ss.model.Line;
import com.flywet.platform.bi.component.ss.model.def.DefaultConst;
import com.flywet.platform.bi.component.ss.model.def.DefaultSetting;

public class CellLinesStyle implements ICellLinesStyle {

	// 顺序按照：上、下、左、右、对角线、反斜线、水平、垂直
	private final Line[] lines;

	// 缓存
	private static Map<String, SoftReference<ICellLinesStyle>> CACHE = new ConcurrentHashMap<String, SoftReference<ICellLinesStyle>>();

	private final String _uuid;

	private CellLinesStyle(Line[] lines) {
		this.lines = lines;
		this._uuid = createUUID(lines);
	}

	private static String createUUID(Line[] lines) {
		String result = lines[0].getUUID();
		for (int i = 1; i < lines.length; i++) {
			result = result + "," + lines[i].getUUID();
		}
		return result;
	}

	@Override
	public String getUUID() {
		return _uuid;
	}

	public static ICellLinesStyle getDefaultInstance() {
		return getInstance(null);
	}

	public static ICellLinesStyle getInstance(Line[] lines) {
		int i = 0;
		Line[] rtn = new Line[8];
		if (lines != null) {
			for (; i < lines.length && i < 8; i++) {
				rtn[i] = ((lines[i] == null) ? DefaultSetting.DEFAULT_LINE
						: lines[i]);
			}
		}
		for (; i < 8; i++) {
			rtn[i] = DefaultSetting.DEFAULT_LINE;
		}

		String key = createUUID(rtn);

		ICellLinesStyle linesStyle = matchCache(key);
		if (linesStyle == null) {
			linesStyle = new CellLinesStyle(rtn);
			putCache(key, linesStyle);
		}

		return linesStyle;
	}

	private static ICellLinesStyle matchCache(String key) {
		SoftReference<ICellLinesStyle> ref = CACHE.get(key);
		if (ref != null) {
			return ref.get();
		}
		return null;
	}

	private static void putCache(String key, ICellLinesStyle cls) {
		CACHE.put(key, new SoftReference<ICellLinesStyle>(cls));
	}

	public static void clearCache() {
		CACHE.clear();
	}

	@Override
	public Line getUp() {
		return lines[DefaultConst.LINE_UP_INDEX];
	}

	@Override
	public Line getDown() {
		return lines[DefaultConst.LINE_DOWN_INDEX];
	}

	@Override
	public Line getLeft() {
		return lines[DefaultConst.LINE_LEFT_INDEX];
	}

	@Override
	public Line getRight() {
		return lines[DefaultConst.LINE_RIGHT_INDEX];
	}

	@Override
	public Line getDiagonal() {
		return lines[DefaultConst.LINE_DIAGONAL_INDEX];
	}

	@Override
	public Line getBackslash() {
		return lines[DefaultConst.LINE_BACKSLASH_INDEX];
	}

	@Override
	public Line getHorizontal() {
		return lines[DefaultConst.LINE_HORIZONTAL_INDEX];
	}

	@Override
	public Line getVertical() {
		return lines[DefaultConst.LINE_VERTICAL_INDEX];
	}

}
