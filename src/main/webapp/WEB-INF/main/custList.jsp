<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@include file="/base-config.jsp"%> --%>
<%@include file="/main-config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>产品基础信息维护</title>
</head>
<body>
 <div class="container">
	<div class=' row form-group'>
		<label class="col-sm-1 control-label text-lable">客户姓名:</label>
		<input type="text" id="q-CustNm" class="col-md-4 form-control con-input" name="custName_Q" />
		<label class="col-md-1 control-label text-lable">联系方式:</label>
		<input type="text" id="q-Contact" class="col-md-4 form-control con-input" name="contact_Q" />
		<div class="col-md-2 text-algin-right"><a href="javascript:void(0)" id="btn-query" class="btn btn-primary">查询</a></div>
	</div>
	</br>
	<div class="row clear"/>
	
	<div class="row" style="width:100%;">
			<div class="row" style="margin-left: 5%; margin-right: 2%;" id="p_table_list" url="back/cus/query">
				<div class="information_list row" style="margin: 10px; height: 150px;">
					<div class="row" style="font-weight: blod;  ">
					    <div class="row">
					    	<span class="col-md-1" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">客户姓名</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">联系方式</span>
							<span class="col-md-6" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">送货地址</span>
							<span class="col-md-3" style="border-width: 2px 2px 1px 2px; border-style:solid;">操作</span> 
						</div>
					</div>
					<div class="row" style="font-size: 16px; font-weight: blod; " id="dataItem">
						<div class="row" value="">
						    <span name="custNm"   class="col-md-1" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="contact" class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="address" class="col-md-6" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="id"   class="col-md-3" style="border: 1px solid #000; border-style:none solid solid solid;"></span>
						</div>
					</div>
					
				</div>
				<div class="row">
						<span class="pages" perPageSize="5" curPageNum="1" totalPage="1"></span>
						<span class="col-md-4"></span><span class="col-md-4"></span>
				</div>
			</div>
			<div class="modal" id="custModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
						<h4 class="modal-title" id="myModalLabel">更新</h4>
						<input type="hidden" name="id" value=""/>
					</div>
					<div class="modal-body">
						 <div class='form-group'>
						    <label class="col-md-1 control-label text-lable">客户姓名:</label>
							<input type="text" class="col-md-3 form-control con-input"  name="custNm" /> 
							<label class="col-md-1 control-label text-lable">联系方式:</label>
							<input type="text" class="col-md-3 form-control con-input" name="contact" /> 
							<label class="col-md-1 control-label text-lable">送货地址:</label>
							<input type="text" class="col-md-3 form-control con-input" name="address" />
						</div>
						<br /> <br />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" class="btn btn-primary" id="updateCustBtn" data-dismiss="modal">保存</button>
				   </div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<script src="${pageScope.basePath}script/custinfo.js"></script>
</body>
</html>