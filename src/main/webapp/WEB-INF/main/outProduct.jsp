<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/main-config.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
    .ui-autocomplete{
        display:block;
        z-index:99999;
    }
</style>
<title>产品入库</title>
<link href="${pageScope.basePath}css/base.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- 按钮触发模态框 -->
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">新增出库订单</button>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">新增</h4>
					</div>
					<input type="hidden" name="id" value=""/>
					<input type="hidden" name="hiddenTotal" value=""/>
					<div class="modal-body" style="height: 250px;">
						<div class='form-group'>
							<label class="col-md-1 control-label text-lable">产品型号:</label>
							<input type="text" class="col-md-3 form-control con-input" name="productCd" /> 
							<label class="col-md-1 control-label text-lable">产品名称:</label>
							<input type="text" class="col-md-3 form-control con-input" name="productNm" />
						</div>
						<br /> <br />
						<div class='form-group'>
							<label class="col-md-1 control-label text-lable">出库数量:</label>
							<input type="text" class="col-md-3 form-control con-input" name="outCount" /> 
							<label class="col-md-1 control-label text-lable">产品单价:</label> 
							<input type="text" class="col-md-3 form-control con-input" name="salePrice" />
						</div>
						<br /> <br />
						<div>
							<label class="col-md-1 control-label text-lable">折扣:</label> 
							<input type="text" class="col-md-3 form-control con-input" placeholder="输入值范围(0~1],默认为1" name="disCount" /> 
							<label class="col-md-1 control-label text-lable">总计货价:</label> 
							<input type="text" readonly="readonly" placeholder="产品单价*产品数量*折扣" class="col-md-3 form-control con-input" name="outSumAmt" />
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="button" id="pageSave" class="btn btn-primary" data-dismiss="modal">提交</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<br /> <br />
		<div  class="row">
			<div class="row" style="font-weight: blod;">
				<div class="row text-center">
					<span class="col-md-2"
						style="border-width: 2px 2px 1px 2px; border-style: solid none solid solid;">产品代码</span>
					<span class="col-md-2"
						style="border-width: 2px 2px 1px 2px; border-style: solid none solid solid;">产品名称</span>
					<span class="col-md-1"
						style="border-width: 2px 2px 1px 2px; border-style: solid none solid solid;">产品单价</span>
					<span class="col-md-1"
						style="border-width: 2px 2px 1px 2px; border-style: solid none solid solid;">出库数量</span>
					<span class="col-md-1"
						style="border-width: 2px 2px 1px 2px; border-style: solid none solid solid;">折扣</span>
					<span class="col-md-1"
						style="border-width: 2px 2px 1px 2px; border-style: solid none solid solid;">总价</span>
					<span class="col-md-4"
						style="border-width: 2px 2px 1px 2px; border-style: solid;">操作</span>
				</div>
			</div>
			<div class="row" style="font-size: 16px; font-weight: blod;" id="orderList">
				<div class="row text-center" value="">
					<span name="productCd" class="col-md-2"
						style="border: 1px solid #000; border-style: none none solid solid;"></span>
					<span name="productNm" class="col-md-2"
						style="border: 1px solid #000; border-style: none none solid solid;"></span>
					<span name="salePrice" class="col-md-1"
						style="border: 1px solid #000; border-style: none none solid solid;"></span>
					<span name="outCount" class="col-md-1"
						style="border: 1px solid #000; border-style: none none solid solid;"></span>
					<span name="disCount" class="col-md-1"
						style="border: 1px solid #000; border-style: none none solid solid;"></span>
					<span name="outSumAmt" class="col-md-1"
						style="border: 1px solid #000; border-style: none none solid solid;"></span>
					<span name="id" class="col-md-4" 
						style="border: 1px solid #000; border-style: none solid solid solid;"></span>
				</div>
			</div>
		</div>

	</div>
	 	<br/> 
	 	<br/> 
	<div class="row">
			<span class="col-md-9"></span>
			<div id="orderBtn" class="col-md-3 text-right">
			<a href="javascript:void(0)" id="outOrder" class="btn btn-primary" data-toggle="modal"  data-target="#orderModal">生成送货单</a>
			</div>
	</div>
	<div class="modal fade" id="orderModal" tabindex="-1" role="dialog"
		aria-labelledby="orderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="orderModalLabel">收货人信息</h4>
				</div>
				<div class="modal-body" style="height: 250px;">
					<div class='form-group'>
						<label class="col-md-1 control-label text-lable">客户电话:</label> <input
							type="text" class="col-md-3 form-control con-input" name="contact" /> <label
							class="col-md-1 control-label text-lable">客户名称:</label> <input
							type="text" class="col-md-3 form-control con-input" name="custNm" />
						<br /> <br /> <label class="col-md-1 control-label text-lable">收货地址:</label>
						<textarea type="text" rows="1" cols="1"
							class="col-md-3 form-control con-input" id="custAddr" name="address" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" id="orderSave" class="btn btn-primary"
						data-dismiss="modal">提交订单</button>
				</div>
			</div>

		</div>
	</div>


	<!-- <script>
		$(function() {
			$('#myModal').on('hide.bs.modal', function() {

			})
		});
	</script> -->
	<script src="${pageScope.basePath}script/outorder.js"></script>
</body>
</html>