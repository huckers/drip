<div class="header">
    <div class="header-wrap">
        <h1 class="logo pull-left">
            <a href="/index">
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
                <li class="layui-nav-item layui-this"><a href="/index">INDEX</a></li>
                <li class="layui-nav-item"><a href="/message">COMMENT</a></li>
                <li class="layui-nav-item"><a href="/about">ABOUT</a></li>
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
        <li><a href="/index">INDEX</a></li>
        <li><a href="/message">COMMENT</a></li>
        <li><a href="/about">ABOUT</a></li>
    </ul>
</div>