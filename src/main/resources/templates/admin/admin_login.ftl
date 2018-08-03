<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Drip管理登录</title>
    <link rel="stylesheet" href="${request.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${request.contextPath}/css/admin.css">
    <link rel="stylesheet" href="${request.contextPath}/css/login.css">
</head>
<body>

<!-- 你的HTML代码 -->

<script src="${request.contextPath}/plugin/layui/layui.js"></script>
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none">
    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>DripAdmin</h2>
            <p>Drip水滴博客管理系统</p>
        </div>
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
            </div>
            <div class="layui-form-item" style="margin-bottom: 20px;">
                <input type="checkbox" name="remember" lay-skin="primary" title="记住密码"><div class="layui-unselect layui-form-checkbox" lay-skin="primary"><span>记住密码</span><i class="layui-icon layui-icon-ok"></i></div>
                <a lay-href="/user/forget" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
            </div>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="LAY-user-login-submit">登 入</button>
            </div>
        </div>
    </div>
    <div class="layui-trans layadmin-user-login-footer">
        <p>© 2018 <a href="http://www.zthack.com/" target="_blank">zthack.com</a></p>
    </div>
</div>
<script>
    //一般直接写在一个js文件中
    layui.use(['layer', 'form'], function(){
        var layer = layui.layer
                ,form = layui.form
                ,$ = layui.jquery;

        form.render();

        form.on("submit(LAY-user-login-submit)", function(obj) {
            var username = $("#LAY-user-login-username").val();
            var password = $("#LAY-user-login-password").val();
            $.ajax({
                url:'${request.contextPath}/admin/doLogin',
                type:'post',
                data:{'username': username, 'password': password},
                dataType:'json',
                success:function(data) {
                    console.log(1);
                    if (data.code == 1) {
                        layer.msg(data.msg);
                        location.href='${request.contextPath}/admin/index';
                    } else {
                        layer.msg(data.msg);
                    }
                }
            })
        })
    });
</script>
</body>
</html>