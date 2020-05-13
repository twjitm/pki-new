<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <title></title>
    <jsp:include page="../core/core.jsp"/>
</head>
<body>
<div class="page-container">
    <div class="page-container">
        <form class="form form-horizontal" action="<%=path%>/users/login.do" id="form-article-add">
            <div id="tab-system" class="HuiTab">
                <div class="tabBar cl">
                    <span>用户信息基本设置</span>
                </div>
                <div class="tabCon">

                    <div class="row cl">
                        <label class="form-label col-xs-4 col-sm-2">
                            <span class="c-red">*</span>
                            用户名称：</label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input name="metFilepath" type="text" id="website-title" placeholder="控制在25个字、50个字节以内"
                                   value="${infos.UName}" class="input-text">
                        </div>
                    </div>
                    <div class="row cl">
                        <label class="form-label col-xs-4 col-sm-2">
                            <span class="c-red">*</span>
                            用户账号：</label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input name="modelPath" type="text" id="websit" placeholder="5个左右,8汉字以内,用英文,隔开"
                                   value="${infos.UAccount}" class="input-text">
                        </div>
                    </div>
                    <div class="row cl">
                        <label class="form-label col-xs-4 col-sm-2">
                            <span class="c-red">*</span>
                            用户密码：</label>
                        <div class="formControls col-xs-8 col-sm-9">
                            <input name="modelPath" type="text" id="website-Keywords" placeholder="5个左右,8汉字以内,用英文,隔开"
                                   value="${infos.UPsd}" class="input-text">
                        </div>
                    </div>

                </div>
            </div>
            <div class="row cl">
                <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                    <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存
                    </button>
                    <button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
                </div>
            </div>
        </form>
    </div>


</div>
<script type="application/javascript">

    $(function () {
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $("#tab-system").Huitab({
            index: 0
        });
    });

</script>

</body>
</html>
