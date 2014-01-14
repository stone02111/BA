/*
 * ====================================================================
 * This software is subject to the terms of the Common Public License
 * Agreement, available at the following URL:
 *   http://www.opensource.org/licenses/cpl.html .
 * Copyright (C) 2003-2004 TONBELLER AG.
 * All Rights Reserved.
 * You must accept the terms of that agreement to use this software.
 * ====================================================================
 *
 * 
 */
package com.tonbeller.jpivot.table;

import org.json.simple.JSONObject;
import org.w3c.dom.Element;

/**
 * Created on 18.10.2002
 * 
 * @author av
 */

public interface CornerBuilder extends PartBuilder {
  Element build(int colSpan, int rowSpan);
  JSONObject buildJo(int colSpan, int rowSpan);
}