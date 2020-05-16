function reviewBooks(bookId) {

    //询问框
    layer.confirm('审核证书中，确定需要通过吗？', {
        btn: ['拒绝申请', '通过申请'] //按钮
    }, function () {

       send(bookId, 2);
    }, function () {
        send(bookId, 1);
    });
}


function send(bookId, pass) {
    //加载层-风格4

    layer.msg('处理中', {
        icon: 16
        ,shade: 0.01
    });
    sheep(6);
    path = window.location.origin + "/" + window.location.pathname.split("/")[1];
    $.ajax({
        type: "POST",
        url: path + '/books/review.do?caBookId=' + bookId + '&type=' + pass,
        success: (function (data) {
            if (data.successful === false) {
                layer.open({
                    title: '异常提示'
                    , content: data.message,
                });
            } else {
                showCmdWindows(data);
                layer.open({
                    title: '成功提示'
                    , content: data.message,
                });

            }
        }),
        error: function () {
            layer.open({
                title: '异常提示'
                , content: '系统异常，请重试',
            });
        }
    });
}


function showJson(Id) {
    path = window.location.origin + "/" + window.location.pathname.split("/")[1];
    $.ajax({
        type: "GET",
        url: path + '/books/getBook.do?id=' + Id,
        success: (function (data) {
            layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['800px', '600px'], //宽高
                content: "<pre>证书数据=" + JSON.stringify(data, null, 2) + "</pre>",
            });
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


function deleteBook(Id) {
    path = window.location.origin + "/" + window.location.pathname.split("/")[1];
    layer.confirm('确定取消申请吗？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        $.ajax({
            type: "GET",
            url: path + '/books/deleteca.do?caBookId=' + Id,
            success: (function (data) {
                layer.open({
                    title: '删除成功'
                    , content: '删除成功',
                });
                location.reload();
                console.dir(data);
            }),
            error: function () {
                layer.open({
                    title: '异常提示'
                    , content: '系统异常，请重试',
                });
            }
        });


    }, function () {
    });
}

function showCmdWindows(book) {

    console.dir(book.data['book']);
   let bk= book.data['book'];
    $("#cmd_text").html("<ul><li>"+"welcome and login system"+"</li>"+"<li>"+"login successful"+"</li>"+"</ul>");

    $("#cmd_text").append("<ul><li>"+" #!/usr/bin/env bash"+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" BOOK_PATCH_NAME=/data/books/dev/"+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" KEY_PASS="+bk.caKeypass+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" STOREPASS="+bk.caStorepass+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" CN_NAME="+bk.caCn+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" OU_NAME="+bk.caOu+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" O_NAME="+bk.caO+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" L_NAME="+bk.caL+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" C_NAME="+bk.caC+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" D_NAME=\"CN=${CN_NAME},OU=${OU_NAME},O=${O_NAME},L=${L_NAME},ST=${ST_NAME},C=${C_NAME}\"\n"+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" echo ${BOOK_PATCH_NAME}+${KEY_PASS}+${STOREPASS}+${D_NAME}>>/data/config.log\n"+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" keytool -genkeypair -keystore ${BOOK_PATCH_NAME} -keypass ${KEY_PASS} -storepass ${STOREPASS} -keyalg RSA -keysize 2048 -validity 3650 -dname ${D_NAME}\n"+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" create book message "+"</li></ul>");
    $("#cmd_text").append("<ul><li>"+" done "+"</li></ul>");


    let win = $("#window").html();

    let obj = layer.open({
        type: 1,
        area: ['680px', '442px'],
        fix: false, //不固定
        maxmin: false,
        shade: 0.4,
        title: '证书生成脚本执行过程',
        content: win,
        btn: ['关闭'],
        shadeClose: true,
        end:function () {
            window.location.reload();
        }
    });
}
function sheep(times) {
    for(var i = 0; i < times; i++) {
        (function(i) {
            setTimeout(function() {
                console.log(i);
            }, (i + 1) * 1000);
        })(i)
    }

}