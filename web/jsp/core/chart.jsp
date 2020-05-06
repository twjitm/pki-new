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

    <script type="text/javascript" src="<%=path%>/lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/hcharts/Highcharts/5.0.6/js/highcharts-3d.js"></script>

</head>
</html>
