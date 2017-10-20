<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/main-config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>存量查询</title>
</head>
<body>
	<div class="container">
		<div class=" row form-group">
			<label class="col-md-1 control-label text-lable">产品型号:</label> 
			<input type="text" id="q-prdCd" class="col-md-3 form-control con-input" name="productCd" /> 
			<div class="col-md-8 text-right"><a href="javascript:void(0)" id="wareHouseQuery"class="btn btn-primary">查询</a> </div>
		</div>
		<br />
		<br/>
		<div class="row clear"></div>
		<div class="row" style="width:100%;">
			<div class="row" style="margin-left: 5%; margin-right: 2%;" id="ware_house_list" url=" back/wareH/query">
				<div class="information_list row" style="margin: 10px; height: 150px;">
					<div class="row" style="font-weight: blod;  ">
					    <div class="row">
					    	<span class="col-md-4" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品编号</span>
					    	<span class="col-md-4" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">库存余量</span>
							<span class="col-md-4" style="border-width: 2px 2px 1px 2px; border-style:solid;">更新时间</span> 
						</div>
					</div>
					<div class="row" style="font-size: 16px; font-weight: blod; " id="dataItem">
						<div class="row" value="">
						    <span name="productCd"   class="col-md-4" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="remainAmt" class="col-md-4" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="updateTm"   class="col-md-4" style="border: 1px solid #000; border-style:none solid solid solid;"></span>
						</div>
					</div>
					
				</div>
				<div class="row">
						<span class="pages" perPageSize="5" curPageNum="1" totalPage="1"></span>
						<span class="col-md-4"></span><span class="col-md-4"></span>
				</div>
			</div>
		</div>
		</div>
</body>

<script type="text/javascript" >
$(function(){
	$("#wareHouseQuery").click(function(){
		var paramJson = {};
		var productCd = $('input[name="productCd"]').val();
		paramJson.productCd = productCd;
		$('#ware_house_list').table_list({attrOprColumNm:"id"},paramJson);
	});
	
})

$("input[name='productCd']").autocomplete({
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
</script>
</html>