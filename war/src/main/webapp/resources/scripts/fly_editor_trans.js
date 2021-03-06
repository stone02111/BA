// 转换
Flywet.editors.trans = {
	type : "trans",
	editorType : "tab",
	defaultOptions : {
		canvasData : {
			onClearAll: "Flywet.editors.trans.action.stepSelect(canvasObj,flowObj)",
			onModify: "Flywet.editors.trans.action.modify(canvasObj,flowObj)",
			canvasEls : {},
			defaultAttributes: {
				onInitStep: {
					onContextMenu: "Flywet.editors.trans.action.stepContent(coords,canvasObj,flowObj,this)",
					onDblClick: "Flywet.editors.trans.action.stepDblclick(canvasObj,flowObj,this)",
					sWidth: 32,
					sHeight: 32,
					bTextStyle: "#333333",
					acceptAll: true,
					onEndHop: "Flywet.editors.trans.action.checkEndHop(setting,this)",
					onRope: "Flywet.editors.trans.action.stepSelect(canvasObj,flowObj,this)",
					onClick: "Flywet.editors.trans.action.stepSelect(canvasObj,flowObj,this)"
				},
				onInitHop: {
					onDblClick: "Flywet.editors.trans.action.hopDblclick(canvasObj,flowObj,this)",
					onContextMenu: "Flywet.editors.trans.action.hopContext(coords,canvasObj,flowObj,this)",
					style: "#2e83ff",
					textStyle: "#333333",
					arrowEndType: "default",
					onRope: "Flywet.editors.trans.action.stepSelect(canvasObj,flowObj,this)",
					onClick: "Flywet.editors.trans.action.stepSelect(canvasObj,flowObj,this)"
				}
			}
		}
	},
	defaultShowConfig : {
		showGrid : false,
		closeGrid : false,
		gridPoints : {
			distance : 50
		},
		outerControl : true,
		outerControlType : "",
		innerControlType : "",
		offset : {
			x : 0,
			y : 0
		},
		scale : 1
	},
	resize : function(){
		// TODO 
		
	},
	saveStatus : function ($tabo) {
		// 保存原来的结果
		if ($tabo && $tabo.data("exdata")){
			var canvasObj = transEditorPanel_var.flowChart;
			if(canvasObj && canvasObj.childCanvas){
				var flow = canvasObj.getChildCanvasByIndex(0);
				$tabo.data("exdata").data = Flywet.parseJSON(flow.getElsValue());
			}
			$tabo.data("exdata").canvasConfig = canvasObj.getShowConfig();
			$tabo.data("exdata").btnsConfig = Flywet.editors.trans.action.getButtonsStatus();
		}
	},
	reloadStatus : function ($taba) {
		if (typeof($taba.data("exdata"))=='undefined')return;
		var canvasData = Flywet.deepClone(Flywet.editors.trans.defaultOptions.canvasData);
		
		var tabData = $taba.data("exdata").data,
			canvasConfig = $taba.data("exdata").canvasConfig,
			btnsConfig = $taba.data("exdata").btnsConfig;
		
		if(tabData.canvasEls) $.extend(canvasData.canvasEls,tabData.canvasEls);
		if(tabData.defaultAttributes){
			if(tabData.defaultAttributes.onInitStep) $.extend(canvasData.defaultAttributes.onInitStep,tabData.defaultAttributes.onInitStep);
			if(tabData.defaultAttributes.onInitHop) $.extend(canvasData.defaultAttributes.onInitHop,tabData.defaultAttributes.onInitHop);
		}
		if(tabData.onClearAll) canvasData.onClearAll=tabData.onClearAll;
		if(tabData.onModify) canvasData.onModify=tabData.onModify;
		if(tabData.extendData) canvasData.extendData=tabData.extendData;
		
		if (typeof transEditorPanel_var == 'undefined') {
			var $panelSize = Flywet.getElementDimensions($(Flywet.escapeClientId("transEditorPanel")));
			Flywet.cw("FlowChart","transEditorPanel_var",{
				id: "transEditorPanel",
				oid: "transThumbContent",
				canvasConfig: {
					width: $panelSize.css.width,
					height: $panelSize.css.height
				},
				outerControl:true,
				data: canvasData
			});
			
			Flywet.editors.trans.action.initButtonsStatus();
		}else{
			if(!canvasConfig){
				canvasConfig = Flywet.deepClone(this.defaultShowConfig);
			}
			transEditorPanel_var.flush(canvasData,canvasConfig);
			
			if(!btnsConfig){
				btnsConfig = Flywet.deepClone(Flywet.editors.trans.action.defalutBtnStatus);
			}
			Flywet.editors.trans.action.setButtonsStatus(btnsConfig);
		}
	},
	flushStatus : function($taba,params){
		if(params && params.data){
			var tabData = $taba.data("exdata").data;
			$taba.data("exdata").data = params.data;
			
			//修改taba
			this.reloadStatus($taba);
		}
	},
	openEditor : function(category,data,displayName,tabName){
		Flywet.ab({
			type : "get",
			modal : true,
			modalMessage : "正在加载【"+displayName+"】...",
			url : "rest/"+data.attrs.src,
			onsuccess : function(data, status, xhr){
				baEditorPageTabs.addTab({
					exdata: data,
					tabId: category,
					tabType: category,
					tabText: displayName,
					dataTarget: tabName,
					closable: true,
					closePanel: false,
			        checkModify: true
				});
			}
		});
	},
	register : function(){
		if(Flywet.editors.register[Flywet.editors.trans.type]){
			return;
		}
		
		// 加载转换页
		Flywet.ab({
			type : "get",
			url : "rest/trans/editor",
			modalMessage: "正在注册转换设计器页面...",
			oncomplete : function(xhr, status){
				// 初始化尺寸
				var editorContainer = diEditorLayout.getPane("center"),
					editorContentWidth = editorContainer.outerWidth(),
					editorContentHeight = editorContainer.outerHeight()-40;
				var $trans = $("#trans");
				$trans.width(editorContentWidth).height(editorContentHeight);
				
				// 构建布局
				$transLayout = $trans.layout({
					defaults: {
						size:					"auto"
						,	minSize:				50
						,	hideTogglerOnSlide:		true		// hide the toggler when pane is 'slid open'
						,	slideTrigger_open:		"click"
//						,	livePaneResizing:		true
						,	spacing_closed:			16
						,	togglerAlign_closed:	"top"
						,	togglerLength_closed:	36
						//	effect defaults - overridden on some panes
						,	fxName:					"slide"		// none, slide, drop, scale
						,	fxSpeed_open:			750
						,	fxSpeed_close:			1500
						,	fxSettings_open:		{ easing: "easeInQuint" }
						,	fxSettings_close:		{ easing: "easeOutQuint" }
						,	onresize_end:			function(){
							$("#transEditorPanel").height($transLayout.getPaneSize("center", false, "horz") - 30)
								.width($transLayout.getPaneSize("center", false, "vert"));
							$("#transThumbContent").width($transLayout.getPaneSize("east"));
							// 改变canvas属性
							transEditorPanel_var.autoChangeSize();
						}
					}
					, west : {
						size : 200
						,	paneSelector : "#transStepBar"
						,	togglerTip_open:		"关闭工具箱"
						,	togglerTip_closed:		"打开工具箱"
						,	sliderTip:				"弹出工具箱"
						,	togglerContent_closed: 	"<div class='ui-layout-toggler-closed-icon ui-icon ui-icon-circle-triangle-e'></div>"
						,	resizable:				false
	//					,	initClosed:				true
					}
					, east : {
						size : 250
						,	paneSelector : "#transPropBar"
						,	togglerTip_open:		"关闭属性框"
						,	togglerTip_closed:		"打开属性框"
						,	sliderTip:				"弹出属性箱"
						,	togglerContent_closed: 	"<div class='ui-layout-toggler-closed-icon ui-icon ui-icon-circle-triangle-w'></div>"
						,	resizerTip:		"调整属性框宽度"
						,	childOptions: {
							defaults: {
								size:					"auto"
								,	contentSelector:	".ui-widget-content"
								,	minSize : 				30
								,	animatePaneSizing: 		true
								,	fxSpeed_size:			750
								,	fxSettings_size:		{ easing: "easeInQuint" }
//								,	livePaneResizing:		true
								,	onresize_end:			function(){
										transEditorPanel_var.autoChangeSize();
									}
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
					, south : {
						paneSelector : "#transLogBar"
						,	initClosed :	true
						,	resizable:		false
						,	size : 250
						,	spacing_closed:	0
					}
				});
				
				
				$("#transEditorPanel").height($transLayout.getPaneSize("center", false, "horz") - 30)
					.width($transLayout.getPaneSize("center", false, "vert"));
				$("#transThumbContent").width($transLayout.getPaneSize("east"));
				
				Flywet.cw("EasyTabs","diEditorTransStepBar",{
					id : "transStepBar"
				});
				Flywet.cw("Scrollbar","transStepBarScroll",{
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
						$("#transEditorPanel").addClass("highlight");
					},
					onDragLeave: function(e,source,data){
						$("#transEditorPanel").removeClass("highlight");
					},
					onDrop: function(e,source,data){
						$("#transEditorPanel").removeClass("highlight");
						Flywet.editors.trans.action.appendEl($(source).data("data"),data);
					}
				});
				
				$trans.hide();
				
				Flywet.editors.register[Flywet.editors.trans.type] = "Y";
			}
		});
	},
	toggleFlags : {
		thumbPane : true,
		dsPane : true,
		thumbHeight : 0,
		dsHeight : 0
	},
	toggleContent : function(target){
		var $close1 = $("#transThumbClose"),
			$close2 = $("#transDSClose"),
			$layout = $("#transPropBar").data('layout');
		
		if(this.toggleFlags.thumbPane && this.toggleFlags.dsPane){
			this.toggleFlags.thumbHeight = $layout.getPaneSize("north");
			this.toggleFlags.dsHeight = $layout.getPaneSize("center", false, "horz");
		}
		
		//最小化1，最大化2
		if(target == "thumbPane" && this.toggleFlags.thumbPane) {
			$layout.sizePane("north", 30);
			
			$close1.addClass("ui-icon-circle-plus");
			$close1.removeClass("ui-icon-circle-minus");
			
			$close2.removeClass("ui-icon-circle-plus");
			$close2.addClass("ui-icon-circle-minus");
			
			this.toggleFlags.thumbPane = false;
			this.toggleFlags.dsPane = true;
		} 
		// 最小化2，最大化1
		else if(target == "dsPane" && this.toggleFlags.dsPane) {
			$layout.sizePane("north", this.toggleFlags.thumbHeight + this.toggleFlags.dsHeight - 30);
		
			$close2.addClass("ui-icon-circle-plus");
			$close2.removeClass("ui-icon-circle-minus");
			
			$close1.removeClass("ui-icon-circle-plus");
			$close1.addClass("ui-icon-circle-minus");
			
			this.toggleFlags.thumbPane = true;
			this.toggleFlags.dsPane = false;
		}
		else {
			$layout.sizePane("north", this.toggleFlags.thumbHeight);
			
			$close1.removeClass("ui-icon-circle-plus");
			$close1.addClass("ui-icon-circle-minus");
			
			$close2.removeClass("ui-icon-circle-plus");
			$close2.addClass("ui-icon-circle-minus");
			
			this.toggleFlags.thumbPane = true;
			this.toggleFlags.dsPane = true;
		}
		
		if(this.toggleFlags.thumbPane && this.toggleFlags.dsPane){
			$layout.enableResizable("north");
		} else {
			$layout.disableResizable("north");
		}
	}
};

/**
 * 转换的按钮操作
 */
Flywet.editors.trans.action = {
	tb : Flywet.editors.toolbarButton,
	editorPrefix : "trans",
	ids : {
		operations : ["run","runreturn","pause","stop","validate","analize"],
		editors : ["edit","magnify","lessen","partMagnify","zoom_100","zoom_fit","screenMove"],
		grids : ["grid_show","grid_close"],
		systems : ["cut","copy","paste","delete"],
		saves : ["save","saveas","save_xml","save_image"]
	},
	defalutBtnStatus : {
		run 		: {active:false,enabled:true,show:true}
		,runreturn 	: {active:false,enabled:true,show:true}
		,pause 		: {active:false,enabled:false,show:true}
		,stop 		: {active:false,enabled:false,show:true}
		,validate 	: {active:false,enabled:true,show:true}
		,analize 	: {active:false,enabled:true,show:true}
		
		,edit	 	: {active:false,enabled:true,show:true}
		,magnify 	: {active:false,enabled:true,show:true}
		,lessen 	: {active:false,enabled:true,show:true}
		,partMagnify: {active:false,enabled:true,show:true}
		,zoom_100 	: {active:false,enabled:true,show:true}
		,zoom_fit 	: {active:false,enabled:true,show:true}
		,screenMove : {active:false,enabled:true,show:true}
		
		,grid_show 	: {active:false,enabled:true,show:true}
		,grid_close : {active:false,enabled:false,show:true}
		
		,cut 		: {active:false,enabled:false,show:true}
		,copy 		: {active:false,enabled:false,show:true}
		,paste 		: {active:false,enabled:false,show:true}
		,"delete" 	: {active:false,enabled:false,show:true}
		
		,save 		: {active:false,enabled:true,show:true}
		,saveas 	: {active:false,enabled:true,show:true}
		,save_xml 	: {active:false,enabled:true,show:true}
		,save_image : {active:false,enabled:true,show:true}
	},
	getButtonsStatus : function(){
		var btns = [], conf = {};
		btns = btns.concat(this.ids.operations,this.ids.editors,this.ids.grids,this.ids.systems,this.ids.saves);
		for(var i=0;i<btns.length;i++){
			conf[btns[i]] = this.tb.getStatus(this.getId(btns[i]));
		}
		return conf;
	},
	setButtonsStatus : function(conf){
		if(conf){
			for(var key in conf){
				this.tb.setStatus(this.getId(key),conf[key]);
			}
		}
	},
	initButtonsStatus : function(){
		this.setButtonsStatus(this.defalutBtnStatus);
	},
	getId : function(id){
		if(typeof(id)=="string"){
			return this.editorPrefix+"_"+id;
		}else if(id instanceof Array){
			var rtn = [];
			for(var i=0;i<id.length;i++){
				rtn.push(this.editorPrefix+"_"+id[i]);
			}
			return rtn;
		}
	},
	getFlow : function(){
		var canvasObj=transEditorPanel_var.flowChart;
    	if(canvasObj && canvasObj.childCanvas){
    		return canvasObj.getChildCanvasByIndex(0);
    	}
	},
	editorZoom100 : function(){
		this.changeOuterControlType("");
    	var flow = this.getFlow();
    	if(flow){
    		flow.showZoom100();
    	}
	},
	editorFix : function(){
		this.changeOuterControlType("");
		var flow = this.getFlow();
    	if(flow){
    		flow.fixSize();
    	}
	},
	changeOuterControlType : function (v,id){
		if(v==undefined || v==null || v==""){
			v = "";
			this.tb.inactive(this.getId(this.ids.editors));
		}else{
			var btnId = this.getId((id)?id:v);
			if(this.tb.isActive(btnId)){
				v = "";
				this.tb.inactive(btnId);
			}else{
				this.tb.inactive(this.getId(this.ids.editors));
				this.tb.active(btnId);
			}
		}
		
		var canvasObj=transEditorPanel_var.flowChart;
    	if(canvasObj){
    		var ctrlType = v;
    		canvasObj.setOuterControl(true,ctrlType);
    		canvasObj.redraw();
    	}
    },

    deleteSelectedElFromOutset : function (){
    	var canvasObj=transEditorPanel_var.flowChart;
    	if(canvasObj && canvasObj.childCanvas){
    		var flow = canvasObj.getChildCanvasByIndex(0);
   			flow.deleteSelectedEl();
    		canvasObj.redraw();
    		
    		this.stepSelect(this.editorPrefix,canvasObj,flow);
    	}
    },

    save : function (func,silence){
    	silence = silence || false;
    	
    	if(!baEditorPageTabs.isTabModify(null)){
    		return;
    	}
    	
    	var _self = this;
    	
    	var canvasObj=transEditorPanel_var.flowChart;
    	if(canvasObj && canvasObj.childCanvas){
    		var transId = canvasObj.config.data.extendData.transId;
    		var flow = canvasObj.getChildCanvasByIndex(0);
    		Flywet.ab({
    			type : "post",
    			url : "rest/trans/"+transId+"/save",
    			modal : true,
    			modalMessage : "正在保存...",
    			params : {
    				silence : silence,
    				val : flow.getElsValue()
    			},
    			onsuccess : function(){
    				baEditorPageTabs.setTabModify(null, false);
    				if(func){
    					func.call(_self);
    				}
    			}
    		});
    	}
    },
    
    saveas : function () {
    	var showSaveas = function(){
    		var canvasObj=transEditorPanel_var.flowChart;
        	if(canvasObj && canvasObj.childCanvas){
        		var transId = canvasObj.config.data.extendData.transId;
	    		var targetId = "saveas_dialog_folder";
	    		
	    		Flywet.cw("Dialog",targetId+"_var",{
	    			id : targetId,
	    			header : "另存为...",
	    			width : 500,
	    			height : 90,
	    			autoOpen : true,
	    			showHeader : true,
	    			modal : true,
	    			url : "rest/trans/saveas/"+transId,
	    			params : {
	    				targetId : targetId+":content"
	    			},
	    			footerButtons : [{
	    				componentType : "fly:PushButton",
	    				type : "button",
	    				label : "确定",
	    				title : "确定",
	    				click  : {
		    				formId:"trans_saveas_form",
							formAction:"rest/trans/saveassubmit",
							onsuccess:function(data, status, xhr) {
								if (data.state == 0) {
									window[targetId + "_var"].hide();
								}
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
	    			maximizable : false,
	    			resizable : false
	    		});
        	}
    	};
    	
    	if(baEditorPageTabs.isTabModify(null)){
    		this.save(showSaveas,true);
    	}else{
    		showSaveas.call(this);
    	}
    },
    
    saveXml : function () {
    },
    
    saveImage : function () {
    },
    
    // @Override 必要方法：用于在Tab发生修改时，点击保存按钮调用的方法。
    saveTab : function (clicked) {
    	var isActive = baEditorPageTabs.isActive(clicked.data("exdata").id+"-tab");
    	if(isActive){
    		this.save("trans");
    	}else{
    		var transId = clicked.data("exdata").data.extendData.transId;
    		Flywet.ab({
    			type : "post",
    			url : "rest/trans/"+transId+"/save",
    			modal : true,
    			modalMessage : "正在保存...",
    			params : {
    				clear : true,
    				val : Flywet.toJSONString(clicked.data("exdata").data)
    			}
    		});
    	}
    },
    
    // @Override 必要方法：用于在Tab发生修改时，点击放弃按钮调用的方法。
    discardTab : function (clicked) {
    	var transId = clicked.data("exdata").data.extendData.transId;
    	Flywet.ab({
			type : "get",
			url : "rest/trans/"+transId+"/discard"
		});
    },
    
    appendEl : function (data,pos){
    	var canvasObj=transEditorPanel_var.flowChart;
    	if(canvasObj && canvasObj.childCanvas){
    		var flow = canvasObj.getChildCanvasByIndex(0);
    		var realOffset = Flywet.widget.FlowChartUtils.scaleLength(canvasObj.config.scale,10);
    		var realPos = Flywet.widget.FlowChartUtils.arcScalePoint(canvasObj.config,{
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
    showGrid : function(){
    	var btnId = this.getId("grid_show");
    	var showGrid;
		if(this.tb.isActive(btnId)){
			showGrid=false;
			this.tb.inactive(btnId);
			this.tb.disabled(this.getId("grid_close"));
		}else{
			showGrid=true;
			this.tb.active(btnId);
			this.tb.enabled(this.getId("grid_close"));
		}
		var canvasObj=transEditorPanel_var.flowChart;
    	if(canvasObj && canvasObj.childCanvas){
    		var flow = canvasObj.getChildCanvasByIndex(0);
    		flow.showGrid(showGrid);
    	}
    },
    
    /**
     * 贴近网格
     */
    closeGrid : function(){
    	var btnId = this.getId("grid_close");
    	var close;
		if(this.tb.isActive(btnId)){
			close=false;
			this.tb.inactive(btnId);
		}else{
			close=true;
			this.tb.active(btnId);
		}
		var canvasObj=transEditorPanel_var.flowChart;
    	if(canvasObj && canvasObj.childCanvas){
    		var flow = canvasObj.getChildCanvasByIndex(0);
    		flow.closeGrid(close);
    	}
    },

    hopContext : function (coords,flowChart,flowObject,model){
        if(window["menu_trans_hop_var"] == undefined){
			Flywet.cw("Menu","menu_trans_hop_var",{
				id : "menu_trans_hop",
				itemWidth : 120,
				menuItems : [{
					id : "menu_trans_hop_flip",
					text : "翻转方向",
					iconCls : "",
					onclick : "Flywet.browse.changeDirByContext(event)"
				},{
					id : "menu_trans_hop_disabled",
					text : "使节点连接失效",
					iconCls : ""
				},{
					id : "menu_trans_hop_delete",
					text : "删除节点连接",
					iconCls : ""
				},{
					type : "separator"
				},{
					id : "menu_trans_hop_main",
					text : "主输出步骤",
					iconCls : "ui-icon-check"
				},{
					id : "menu_trans_hop_error",
					text : "错误处理步骤",
					iconCls : ""
				}]
			});
		}
        menu_trans_hop_var.show(coords.e);
    },

    hopDblclick : function (flowChart,flowObject,model){
    	
    },

    stepContent : function (coords,flowChart,flowObject,model){
        if(window["menu_trans_step_var"] == undefined){
			Flywet.cw("Menu","menu_trans_step_var",{
				id : "menu_trans_step",
				itemWidth : 180,
				menuItems : [{
					id : "menu_trans_step_flip",
					text : "<b>编辑步骤...</b>",
					iconCls : "",
					onclick : "Flywet.browse.changeDirByContext(event)"
				},{
					id : "menu_trans_step_disabled",
					text : "编辑步骤描述...",
					iconCls : ""
				},{
					type : "separator"
				},{
					id : "menu_trans_step_data",
					text : "数据发送",
					iconCls : "",
					subItems : [{
						id : "menu_trans_step_distribute",
						text : "轮流发送模式",
						iconCls : "ui-icon-check"
					},{
						id : "menu_trans_step_balanse",
						text : "负载均衡模式",
						iconCls : ""
					},{
						id : "menu_trans_step_copy",
						text : "复制发送模式",
						iconCls : ""
					}]
				},{
					id : "menu_trans_step_copy_num",
					text : "更改开始复制的数量...",
					iconCls : ""
				},{
					type : "separator"
				},{
					id : "menu_trans_step_delete",
					text : "删除步骤",
					iconCls : ""
				},{
					id : "menu_trans_step_hide",
					text : "隐藏步骤",
					iconCls : ""
				},{
					id : "menu_trans_step_isolate",
					text : "分离步骤",
					iconCls : ""
				},{
					type : "separator"
				},{
					id : "menu_trans_step_show_input",
					text : "显示输入字段...",
					iconCls : ""
				},{
					id : "menu_trans_step_show_output",
					text : "显示输出字段...",
					iconCls : ""
				},{
					type : "separator"
				},{
					id : "menu_trans_step_error",
					text : "定义错误处理...",
					iconCls : ""
				}]
			});
		}
        menu_trans_step_var.show(coords.e);
    },
    
    /**
     * 判断是否可以进行连线
     * 
     * @param setting：fromElId, toElId
     * @param flowObject
     */
    checkEndHop : function (setting,flowObject){
    	var hops = flowObject.config.canvasEls.hops;
    	for(var i=0;i<hops.length;i++){
    		if(hops[i].fromElId == setting.fromElId && hops[i].toElId == setting.toElId){
    			return false;
    		}
    	}
    	return true;
    },
    
    stepSelect : function(flowChart,flowObject,model){
    	var editorIds = this.getId(["cut","copy"]);
    	var deleteId = this.getId("delete");
    	if(flowObject.hasSelectedEl("step")){
    		this.tb.enabled(editorIds);
    	}else{
    		this.tb.disabled(editorIds);
    	}
    	if(flowObject.hasSelectedEl()){
    		this.tb.enabled(deleteId);
    	}else{
    		this.tb.disabled(deleteId);
    	}
    },
    
    modify : function(flowChart,flowObject){
    	// 表示修改
    	baEditorPageTabs.setTabModify(null, true);
    },
    
    flush: function(params){
    	baEditorPageTabs.flush(null,params);
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
    	
    	var dialogId = "dialog-trans-step";
    	Flywet.cw("Dialog",dialogId+"_var",{
			id : dialogId,
			header : model.bText[0],
			width : w,
			height : h,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/trans/step/"+flowObject.config.extendData.transId+"/"+model.extendData.stepName+"/"+model.provider,
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "确定",
				title : "确定",
				click : {
					formId : "form:"+dialogId,
					formAction : "rest/trans/step/"+flowObject.config.extendData.transId+"/"+model.extendData.stepName+"/save",
					params : {
						dx : model.dx,
						dy : model.dy
					},
					onsuccess : function(data){
						Flywet.editors.trans.action.modify(flowChart,flowObject);
						if(data.data){
							var flag = Flywet.parseJSON(data.data);
							if(flag.reflush){
								Flywet.editors.trans.action.flush(flag.data);
							}
						}
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
    },
    
    run : function(){
    	var canvasObj=transEditorPanel_var.flowChart;
    	var transId = canvasObj.config.data.extendData.transId;
    	
    	var dialogId = "dialog-trans-run";
    	Flywet.cw("Dialog",dialogId+"_var",{
			id : dialogId,
			header : "执行转换",
			width : 600,
			height : 400,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/trans/"+transId+"/run",
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "确定",
				title : "确定",
				click : {
					formId : "form:"+dialogId,
					formAction : "rest/trans/"+transId+"/run/do"
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
			maximizable : true
		});
    },
    
    check : function(){
    	var canvasObj=transEditorPanel_var.flowChart;
    	var transId = canvasObj.config.data.extendData.transId;
    	
    	var dialogId = "dialog-trans-check";
    	Flywet.cw("Dialog",dialogId+"_var",{
			id : dialogId,
			header : "转换验证结果",
			width : 600,
			height : 400,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/trans/"+transId+"/check",
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "关闭",
				title : "关闭",
				events : {
					"click" : "hide"
				}
			}],
			closable : true,
			maximizable : true
		});
    },
    
    checkShowSuccess : function(val){
    	// 显示成功记录
    	if(val){
    		trans_check_var.jq.datagrid("setOptions",{dataFilter:function(index, row) {return true;}})
    		trans_check_var.jq.datagrid("reload");
    	}else{
    		trans_check_var.jq.datagrid("setOptions",{
    			dataFilter:function(index, row) {
    				if(row.type != '1'){
    					return true;
    				}
    				return false;
    			}});
    		trans_check_var.jq.datagrid("reload");
    	}
    	
    },
    
    analyse : function(){
    	var canvasObj=transEditorPanel_var.flowChart;
    	var transId = canvasObj.config.data.extendData.transId;
    	
    	var dialogId = "dialog-trans-analyse";
    	Flywet.cw("Dialog",dialogId+"_var",{
			id : dialogId,
			header : "影响分析",
			width : 600,
			height : 400,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/trans/"+transId+"/analyse",
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "关闭",
				title : "关闭",
				events : {
					"click" : "hide"
				}
			}],
			closable : true,
			maximizable : true
		});
    },
    
    showLog : function(){
    	$transLayout.toggle('south',true);
    }
    
};