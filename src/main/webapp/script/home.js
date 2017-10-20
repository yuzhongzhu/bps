/**
 * 填充主窗口显示
 * @param url
 */
function init(url){
	console.log("asdfas"+url);
	$.ajax({
		url:url,
		type:'post',
		dataType:'html',
		error: function(){alert('error');},
		success:function(data){
		$("#content").html(data);
		}
		});
}


$(function(){
	 $.post('back/menu/query',{},function(data){
		 var menuJsonObj =JSON.parse(data);
		 var menuHtml ='';
		 $.each(menuJsonObj,function(index,obj){
			 if(obj.parentId=='-1'){
				 menuHtml = menuHtml+'<a href="#dashboard-menu'+obj.id+'" class="list-group-item nav-header menu-list-item" data-toggle="collapse" target="menuFrame">'
				 menuHtml = menuHtml+obj.menuNm +'</a>';
				 menuHtml = menuHtml+'<ul id="dashboard-menu'+obj.id+'" class="nav nav-list collapse"></ul>'
			 }
		 });
		 $('.list-group').html(menuHtml);
		 $.each(menuJsonObj,function(index,obj){
			 if(obj.parentId !='-1'){
				$('#dashboard-menu'+obj.parentId).append('<li><a href="javascript:void(0);" onclick="init('+"'"+obj.url+"'"+')">'/*'<li><a href="javascript:void(0);">'*/+obj.menuNm+'</a></li>');
			 }
		 });
	 });
	 init('main.jsp');
})