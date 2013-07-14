Plywet.filesys = {
	fsopContext:{},
	ids : {
		bpVarName : "editorContent-navi-filesys-bp_var",
		rootBtns : ["fs-btn-create","fs-btn-edit","fs-btn-remove"],
		itemBtns : ["fs-btn-create-dir","fs-btn-upload-file","fs-btn-download-file"]
	},
	tb : Plywet.editors.toolbarButton,
	delFile	: function() {
		if (!Plywet.editors.item.checkSelected(Plywet.filesys.ids.bpVarName)) {
			Plywet.dialog.warning("请先选中一个对象。");
			return;
		}
		var selItem = Plywet.editors.item.getOneSelected(Plywet.filesys.ids.bpVarName);
		Plywet.ab({
			type : "DELETE",
			url : "rest/fsop/delete?data=" + Plywet.toJSONString(selItem)
		});
	},
	downloadFile	: function() {
		if (!Plywet.editors.item.checkSelected(Plywet.filesys.ids.bpVarName)) {
			Plywet.dialog.warning("请先选中一个对象。");
			return;
		}
		var selItem = Plywet.editors.item.getOneSelected(Plywet.filesys.ids.bpVarName);
		if(selItem.type == "node"){
			Plywet.dialog.error("系统无法下载文件夹，请选中一个文件对象进行下载。");
		}else{
			selItem = {
				rootId : selItem.rootId,
				path : selItem.path,
				category : selItem.category
			};
			$(Plywet.escapeClientId("filesys-space-frame")).attr("src","rest/fs/download?data="+encodeURIComponent(Plywet.toJSONString(selItem)));
		}
	},
	uploadResult : function(target) {
		var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
		var targetId = "upload_dialog_" + currentCase.category;
		
		var msg = $(document.getElementById('fs_upload_space_frame').contentWindow.document.body).find("pre");
		msg = $(msg).html();
		if(msg && msg != ""){
			msg = Plywet.parseJSON(msg);
			// 清空
			$(document.getElementById('fs_upload_space_frame').contentWindow.document.body).html("");
			
			window[targetId + "_var"].hide();
			this.flushDir(currentCase.category,{rootId:currentCase.rootId,path:currentCase.path});
			
			Plywet.ajax.ShowMessage(msg);
		}
	},
	uploadFile	: function() {
		var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
		var targetId = "upload_dialog_" + currentCase.category;
		
		var parentDir = {
			rootId : currentCase.rootId,
			path : currentCase.path,
			category : currentCase.category
		};
		
		Plywet.cw("Dialog",targetId + "_var",{
			id : targetId,
			header : "文件上传",
			width : 400,
			height : 300,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/fs/items/upload?data="+encodeURIComponent(Plywet.toJSONString(parentDir)),
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "新增",
				title : "新增",
				events: {
					click:function(){
						var layout = $(Plywet.escapeClientId("fs_upload_form")).find(".ui-grid-layout");
						var num = layout.find("label").size() + 1;
						layout.append('<div class="ui-grid-layout-item ui-layout-float ui-helper-clearfix" style="width: 30%; height: 28px;">' +
								'<label class="ui-label-default ui-helper-clearfix" for="fs'+num+'" style="margin:5px 30px 5px 5px;float:right;" text="上传文件'+num+'：" buddy="fs'+num+'">上传文件'+num+'：</label>' +
								'</div>');
						layout.append('<div class="ui-grid-layout-item ui-layout-float ui-helper-clearfix" style="width: 70%; height: 28px;">' +
								'<input id="fs'+num+'" type="file" size="30" name="fs'+num+'">' +
								'</div>');
					}
				}
			},{
				componentType : "fly:PushButton",
				type : "button",
				label : "上传",
				title : "上传",
				events: {
					click:function(){
						$(Plywet.escapeClientId("fs_upload_form")).submit();
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
	rename : function() {
		var selItem = Plywet.editors.item.getOneSelected(Plywet.filesys.ids.bpVarName);
		var targetId = "rename_dialog_" + selItem.category + "_" + selItem.type;
		
		Plywet.cw("Dialog",targetId + "_var",{
				id : targetId,
				header : "重命名【" + selItem.name + "】",
				width : 700,
				height : 400,
				autoOpen : true,
				showHeader : true,
				modal : true,
				url : "rest/fs/items/rename?srcName=" + selItem.name+"&data=" + Plywet.toJSONString(selItem),
				footerButtons : [{
					componentType : "fly:PushButton",
					type : "button",
					label : "确定",
					title : "确定",
					events: {
						click:function(){
							Plywet.ab({
								type : "post",
								url : "rest/fsop/rename",
								source:"fs_rename_form",
								onsuccess:function(data, status, xhr) {
									if (data.state == 0) {
										window[targetId + "_var"].hide();
									}
								}
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
	createDir : function() {
		var _self = this;
		var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
		var category =  currentCase.category;
		var targetId = "fs_create_dialog_folder";
		
		Plywet.cw("Dialog",targetId+"_var",{
			id : targetId,
			header : "新建目录",
			width : 500,
			height : 70,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/fs/items/folder/create/"+category,
			params : {
				targetId : targetId+":content",
				rootId : currentCase.rootId,
				path : currentCase.path
			},
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "确定",
				title : "确定",
				events: {
					click:function(){
						Plywet.ab({
							formId:"fs_folder_create_form",
							formAction:"rest/fs/items/folder/createsubmit",
							onsuccess:function(data, status, xhr) {
								if (data.state == 0) {
									window[targetId + "_var"].hide();
									_self.flushDir(category,{rootId:currentCase.rootId,path:currentCase.path});
								}
							}
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
			maximizable : false,
			resizable : false
		});
	},
	
	cut:function(){
		var selItem = Plywet.editors.item.getOneSelected(Plywet.filesys.ids.bpVarName);
		if (selItem) {
			var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
			this.fsopContext = currentCase;
			this.fsopContext['path'] = selItem.path;
			this.fsopContext['operation'] = 'CUT';
		}
	},
	copy:function(){
		var selItem = Plywet.editors.item.getOneSelected(Plywet.filesys.ids.bpVarName);
		if (selItem) {
			var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
			this.fsopContext = currentCase;
			this.fsopContext['path'] = selItem.path;
			this.fsopContext['operation'] = 'COPY';
		}
	},
	paste:function(){
		var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
		var operateCase = this.fsopContext;
		
		Plywet.ab({
			type : "get",
			url : "rest/fsop/paste?currentCase="+Plywet.toJSONString(currentCase)+"&operateCase="+Plywet.toJSONString(operateCase)
		});
	},
	create:function(){
		var _self = this;
		var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
		var category =  currentCase.category;
		
		// 打开的dialog的id
		var targetId = "dialog_" + currentCase.category;
		
		Plywet.cw("Dialog", targetId + "_var",{
			id : targetId,
			header : "新增根目录属性",
			width : 350,
			height : 165,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/fs/items/create/"+category+"?targetId="+targetId+":content",
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "确定",
				title : "确定",
				events: {
					click:function(){
						Plywet.ab({
							type : "post",
							formId:"fs_create_form",
							onsuccess:function(data, status, xhr) {
								if (data.state == 0) {
									window[targetId + "_var"].hide();
									_self.flush(category);
								}
							}
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
			maximizable : false,
			resizable : false
		});
	},
	
	/**
	 * 编辑一个文件夹
	 */
	edit : function(){
		var _self = this;
		var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
		var category = currentCase.category;
		
		// 打开的dialog的id
		var targetId = "dialog_" + currentCase.category;
		
		// 获得选择项
		var selItem = Plywet.editors.item.getOneSelected(Plywet.filesys.ids.bpVarName);
		if(!selItem){
			Plywet.dialog.warning("请先选中一个对象。");
			return;
		}
		var id = selItem.id;
		
		Plywet.cw("Dialog", targetId + "_var",{
			id : targetId,
			header : "编辑根目录属性",
			width : 350,
			height : 165,
			autoOpen : true,
			showHeader : true,
			modal : true,
			url : "rest/fs/items/edit/"+category+"/"+id+"?targetId="+targetId+":content",
			footerButtons : [{
				componentType : "fly:PushButton",
				type : "button",
				label : "确定",
				title : "确定",
				events: {
					click:function(){
						Plywet.ab({
							type : "post",
							formId:"fs_edit_form",
							onsuccess:function(data, status, xhr) {
								if (data.state == 0) {
									window[targetId + "_var"].hide();
									_self.flush(category);
								}
							}
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
			maximizable : false,
			resizable : false
		});
		
	},
	remove:function(){
		var _self = this;
		var currentCase = window[Plywet.filesys.ids.bpVarName].getCurrentData();
		var category = currentCase.category;
		
		// 获得选择项
		var selItem = Plywet.editors.item.getOneSelected(Plywet.filesys.ids.bpVarName);
		if(!selItem){
			Plywet.dialog.warning("请先选中一个对象。");
			return;
		}
		var id = selItem.id;
		
		Plywet.cw("ConfirmDialog",null,{type:"confirm",
			text:"确认删除文件夹[ " + selItem.displayName + " ]？",
			confirmFunc:function(e,val){
				if(val){
					Plywet.ab({
						type : "DELETE",
						url : "rest/fs/items/remove/"+category+"/"+id,
						onsuccess:function(data, status, xhr) {
							if (data.state == 0) {
								_self.flush(category);
							}
						}
					});
				}
			}
		});
	},
	
	flush:function(category){
		// 更新当前目录内容
		Plywet.ab({
			type : "get",
			url : "rest/fs/root/"+category
		});
	},
	
	flushDir:function(category,data){
		Plywet.ab({
			type : "get",
			url : "rest/fs/items/list/"+category,
			params : {
				data : Plywet.toJSONString(data)
			}
		});
	},
	
	controlBtn:function(type){
		if(type == "root"){
			this.tb.show(this.ids.rootBtns);
			this.tb.hide(this.ids.itemBtns);
		}else if(type == "item"){
			this.tb.hide(this.ids.rootBtns);
			this.tb.show(this.ids.itemBtns);
		}else{
			this.tb.hide(this.ids.rootBtns);
			this.tb.hide(this.ids.itemBtns);
		}
	}
};