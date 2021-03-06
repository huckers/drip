<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>留言 - 水滴博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
</head>
<body class="lay-blog">
    <#include "header.ftl">
    <div class="container-wrap">
        <div class="container container-message">
            <div class="contar-wrap" id="contar-wrap">
                <form class="layui-form" action="">
                    <div class="layui-form-item layui-form-text">
                        <input type="text" name="nickName" required lay-verify="required" placeholder="昵称(必填)"
                               autocomplete="off" class="layui-input">
                        <textarea  class="layui-textarea" id="LAY-msg-content" style="resize:none" placeholder="写点儿什么呢..."></textarea>
                        <button lay-submit lay-filter="sure" class="layui-btn">提交</button>
                    </div>
                </form>

                <div id="LAY-msg-box">
                    <div class="info-box">
                        <div class="info-item">
                            <img class="info-img" src="/images/info-img.png" alt="">
                            <div class="info-text">
                                <p class="title count">
                                    <span class="name">一片空白</span>
                                    <span class="date">2018-01-01 12:11:11</span>
                                </p>
                                <p class="info-intr">父爱如山，不善表达。回想十多年前，总记得父亲有个宽厚的肩膀，小小的自己跨坐在上面，越过人山人海去看更广阔的天空，那个时候期望自己有一双翅膀，能够像鸟儿一样飞得高，看得远。虽然父亲有时会和自己开玩笑，但在做错事的时候会受到严厉的训斥。父亲有双粗糙的大手掌。</p>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="test1" class="paging"></div>
            </div>
        </div>
    </div>
    <#include "footer.ftl">
    <script src="${request.contextPath}/plugin/layui/layui.js">

    </script>
    <script>
        layui.config({
            base: '/js/'
        }).use('blog');
        layui.use('jquery', function(){
            var $ = jQuery = layui.$;
        });
    </script>
    <script id="LAY-msg-tpl" type="text/html">
        <div class="info-box">
            <div class="info-item">
                <img class="info-img" src="{{ d.avatar }}" alt="">
                <div class="info-text">
                    <p class="title">
                        <span class="name">{{ d.username }}</span>
					  <span class="info-img">
					  	<i class="layui-icon layui-icon-praise"></i>
					  	{{ d.praise }}
					 	</span>
                    </p>
                    <p class="info-intr">
                        {{ d.content }}
                    </p>
                </div>
            </div>
        </div>
    </script>
</body>
</html>