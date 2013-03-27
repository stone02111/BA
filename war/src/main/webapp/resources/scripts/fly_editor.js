Plywet.editors = {
	register : {},
	reinit : function(){
		if(Plywet.editors.register[Plywet.editors.trans.type]){
			Plywet.editors.trans.reinit();
		}
	},
	changeEditor : function ($taba,$tabo) {
		if($tabo && $tabo.data("tabId")){
			eval("Plywet.editors."+$tabo.data("tabId")+".saveStatus($tabo);");
		}
		if($taba && $taba.data("tabId")){
			eval("Plywet.editors."+$taba.data("tabId")+".reloadStatus($taba);");
		}
	}
};

Plywet.editors.toolbarButton = {
	isActive : function(id){
		return $(Plywet.escapeClientId(id)).hasClass("ui-state-active");
	},
	
	active : function(id){
		if(typeof(id)=="string"){
			$(Plywet.escapeClientId(id)).addClass("ui-state-active");
		}else if(id instanceof Array){
			for(var i=0;i<id.length;i++){
				$(Plywet.escapeClientId(id[i])).addClass("ui-state-active");
			}
		}
	},
	
	inactive : function(id){
		if(typeof(id)=="string"){
			$(Plywet.escapeClientId(id)).removeClass("ui-state-active");
		}else if(id instanceof Array){
			for(var i=0;i<id.length;i++){
				$(Plywet.escapeClientId(id[i])).removeClass("ui-state-active");
			}
		}
	},
	
	enabled : function(id){
		if(typeof(id)=="string"){
			$(Plywet.escapeClientId(id)).removeClass("ui-state-disabled").removeAttr("disabled");
		}else if(id instanceof Array){
			for(var i=0;i<id.length;i++){
				$(Plywet.escapeClientId(id[i])).removeClass("ui-state-disabled").removeAttr("disabled");
			}
		}
	},
	
	disabled : function(id){
		if(typeof(id)=="string"){
			$(Plywet.escapeClientId(id)).addClass("ui-state-disabled").attr("disabled","disabled");
		}else if(id instanceof Array){
			for(var i=0;i<id.length;i++){
				$(Plywet.escapeClientId(id[i])).addClass("ui-state-disabled").attr("disabled","disabled");
			}
		}
	}
};

