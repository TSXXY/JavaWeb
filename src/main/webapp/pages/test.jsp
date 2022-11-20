<%@ page import="com.tan.javaweb.pojo.Page" %>
<%@ page import="com.tan.javaweb.pojo.Film" %>
<%@ page import="java.util.List" %><%--
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
<%
    Page<Film> page1 = (Page<Film>) request.getAttribute("page");
    Integer pageTotalCount = page1.getPageTotalCount();
    Integer pageNo = page1.getPageNo();
    Integer pageSize = page1.getPageSize();
    List<Film> items = page1.getItems();
    Integer pageTotal = page1.getPageTotal();

%>
<table class="layui-hide" id="test"></table>
<script type="text/html" id="checkboxTpl">
    <button type="button" class="layui-btn layui-btn-normal">编辑</button>
    <button type="button" class="layui-btn layui-btn-danger">删除</button>
</script>
<script src="../layui-v2.6.8/layui/layui.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table
            , form = layui.form;

        table.render({
            elem: '#test'
            , url: ${requestScope.page.items}
            , cellMinWidth: 80
            , cols: [[
                {field: 'id', title: 'ID', width: 100, unresize: true, sort: true}
                , {field: 'name', title: '名字', templet: '#usernameTpl'}
                , {field: 'episode', title: '总集数'}
                , {field: 'type', title: '类型', minWidth: 120}
                , {field: '#', title: '操作', width: 85, templet: '#checkboxTpl'}
            ]]
            , page: true
        });
    });
</script>
</body>
</html>
