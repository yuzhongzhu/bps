<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%    
String path = request.getContextPath();    
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量    
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";    
// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。    
pageContext.setAttribute("basePath",basePath);    
%>  
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="${pageScope.basePath}script/plugins/bootstrap.min.css" rel="stylesheet"/>

<!-- 可选的Bootstrap主题文件（一般不使用） -->
<link href="${pageScope.basePath}script/plugins/bootstrap-theme.min.css"rel="stylesheet"/>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="${pageScope.basePath}script/plugins/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="${pageScope.basePath}script/plugins/bootstrap.min.js"></script>
