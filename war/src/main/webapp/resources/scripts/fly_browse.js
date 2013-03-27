Plywet.browse = {
	TEMP : {},
	showOperationForDir : function(event,data) {
		if (event.which != 3) { //不是右键
			return false;
		}
		Plywet.browse.TEMP.contextObjectData = data;
		if(window["menu_dir_var"] == undefined){
			Plywet.cw("Menu","menu_dir_var",{
				id : "menu_dir",
				itemWidth : 120,
				menuItems : [{
					id : "menu_dir_open",
					text : "<b>打开</b>",
					iconCls : "ui-icon-system-open",
					onClick : "Plywet.browse.changeDirByContext(event)"
				},{
					type : "separator"
				},{
					id : "menu_dir_cut",
					text : "剪切",
					iconCls : "ui-icon-system-cut"
				},{
					id : "menu_dir_copy",
					text : "复制",
					iconCls : "ui-icon-system-copy"
				},{
					id : "menu_dir_rename",
					text : "重命名",
					iconCls : ""
				},{
					id : "menu_dir_delete",
					text : "删除",
					iconCls : "ui-icon-system-delete"
				}]
			});
		}
		menu_dir_var.show(event);
	},
	changeDirByContext : function(event) {
		Plywet.browse.changeDir(event,Plywet.browse.TEMP.contextObjectData);
	},
	changeDir : function(event,data) {
		Plywet.ab({
			type : "get",
			url : "rest/"+data.attrs.src,
			params: {
				"data": Plywet.toJSONString($.extend({},data.data,data.attrs))
			}
		});
	},
	showOperationForFile : function(event,data) {
		if (event.which != 3) { //不是右键
			return false;
		}
		Plywet.browse.TEMP.contextObjectData = data;
		var category = data.data.category;
		if(category=="trans" || category=="job"){
			if(window["menu_file_var"] == undefined){
				Plywet.cw("Menu","menu_file_var",{
					id : "menu_file",
					itemWidth : 120,
					menuItems : [{
						id : "menu_file_open",
						text : "<b>打开</b>",
						iconCls : "ui-icon-system-open",
						onClick : "Plywet.browse.openFileByContext(event)"
					},{
						type : "separator"
					},{
						id : "menu_file_cut",
						text : "剪切",
						iconCls : "ui-icon-system-cut"
					},{
						id : "menu_file_copy",
						text : "复制",
						iconCls : "ui-icon-system-copy"
					},{
						id : "menu_file_rename",
						text : "重命名",
						iconCls : ""
					},{
						id : "menu_file_delete",
						text : "删除",
						iconCls : "ui-icon-system-delete"
					},{
						type : "separator"
					},{
						id : "menu_file_attribute",
						text : "属性",
						iconCls : "ui-icon-system-setting",
						onClick : "Plywet.browse.openFileSettingByContext(event)"
					}]
				});
			}
			menu_file_var.show(event);
		}else if(category=="db"){
			if(window["menu_db_var"] == undefined){
				Plywet.cw("Menu","menu_db_var",{
					id : "menu_db",
					itemWidth : 120,
					menuItems : [{
						id : "menu_db_open",
						text : "<b>打开</b>",
						iconCls : "ui-icon-system-open",
						onClick : "Plywet.browse.openFileByContext(event)"
					},{
						type : "separator"
					},{
						id : "menu_db_copy",
						text : "复制",
						iconCls : "ui-icon-system-copy"
					},{
						id : "menu_file_rename",
						text : "重命名",
						iconCls : ""
					},{
						id : "menu_db_delete",
						text : "删除",
						iconCls : "ui-icon-system-delete"
					}]
				});
			}
			menu_db_var.show(event);
		}
		
	},
	openFileSettingByContext : function(event){
		var data = Plywet.browse.TEMP.contextObjectData;
		var category = data.data.category;
		Plywet.cw("Dialog","dialog_"+category+"_"+data.data.type+"_"+data.data.id+"_var",{
			id : "dialog:"+category+":"+data.data.type+":"+data.data.id,
			header : "设置【"+data.attrs.displayName+"】",
			width : 700,
			height : 400,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/"+data.attrs.src+"/setting",
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "确定",
				title : "确定",
				events : {
					"click" : function(){
						Plywet.ab({
							formId : "db_"+data.data.id,
							formAction : "rest/"+data.attrs.src+"/setting/save",
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
			maximizable : true
		});
	},
	openFileByContext : function(event) {
		Plywet.browse.openFile(event,Plywet.browse.TEMP.contextObjectData);
	},
	openFile : function(event,data) {
		var superData = data,
			category = data.data.category,
			tabName = category+"-"+data.id+"-tab",
			displayName = data.attrs.displayName;
		
		// 转换、作业、表单报表打开转换设计器（TAB）
		if(category=="trans" || category=="job" || category=="form"){
			if (diEditorPageTabs.hasMatch(tabName)) {
				diEditorPageTabs.select(tabName);
				return;
			}
			Plywet.ab({
				type : "get",
				modal : true,
				modalMessage : "正在加载【"+displayName+"】...",
				url : "rest/"+data.attrs.src,
				onsuccess : function(data, status, xhr){
					diEditorPageTabs.addTab({
						exdata: data,
						tabId: category,
						tabText: displayName,
						dataTarget: tabName,
						closable: true,
						closePanel: false,
				        checkModify: true
					});
				}
			});
		}
		// 数据库文件打开数据库配置页面
		else if(category=="db"){
			Plywet.cw("Dialog","dialog_"+category+"_"+data.data.type+"_"+data.data.id+"_var",{
				id : "dialog:"+category+":"+data.data.type+":"+data.data.id,
				header : "编辑【"+displayName+"】",
				width : 700,
				height : 400,
				autoOpen : true,
				showHeader : true,
				modal : true,
				url : "rest/"+data.attrs.src,
				footerButtons : [{
					componentType : "fly:PushButton",
					type : "button",
					label : "确定",
					title : "确定",
					events : {
						"click" : function(){
							Plywet.ab({
								formId : "db_"+data.data.id,
								formAction : "rest/"+data.attrs.src+"/save"
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
				maximizable : true
			});
		}
	}
};