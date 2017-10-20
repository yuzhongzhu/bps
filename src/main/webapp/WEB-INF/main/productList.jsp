<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/base-config.jsp"%> 
<%@include file="/main-config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>产品基础信息维护</title>
</head>
<body>
 <div class="container">
	<div class=' row form-group'>
		<label class="col-sm-1 control-label text-lable">产品型号:</label>
		<input type="text" id="q-prdCd" class="col-md-4 form-control con-input" />
		<label class="col-md-1 control-label text-lable">产品名称:</label>
		<input type="text" id="q-prdNm" class="col-md-4 form-control con-input" />
		<div class="col-md-2 text-algin-right"><a href="javascript:void(0)" onclick="query()" class="btn btn-primary">查询</a></div>
	</div>
	</br>
	<div class="row clear"/>
	
	<div class="row" style="width:100%;">
			<div class="row" style="margin-left: 5%; margin-right: 2%;" id="p_table_list" url="back/prd/query">
				<div class="information_list row" style="margin: 10px; height: 150px;">
					<div class="row" style="font-weight: blod;  ">
					    <div class="row">
					    	<span class="col-md-1" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品代码</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品名称</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品进价</span>
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品售价</span> 
							<span class="col-md-2" style="border-width: 2px 2px 1px 2px; border-style:solid none solid solid;">产品参数</span> 
							<span class="col-md-3" style="border-width: 2px 2px 1px 2px; border-style:solid;">操作</span> 
						</div>
					</div>
					<div class="row" style="font-size: 16px; font-weight: blod; " id="dataItem">
						<div class="row" value="" >
						    <span name="productCd"   class="col-md-1" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="productNm" class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="basePrice" class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="price" class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span> 
							<span name="param"   class="col-md-2" style="border: 1px solid #000; border-style:none none solid solid;"></span>
							<span name="id"   class="col-md-3" style="border: 1px solid #000; border-style:none solid solid solid;"></span>
						</div>
					</div>
					
				</div>
				<div class="row">
						<span class="pages" perPageSize="5" curPageNum="1" totalPage="1"></span>
						<span class="col-md-4"></span><span class="col-md-4"></span>
				</div>
			</div>
		</div>
		<div class="modal fade" id="updatePModal" tabindex='-1' role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">更新</h4>
						<input type='hidden' name="id"/>
					</div>
					<div class="modal-body" style="height:250px;">
						<div class='form-group'>
							<label class="col-md-1 control-label text-lable">产品型号:</label>
							<input type="text" class="col-md-3 form-control con-input" readonly="readonly" name="productCd" /> 
							<label class="col-md-1 control-label text-lable">产品名称:</label>
							<input type="text" class="col-md-3 form-control con-input" name="productNm" />
						</div>
						<br/>
						<br/>
						<div class='form-group'>
							<label class="col-md-1 control-label text-lable">产品进价:</label>
							<input type="text" class="col-md-3 form-control con-input" name="basePrice" /> 
							<label class="col-md-1 control-label text-lable">产品售价:</label>
							<input type="text" class="col-md-3 form-control con-input" name="price" />
						</div>
						<br/>
						<br/>
						<div class='form-group'>
							<label class="col-md-1 control-label text-lable">产品参数:</label>
							<textarea type="text" cols="4" rows="4" class="col-md-6 form-control con-input" name="param" id="param"/> 
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" id="updateBasePrd" class="btn btn-primary" data-dismiss="modal">更新</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="${pageScope.basePath}script/productList.js"></script>
</body>
</html>