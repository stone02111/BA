<div id="editorContent-navi-${entity.code}" class="fly-editor-tab">
	<div id="editorContent-navi-filesys-bc" class="ui-breadcrumb ui-widget-header ui-helper-clearfix ui-corner-all">
		<div class="ui-toolbar-group-left" style="width: 20%;">
			<ul>
			</ul>
		</div>
		<div class="ui-toolbar-group-right">
            <fly:pushbutton id="fs-btn-create" icon="ui-icon-folder-open" show="N"
            	label="新增" title="新增" onclick="Flywet.filesys.create()" />
            <fly:pushbutton id="fs-btn-edit" icon="ui-icon-folder-open" show="N"
            	label="编辑" title="编辑" onclick="Flywet.filesys.edit()" />
            <fly:pushbutton id="fs-btn-remove" icon="ui-icon-folder-open" show="N"
            	label="删除" title="删除" onclick="Flywet.filesys.remove()" />
            <fly:pushbutton id="fs-btn-create-dir" icon="ui-icon-folder-open" show="N"
            	label="创建目录" title="创建目录" onclick="Flywet.filesys.createDir()" />
            <fly:pushbutton id="fs-btn-upload-file" icon="ui-icon-folder-open" show="N"
            	label="上传" title="上传" onclick="Flywet.filesys.uploadFile()" />
            <fly:pushbutton id="fs-btn-download-file" icon="ui-icon-folder-open" show="N"
            	label="下载" title="下载" onclick="Flywet.filesys.downloadFile()" />
		</div>
	</div>
	<div id="editorContent-navi-filesys-bp" class="fly-editor-content-height-browse-panel">
	</div>
	<iframe id="filesys-space-frame" class="ui-space-frame"></iframe>
</div>
