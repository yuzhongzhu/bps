$(function(){
	$("#q-prdCd").autocomplete({
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
			/* $('#q-prdNm').val(ui.item.value);*/
		}
	});
	
});

/***
 * 产品基础信息列表查询
 */
function query(){
	var queryParam = {};
	var productCd = $('#q-prdCd').val();
	var productNm = $('#q-prdNm').val();
	queryParam.productCd =productCd;
	queryParam.productNm =productNm;
	$("#p_table_list").table_list({
		attrOprColumNm:"id",oprtJson:[{oprFunc:"updateInOrder",oprFuncNm:"更新"}]
	}, queryParam);
}

function updateInOrder(obj){
	$("#dataItem").children().each(function(i){
		if($(this).attr("value")==obj){
			$('input[name="id"]').val(obj);
			$(this).children().each(function(i){
				if($(this).attr("name")!="id"){
					if($(this).attr("name")!="param"){
						$('input[name="'+$(this).attr("name")+'"]').val($(this).html());
					}else{
						$('#param').val($(this).html());
					}
					
				}
			});
		}
	});
	//带开模态窗口
	$('#updatePModal').modal('show');
}

$("#updateBasePrd").click(function(){
	var url = "back/prd/updatePrd";
	var paramJson ={};
	paramJson.id = $('input[name="id"]').val();
	paramJson.productCd = $('input[name="productCd"]').val();
	paramJson.productNm = $('input[name="productNm"]').val();
	paramJson.basePrice = $('input[name="basePrice"]').val();
	paramJson.price = $('input[name="price"]').val();
	paramJson.param = $('#param').val();
	$.post(url,paramJson,function(data){
		var dataJson = JSON.parse(data);
		var tips = '';
		if(dataJson.code=='OK'){
			tips ="更新成功";
			query();
		}else {
			tips ="更新失败";
		}
		messageAlert('操作提示!',tips);
		
	})
})