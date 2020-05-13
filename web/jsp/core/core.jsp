<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 同一资源控制 -->
    <link rel="stylesheet" type="text/css" href="<%=path %>/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/static/h-ui.admin/css/style.css" />
    <link rel="stylesheet"  type="text/css" href="<%=path %>/css/jquery.mloading.css">

    <script type="text/javascript" src="<%=path %>/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/static/h-ui/js/H-ui.min.js"></script>
    <script type="text/javascript" src="<%=path %>/lib/My97DatePicker/4.8/WdatePicker.js"></script>
    <script type="text/javascript" src="<%=path %>/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=path %>/lib/layer/2.4/layer.js"></script>

    <script type="text/javascript" src="<%=path %>/js/books/books.js"></script>

</head>
</html>
