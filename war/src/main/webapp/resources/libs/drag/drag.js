/**
 * 拖动
 * @author yanghyc
 * @date 2012-10-18
 */
Flywet.widget.Drag=function(cfg){
	this.cfg = cfg;
	this.dom=cfg.dom;
	this.targetid=cfg.targetid;
	this.id = this.cfg.id;
	this.jqId = Flywet.escapeClientId(this.id);
	this.jq = $(this.jqId);
	this.init();
};
Flywet.extend(Flywet.widget.Drag, Flywet.widget.BaseWidget);
Flywet.widget.Drag.prototype={
	init:function(){
		var src=this.dom;
		if(!src&&this.id) src="#"+this.id;
		if(src){
			this.drag(src);
			this.setCSS();
		}
	},
	drag:function(dom){
		var _self=this;
		$(dom).draggable({
			'helper':'clone',
			'scroll': false,
			'drag':function(e){
				if(_self.cfg.drag) _self.cfg.drag(_self.cfg.data);
				//TODO以下为测试代码后续应当被删除
				if(!_self.targetid) return;
				$("#"+_self.targetid).html(e.clientX+"--"+e.clientY);
			},
			'stop':function(e){
				if(_self.cfg.stop) _self.cfg.stop(_self.cfg.data);
				alert(JSON.stringify(_self.cfg.data));
				//TODO以下为测试代码后续应当被删除
				if(!_self.targetid) return;
				var offset=$("#"+_self.targetid).offset();
				var height=$("#"+_self.targetid).outerHeight();
				var width=$("#"+_self.targetid).outerWidth();
				if(offset.left<e.clientX&&e.clientX<(offset.left+width)&&offset.top<e.clientY&&e.clientY<(offset.top+height)){
					
					$(dom).clone().appendTo("#"+_self.targetid);
				
				}
			}
		});
	},
	setCSS:function(){
		$("#"+this.id).css({
			'cursor':'move'
		});
	}
};