// 转换
Plywet.editors.trans = {
	type : "trans",
	reinit : function(){
//		transStepBarScroll.reinit();
		
//		if(window["transEditorPanel_var"]){
//			transEditorPanel_var.changeSize(Plywet.desktop.contentWidthNoPadding,
//				Plywet.desktop.contentHeightEditor);
//		}
	},
	saveStatus : function ($tabo) {
		// 保存原来的结果
		if ($tabo && $tabo.data("exdata")){
			var canvasObj = transEditorPanel_var.flowChart;
			if(canvasObj && canvasObj.childCanvas){
				var flow = canvasObj.getChildCanvasByIndex(0);
				$tabo.data("exdata").data = Plywet.parseJSON(flow.getElsValue());
			}
		}
	},
	reloadStatus : function ($taba) {
		if (typeof($taba.data("exdata"))=='undefined')return;
		var canvasData = {
			onClearAll: "Plywet.editor.stepSelect('trans',canvasObj,flowObj)",
			onModify: "Plywet.editor.modify('trans',canvasObj,flowObj)",
			canvasEls : {},
			defaultAttributes: {
				onInitStep: {
					onContextMenu: "Plywet.editor.stepContent(canvasObj,flowObj,this)",
					onDblClick: "Plywet.editor.stepDblclick(canvasObj,flowObj,this)",
					sWidth: 32,
					sHeight: 32,
					bTextStyle: "#ffffff",
					acceptAll: true,
					onEndHop: "Plywet.editor.checkEndHop('trans',setting,this)",
					onRope: "Plywet.editor.stepSelect('trans',canvasObj,flowObj,this)",
					onClick: "Plywet.editor.stepSelect('trans',canvasObj,flowObj,this)"
				},
				onInitHop: {
					onDblClick: "Plywet.editor.hopDblclick(canvasObj,flowObj,this)",
					onContextMenu: "Plywet.editor.hopContext(canvasObj,flowObj,this)",
					style: "#2e83ff",
					textStyle: "#ffffff",
					arrowEndType: "default",
					onRope: "Plywet.editor.stepSelect('trans',canvasObj,flowObj,this)",
					onClick: "Plywet.editor.stepSelect('trans',canvasObj,flowObj,this)"
				}
			}
		};
		var tabData = $taba.data("exdata").data;
		if(tabData.canvasEls) $.extend(canvasData.canvasEls,tabData.canvasEls);
		if(tabData.defaultAttributes){
			if(tabData.defaultAttributes.onInitStep) $.extend(canvasData.defaultAttributes.onInitStep,tabData.defaultAttributes.onInitStep);
			if(tabData.defaultAttributes.onInitHop) $.extend(canvasData.defaultAttributes.onInitHop,tabData.defaultAttributes.onInitHop);
		}
		if(tabData.onClearAll) canvasData.onClearAll=tabData.onClearAll;
		if(tabData.onModify) canvasData.onModify=tabData.onModify;
		if(tabData.extendData) canvasData.extendData=tabData.extendData;
		if (typeof transEditorPanel_var == 'undefined') {
			var $panelSize = Plywet.getElementDimensions($(Plywet.escapeClientId("transEditorPanel")));
			Plywet.cw("FlowChart","transEditorPanel_var",{
				id: "transEditorPanel",
				oid: "transThumbContent",
				canvasConfig: {
					width: $panelSize.css.width,
					height: $panelSize.css.height
				},
				outerControl:true,
				data: canvasData
			});
		}else{
			transEditorPanel_var.flush(canvasData);
		}
	},
	register : function(){
		if(Plywet.editors.register[Plywet.editors.trans.type]){
			return;
		}
		
		// 加载转换页
		Plywet.ab({
			type : "get",
			url : "rest/transjob/trans/editor",
			beforeSend : function(){
				Plywet.desktop.changeMarkText("正在注册转换设计器页面...");
			},
			oncomplete : function(xhr, status){
				var editorContainer = diEditorLayout.getPane("center"),
				editorContentWidth = editorContainer.outerWidth(),
				editorContentHeight = editorContainer.outerHeight()-40;
				// 初始化尺寸
				var trans = $("#trans");
				trans.width(editorContentWidth).height(editorContentHeight);
				
				// 结构
				$transLayout = trans.layout({
					defaults: {
						size:					"auto"
						,	minSize:				50
						,	hideTogglerOnSlide:		true		// hide the toggler when pane is 'slid open'
						,	slideTrigger_open:		"mouseover"
						,	livePaneResizing:		true
						,	spacing_closed:			16
						,	togglerAlign_closed:	"top"
						,	togglerLength_closed:	16
						//	effect defaults - overridden on some panes
						,	fxName:					"slide"		// none, slide, drop, scale
						,	fxSpeed_open:			750
						,	fxSpeed_close:			1500
						,	fxSettings_open:		{ easing: "easeInQuint" }
						,	fxSettings_close:		{ easing: "easeOutQuint" }
					}
					, west : {
						size : 200
						,	paneSelector : "#transStepBar"
						,	togglerTip_open:		"关闭工具箱"
						,	togglerTip_closed:		"打开工具箱"
						,	resizable:				false
	//					,	initClosed:				true
						,	fxSettings_open:		{ easing: "easeOutBounce" }
					}
					, east : {
						size : 250
						,	paneSelector : "#transPropBar"
						,	togglerTip_open:		"关闭属性框"
						,	togglerTip_closed:		"打开属性框"
						,	resizerTip:		"调整属性框宽度"
						,	childOptions: {
							defaults: {
								size:					"auto"
								,	contentSelector:	".ui-widget-content"
								,	minSize : 				30
								,	animatePaneSizing: 		true
								,	fxSpeed_size:			750
								,	fxSettings_size:		{ easing: "easeInQuint" }
								,	livePaneResizing:		true
							}
							, north: {
								size : 150
								,	closable : false
								,  	resizerTip:		"调整属性框高度"
								,	paneSelector : "#transThumbPanel"
							}
							, center: {
								paneSelector : "#transDSPanel"
							}
						}
					}
					, center : {
						paneSelector : "#transContent"
						, 	minSize : 200
					}
				});
				
				
				$("#transEditorPanel").height($transLayout.getPaneSize("center", false, "horz") - 40)
					.width($transLayout.getPaneSize("center", false, "vert")-10);
				$("#transThumbContent").width($transLayout.getPaneSize("east")-12);
				
				Plywet.cw("EasyTabs","diEditorTransStepBar",{
					id : "transStepBar"
				});
				Plywet.cw("Scrollbar","transStepBarScroll",{
					id:'transStepBar',
					tabGroup:'transStepBar-ul',
					step:80,
					scrollType:'vertical'
				});
				
				// 拖拽
				$(".fly-trans-step-plugin").draggable({
					revert:true,
					deltaX:-10,
					deltaY:-10,
					proxy:function(source){
						var n = $('<div class="proxy"></div>');
						n.append($(source).children("div").clone());
						n.appendTo('body');
						return n;
					}
				});
				$("#transEditorPanel").droppable({
					accept: '.fly-trans-step-plugin',
					onDragEnter:function(e,source,data){
						$("#transEditorPanel").addClass("ui-state-highlight");
					},
					onDragLeave: function(e,source,data){
						$("#transEditorPanel").removeClass("ui-state-highlight");
					},
					onDrop: function(e,source,data){
						$("#transEditorPanel").removeClass("ui-state-highlight");
						Plywet.editor.appendEl("trans",$(source).data("data"),data);
					}
				});
				
				// 添加一个静态的树
				var config = {
					'id' : 'datasource',
					"checkbox":true,
					"dnd":true,
					'els' : [ {
						'id' : 'id0',
						'displayName' : '数据库',
						'type' : 'node',
						'icon' : 'resources/libs/tree/images/diy/1_close.png',
						'els' : [ {
							id : 'id1-1',
							displayName : '连接名称1',
							type : 'node',
							'icon' : '',
							state:"open",
							'els' : [ {
								id : 'id1-1-1',
								displayName : '表结构',
								type : 'node',
								state:"closed",
								'icon' : '',
								'els' : [ {
									id : 'id1-1-1',
									displayName : '表1',
									type : 'leaf',
									draggable : true
								}, {
									id : 'id1-1-11',
									displayName : '表2',
									type : 'leaf',
									draggable : true
								}, {
									id : 'id1-1-12',
									displayName : '表3',
									type : 'leaf',
									draggable : true
								} ]
							}, {
								id : 'id1-1-2',
								displayName : '视图',
								type : 'node',
								'els' : [ {
									id : 'id1-1-21',
									displayName : '视图1',
									type : 'leaf'
								}, {
									id : 'id1-1-22',
									displayName : '视图2',
									type : 'leaf'
								}, {
									id : 'id1-1-23',
									displayName : '视图3',
									type : 'leaf'
								} ]
							}, {
								id : 'id1-1-3',
								displayName : '存储过程',
								type : 'node',
								'els' : [ {
									id : 'id1-1-31',
									displayName : '过程1',
									type : 'leaf'
								}, {
									id : 'id1-1-32',
									displayName : '过程2',
									type : 'leaf'
								}, {
									id : 'id1-1-33',
									displayName : '过程3',
									type : 'leaf'
								} ]
							} ]
						}, {
							id : 'id1-21',
							displayName : '连接名称2',
							type : 'node'
						}, {
							id : 'id1-22',
							displayName : '连接名称3',
							type : 'node'
						} ]
					} ]
				};
				var tree = new Plywet.widget.EasyTree(config);
				
				trans.hide();
				
				Plywet.editors.register[Plywet.editors.trans.type] = "Y";
			}
		});
	}
};

