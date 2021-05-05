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

<#--    原始容器-->
<table class="layui-hide" id="test" lay-filter="test"></table>

<#--    工具栏-->
</div>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
        <button class="layui-btn layui-btn-sm" lay-event="add">添加成员信息</button>
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
            // ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                // , sort: true, totalRowText: '合计'
                ,{field:'id', title:'ID', width:80, fixed: 'left', unresize: true}
                ,{field:'username', title:'用户名', width:120}
                ,{field:'password', title:'密码', width:120}
                ,{field:'accountName', title:'姓名', width:100}
                ,{field:'accountType', title:'学生类型', width:80}
                ,{field:'mobile', title:'手机号', width:150
                    // totalRow: true, edit: 'text', templet: function(res){
                    //     return '<em>'+ res.email +'</em>'}
                        }
                ,{field:'school', title:'学院', width:150, sort: true}
                ,{field:'studentId', title:'学号', width:120, sort: true}
                ,{field:'subgroup', title:'所属分团', width:120, sort: true}
                ,{field:'sex', title:'性别', width:100, sort: true}
                ,{field:'teacher', title:'指导老师', sort: true}
                ,{field:'specialtyType', title:'是否为特长生', width:100, sort: true}
                ,{field:'joinTime', title:'入团时间', width:120 ,sort: true}
                ,{field:'inGroupTime', title:'在团学期', width:120, sort: true}
                ,{field:'remark', title:'备注', width:120}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
            // ,limits:[5,10,15,20,50,100]
            // ,limit:5
        });

        //工具栏事件
        //监听数据表格的头部工具栏
        /**
         * 格式：
         *   table.on('toolbar(数据表格的lay-filter属性值)', function(obj){})
         */
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
                case 'add':
                    //添加操作
                    openAddMember();
            };
        });

        /**
         * 打开添加成员信息窗口层
         */
        function openAddMember() {
            //iframe层
            //弹出层标题
            var title = "<h2>成员管理-添加成员信息</h2>"
            var url = "/addmember"
            layui.layer.open({
                //类型
                type: 2,
                title: title,
                //宽高
                area: ['500px', '90%'],
                //url地址
                content: url ,//iframe的url
                maxmin: true
            });
        }
        function openUpdateMember(id) {
            //iframe层
            //弹出层标题
            var title = "<h2>成员管理-编辑成员信息</h2>"
            var url = "/updatemember/" + id
            layui.layer.open({
                //类型
                type: 2,
                title: title,
                id: id,
                //宽高
                area: ['500px', '90%'],
                //url地址
                content: url ,//iframe的url
                maxmin: true
            });
        }

        //监听工具条
        table.on('tool(test)', function(obj){
            var data = obj.data;
            if(obj.event === 'del'){ //删除
                layer.confirm('删除用户' + data.username + '?', {skin: 'layui-layer-molv',offset:'c', icon:'0'},function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        url: '/member/' + data.id,
                        type: 'delete',
                        success: function (res) {
                            console.log(res);
                            if (res.code == 200) {
                                layer.msg('删除成功', {icon: 1, skin: 'layui-layer-molv', offset:'c'});
                            } else {
                                layer.msg('删除失败', {icon: 2, skin: 'layui-layer-molv', offset:'c'});
                            }
                        }
                    })
                });
            }
            else if(obj.event === 'edit'){
                var id = data.id
                openUpdateMember(id)
            }
        });
    });

    // //监听工具条(右侧)
    // table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
    //     var data = obj.data; //获得当前行数据
    //     var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
    //     var tr = obj.tr; //获得当前行 tr 的DOM对象
    //     if(layEvent === 'del'){ //删除
    //         layer.confirm('删除用户' + data.username + '?', {skin: 'layui-layer-molv',offset:'c', icon:'0'},function(index){
    //             obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
    //             layer.close(index);
    //             //向服务端发送删除指令
    //             $.ajax({
    //                 url: '/member/' + data.id,
    //                 type: 'delete',
    //                 success: function (res) {
    //                     console.log(res);
    //                     if (res.code == 200) {
    //                         layer.msg('删除成功', {icon: 1, skin: 'layui-layer-molv', offset:'c'});
    //                     } else {
    //                         layer.msg('删除失败', {icon: 2, skin: 'layui-layer-molv', offset:'c'});
    //                     }
    //                 }
    //             })
    //         });
    //     }
    //     else if(layEvent === 'edit'){ //编辑
    //         // 发送更新请求
    //         $.ajax({
    //             url: '/member/' + data.id,
    //             method: 'put',
    //             data: JSON.stringify({
    //                 username: data.username,
    //                 password: data.password,
    //                 empId: data.empId,
    //                 isAdmin: temp == null ? data.isAdmin : temp
    //             }),
    //             contentType: "application/json",
    //             success: function (res) {
    //                 console.log(res);
    //                 if (res.code == 200) {
    //                     layer.msg('更新成功', {icon: 1});
    //                     obj.update({
    //                         username: data.username,
    //                         password: data.password,
    //                         empId: data.empId
    //                     });
    //                 } else {
    //                     layer.msg('更新失败', {icon: 2});
    //                 }
    //             }
    //         });
    //     }
    // });

</script>

</body>
</html>