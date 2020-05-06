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
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="stylesheet" type="text/css" href="<%=path %>/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="<%=path %>/static/h-ui.admin/css/style.css"/>

    <title>我的桌面</title>
</head>
<body>
<div class="page-container">
    <p class="f-30 text-success">欢迎使用-PKI的校园登录系统</p>
    <p>登录次数：18 </p>
    <p>上次登录IP：222.35.131.79.1 上次登录时间：2014-6-14 11:19:55</p>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th colspan="7" scope="col">站点信息</th>
        </tr>
        <tr class="text-c">
            <th>申请人</th>
            <th>申请数量</th>
            <th>已审核数量</th>
            <th>未审核数量</th>
            <th>总量</th>
            <th>申请人类型</th>
        </tr>
        </thead>
        <tbody>
        <tr class="text-c">
            <td>总数</td>
            <td>92</td>
            <td>9</td>
            <td>0</td>
            <td>8</td>
            <td>20</td>
        </tr>
        <tr class="text-c">
            <td>今日</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr class="text-c">
            <td>昨日</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr class="text-c">
            <td>本周</td>
            <td>2</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr class="text-c">
            <td>本月</td>
            <td>2</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        </tbody>
    </table>

</div>

<jsp:include page="../core/footer.jsp"/>
<script type="text/javascript" src="<%=path %>/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=path %>/static/h-ui/js/H-ui.min.js"></script>


</body>
</html>