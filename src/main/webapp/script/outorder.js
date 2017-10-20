function deleteOrder(id){
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
}

$("input[name='productCd']").autocomplete({
	minLength : 1,
	source : function(request, response) {
		var prdCd = "%"+request.term+"%";
		$.ajax({
			url : "back/wareH/queryKey",
			data:JSON.stringify({'productCd': prdCd}),
			dataType : 'json',
			contentType: "application/json; charset=utf-8",  
			type : "POST",
			success : function(result) {
			  console.log(result);
			  response($.map(result, function (data, index) { 
				 
				 var obj ={label: data.productCd+"--"+data.remainAmt,value:data.productCd};
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
			 $('input[name="hiddenTotal"]').val(arry[1]);
	}
});

$(function(){
    $('#myModal').modal('hide');
    $('#orderModal').modal('hide')
	$("#orderBtn").hide();
	$("#pageSave").click(function(){
		var orderArr = [];
		var productCd = $('input[name="productCd"]').val();
		orderArr.push(productCd);
		var productNm = $('input[name="productNm"]').val();
		orderArr.push(productNm);
		var salePrice = $('input[name="salePrice"]').val();
		orderArr.push(salePrice);
		var outCount = $('input[name="outCount"]').val();
		orderArr.push(outCount);
		var disCount = $('input[name="disCount"]').val();
		if(disCount==''||disCount == ' '){
			disCount= 1;
		}
		orderArr.push(disCount);
		var outSumAmt = $('input[name="outSumAmt"]').val();
		orderArr.push(outSumAmt);
		var id = $('input[name="id"]').val();
		if(id==''){
			id = new Date().getTime();
			var content = $("#orderList").children().eq(0).prop("outerHTML");
			$("#orderList").append(content);
			$("#orderList").children().eq(0).attr("value",id);
			$("#orderList").children().eq(0).children().each(function(i,data){
				if($(this).attr("name")!="id"){
					$(this).html(orderArr[i]);
				}else {
					$(this).html("");
	            	$(this).append("<a href='javascript:;' onclick='deleteOrder("+id+")'>删除</a>||<a href='javascript:;' onclick='updateOrder("+id+")'>修改</a>")
				}
				
			});
			if($("#orderList").children().length>1){
				$("#orderBtn").show();
			}
		}else{
			$("#orderList").children().each(function(i){
				if($(this).attr("value")==id){
					$(this).children().each(function(i){
						if($(this).attr("name")!="id"){
							$(this).html(orderArr[i]);
						}
						
					});
				}
			});
		}
		clearForm();
	});
	
	$('input[name="salePrice"]').blur(function(){
		var salePrice = $('input[name="salePrice"]').val();
		if(salePrice==''||salePrice==' '){
			$('input[name="salePrice"]').val('');
			$('input[name="salePrice"]').focus();
			return;
		}
		var outCount = $('input[name="outCount"]').val();
		if(outCount==''||outCount ==' ' ||outCount==0){
			$('input[name="outCount"]').val('');
			$('input[name="outCount"]').focus();
			return;
		}
		var disCount = $('input[name="disCount"]').val();
		if(disCount==''||disCount == ' '){
			disCount= 1;
			$('input[name="disCount"]').val('1');
		}
		var outSumAmt = salePrice * outCount * disCount;
		$('input[name="outSumAmt"]').val(outSumAmt.toFixed(3));
	});

	$('input[name="outCount"]').blur(function(){
		var flag = true;
		var outCount = $('input[name="outCount"]').val();
		if(outCount==''||outCount ==' ' ||outCount==0){
			$('input[name="outCount"]').val('');
			$('input[name="outCount"]').focus();
			return;
		}
		var total = $('input[name="hiddenTotal"]').val();
		console.log(outCount+""+total);
		if(Number(outCount)>Number(total)){
			flag = false;
			messageAlert('操作提示!', "库存量【"+total+"】不足");
			$('input[name="outCount"]').val('');
			return;
		}
		if(flag){
			var salePrice = $('input[name="salePrice"]').val();
			if(salePrice==''||salePrice==' '){
				$('input[name="salePrice"]').val('');
				$('input[name="salePrice"]').focus();
				return;
			}
			var disCount = $('input[name="disCount"]').val();
			if(disCount==''||disCount == ' '){
				disCount= 1;
				$('input[name="disCount"]').val('1');
			}
			var outSumAmt = salePrice * outCount * disCount;
			$('input[name="outSumAmt"]').val(outSumAmt.toFixed(3));
		}
		
	});
	
	$('input[name="disCount"]').blur(function(){
		var disCount = $('input[name="disCount"]').val();
		if(disCount==''||disCount==' '){
			$('input[name="disCount"]').val('1');
		}
		var outCount = $('input[name="outCount"]').val();
		if(outCount==''||outCount ==' ' ||outCount==0){
			$('input[name="outCount"]').val('');
			$('input[name="outCount"]').focus();
			return;
		}
		var salePrice = $('input[name="salePrice"]').val();
		if(salePrice==''||salePrice==' '){
			$('input[name="salePrice"]').val('');
			$('input[name="salePrice"]').focus();
			return;
		}
		var outSumAmt = salePrice * outCount * disCount;
		$('input[name="outSumAmt"]').val(outSumAmt.toFixed(3));
	});
	
	

		$("#orderSave").click(function() {
		var url = "back/outOrder/save";
		var paramJson = {};
		var custInfo = {};
		var orderList=[];
		var batchNo = new Date().getTime();
		$("#orderList").children().each(function(i) {
			var orders = {};
			$(this).children().each(function(i) {
				if ($(this).attr("name") != "id" && $(this).html() != '') {
					orders[$(this).attr("name")] = $(this).html();
				}
			});
			if (!jQuery.isEmptyObject(orders)) {
				orders.outBatchNo = batchNo;
				console.log(orders);
				orderList.push(orders);
			}
		});
		custInfo.contact = $('input[name="contact"]').val();
		custInfo.custNm = $('input[name="custNm"]').val();
		custInfo.address = $('#custAddr').val();
		paramJson.custInfo=custInfo;
		paramJson.orderList = orderList;
		console.log(JSON.stringify(paramJson));
		$.ajax({  
		    type: "POST",  
		    url: url,  
		    data: JSON.stringify(paramJson),//将对象序列化成JSON字符串  
		    dataType:"json",
		    contentType : 'application/json;charset=utf-8', //设置请求头信息  
		    success: function(data){
		    	console.log(data);
		    	var message;
		    	if(data.code=='OK'){
		    		message = "保存出库订单成功";
		    	}else{
		    		message = data.message;
		    	}
		    	messageAlert('操作提示!', message);
		    	clearForm();
		    },  
		    error: function(res){  
		    }  
		});  
		
		
		/*$.post(url, paramJson, function(data) {
			var data = JSON.parse(data);
			console.log(data);
			var tips = '';
			if (data.code == 'OK') {
				tips = "保存产品基础信息成功";
				clearForm();
			} else if (data.code == 'EXIST') {
				tips = "当前产品型号已存在，无需录入";
			} else {
				tips = "保存产品基础信息失败";
			}
			messageAlert('操作提示!', tips);
		});*/
	});
})