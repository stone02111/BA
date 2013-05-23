Plywet.filesys = {
	fsopContext:{},
	delFile	: function() {
		if (!this.checkSelected()) {
			return;
		}
		var selItem = this.getOneSelected();
		Plywet.ab({
			type : "DELETE",
			url : "rest/fsop/delete?data=" + Plywet.toJSONString(selItem)
		});
	},
	downloadFile	: function() {
		if (!this.checkSelected()) {
			return;
		}
		var selItem = this.getOneSelected();
		$('#space_frame').attr("src","rest/fsop/download?data="+Plywet.toJSONString(selItem));
		/*
		Plywet.ab({
			type : "get",
			url : "rest/fsop/download",
			params: {
				"data": Plywet.toJSONString(selItem)
			}
		});
		*/
	},
	uploadFile	: function() {
		var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
		var targetId = "upload_dialog_" + currentCase.category + "_" + currentCase.rootId;
		
		Plywet.cw("Dialog",targetId + "_var",{
				id : targetId,
				header : "文件上传",
				width : 700,
				height : 400,
				autoOpen : true,
				showHeader : true,
				modal : true,
				url : "rest/fs/items/upload?data="+Plywet.toJSONString(currentCase),
				footerButtons : [{
					componentType : "fly:PushButton",
					type : "button",
					label : "新增",
					title : "新增",
					events: {
						click:function(){
							$('#files_div').append('<input type="file" name="file"></input>');
						}
					}
				},{
					componentType : "fly:PushButton",
					type : "button",
					label : "上传",
					title : "上传",
					events: {
						click:function(){
							$("#fs_upload_form").submit();
							/*Plywet.ab({
								type : "POST",
								url : "rest/fsop/upload",
								source:"fs_upload_form",
								onsuccess:function(data, status, xhr) {
									alert(data.messages[0]);
									if (data.state == 0) {
										window[targetId + "_var"].hide();
									}
								}
							});*/
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
		var selItem = this.getOneSelected();
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
								type : "POST",
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
	createDir	: function() {
		var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
		var targetId = "create_dialog_" + currentCase.category + "_" + currentCase.rootId;
		
		Plywet.cw("Dialog",targetId + "_var",{
				id : targetId,
				header : "新建目录",
				width : 700,
				height : 400,
				autoOpen : true,
				showHeader : true,
				modal : true,
				url : "rest/fs/items/create?data="+Plywet.toJSONString(currentCase),
				footerButtons : [{
					componentType : "fly:PushButton",
					type : "button",
					label : "确定",
					title : "确定",
					events: {
						click:function(){
							Plywet.ab({
								type : "POST",
								url : "rest/fsop/create",
								source:"fs_create_form",
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
	checkSelected:function() {
		var fsbpvar = window["editorContent-navi-filesys-bp_var"];
		
		var selItems = fsbpvar.getSelections();
		if (!selItems || selItems.length == 0) {
			return false;
		}
		if (selItems.length > 1) {
			return false;
		}
		return true;
	},
	
	/**
	 * 获得一个选中节点
	 */
	getOneSelected : function() {
		var fsbpvar = window["editorContent-navi-filesys-bp_var"];
		if (this.checkSelected()) {
			var selItems = fsbpvar.getSelections();
			return selItems[0];	
		}
		
		return null;
	},
	
	cut:function(){
		var selItem = this.getOneSelected();
		if (selItem) {
			var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
			this.fsopContext = currentCase;
			this.fsopContext['path'] = selItem.path;
			this.fsopContext['operation'] = 'CUT';
		}
	},
	copy:function(){
		var selItem = this.getOneSelected();
		if (selItem) {
			var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
			this.fsopContext = currentCase;
			this.fsopContext['path'] = selItem.path;
			this.fsopContext['operation'] = 'COPY';
		}
	},
	paste:function(){
		var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
		var operateCase = this.fsopContext;
		
		Plywet.ab({
			type : "GET",
			url : "rest/fsop/paste?currentCase="+Plywet.toJSONString(currentCase)+"&operateCase="+Plywet.toJSONString(operateCase)
		});
	},
	addHost:function(){
		var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
		var targetId = "create_dialog_" + currentCase.category + "_" + currentCase.rootId;
		
		Plywet.cw("Dialog",targetId + "_var",{
				id : targetId,
				header : "新增主机",
				width : 700,
				height : 400,
				autoOpen : true,
				showHeader : true,
				modal : true,
				url : "rest/host/setting",
				footerButtons : [{
					componentType : "fly:PushButton",
					type : "button",
					label : "确定",
					title : "确定",
					events: {
						click:function(){
							Plywet.ab({
								type : "POST",
//								url : "rest/host/setting",
								source:"fs_host_form",
								onsuccess:function(data, status, xhr) {
									if (data.state == 0) {
										window[targetId + "_var"].hide();
									}
								}
							});
						}
					}				},{
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
	removeHost:function(){
		var selItem = this.getOneSelected();
		Plywet.ab({
			type : "DELETE",
			url : "rest/host/" + selItem.id
		});
	},
	addFsLocal:function(){
		var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
		var targetId = "create_dialog_" + currentCase.category + "_" + currentCase.rootId;
		
		Plywet.cw("Dialog",targetId + "_var",{
				id : targetId,
				header : "新增根目录",
				width : 700,
				height : 400,
				autoOpen : true,
				showHeader : true,
				modal : true,
				url : "rest/fslocal/setting",
				footerButtons : [{
					componentType : "fly:PushButton",
					type : "button",
					label : "确定",
					title : "确定",
					events: {
						click:function(){
							Plywet.ab({
								type : "POST",
								url : "rest/fslocal/setting",
								source:"fs_fslocal_form",
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
	removeFsLocal:function(){
		var selItem = this.getOneSelected();
		Plywet.ab({
			type : "DELETE",
			url : "rest/fslocal/" + selItem.id,
			onsuccess:function(data, status, xhr) {
						alert(data.messages[0]);
					}
		});
	},
	add:function(){
		var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
		var category =  currentCase.category;
		if ("local" == category) {
			this.addFsLocal();
		} else {
			this.addHost();
		}
	},
	
	/**
	 * 编辑一个文件夹
	 */
	edit : function(){
		var _self = this;
		
		var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
		var category = currentCase.category;
		
		// 打开的dialog的id
		var targetId = "dialog_" + currentCase.category;
		
		// 获得选择项
		var selItem = _self.getOneSelected();
		if(!selItem){
			Plywet.dialog.prompt("请先选中一个对象。");
			return;
		}
		var id = selItem.id;
		
		if ("local" == category) {
			editFsLocal();
		} else {
			editFtp();
		}
		
		function editFsLocal(){
			
			Plywet.cw("Dialog", targetId + "_var",{
				id : targetId,
				header : "编辑根目录属性",
				width : 350,
				height : 165,
				autoOpen : true,
				showHeader : true,
				modal : true,
				url : "rest/fs/items/edit/"+id+"?targetId="+targetId+":content",
				footerButtons : [{
					componentType : "fly:PushButton",
					type : "button",
					label : "确定",
					title : "确定",
					events: {
						click:function(){
							Plywet.ab({
								type : "POST",
								url : "rest/fslocal/setting",
								source:"fs_fslocal_form",
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
		}
		
		function editFtp(){

			Plywet.cw("Dialog",targetId + "_var",{
					id : targetId,
					header : "编辑主机",
					width : 700,
					height : 400,
					autoOpen : true,
					showHeader : true,
					modal : true,
					url : "rest/host/setting?hostId=" + id,
					footerButtons : [{
						componentType : "fly:PushButton",
						type : "button",
						label : "确定",
						title : "确定",
						events: {
							click:function(){
								Plywet.ab({
									type : "POST",
									url : "rest/host/setting",
									source:"fs_host_form",
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
		}
	},
	remove:function(){
		var currentCase = window["editorContent-navi-filesys-bp_var"].getCurrentData();
		var category =  currentCase.category;
		if ("local" == category) {
			this.removeFsLocal();
		} else {
			this.removeHost();
		}
	}
};