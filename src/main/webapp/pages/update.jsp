<%--
  Created by IntelliJ IDEA.
  User: Tan
  Date: 2022/11/22
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../layui-v2.6.8/layui/css/layui.css">
</head>
<body>

<div>
    <form action="/filmServlet?action=updateFilm" class="layui-form" style="display: flex;flex-direction: column;" method="post">
        <input type="hidden" id="id" name="id">
        <div class="layui-form-item" style="margin: auto">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input type="text" id="name" name="name" lay-verify="required" placeholder="请输入" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="margin: auto">
            <label class="layui-form-label">总集数</label>
            <div class="layui-input-inline">
                <input type="text" id="episode" name="episode" lay-verify="required" placeholder="请输入" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="margin: auto">
            <label class="layui-form-label">类型</label>
            <div class="layui-input-inline">
                <input type="text" id="type" name="type" lay-verify="required" placeholder="请输入" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
<%--        <div class="layui-form-item" style="margin: auto">--%>
<%--            <label class="layui-form-label">简介</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="text" id="introduction" name="introduction" lay-verify="required" placeholder="请输入" autocomplete="off"--%>
<%--                       class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">简介</label>
            <div class="layui-input-block">
                <textarea id="introduction" name="introduction" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item" style="margin: auto">
            <label class="layui-form-label">封面</label>
            <div class="layui-input-inline">
                <input type="text" id="cover" name="cover" lay-verify="required" placeholder="请输入" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" style="margin: auto">
            <label class="layui-form-label">播放时间</label>
            <div class="layui-input-inline">
                <input type="text" id="release_time" name="release_time"  placeholder="请输入" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div style="margin: auto">
            <button id="update" class="layui-btn" lay-submit >修改</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>

    </form>
</div>

<script src="../layui-v2.6.8/layui/layui.js"></script>
<script>
    layui.use('layer',()=>{
        var $=layui.jquery
        var layer=layui.layer

        $("#update").click(()=>{
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.msg("修改成功")
            parent.layer.close(index);
        })
    })
</script>
</body>
</html>
