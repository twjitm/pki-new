<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>校园 PKI 证书管理系统</title>
    <jsp:include page="../core/core.jsp"/>
</head>

<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 证书管理 <span
        class="c-gray en">&gt;</span>证书列表(管理员)<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                            href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="cl pd-5 bg-1 bk-gray mt-20">

        <span class="r">共有数据：<strong>${dataLang}</strong> 条</span></div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-hover table-bg table-sort" id="tableId">
            <thead>
            <tr class="text-c">
                <th>证书ID</th>
                <th>申请人名称</th>
                <th>组织单位名称</th>
                <th>组织名称</th>
                <th>城市或区域名称</th>
                <th>国家代码</th>
                <th>州或省份名称</th>
                <th>密钥库的密码</th>
                <th>私钥的密码</th>
                <th>证书状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="bottle">
                <tr class="text-c">
                    <td> ${bottle.caId}</td>
                    <td>${bottle.caCn}</td>
                    <td>${bottle.caOu}</td>
                    <td>${bottle.caO}</td>
                    <td>${bottle.caL}</td>
                    <td>${bottle.caSt}</td>
                    <td>${bottle.caC}</td>
                    <td>${bottle.caStorepass}</td>
                    <td>${bottle.caKeypass}</td>
                    <td>
                        <c:if test="${bottle.caStart==0}">
                        <p>审核中</p>
                    </c:if>
                        <c:if test="${bottle.caStart==1}">
                            <p>审核通过</p>
                        </c:if>
                        <c:if test="${bottle.caStart==2}">
                            <p>审核不通过</p>
                        </c:if>
                    </td>
                    <td>
                        <button class="btn btn-success radius" onclick="showJson(${bottle.caId})"  value="${bottle.caId}">查看</button>
                        <button class="btn btn-danger radius" onclick="deleteBook(${bottle.caId})" value="${bottle.caId}">删除</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('.table-sort').dataTable({
            "aaSorting": [[1, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                //{"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
            ]
        });
    });
</script>

</body>
</html>
