<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@taglib prefix="s" uri="/struts-tags"%>
<title>登录系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<link rel="stylesheet" type="text/css" href="<%=path%>/js/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%=path%>/css/login/main.css">
	
</head>

<body>

<div class="limiter">
	<div class="container-login100" style="background-image: url('<%=path%>/img/bg-01.jpg');">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
			<form class="login100-form validate-form">
				<span class="login100-form-title p-b-49">登录</span>

				<div class="wrap-input100 validate-input m-b-23" data-validate="请输入用户名">
					<span class="label-input100">用户名</span>
					<input class="input100" type="text" name="username" placeholder="请输入用户名" autocomplete="off">
				</div>

				<div class="wrap-input100 validate-input" data-validate="请输入密码">
					<span class="label-input100">密码</span>
					<input class="input100" type="password" name="pass" placeholder="请输入密码">
				</div>

				<div class="text-right p-t-8 p-b-31">
					<a href="javascript:">忘记密码？</a>
				</div>

				<div class="container-login100-form-btn">
					<div class="wrap-login100-form-btn">
						<div class="login100-form-bgbtn"></div>
						<button class="login100-form-btn">登 录</button>
					</div>
				</div>

				<div class="flex-col-c p-t-25">
					<a href="javascript:" class="txt2">立即注册</a>
				</div>
			</form>
		</div>
	</div>
</div>

<script src="<%=path%>/js/vendor/jquery/jquery-3.2.1.min.js" type="application/javascript"></script>
<script src="<%=path%>/js/vendor/main.js" type="application/javascript"></script>
</body>
</html>
