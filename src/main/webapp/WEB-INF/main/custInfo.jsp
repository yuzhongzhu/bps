<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/main-config.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客户基础信息</title>
</head>
<body>
	<div class=' row form-group'>
			<label class="col-md-1 control-label text-lable">客户姓名:</label><input type="text" class="col-md-5 form-control " style="width:32%" name="custName" />
			<label class="col-md-1 control-label text-lable">联系方式:</label><input type="text" class="col-md-5 form-control " style="width:32%" name="contact" />
	</div>
	</br>
	<div class='form-group'>
			<label class="col-md-1 control-label text-lable">送货地址:</label>
			<textarea  rows="1" cols="1" class="col-md-3 form-control con-input" id="address" />
	</div>
	</br>
	<div class="text-right">
			<a href="javascript:void(0)" onclick="save()" class="btn btn-primary">新增</a>
	</div>
	<script src="${pageScope.basePath}script/custinfo.js"></script>
</body>
</html>