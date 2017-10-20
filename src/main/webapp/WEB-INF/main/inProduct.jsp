<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/main-config.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>产品入库</title>
<link href="${pageScope.basePath}css/base.css" rel="stylesheet">
</head>
<body>
	<div class='form-group'>
			<label class="col-md-1 control-label text-lable">进货单号:</label><input type="text" placeholder="进货单号" class="col-md-3 form-control con-input" name="batchNo" />
			<label class="col-md-1 control-label text-lable">产品型号:</label><input type="text" class="col-md-3 form-control con-input" name="productCd" />
			<label class="col-md-1 control-label text-lable">产品名称:</label><input type="text" class="col-md-3 form-control con-input" name="productNm" />
			
	</div>
	</br>
	</br>
	<div class='form-group'>
			<label class="col-md-1 control-label text-lable">产品总价:</label><input type="text" class="col-md-3 form-control con-input" name="inSumAmt" placeholder="请输入金额数值"/>
			<label class="col-md-1 control-label text-lable">产品数量:</label><input type="text" class="col-md-3 form-control con-input" name="inCount" placeholder="请输入正整数"/>
			<label class="col-md-1 control-label text-lable">单笔进价:</label><input type="text" class="col-md-3 form-control con-input" name="basePrice" readonly="readonly"  placeholder="[产品总价/产品数量]"/>
			
	</div>
	</br>
	</br>
	<div class='form-group'>
		<label class="col-md-1 control-label text-lable">预售价格:</label><input type="text" class="col-md-2 form-control con-input" name="salePrice" readonly="readonly"  placeholder="单笔进价*1.05"/>
	    <label class="col-md-1 control-label text-lable">货源地:</label><input type="text" class="col-md-3 form-control con-input" name="prdAddress" />
		<label class="col-md-1 control-label text-lable">备注信息:</label><textarea class="col-md-3 form-control con-input" id="rmk" rows="1" cols="1"></textarea>
		<div class="col-md-1">
			<a href="javascript:void(0)" id="inOrder" class="btn btn-primary">入库</a>
		</div>
	</div>
	<script src="${pageScope.basePath}script/inProduct.js"></script>
</body>
</html>