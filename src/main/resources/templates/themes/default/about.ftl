<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>关于 - 水滴博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="${request.contextPath}/css/mian.css">
</head>
<body class="lay-blog">
<#include "header.ftl">
<div class="container-wrap">
    <div class="container container-message container-details container-about">
        <div class="contar-wrap">
            <div class="item">
                <div class="item-box">
                    <h3>关于</h3>
                    <p>诸葛亮于汉灵帝光和四年（181年）出生在琅琊郡阳都县的一个官吏之家，诸葛氏是琅琊的望族，先祖诸葛丰曾在西汉元帝时做过司隶校尉，诸葛亮的父亲诸葛珪在东汉末年做过泰山郡丞； [2]  诸葛亮3岁时母亲章氏病逝，诸葛亮8岁时丧父，与弟弟诸葛均一起跟随由袁术任命为豫章太守的叔父诸葛玄到豫章（今江西南昌）赴任，东汉朝廷派朱皓取代了诸葛玄职务，诸葛玄就去投奔荆州刘表。</p>
                    <p>建安二年（197年），诸葛玄去世，诸葛亮就在隆中（位于今湖北襄阳）隐居，平日喜欢吟诵《梁甫吟》，又常以管仲、乐毅自比，时人对他都是不屑一顾，只有好友徐庶、崔州平等人相信他的才干。</p>
                    <p>诸葛亮与当时的襄阳名士司马徽、庞德公、黄承彦等有结交。黄承彦曾对诸葛亮说：“听到你要选妻，我家中有一丑女，头发黄、皮肤黑，但才华可与你相配。”诸葛亮应许这头亲事，迎娶她。当时的人都以此作笑话取乐，乡里甚至作了句谚语：“莫作孔明择妇，正得阿承丑女”，但也有一种说法指黄月英本人极美，因此遭到乡里其他年轻女性的嫉妒而诋毁她的容貌。</p>
                    <p>诸葛亮于汉灵帝光和四年（181年）出生在琅琊郡阳都县的一个官吏之家，诸葛氏是琅琊的望族，先祖诸葛丰曾在西汉元帝时做过司隶校尉，诸葛亮的父亲诸葛珪在东汉末年做过泰山郡丞； [2]  诸葛亮3岁时母亲章氏病逝，诸葛亮8岁时丧父，与弟弟诸葛均一起跟随由袁术任命为豫章太守的叔父诸葛玄到豫章（今江西南昌）赴任，东汉朝廷派朱皓取代了诸葛玄职务，诸葛玄就去投奔荆州刘表。</p>
                    <p>建安二年（197年），诸葛玄去世，诸葛亮就在隆中（位于今湖北襄阳）隐居，平日喜欢吟诵《梁甫吟》，又常以管仲、乐毅自比，时人对他都是不屑一顾，只有好友徐庶、崔州平等人相信他的才干。</p>
                    <p>诸葛亮与当时的襄阳名士司马徽、庞德公、黄承彦等有结交。黄承彦曾对诸葛亮说：“听到你要选妻，我家中有一丑女，头发黄、皮肤黑，但才华可与你相配。”诸葛亮应许这头亲事，迎娶她。当时的人都以此作笑话取乐，乡里甚至作了句谚语：“莫作孔明择妇，正得阿承丑女”，但也有一种说法指黄月英本人极美，因此遭到乡里其他年轻女性的嫉妒而诋毁她的容貌。</p>
                    <div class="count layui-clear">
                        <span class="pull-left">阅读 <em>100000+</em></span>
                        <span class="pull-right like"><i class="layui-icon layui-icon-praise"></i><em>999</em></span>
                    </div>
                </div>
            </div>
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
</body>
</html>