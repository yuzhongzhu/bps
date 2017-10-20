/*function deleteOrder(id){
	$("#orderList").children().each(function(i){
		if($(this).attr("value")==id){
			$(this).remove();
		}
	});
	if($("#orderList").children().length==1){
		$("#orderBtn").hide();
	}
}


function updateOrder(tag){
	$("#orderList").children().each(function(i){
		if($(this).attr("value")==tag){
			$('input[name="id"]').val(tag);
			$(this).children().each(function(i){
				if($(this).attr("name")!="id"){
					$('input[name="'+$(this).attr("name")+'"]').val($(this).html());
				}
			});
		}
	});
	$('#myModalLabel').html("修改")
	$('#myModal').modal('show');
}*/
$("input[name='productCd_Q']").autocomplete({
	minLength : 1,
	source : function(request, response) {
		var prdCd = "%"+request.term+"%";
		$.ajax({
			url : "back/prd/queryKey",
			data:JSON.stringify({'productCd': prdCd}),
			dataType : 'json',
			contentType: "application/json; charset=utf-8",  
			type : "POST",
			success : function(result) {
			  console.log(result);
			  response($.map(result, function (data, index) { 
				 
				 var obj ={label: data.productCd+"--"+data.productNm,value:data.productCd};
				 /* var obj = {label: data.Code + "--" + data.Name, value: data.Name }*/
			  return obj; }
			  ))
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				console.log("无信息");
			}
		});
	},
	select : function(event, ui) {
			 console.log(ui);
			 var labelVl = ui.item.label;
			 var arry = labelVl.split("--");
	}
});
$(function(){
	$("#outOrderQuery").click(function(){
		queryOrder();
	});
	
});


function queryOrder(){
	var paramJson = {};
	var productCd = $('input[name="productCd_Q"]').val();
	var outBatchNo = $('input[name="outBatchNo_Q"]').val();
	var crtDt = $('#dtp_input2').val();
	if(productCd!=''){
		paramJson.productCd = "%"+productCd+"%";
	}
	if(outBatchNo!=''){
		paramJson.outBatchNo = "%"+outBatchNo+"%";
	}
	paramJson.outRegisterTm = crtDt;
	$('#out_order_list').table_list({attrOprColumNm:"id",oprtJson:[{oprFunc:"updateOutOrder",oprFuncNm:"取消"}]},paramJson);
	clearForm();
}




function updateOutOrder(obj){
	//$("#outOrderModal").modal('show');
	$("#dataItem").children().each(function(i){
		if($(this).attr("value")==obj){
			$(this).children().each(function(i){
				if($(this).attr("name")=="sta"){
					var text =$(this).html();
					if(text=="取消"){
						messageAlert('操作提示!', "订单状态已取消不可进行更新");
						return;
					}else{
						var url = "back/outOrder/updateSta";
						var paramJson ={id:obj,sta:'0'};
						$.post(url,paramJson,function(data){
							var data = JSON.parse(data);
							console.log(data);
							var tips = '';
							if (data.code == 'OK') {
								tips = "更新状态成功";
								queryOrder();
							} else if (data.code == 'EXIST') {
								tips = "当前产品型号已存在，无需录入";
							} else {
								tips = "更新状态失败";
							}
							messageAlert('操作提示!', tips);
						});
					}
				}
			});
		}
	});
}