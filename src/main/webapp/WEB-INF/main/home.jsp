<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="list-group">
		<a href="#dashboard-menu" class="list-group-item nav-header"
			data-toggle="collapse" target="menuFrame">基本设置<span class="badge">2</span></a>
		<ul id="dashboard-menu" class="nav nav-list collapse">
			<li><a href="{:U('Config/set')}">网站配置</a></li>
			<li><a href="users.html">公众号配置</a></li>
		</ul>

		<a href="#dashboard-menu1" class="list-group-item nav-header"
			data-toggle="collapse" target="menuFrame">公众号<span class="badge">3</span></a>
		<ul id="dashboard-menu1" class="nav nav-list collapse ">
			<li><a href="index.html">微信菜单</a></li>
			<li><a href="users.html">系统回复</a></li>
			<li><a href="users.html">文字回复</a></li>
		</ul>
		<a href="#dashboard-menu2" class="list-group-item nav-header"
			data-toggle="collapse" target="menuFrame">微官网<span class="badge">2</span></a>
		<ul id="dashboard-menu2" class="nav nav-list collapse ">
			<li><a href="index.html">分类管理</a></li>
			<li><a href="users.html">文章管理</a></li>
		</ul>
	</div>
</body>
</html>