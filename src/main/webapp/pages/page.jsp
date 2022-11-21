<%--
  Created by IntelliJ IDEA.
  User: Tan
  Date: 2022/11/19
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="../layui-v2.6.8/layui/css/layui.css">
<body>
<table class="layui-hide" id="test"></table>
<script type="text/html" id="toolbarDemo">
    <div style="display: flex">
        <div>
            <form class="layui-form" action="" style="display: flex">
                <input type="text" name="title"  placeholder="请输入查询内容"
                       autocomplete="off" class="layui-input" style="width: 300px">
                <button class="layui-btn" lay-submit >查询</button>
            </form>
        </div>
        <div>
            <button class="layui-btn" style="margin-left: 30px">新增</button>
        </div>
    </div>
</script>
<script type="text/html" id="checkboxTpl">
    <button type="button" class="layui-btn layui-btn-normal layui-btn-sm">编辑</button>
    <button type="button" class="layui-btn layui-btn-sm layui-btn-danger">删除</button>
</script>
<script src="../layui-v2.6.8/layui/layui.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table
            , form = layui.form;

        table.render({
            elem: '#test'
            , url: "/filmServlet?action=pages"
            , toolbar: '#toolbarDemo'
            , cellMinWidth: 80
            , limits: [20]
            , limit: 20
            , cols: [[
                {type: 'checkbox'}
                , {type: 'numbers'}
                , {field: 'id', title: 'ID', unresize: true, hide: true}
                , {field: 'name', title: '名字', templet: '#usernameTpl'}
                , {field: 'episode', title: '总集数'}
                , {field: 'type', title: '类型'}
                , {field: 'introduction', title: '简介'}
                , {field: 'cover', title: '封面'}
                , {field: 'release_time', title: '播放时间'}
                , {field: '#', title: '操作', templet: '#checkboxTpl', width: 150}
            ]]
            , page: true
        });
    });
</script>
</body>
</html>
