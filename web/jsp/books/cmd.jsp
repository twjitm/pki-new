<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <title>WeChat Manager</title>
    <link href="css/index.css" rel="stylesheet" type="text/css">
    <script>
        // $(document).ready(function(){
        //     $(document).keyup(function(event){
        //         if(event.keyCode ==13){
        //             $.ajax({
        //                 type: "POST",
        //                 url: "ok.php",
        //                 data: "code="+$("#in").val(),
        //                 success: function(msg){
        //                     $("ul").append("<li>"+$("#in").val()+"</li>");  //将输入的输出到界面
        //                     $("ul").append("<li>"+msg+"</li>");             //获取返回值并输出
        //                     $("#in").val("");                               //清空输入框
        //                     $("#text").scrollTop($("#text").scrollTop()+32);//滚动条拉到最下面，显示出输入框
        //                 }
        //             });
        //         }
        //     });
        //     $("#in")[0].focus();
        // });
    </script>
</head>

<body>
<div class="window">
    <div class="title">
        <img src="css/1.jpg">
        <span>Wechat Dos</span>
    </div>
    <div id="text">
        <ul>
            <li>Welcome...</li>
            <li>login:</li>
        </ul>
        <input type="text" name="" id='in'>
    </div>
</div>
</body>
</html>
