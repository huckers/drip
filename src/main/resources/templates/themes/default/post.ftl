<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${post.title!''} - ${settings.blog_name!''}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${request.contextPath}/css/main.css">
</head>
<body class="lay-blog">
<#include "header.ftl">
<div class="container-wrap">
    <div class="container container-message container-details">
        <div class="contar-wrap">
            <div class="item">
                <div class="item-box  layer-photos-demo1 layer-photos-demo">
                    <h3><a href="">${post.title}</a></h3>
                    <h5>发布于：<span>${post.createDate?string('yyyy-MM-dd HH:mm:ss')}</span></h5>
                    <p>${post.content}</p>
                    <img src="/images/item.png" alt="">
                    <div class="count layui-clear">
                        <span class="pull-left">阅读 <em>${post.viewCount!0}</em></span>
                        <span class="pull-right like" id="${post.id}"><i
                                class="layui-icon layui-icon-praise"></i><em>${post.likeCount!0}</em></span>
                    </div>
                </div>
            </div>
            <a name="comment"> </a>
            <div class="comt layui-clear">
                <a href="javascript:;" class="pull-left">评论</a>
            </div>
            <div class="container-comment">
                <form class="layui-form">
                    <div class="layui-form-item layui-form-text">
                        <input type="hidden" name="postId" value="${post.id}">
                        <input type="text" name="nickName" required lay-verify="required" placeholder="昵称(必填)"
                               autocomplete="off" class="layui-input">
                        <textarea class="layui-textarea" required lay-verify="required" name="content"
                                  style="resize:none" placeholder="写点什么啊"></textarea>
                        <button lay-submit lay-filter="sure" class="layui-btn">提交</button>
                    </div>
                </form>
            </div>
            <div id="LAY-msg-box">
            <#list post.comments as comment>
                <div class="info-item">
                    <img class="info-img" src="/images/info-img.png" alt="">
                    <div class="info-text">
                        <p class="title count">
                            <span class="name">${comment.nickName}</span>
                            <span class="date">${comment.createDate?string('yyyy-MM-dd HH:mm:ss')}</span>
                        </p>
                        <p class="info-intr">${comment.content}</p>
                    </div>
                </div>
            </#list>
            </div>
        </div>
    </div>
</div>
<#include "footer.ftl">
<script src="${request.contextPath}/plugin/layui/layui.js">

</script>
<script>
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer
                , form = layui.form
                , $ = layui.jquery;

        form.render();

        form.on("submit(sure)", function (obj) {
            var postId = $("[name='postId']").val();
            var nickName = $("[name='nickName']").val();
            var content = $("[name='content']").val();
            $.ajax({
                url: '${request.contextPath}/post/comment',
                type: 'post',
                data: {'postId': postId, 'nickName': nickName, 'content': content},
                dataType: 'json',
                success: function (data) {
                    console.log(1);
                    if (data.code == 1) {
                        layer.msg(data.msg);
//                        Location.reload();
                    } else {
                        layer.msg(data.msg);
                    }
                }
            })
        })
    })
</script>
</body>
</html>