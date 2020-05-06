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
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>证书管理<span
        class="c-gray en">&gt;</span> 添加配置证书 <a class="btn btn-success radius r"
                                                style="line-height:1.6em;margin-top:3px"
                                                href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
    <div class="container">
        <h1 class="f-20 container" style="text-align:center">添加配置证书</h1>
    <input value="${backModel.id}" style="display: none" id="modelId">
    <div class="row container">
        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>证书申请人：</label>
        <div class="formControls col-xs-4 col-sm-2">
            <input type="text" class="input-text" value="${backModel.caCn}" id="caCn" name="caO">

        </div>
    </div>
    <div class="row container">
        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>组织单位名称：</label>
        <div class="formControls col-xs-4 col-sm-2">
            <input type="text" class="input-text" value="${backModel.caOu}" id="caOu">
        </div>
    </div>
    <div class="row container">
        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>组织名称：</label>
        <div class="formControls col-xs-4 col-sm-2">
            <input type="text" class="input-text" value="${yearNum}" id="caO" name="caO"
            >
        </div>
    </div>
    <div class="row container">
        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>城市或区域名称：</label>
        <div class="formControls col-xs-4 col-sm-2">
            <input type="text" class="input-text" name="caL" value="${commitParam.caL}"
                   id="caL">
        </div>

    </div>
    <div class="row container">
        <label class="form-label col-xs-2 col-sm-2">单位的两字母国家代码</label>
        <div class="formControls col-xs-2 col-sm-2">
            <input type="text" class="input-text" name="caC" value="${commitParam.caC}"
                   id="caC">
        </div>

    </div>
    <div class="row container">
        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>州或省份名称：</label>
        <div class="formControls col-xs-4 col-sm-2">
            <input type="text" class="input-text" name="caSt" value="${commitParam.caSt}"
                   id="caSt" >
        </div>
    </div>
    <div class="row container">
        <label class="form-label col-xs-5 col-sm-2"><span class="c-red">*</span>密钥库的密码</label>
        <div class="formControls col-xs-4 col-sm-2">
            <input type="text" class="input-text" name="caStorepass" value="${commitParam.caStorepass}"
                   id="caStorepass">
        </div>
    </div>
    <div class="row container">
        <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>私钥的密码：</label>
        <div class="formControls col-xs-4 col-sm-2">
            <input type="text" class="input-text" name="caKeypass" value="${commitParam.caKeypass}"
                   id="caKeypass">
        </div>
    </div>
    <div class="row container">
        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
            <input type="submit" onclick="submitFrom()" class="btn btn-primary radius" value="提交配置"/>
        </div>
    </div>
</div>
</div>
<script type="text/javascript">

    function num(obj) {
        obj.value = obj.value.replace(/[^\d.]/g, ""); //清除"数字"和"."以外的字符
        obj.value = obj.value.replace(/^\./g, ""); //验证第一个字符是数字
        obj.value = obj.value.replace(/\.{2,}/g, "."); //只保留第一个, 清除多余的
        obj.value = obj.value.replace(".", "$#$").replace(/\./g, "").replace("$#$", ".");
        obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/, '$1$2.$3'); //只能输入两个小数
    }

    /**
     * 提交表单信息
     */
    function submitFrom() {
        var type = 1;
        var caCn = $('#caCn').val();
        var caOu = $('#caOu').val();
        var caO = $('#caO').val();
        var caL = $('#caL').val();
        var caC = $('#caC').val();
        var caStorepass = $('#caStorepass').val();
        var caKeypass = $('#caKeypass').val();
        var caSt = $('#caSt').val();

        if (caCn == null || caCn == '') {
            layer.tips('请输入。', '#caCn', {
                tips: [1, '#3595CC'],
                time: 4000
            });
            return;
        }
        if (caO == null || caO == '') {
            layer.tips('请输入。', '#caO', {
                tips: [1, '#3595CC'],
                time: 4000
            });
            return;
        }
        if (caL == null || caL == '') {
            layer.tips('请输入。', '#caL', {
                tips: [1, '#3595CC'],
                time: 4000
            });
            return;
        }
        if (caC == null || caC == '') {
            layer.tips('请输入。', '#caC', {
                tips: [1, '#3595CC'],
                time: 4000
            });
            return;
        }
        if (caStorepass == null || caStorepass == '') {
            layer.tips('请输入。', '#caStorepass', {
                tips: [1, '#3595CC'],
                time: 4000
            });
            return;
        }
        if (caKeypass == null || caKeypass == '') {
            layer.tips('请输入。', '#caKeypass', {
                tips: [1, '#3595CC'],
                time: 4000
            });
            return;
        }

        let postData = {};
        postData['type'] = type;
        postData['caCn'] = caCn;
        postData['caOu'] = caOu;
        postData['caO'] = caO;
        postData['caL'] = caL;
        postData['caC'] = caC;
        postData['caStorepass'] = caStorepass;
        postData['caKeypass'] = caKeypass;
        postData['caSt'] = caSt;
        console.dir(postData);
        //询问框
        layer.confirm('是否确定提交证书申请，需要管理员同意？', {
            btn: ['确定', '取消'] //按钮
        }, function () {
            postData['isReally'] = 1;
            send(postData);
        }, function () {
        });
    }

    function send(postData) {

        $.ajax({
            type: "POST",
            url: '<%=path%>/books/apply.do',
            data: postData,
            success: (function (data) {
                if (data.successful === false) {
                    layer.open({
                        title: '异常提示'
                        , content: data.message,
                    });
                } else {
                    layer.open({
                        title: '成功提示'
                        , content: data.message,
                    });
                    location.replace(location.href);
                }
                console.dir(data);
            }),
            error: function () {
                layer.open({
                    title: '异常提示'
                    , content: '系统异常，请重试',
                });
            }
        });
    }

</script>

</body>
</html>