// 表单
Plywet.editors.form = {
	saveStatus : function ($tabo) {
		console.log("save form");
	},
	reloadStatus : function ($taba) {
		console.log("reload form");
		
		if (typeof($taba.data("exdata"))=='undefined')return;
		var tabData = $taba.data("exdata");
		console.log(tabData);
		
		
	},
	reinit : function(){
//		formStepBarScroll.reinit();
		
//		if(window["formEditorPanel_var"]){
//			formEditorPanel_var.changeSize(Plywet.desktop.contentWidthNoPadding,
//				Plywet.desktop.contentHeightEditor);
//		}
	},
	register : function(){
		if(Plywet.editors.register["form"]){
			return;
		}
		
		Plywet.ab({
			type : "get",
			url: "rest/report/form/editor",
			beforeSend : function(){
				Plywet.desktop.changeMarkText("正在注册表单设计器页面...");
			},
			oncomplete : function(xhr, status){
				var editorContainer = diEditorLayout.getPane("center"),
					editorContentWidth = editorContainer.outerWidth(),
					editorContentHeight = editorContainer.outerHeight()-40;
				// 初始化尺寸
				var form = $("#form");
				form.width(editorContentWidth).height(editorContentHeight);
				$("#formEditorPanel").height(editorContentHeight - 40);
				
				// 结构
				$formLayout = form.layout({
					defaults: {
						size:					"auto"
						,	minSize:				50
						,	hideTogglerOnSlide:		true		// hide the toggler when pane is 'slid open'
						,	slideTrigger_open:		"mouseover"
						,	livePaneResizing:		true
						,	spacing_closed:			16
						,	togglerAlign_closed:	"top"
						,	togglerLength_closed:	16
						//	effect defaults - overridden on some panes
						,	fxName:					"slide"		// none, slide, drop, scale
						,	fxSpeed_open:			750
						,	fxSpeed_close:			1500
						,	fxSettings_open:		{ easing: "easeInQuint" }
						,	fxSettings_close:		{ easing: "easeOutQuint" }
					}
					, west : {
						size : 200
						,	paneSelector : "#formStepBar"
						,	togglerTip_open:		"关闭工具箱"
						,	togglerTip_closed:		"打开工具箱"
						,	resizable:				false
//						,	initClosed:				true
						,	fxSettings_open:		{ easing: "easeOutBounce" }
					}
					, east : {
						size : 250
						,	paneSelector : "#formPropBar"
						,	togglerTip_open:		"关闭属性框"
						,	togglerTip_closed:		"打开属性框"
						,	resizerTip:		"调整属性框宽度"
						,	childOptions: {
							defaults: {
								size:					"auto"
								,	contentSelector:	".ui-widget-content"
								,	minSize : 				30
								,	animatePaneSizing: 		true
								,	fxSpeed_size:			750
								,	fxSettings_size:		{ easing: "easeInQuint" }
								,	livePaneResizing:		true
							}
							, north: {
								size : 200
								,	closable : false
								,  	resizerTip:		"调整属性框高度"
								,	paneSelector : "#formStructPanel"
							}
							, center: {
								paneSelector : "#formPropPanel"
							}
						}
					}
					, center : {
						paneSelector : "#formContent"
						, 	minSize : 200
					}
				});
				
				
				Plywet.cw("EasyTabs","diEditorFormStepBar",{
					id : "formStepBar"
				});
				Plywet.cw("Scrollbar","formStepBarScroll",{
					id:'formStepBar',
					tabGroup:'formStepBar-ul',
					step:80,
					scrollType:'vertical'
				});
				// 拖拽
				$(".fly-form-step-plugin").draggable({
					revert:true,
					deltaX:-10,
					deltaY:-10,
					proxy:function(source){
						var n = $('<div class="proxy"></div>');
						n.append($(source).children("div").clone());
						n.appendTo('body');
						return n;
					}
				});
				$("#formEditorPanel").droppable({
					accept: '.fly-form-step-plugin',
					onDragEnter:function(e,source,data){
						$("#formEditorPanel").addClass("ui-state-highlight");
					},
					onDragLeave: function(e,source,data){
						$("#formEditorPanel").removeClass("ui-state-highlight");
					},
					onDrop: function(e,source,data){
						$("#formEditorPanel").removeClass("ui-state-highlight");
						Plywet.editor.appendEl("form",$(source).data("data"),data);
					}
				});
				
				form.hide();
				
				Plywet.editors.register["form"] = "Y";
			}
		});
	},
	toggleFlags : {
		structPane : true,
		propPane : true,
		structHeight : 0,
		propHeight : 0
	},
	toggleContent : function(target){
		var $close1 = $("#formStructClose"),
			$close2 = $("#formPropClose"),
			$layout = $("#formPropBar").data('layout');
		
		if(this.toggleFlags.structPane && this.toggleFlags.propPane){
			this.toggleFlags.structHeight = $layout.getPaneSize("north");
			this.toggleFlags.propHeight = $layout.getPaneSize("center", false, "horz");
		}
		
		//最小化1，最大化2
		if(target == "structPane" && this.toggleFlags.structPane) {
			$layout.sizePane("north", 30);
			
			$close1.addClass("ui-icon-circle-plus");
			$close1.removeClass("ui-icon-circle-minus");
			
			$close2.removeClass("ui-icon-circle-plus");
			$close2.addClass("ui-icon-circle-minus");
			
			this.toggleFlags.structPane = false;
			this.toggleFlags.propPane = true;
		} 
		// 最小化2，最大化1
		else if(target == "propPane" && this.toggleFlags.propPane) {
			$layout.sizePane("north", this.toggleFlags.structHeight + this.toggleFlags.propHeight - 30);
		
			$close2.addClass("ui-icon-circle-plus");
			$close2.removeClass("ui-icon-circle-minus");
			
			$close1.removeClass("ui-icon-circle-plus");
			$close1.addClass("ui-icon-circle-minus");
			
			this.toggleFlags.structPane = true;
			this.toggleFlags.propPane = false;
		}
		else {
			$layout.sizePane("north", this.toggleFlags.structHeight);
			
			$close1.removeClass("ui-icon-circle-plus");
			$close1.addClass("ui-icon-circle-minus");
			
			$close2.removeClass("ui-icon-circle-plus");
			$close2.addClass("ui-icon-circle-minus");
			
			this.toggleFlags.structPane = true;
			this.toggleFlags.propPane = true;
		}
		
		if(this.toggleFlags.structPane && this.toggleFlags.propPane){
			$layout.enableResizable("north");
		} else {
			$layout.disableResizable("north");
		}
	}
};


