<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- 	<%@ include file="/base-config.jsp"%> --%>
<%@ include file="/main-config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>订单配送查询</title>
</head>
<body>
	<div class="container">
		<div class=" row form-group">
			<label class="col-md-1 control-label text-lable">客户姓名:</label> <input
				type="text"  class="col-md-3 form-control con-input"
				name="custNm_Q" /> <label
				class="col-md-1 control-label text-lable">订单编号:</label> <input
				type="text" class="col-md-3 form-control con-input"
				name="batchNo_Q" /> <label class="col-md-1 control-label text-lable">创建日期:</label>
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
			<div class="col-md-3 text-right"><a href="javascript:void(0)" id="sendQuery"class="btn btn-primary">查询</a> </div>
		</div>
		        <input type="hidden" id="dtp_input2" value="" /><br/>
		<br/>
		<div class="row clear"></div>
		<div class="row" style="width:100%;">
			<div class="row" style="margin-left: 5%; margin-right: 2%;" id="send_list" url="back/outOrder/querySend">
				<div class="information_list row" style="margin: 10px; height: 150px;">
					<div class="row" style="font-weight: blod;  ">
					    <div class="row" value="">
					    	<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">订单编号</span>
							<span class="col-md-1" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">客户姓名</span>
							<span class="col-md-1" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">联系方式</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">配送时间</span>
							<span class="col-md-4" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">配送地址</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid;">操作</span> 
						</div>
					</div>
					<div class="row" style="font-size: 16px; font-weight: blod; " id="dataItem">
						<div class="row" value="">
						    <span name="outBatchNo"   class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="custNm" class="col-md-1" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="contact" class="col-md-1" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="sendDt" class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="address" class="col-md-4" style="border: 1px solid #000; border-style:none none solid solid;"></span>
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
		<div class="modal" id="sendModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height="0" id="wb" name="wb" width="0"></OBJECT>
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
						<h4 class="modal-title" id="myModalLabel">配送详情</h4>
					</div>
					<div class="modal-body" style="height:280px;">
						 <div class="row">
						    <label class="col-md-1 control-label text-lable">订单编号:</label>
							<span id="outBatchNo" class="col-md-2 text-left" style="margin-top:6px;"></span>
						</div>
						 <div  class="row">
						   <label class="col-md-1 control-label text-lable">收货人:</label><span class="col-md-2 text-left" style="margin-top:6px;" id="custNm"></span>
						   <label class="col-md-1 control-label text-lable">联系方式:</label><span class="col-md-2 text-left" style="margin-top:6px;" id="contact"></span>
						  
						</div>
						<div  class="row">
						   <label class="col-md-1 control-label text-lable">送货地址:</label><span class="col-md-2 text-left" style="margin-top:6px;" id="address"> </span>
						</div>
						 </br>
						 <div class=" table-responsive" id="orderList">
						</div>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="printBtn" data-dismiss="modal">打印</button>
				   </div>
				</div>
			</div>
		</div> 
</div>
</body>

<link href="${pageScope.basePath}script/plugins/bootstrap-datetimepicker.min.css" rel="stylesheet">
<script src="${pageScope.basePath}script/plugins/bootstrap-datetimepicker.min.js"></script>
<script src="${pageScope.basePath}script/plugins/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${pageScope.basePath}script/sendList.js"/>
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