<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- 	<%@ include file="/base-config.jsp"%> --%>
<%@ include file="/main-config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>出库订单查询</title>
</head>
<body>
	<div class="container">
		<div class=" row form-group">
			<label class="col-md-1 control-label text-lable">产品型号:</label> <input
				type="text" id="q-prdCd" class="col-md-3 form-control con-input"
				name="productCd_Q" /> <label
				class="col-md-1 control-label text-lable">订单编号:</label> <input
				type="text" id="q-batchNo" class="col-md-3 form-control con-input"
				name="batchNo_Q" /> <label class="col-md-1 control-label text-lable">入库日期:</label>
			<div class="input-group date form_date col-md-3" data-date=""
				data-date-format="yyyy-mm-dd" data-link-field="dtp_input2"
				data-link-format="yyyymmdd">
				<input class="form-control" type="text" value="" readonly> <span
					class="input-group-addon"><span
					class="glyphicon glyphicon-remove"></span></span> <span
					class="input-group-addon"><span
					class="glyphicon glyphicon-calendar"></span></span>
			</div>
		</div>
		<div class="row">
			<span
				class="col-md-8></span>
			<div class="col-md-3 text-right"><a href="javascript:void(0)" id="inOrderQuery"class="btn btn-primary">查询</a> </div>
		</div>
		        <input type="hidden" id="dtp_input2" value="" /><br/>
		<br/>
		<div class="row clear"></div>
		<div class="row" style="width:100%;">
			<div class="row" style="margin-left: 5%; margin-right: 2%;" id="in_order_list" url=" back/inPrd/query">
				<div class="information_list row" style="margin: 10px; height: 150px;">
					<div class="row" style="font-weight: blod;  ">
					    <div class="row" value="">
					    	<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">订单批次号</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品编码</span>
							<span class="col-md-1" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品总数</span>
							<span class="col-md-1" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品总价</span>
							<span class="col-md-1" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品进价</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">进货时间</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid;">操作</span> 
						</div>
					</div>
					<div class="row" style="font-size: 16px; font-weight: blod; " id="dataItem">
						<div class="row" >
						    <span name="batchNo"   class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="productCd" class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="inCount" class="col-md-1" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="inSumAmt" class="col-md-1" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="basePrice" class="col-md-1" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="inRegisterTm" class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="id"   class="col-md-2" style="border: 1px solid #000; border-style:none solid solid solid;"></span>
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
		<div class="modal" id="inOrderModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
						<h4 class="modal-title" id="myModalLabel">更新</h4>
						<input type="hidden" name="id" value=""/>
					</div>
					<div class="modal-body" style="height:280px;">
						 <div class='form-group'>
						    <label class="col-md-1 control-label text-lable">订单批次号:</label>
							<input type="text" class="col-md-3 form-control con-input" readonly="readonly" name="batchNo" /> 
							<label class="col-md-1 control-label text-lable">产品型号:</label>
							<input type="text" class="col-md-3 form-control con-input" name="productCd" /> 
						</div>
						<br /> <br />
						<div class='form-group'>
						    <label class="col-md-1 control-label text-lable">产品总数:</label>
							<input type="text" class="col-md-2 form-control con-input" name="inCount" />
						    <label class="col-md-1 control-label text-lable">进货总价:</label>
							<input type="text" class="col-md-3 form-control con-input" name="inSumAmt" /> 
						</div>
						<br /> <br />
						<div class='form-group'>
							<label class="col-md-1 control-label text-lable">产品进价:</label>
							<input type="text" class="col-md-3 form-control con-input" name="basePrice" /> 
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="updateOrderBtn" data-dismiss="modal">保存</button>
				   </div>
				</div>
			</div>
		</div> 
</body>

<link href="${pageScope.basePath}script/plugins/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script src="${pageScope.basePath}script/plugins/bootstrap-datetimepicker.min.js"></script>
<script src="${pageScope.basePath}script/plugins/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${pageScope.basePath}script/inProductList.js"/>
<script type="text/javascript">
$('.form_date').datetimepicker({
    language:  'cn',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: 0
});
</script>
</html>