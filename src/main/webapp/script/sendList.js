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
$("input[name='custNm_Q']").autocomplete({
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


$(function(){
	$("#sendQuery").click(function(){
		queryOrder();
	});
	
});

$('#printBtn').click(function(){
   OpenWindow=window.open("ticket.html", "target","");  
   penWindow.document.getElementById("ticketBody").append()
	//写成一行   
	/*OpenWindow.document.write("<TITLE>例子</TITLE>")   
	OpenWindow.document.write("<BODY BGCOLOR=#ffffff>")   
	
	OpenWindow.document.write("<h1>Hello!</h1>")   
	OpenWindow.document.write("New window opened!")   
	OpenWindow.document.write("</BODY>")   
	OpenWindow.document.write("</HTML>")  */ 
	//window.print();
	OpenWindow.document.close()   
	
})


function queryOrder(){
	var paramJson = {};
	var custNm = $('input[name="custNm_Q"]').val();
	var outBatchNo = $('input[name="batchNo_Q"]').val();
	var crtDt = $('#dtp_input2').val();
	if(custNm!=''){
		paramJson.custNm = "%"+custNm+"%";
	}
	if(outBatchNo!=''){
		paramJson.outBatchNo = "%"+outBatchNo+"%";
	}
	paramJson.sendDt = crtDt;
	$('#send_list').table_list({attrOprColumNm:"id",oprtJson:[{oprFunc:"sendDetail",oprFuncNm:"配送详情"}]},paramJson);
	clearForm();
}




function sendDetail(obj){
	var batchNo;
	$("#dataItem").children().each(function(i){
		if($(this).attr("value")==obj){
			$(this).children().each(function(i){
				if($(this).attr("name")=="outBatchNo"){
					batchNo = $(this).html();
				}
				if($(this).attr("name")=="custNm"){
					custNm = $(this).html();
				}
				if($(this).attr("name")=="contact"){
					contact = $(this).html();
				}
				if($(this).attr("name")=="address"){
					address = $(this).html();
				}
				if($(this).attr("name")=="sendDt"){
					sendDt = $(this).html();
				}
			});
		}
	});
	
	setTimeout(function(){
		window.open("ticket.html?param="+batchNo, "target","");
	},500);
	
	/*OpenWindow.document.getElementById("orderList").append(htmlText);
	OpenWindow.document.close(); */
}