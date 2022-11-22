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
<table class="layui-hide" id="test" lay-filter="demo"></table>
<script type="text/html" id="toolbarDemo">
    <div style="display: flex">
        <div style="display: flex">
            <input type="text" name="query" id="query" placeholder="请输入查询的作品名字"
                   autocomplete="off" class="layui-input" style="width: 300px">
            <button class="layui-btn" type="submit" lay-event="query">查询</button>
        </div>
        <div>
            <button class="layui-btn" style="margin-left: 30px" lay-event="add">新增</button>
        </div>
    </div>
</script>
<script type="text/html" id="checkboxTpl">
    <button type="button" class="layui-btn layui-btn-normal layui-btn-sm" lay-event="update">编辑</button>
    <button type="button" class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del">删除</button>
</script>
<script src="../layui-v2.6.8/layui/layui.js"></script>
<script>
    layui.use(['table', 'layer'], function () {
        var table = layui.table
            , form = layui.form;
        var layer = layui.layer;
        var $ = layui.jquery

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

        table.on('tool(demo)', function (obj) {
            let data = obj.data
            if (obj.event === 'update') {
                layer.open({
                    type: 2,
                    title: '编辑信息',
                    content: '/pages/update.jsp',
                    area: ['600px', '500px'],
                    success: (layero, index) => {
                        let body = layer.getChildFrame('body', index);
                        body.find("#id").val(data.id)
                        body.find("#name").val(data.name)
                        body.find("#episode").val(data.episode)
                        body.find("#type").val(data.type)
                        body.find("#introduction").val(data.introduction)
                        body.find("#cover").val(data.cover)
                        body.find("#release_time").val(data.release_time)

                    },
                    end: () => {
                        table.reload('test')
                    }
                })
            } else if (obj.event === 'del') {
                layer.confirm(`你确定要删除《` + data.name + `》吗？`, {icon: 3, title: '提示'}, index => {
                    $.ajax({
                        type: "POST",
                        url: "/filmServlet",
                        data: "id=" + data.id + "&action=delFilmById",
                        success: msg => {
                            layer.msg("《" + data.name + "》删除成功！")
                            table.reload('test')
                        },
                        error: msg => {
                            layer.msg("嘎了！！！！！！！！！！！！！！！！！！")
                        }
                    });
                    layer.close(index)
                });
            }

        });

        table.on('toolbar(demo)', obj => {
            if (obj.event === 'add') {
                layer.open({
                    type: 2,
                    title: '添加信息',
                    content: '/pages/add.jsp',
                    area: ['600px', '500px'],
                    end: () => {
                        table.reload('test')
                    }
                })
            } else if (obj.event === 'query') {
                let text = $('#query').val()
                if (text === "") {
                    table.reload('test',{
                        url:"/filmServlet?action=pages"
                    })
                } else {
                    table.reload('test', {
                        url: "/filmServlet?text=" + text + "&action=queryFilmByName"
                    })

                }

            }
        })
    });
</script>
</body>
</html>
