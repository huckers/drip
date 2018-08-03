<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>水滴博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${request.contextPath}/css/mian.css">
</head>
<body class="lay-blog">
<div class="header">
    <div class="header-wrap">
        <h1 class="logo pull-left">
            <a href="index.html">
                <img src="${request.contextPath}/images/logo.png" alt="" class="logo-img">
                <span class="logo-text" style="color: white">DRIP.</span>
            </a>
        </h1>
        <form class="layui-form blog-seach pull-left" action="">
            <div class="layui-form-item blog-sewrap">
                <div class="layui-input-block blog-sebox">
                    <i class="layui-icon layui-icon-search"></i>
                    <input type="text" name="title" lay-verify="title" autocomplete="off"  class="layui-input">
                </div>
            </div>
        </form>
        <div class="blog-nav pull-right">
            <ul class="layui-nav pull-left">
                <li class="layui-nav-item layui-this"><a href="index.html">INDEX</a></li>
                <li class="layui-nav-item"><a href="message.html">COMMENT</a></li>
                <li class="layui-nav-item"><a href="about.html">ABOUT</a></li>
            </ul>
            <a href="/admin" class="personal pull-left">
                <i class="layui-icon layui-icon-username"></i>
            </a>
        </div>
        <div class="mobile-nav pull-right" id="mobile-nav">
            <a href="javascript:;">
                <i class="layui-icon layui-icon-more"></i>
            </a>
        </div>
    </div>
    <ul class="pop-nav" id="pop-nav">
        <li><a href="index">INDEX</a></li>
        <li><a href="message.html">COMMENT</a></li>
        <li><a href="about.html">ABOUT</a></li>
    </ul>
</div>
<div class="container-wrap">
    <div class="container">
        <div class="contar-wrap">
            <h4 class="item-title">
                <p><i class="layui-icon layui-icon-speaker"></i>微言：<span>水滴石穿 集流成海!</span></p>
            </h4>
            <#if posts??>
                <#list posts as post>
                    <div class="item">
                        <div class="item-box  layer-photos-demo1 layer-photos-demo">
                            <h3><a href="/post/${post.id}">${post.title}</a></h3>
                            <h5>发布于：<span>${post.createDate?string('yyyy-MM-dd HH:mm:ss')}</span></h5>
                            <p>${post.content}</p>
                            <img src="${request.contextPath}/images/item.png" alt="">
                        </div>
                        <div class="comment count">
                            <a href="details.html#comment">评论(${post.commentCount})</a>
                            <a href="javascript:;" class="like">点赞(0)</a>
                        </div>
                    </div>
                </#list>
            </#if>
        </div>
        <div id="post_list"></div><#--分页控制条-->
    </div>
</div>
<div class="footer">
    <p>
        <span>&copy; 2018</span>
        <span>Powered By <a href="http://www.zthack.com" target="_blank">ZThack.Com</a></span>
        <span>数据统计</span>
    </p>
    <p><span>水滴石穿 集流成海</span></p>
</div>
<script src="${request.contextPath}/plugin/layui/layui.js"></script>
<script>
    layui.config({
        base: '/js/'
    }).use('blog');
    layui.use('laypage', function(){
        var laypage = layui.laypage;

        //执行一个laypage实例
        laypage.render({
            elem: 'post_list' //注意，这里的 test1 是 ID，不用加 # 号
            ,count: 20 //数据总数，从服务端得到
//            ,jump: function(obj, first){
//                //obj包含了当前分页的所有参数，比如：
//                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
//                console.log(obj.limit); //得到每页显示的条数
//
//                //首次不执行
//                if(!first){
//                    //do something
//                }
//            }
        });
        //自定义样式
        laypage.render({
            elem: 'post_list'
            ,count: 100
            ,theme: '#1E9FFF'
        });
    });
</script>
</body>
</html>