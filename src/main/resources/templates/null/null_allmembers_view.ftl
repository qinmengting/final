<!DOCTYPE html>
<html lang="en">
<head>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script src="static/layui/layui.js"></script>
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div class="layui-form-item" style="padding-right: 0px">
<table class="layui-hide" id="test" lay-filter="test"></table>
</div>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
        <button class="layui-btn layui-btn-sm" lay-event="add">
            <a href="/addmember" target="admin-list">添加成员信息</a></button>
    </div>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        //温馨提示：默认由前端自动合计当前行数据。从 layui 2.5.6 开始： 若接口直接返回了合计行数据，则优先读取接口合计行数据。
        //详见：https://www.layui.com/doc/modules/table.html#totalRow
        table.render({
            elem: '#test'
            ,url:'/member/queryAll'
            ,toolbar: '#toolbarDemo'
            ,title: '大学生艺术团成员信息表'
            ,totalRow: true
            // ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
            //     layout: ['limit', 'count', 'prev', 'page', 'next', 'skip'] //自定义分页布局
            //     ,curr: 1 //设定初始在第 5 页
            //     ,groups: 3 //只显示 1 个连续页码
            //     ,first: false //不显示首页
            //     ,last: false //不显示尾页
            //
            // }
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                // ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true, sort: true, totalRowText: '合计'}
                ,{field:'username', title:'用户名', width:120}
                ,{field:'password', title:'密码', width:120}
                ,{field:'accountName', title:'姓名', width:100}
                ,{field:'accountType', title:'学生类型', width:120}
                ,{field:'mobile', title:'手机号', width:150
                    // totalRow: true, edit: 'text', templet: function(res){
                    //     return '<em>'+ res.email +'</em>'}
                        }
                ,{field:'school', title:'学院', width:80, sort: true}
                ,{field:'studentId', title:'学号', width:80, sort: true}
                ,{field:'subgroup', title:'所属分团', width:80, sort: true}
                ,{field:'sex', title:'性别', width:100, sort: true}
                ,{field:'teacher', title:'指导老师', sort: true}
                ,{field:'specialtyType', title:'是否为特长生', width:100}
                ,{field:'joinTime', title:'入团时间', width:120}
                ,{field:'inGroupTime', title:'在团学期', width:120}
                ,{field:'remark', title:'备注', width:120}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
            // ,limits:[5,10,15,20,50,100]
            // ,limit:5
        });

        //工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：'+ data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选': '未全选')
                    break;
            };
        });

        //监听工具条
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });
    });
</script>

</body>
</html>