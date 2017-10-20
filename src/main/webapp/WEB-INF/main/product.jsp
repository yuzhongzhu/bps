<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/main-config.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="${pageScope.basePath}script/plugins/fileinput-min.css" rel="stylesheet">

<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="${pageScope.basePath}script/plugins/fileinput-min.js"></script>
<title>产品基础信息</title>
</head>
<body>
	<div class='form-group'>
			<label class="col-md-1 control-label text-lable">产品型号:</label><input type="text" class="col-md-3 form-control con-input" name="productCd" />
			<label class="col-md-1 control-label text-lable">产品名称:</label><input type="text" class="col-md-3 form-control con-input" name="productNm" />
			<label class="col-md-1 control-label text-lable">产品进价:</label><input type="text" class="col-md-3 form-control con-input" name="basePrice" />
	</div>
	</br>
	<div class='form-group'>
			
			<label class="col-md-1 control-label text-lable">产品售价:</label><input type="text" class=" col-md-3 form-control con-input" name="price" />
			<label class="col-md-1 control-label text-lable">计量单位:</label><input type="text" class="col-md-3 form-control con-input" name="unit" />
		    <label class="col-md-1 control-label text-lable">产品参数:</label><input type="text" class="col-md-3 form-control con-input" name="param" />
	</div>
	</br>
	<div class="text-right">
			<a href="javascript:void(0)" onclick="save()" class="btn btn-primary">入库</a>
	</div>
	 <div id="uploadFileDlg" class="easyui-dialog" style="width:800px;text-align:center;"  
            closed="true">  
          
                Excel批量导入:<input id="file" type="file" style="width:280px;display:inline-block;">  
                <button id="uploadBtn" class="btn btn-primary" style="width:auto;display:inline-block;">上传</button>   
           	    <button id="clearBtn" class="btn btn-primary"  style="width:auto;display:inline-block;">清除</button>   
            <!-- <div class="progress progress-bar-striped active" style="display:none;">  
                <div id="progressBar" class="progress-bar progress-bar-info" role="progressbar"  
                aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"  
                style="width:0%;">  
                </div>  
            </div>   -->
            <table id="uploadBatchDg"></table>  
        </div>  
	<script src="${pageScope.basePath}script/product.js"></script>
</body>
</html>