<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<![endif]-->
<link href="<%=path %>/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=path %>/static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<title>404页面</title>
</head>
<body>
<section class="container-fluid page-404 minWP text-c">
	<p class="error-title"><i class="Hui-iconfont va-m" style="font-size:80px">&#xe688;</i>
		<span class="va-m"> 404</span>
	</p>
	<p class="error-description">不好意思，您访问的页面不存在~</p>
	<p class="error-info">您可以：
		<a href="javascript:;" onclick="history.go(-1)" class="c-primary">&lt; 返回上一页</a>
		<span class="ml-20">|</span>
		<a href="/" class="c-primary ml-20">去首页 &gt;</a>
	</p>
</section>
</body>
</html>