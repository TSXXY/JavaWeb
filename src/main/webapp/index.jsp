<%@ page import="java.util.List" %>
<%@ page import="com.tan.javaweb.pojo.Film" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<link rel="stylesheet" href="./layui-v2.6.8/layui/css/layui.css">
<body>
<%--功能--%>
<div style="display: flex">
    <button type="button" class="layui-btn layui-btn-normal">新增</button>
    <form class="layui-form" action="" style="display: flex">
        <div class="layui-form-item">
            <div class="layui-input-block" >
                <input type="text" name="title" required lay-verify="required" placeholder="请输入查询内容"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div>
            <button class="layui-btn" lay-submit lay-filter="formDemo" >立即提交</button>
        </div>
    </form>
</div>
<%--显示--%>
<div>
    <table class="layui-table">
        <colgroup>
            <col>
            <col>
            <col>
            <col>
            <col>
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>id</th>
            <th>名字</th>
            <th>影片总集数</th>
            <th>影片类型</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Film> list = (List<Film>) request.getAttribute("list");
            for (Film film : list) { %>
        <tr>
            <td><%=film.getId()%></td>
            <td><%=film.getName()%></td>
            <td><%=film.getEpisode()%></td>
            <td><%=film.getType()%></td>
            <td>
                <button type="button" class="layui-btn layui-btn-normal">编辑</button>
                <button type="button" class="layui-btn layui-btn-danger">删除</button>
            </td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>
    <script src="./layui-v2.6.8/layui/layui.js"></script>
</div>

</body>
</html>