<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${pageScope.basePath}script/plugins/jquery-confirm.min.css">
<script src="${pageScope.basePath}script/plugins/jquery-confirm.min.js"></script>
<script src = "${pageScope.basePath}script/plugins/pagination.js"></script>
<link href="${pageScope.basePath}css/base.css" rel="stylesheet">
<link rel="stylesheet" href="${pageScope.basePath}script/plugins/jquery-ui.css">
<script src="${pageScope.basePath}script/plugins/jquery-ui.js"></script> 
<script>
 function messageAlert(titleShow,msg,callback){
	$.alert({
		    title: titleShow,
		    content: msg,
		    buttons:{ok:function(){
		    	if(typeof callback === "function"){
		    		callback();
		    	}
		    }}
		});
 }
 
 
 function clearForm(){
	 $(':input').not(':button, :submit, :reset, :hidden').val('').removeAttr('checked').removeAttr('selected');  
 }
</script>