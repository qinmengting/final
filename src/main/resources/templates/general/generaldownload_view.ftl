<!-- 后台管理系统问题列表-->
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="../static/js/jquery-3.4.1.min.js"></script>
    <script src="../static/layui/layui.js"></script>
    <link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body>

<table class="layui-hide" id="file-table" lay-filter="file-table"></table>

<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="addFile">艺术团文件</button>
    </div>
</script>

<script type="text/html" id="barTpl">
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="download" id="download-btn">下载</a>
</script>

<script>
    var realUUIDname = "";
    var originalFilename = "";
    layui.use('table', function(){

        var table = layui.table;

        table.render({
            elem: '#file-table',
            url:'/files/',
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
                {field:'id', width:60, title: 'ID'},
                {field:'title', width:200, title: '文件名称', edit: true},
                {field:'description', width:300, title:'描述', edit: true},
                {field:'username', width:150, title: '创建者'},
                {field:'createdTime', width:180, title: '创建时间', sort: true},
                {field:'filename', width: 120, title: 'sdfsd', hide: true},
                {fixed: 'right', width:180, align:'center', toolbar: '#barTpl'}
            ]]
            ,page: true
        });

        //监听工具条(右侧)
        table.on('tool(file-table)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if(layEvent === 'download'){ //下载文件
                // 文件下载
                console.log(data.id);
                window.location.href = "/files/download/" + data.id;
            }
        });

    });
</script>

</body>
</html>