Plywet.editor = {
	ids : {
		operations : ["run","runstep","runreturn","pause","stop","validate","analize","runstep"],
		editors : ["edit","magnify","lessen","partMagnify","zoom_100","zoom_fit","screenMove"],
		grids : ["grid_show","grid_close"],
		systems : ["cut","copy","paste","delete"],
		saves : ["save","saveas","save_xml","save_image"]
	},
	getId : function(panel,id){
		if(typeof(id)=="string"){
			return panel+"_"+id;
		}else if(id instanceof Array){
			var rtn = [];
			for(var i=0;i<id.length;i++){
				rtn.push(panel+"_"+id[i]);
			}
			return rtn;
		}
	},
	getFlow : function(panel){
		eval("var canvasObj="+panel+"EditorPanel_var.flowChart");
    	if(canvasObj && canvasObj.childCanvas){
    		return canvasObj.getChildCanvasByIndex(0);
    	}
	},
	editorZoom100 : function(panel){
		Plywet.editor.changeOuterControlType(panel,"");
    	var flow = Plywet.editor.getFlow(panel);
    	if(flow){
    		flow.showZoom100();
    	}
	},
	editorFix : function(panel){
		Plywet.editor.changeOuterControlType(panel,"");
		var flow = Plywet.editor.getFlow(panel);
    	if(flow){
    		flow.fixSize();
    	}
	},
	changeOuterControlType : function (panel,v,id){
		if(v==undefined || v==null || v==""){
			v = "";
			Plywet.editors.toolbarButton.inactive(Plywet.editor.getId(panel,Plywet.editor.ids.editors));
		}else{
			var btnId = Plywet.editor.getId(panel,((id)?id:v));
			if(Plywet.editors.toolbarButton.isActive(btnId)){
				v = "";
				Plywet.editors.toolbarButton.inactive(btnId);
			}else{
				Plywet.editors.toolbarButton.inactive(Plywet.editor.getId(panel,Plywet.editor.ids.editors));
				Plywet.editors.toolbarButton.active(btnId);
			}
		}
		
		eval("var canvasObj="+panel+"EditorPanel_var.flowChart");
    	if(canvasObj){
    		var ctrlType = v;
    		canvasObj.setOuterControl(true,ctrlType);
    		canvasObj.redraw();
    	}
    },

    deleteSelectedElFromOutset : function (panel){
    	eval("var canvasObj="+panel+"EditorPanel_var.flowChart");
    	if(canvasObj && canvasObj.childCanvas){
    		var flow = canvasObj.getChildCanvasByIndex(0);
   			flow.deleteSelectedEl();
    		canvasObj.redraw();
    		
    		Plywet.editor.stepSelect('trans',canvasObj,flow);
    	}
    	
    	
    },

    save : function (panel){
    	eval("var canvasObj="+panel+"EditorPanel_var.flowChart");
    	if(canvasObj && canvasObj.childCanvas){
    		var transId = canvasObj.config.data.extendData.transId;
    		var flow = canvasObj.getChildCanvasByIndex(0);
    		Plywet.ab({
    			type : "post",
    			url : "rest/transjob/trans/"+transId+"/save",
    			modal : true,
    			modalMessage : "正在保存...",
    			params : {
    				val : flow.getElsValue()
    			}
    		});
    	}
    	
    	diEditorPageTabs.setTabModify(null, false);
    },
    
    saveTab : function (clicked) {
    	var isActive = diEditorPageTabs.isActive(clicked.data("exdata").id+"-tab");
    	if(isActive){
    		Plywet.editor.save("trans");
    	}else{
    		var transId = clicked.data("exdata").data.extendData.transId;
    		Plywet.ab({
    			type : "post",
    			url : "rest/transjob/trans/"+transId+"/save",
    			modal : true,
    			modalMessage : "正在保存...",
    			params : {
    				clear : true,
    				val : Plywet.toJSONString(clicked.data("exdata").data)
    			}
    		});
    	}
    },
    
    discardTab : function (clicked) {
    	var transId = clicked.data("exdata").data.extendData.transId;
    	Plywet.ab({
			type : "get",
			url : "rest/transjob/trans/"+transId+"/discard"
		});
    },
    
    appendEl : function (panel,data,pos){
    	eval("var canvasObj="+panel+"EditorPanel_var.flowChart");
    	if(canvasObj && canvasObj.childCanvas){
    		var flow = canvasObj.getChildCanvasByIndex(0);
    		var realOffset = Plywet.widget.FlowChartUtils.scaleLength(canvasObj.config.scale,10);
    		var realPos = Plywet.widget.FlowChartUtils.arcScalePoint(canvasObj.config,{
    			x:(pos.x-realOffset),
    			y:(pos.y-realOffset)
    		});
    		// 判断是否重名
    		var steps = flow.config.canvasEls.steps;
    		var displayName = data.displayName, displayName_old = displayName, idx = 2;
    		var rename = true;
    		while(rename){
    			rename = false;
	    		for(var i=0;i<steps.length;i++){
	    			if(displayName == steps[i].extendData.stepName){
	    				displayName = displayName_old + (idx++);
	    				rename = true;
	    				break;
	    			}
	    		}
    		}
    		// 添加一个节点
    		flow.appendEl({
    			'type':'sys:step:picture',
    			'imgSrc':data.icon,
    			'provider':data.id,
    			'dx':realPos.x,'dy':realPos.y,
    			'extendData':{'stepName':displayName,'dialogPosition':data.dialogPosition},
    			'bText':[displayName]},"step");
    		canvasObj.redraw();
    	}
    },
    
    
    
    /**
     * 显示网格
     */
    showGrid : function(panel){
    	var btnId = Plywet.editor.getId(panel,"grid_show");
    	var showGrid;
		if(Plywet.editors.toolbarButton.isActive(btnId)){
			showGrid=false;
			Plywet.editors.toolbarButton.inactive(btnId);
			Plywet.editors.toolbarButton.disabled(Plywet.editor.getId(panel,"grid_close"));
		}else{
			showGrid=true;
			Plywet.editors.toolbarButton.active(btnId);
			Plywet.editors.toolbarButton.enabled(Plywet.editor.getId(panel,"grid_close"));
		}
    	eval("var canvasObj="+panel+"EditorPanel_var.flowChart");
    	if(canvasObj && canvasObj.childCanvas){
    		var flow = canvasObj.getChildCanvasByIndex(0);
    		flow.showGrid(showGrid);
    	}
    },
    
    /**
     * 贴近网格
     */
    closeGrid : function(panel){
    	var btnId = Plywet.editor.getId(panel,"grid_close");
    	var close;
		if(Plywet.editors.toolbarButton.isActive(btnId)){
			close=false;
			Plywet.editors.toolbarButton.inactive(btnId);
		}else{
			close=true;
			Plywet.editors.toolbarButton.active(btnId);
		}
    	eval("var canvasObj="+panel+"EditorPanel_var.flowChart");
    	if(canvasObj && canvasObj.childCanvas){
    		var flow = canvasObj.getChildCanvasByIndex(0);
    		flow.closeGrid(close);
    	}
    },

    hopContext : function (flowChart,flowObject,model){
    	console.log(flowChart);
        console.log(flowObject);
        console.log(model);
    },

    hopDblclick : function (flowChart,flowObject,model){
    	console.log(flowChart);
        console.log(flowObject);
        console.log(model);
    },

    stepContent : function (flowChart,flowObject,model){
    	console.log(flowChart.oraData);
        console.log(flowObject);
        console.log(model);
    },
    
    /**
     * 判断是否可以进行连线
     * 
     * @param panel
     * @param setting：fromElId, toElId
     * @param flowObject
     */
    checkEndHop : function (panel,setting,flowObject){
    	var hops = flowObject.config.canvasEls.hops;
    	for(var i=0;i<hops.length;i++){
    		if(hops[i].fromElId == setting.fromElId && hops[i].toElId == setting.toElId){
    			return false;
    		}
    	}
    	return true;
    },
    
    stepSelect : function(panel,flowChart,flowObject,model){
    	var editorIds = Plywet.editor.getId(panel,["cut","copy"]);
    	var deleteId = Plywet.editor.getId(panel,"delete");
    	if(flowObject.hasSelectedEl("step")){
    		Plywet.editors.toolbarButton.enabled(editorIds);
    	}else{
    		Plywet.editors.toolbarButton.disabled(editorIds);
    	}
    	if(flowObject.hasSelectedEl()){
    		Plywet.editors.toolbarButton.enabled(deleteId);
    	}else{
    		Plywet.editors.toolbarButton.disabled(deleteId);
    	}
    },
    
    modify : function(panel,flowChart,flowObject){
    	// 表示修改
		diEditorPageTabs.setTabModify(null, true);
    },

    stepDblclick : function (flowChart,flowObject,model){
    	var autoMaximized = false, maximizable = true, w = 600, h = 400;
    	var	dialogPos;
    	if(model.extendData){
    		dialogPos = model.extendData.dialogPosition;
    	}
    	if(dialogPos){
    		if(dialogPos == "full"){
    			autoMaximized = true;
    			maximizable = false;
    		} else if(dialogPos.indexof(",")>0){
    			var pos = dialogPos.split(",");
    			w = pos[0];
    			h = pos[1];
    		}
    	}
    	Plywet.cw("Dialog",null,{
			id : "dialog-"+model.id,
			header : model.bText[0],
			width : w,
			height : h,
			autoOpen : true,
			showHeader : true,
			url : "rest/transjob/transstep/"+flowObject.config.extendData.transId+"/"+model.extendData.stepName+"/"+model.provider,
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "确定",
				title : "确定",
				events : {
					"click" : function(){
						Plywet.ab({
							formId : "",
							formAction : ""
						});
					}
				}
			},{
				componentType : "fly:PushButton",
				type : "button",
				label : "取消",
				title : "取消",
				events : {
					"click" : "hide"
				}
			}],
			closable : true,
			maximizable : maximizable,
			autoMaximized : autoMaximized
		});
    }
};