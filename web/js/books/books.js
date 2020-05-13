

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
                layer.open({
                    title: '成功提示'
                    , content: data.message,
                });
                window.location.reload();
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