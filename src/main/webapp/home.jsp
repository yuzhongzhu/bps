<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <%@ include file="base-config.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <% 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>
<meta http-equiv="pragma" content="no-cache">  
<meta http-equiv="cache-control" content="no-cache">  
<meta http-equiv="expires" content="0">

<title>Insert title here</title>
<script src="./script/home.js"></script>
<link href="./css/home.css" rel="stylesheet" />
</head>
<body>
	<div>
		<div class="row row_reset">我是Head</div>
		<div class="row row_reset">
			<div class="col left-column">
				<div class="list-group block">
				</div>
			</div>
			<!-- http://blog.csdn.net/shaobingj126/article/details/23676759/ -->
			<div class="col middle-column" id="content">我是content</div>
			<div class="col right-column"></div>
			</div>
		<div class="row row_reset">我是foot</div>
	</div>
    
</body>
</html>