$("input[name='custName_Q']").autocomplete({
		minLength : 1,
		source : function(request, response) {
			var prdCd = "%"+request.term+"%";
			$.ajax({
				url : "back/cus/queryKey",
				data:JSON.stringify({'custNm': prdCd}),
				dataType : 'json',
				contentType: "application/json; charset=utf-8",  
				type : "POST",
				success : function(result) {
				  console.log(result);
				  response($.map(result, function (data, index) { 
					 
					 var obj ={label: data.custNm+"--"+data.contact,value:data.custNm};
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


function save(){
	var url="back/cus/save"
	var paramJson={};
	var custName = $('input[name="custName"]').val();
	var contact = $('input[name="contact"]').val();
	var address = $('#address').val();
	paramJson.custNm = custName;
	paramJson.contact = contact;
	paramJson.address = address;
	$.post(url,paramJson,function(data){
		var data = JSON.parse(data);
		console.log(data);
		var tips = '';
		if(data.code=='OK'){
		 tips ="客户基础信息保存成功";
		 $('input[name="custName"]').val('');
		 $('input[name="contact"]').val('');
		 $('input[name="address"]').val('');
		}else if(data.code =='EXIST'){
			tips ="录入的客户信息已存在，无需录入【联系方式相同】";
		}else {
			tips ="客户基础信息保存失败";
		}
		messageAlert('操作提示!',tips);
	});
}


$(function(){
	$('#btn-query').click(function(){
		queryCust();
	});
	
})

function queryCust(){
	var queryParam = {};
	var custNm = $('#q-CustNm').val();
	var contact = $('#q-Contact').val();
	if(custNm !=''){
		queryParam.custNm ="%"+custNm+"%";
	}
	if(contact !=''){
		queryParam.contact ="%"+contact+"%";
	}
	console.log(queryParam);
	$("#p_table_list").table_list({
		attrOprColumNm:"id",oprtJson:[{oprFunc:"updateCust",oprFuncNm:"更新"}]
	}, queryParam);
}

$('#updateCustBtn').click(function(){
	var url = 'back/cus/update';
	var paramJson ={};
	var id = $('input[name="id"]').val();
	var custName = $('input[name="custNm"]').val();
	var contact = $('input[name="contact"]').val();
	var address = $('input[name="address"]').val();
	paramJson.id = id;
	paramJson.custNm = custName;
	paramJson.contact = contact;
	paramJson.address = address;
	$.post(url,paramJson,function(data){
		var data = JSON.parse(data);
		console.log(data);
		var tips = '';
		if(data.code=='OK'){
		 tips ="更新成功";
		 queryCust();
		}else if(data.code =='EXIST'){
			tips ="录入的客户信息已存在，无需录入【联系方式相同】";
		}else {
			tips ="更新失败";
		}
		messageAlert('操作提示!',tips);
	});
});
function updateCust(tag){
	$("#dataItem").children().each(function(i){
		if($(this).attr("value")==tag){
			$('input[name="id"]').val(tag);
			$(this).children().each(function(i){
				if($(this).attr("name")!="id"){
					$('input[name="'+$(this).attr("name")+'"]').val($(this).html());
				}
			});
		}
	});
	$('#custModal').modal('show');
}