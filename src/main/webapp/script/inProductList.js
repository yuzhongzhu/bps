$(function(){
	$("#inOrderQuery").click(function(){
		inOrderQuery();
	});
	
});


function inOrderQuery(){
	var paramJson = {};
	var productCd = $('input[name="productCd_Q"]').val();
	var batchNo = $('input[name="batchNo_Q"]').val();
	var crtDt = $('#dtp_input2').val();
	if(productCd!=''){
		paramJson.productCd = "%"+productCd+"%";
	}
	if(productCd!=''){
		paramJson.batchNo = "%"+batchNo+"%";
	}
	paramJson.inRegisterTm = crtDt;
	$('#in_order_list').table_list({attrOprColumNm:"id",oprtJson:[{oprFunc:"updateInOrder",oprFuncNm:"更新"},{oprFunc:"deleteInOrder",oprFuncNm:"删除"}]},paramJson);
}
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


function updateInOrder(obj){
	$("#dataItem").children().each(function(i){
		if($(this).attr("value")==obj){
			$('input[name="id"]').val(obj);
			$(this).children().each(function(i){
				if($(this).attr("name")!="id"){
					$('input[name="'+$(this).attr("name")+'"]').val($(this).html());
				}
			});
		}
	});
	$('#inOrderModal').modal('show');
}
$('#updateOrderBtn').click(function(){
	var url = "back/inPrd/updateOrder";
	var paramJson = {};
	 paramJson.id = $('input[name="id"]').val();
	 paramJson.productCd = $('input[name="productCd"]').val();
	 paramJson.batchNo = $('input[name="batchNo"]').val();
	 paramJson.inCount = $('input[name="inCount"]').val();
	 paramJson.inSumAmt = $('input[name="inSumAmt"]').val();
	 paramJson.basePrice = $('input[name="basePrice"]').val();
	 $.post(url,paramJson,function(data){
		 var dataJson = JSON.parse(data);
		 var tips = '';
			if(dataJson.code=='OK'){
				tips ="更新成功";
				inOrderQuery();
			}else {
				tips ="更新失败";
			}
			messageAlert('操作提示!',tips);
	 });
	
});

function deleteInOrder(obj){
	console.log(obj);
}