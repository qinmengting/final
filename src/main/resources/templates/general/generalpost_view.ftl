<!-- 后台管理系统问题列表-->
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="../static/js/jquery-3.4.1.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body>

<table class="layui-hide" id="post-table" lay-filter="post-table"></table>

<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="addPost">全部公告</button>
    </div>
</script>

<script>

    var layerCallback;
    var json;
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#post-table',
            url:'/posts/',
            toolbar: '#toolbar',
            parseData: function (res) {
                console.log(res);
                return {
                    "code": 0,
                    "msg": "",
                    "count": res.size,
                    data: res.data
                }
            }
            ,cols: [[
                // {field:'id', width:60, title: 'ID'},
                {field:'title', width:200, title: '公告名称', templet: function (row) {
                        return row.title;
                    }},
                {field:'content', width:400, title:'公告内容'},
                {field:'username', width:150, title: '公告人', templet: function (row) {
                        if (row.username == null ) return "无此用户";
                        return row.username;
                    }},
                {field:'createdTime', width:180, title: '创建时间', sort: true},

                {fixed: 'right', width:150, align:'center', toolbar: '#barTpl'}
            ]]
            ,page: true
        });

    });
</script>
</body>
</html>