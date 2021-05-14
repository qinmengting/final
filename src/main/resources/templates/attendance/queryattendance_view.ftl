<!DOCTYPE html>
<html lang="en">
<head>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script src="static/layui/layui.js"></script>
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md10">
            <div class="layui-card">
                <div class="layui-card-header"><span style="margin-right: 10px; margin-bottom: 2px" class="layui-badge-dot"></span>请选择查询条件</div>
                <div class="layui-card-body">
                    <form class="layui-form" id="addform" method="get">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">姓名</label>
                                <div class="layui-input-block" style="width: 218.67px">
                                    <input type="text" name="accountName" placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">学号</label>
                                <div class="layui-input-block">
                                    <input type="text" name="studentId" placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">所属分团</label>
                            <div class="layui-inline">
                                <select name="subgroup" lay-search="">
                                    <option value="">直接选择或搜索选择</option>
                                    <option value="合唱团">合唱团</option>
                                    <option value="话剧团">话剧团</option>
                                    <option value="舞蹈团">舞蹈团</option>
                                    <option value="打击乐团">打击乐团</option>
                                    <option value="民乐团">民乐团</option>
                                    <option value="室内乐团">室内乐团</option>
                                    <option value="主持部">主持部</option>
                                    <option value="礼仪部">礼仪部</option>
                                    <option value="造型设计部">造型设计部</option>
                                    <option value="办公室">办公室</option>
                                    <option value="演出中心">演出中心</option>
                                    <option value="训练管理">训练管理</option>
                                    <option value="传媒中心">传媒中心</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <a class="layui-btn search_btn" datatype="reload"><i class="layui-icon">&#xe615</i>搜索</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="layui-form-item" style="padding-right: 0px">

<#--    原始容器-->
<table class="layui-hide" id="test" lay-filter="test"></table>

<#--    工具栏-->
</div>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">保存</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['element', 'layer','table','form'], function(){
        var table = layui.table;
        var form = layui.form;

        var tableIns = table.render({
            elem: '#test'
            ,url:'/attendance/queryByParams'
            ,toolbar: '#toolbarDemo'
            ,title: '大学生艺术团成员信息表'
            // ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                // , sort: true, totalRowText: '合计'
                ,{field:'id', title:'ID', width:80, fixed: 'left', sort: true,unresize: true}
                ,{field:'accountName', title:'姓名', width:100}
                ,{field:'studentId', title:'学号', width:120, sort: true}
                ,{field:'subgroup', title:'所属分团', width:120, sort: true}
                ,{field:'gmtCreate', title:'考勤时间', edit:'date', width:120, sort: true}
                ,{field:'remark', title:'备注', edit:'text', width:120}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
            // ,limits:[5,10,15,20,50,100]
            // ,limit:5
        });

        //搜索
        $(".search_btn").click(function (){
            tableIns.reload({
                where: {
                    accountName:$("[name='accountName']").val()
                    , studentId:$("[name='studentId']").val()
                    , subgroup:$("[name='subgroup']").val()
                }
                ,page: {
                    curr:1
                }
            })
        })

        table.on('tool(test)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象
            if(layEvent === 'del'){ //删除
                layer.confirm('删除'+data.gmtCreate + " " + data.accountName + '的考勤记录？?', {skin: 'layui-layer-molv',offset:'c', icon:'0'},function(index){
                    obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                    layer.close(index);
                    //向服务端发送删除指令
                    $.ajax({
                        url: '/attendance/delete/' + data.id,
                        type: 'delete',
                        success: function (res) {
                            console.log(res);
                            if (res.code == 200) {
                                layer.msg('删除成功', {icon: 1, skin: 'layui-layer-molv', offset:'c'});
                            } else {
                                layer.msg(res.msg(), {icon: 2, skin: 'layui-layer-molv', offset:'c'});
                            }
                        }
                    })
                });
            } else if(layEvent === 'edit'){ //编辑
                // 发送更新请求
                $.ajax({
                    url: '/attendance/update/' + data.id,
                    method: 'put',
                    data: JSON.stringify({
                        accountName: data.accountName,
                        studentId: data.studentId,
                        subgroup: data.subgroup,
                        remark: data.remark,
                        gmtCreate: data.gmtCreate
                    }),
                    contentType: "application/json",
                    success: function (res) {
                        console.log(res);
                        if (res.code == 200) {
                            layer.msg('编辑成功', {icon: 1});
                            obj.update({
                                accountName: data.accountName,
                                studentId: data.studentId,
                                subgroup: data.subgroup,
                                remark: data.remark,
                                gmtCreate: data.gmtCreate
                            });
                        } else {
                            layer.msg(res.msg, {icon: 2});
                        }
                    }
                });
            }
        });

    });

</script>

</body>
</html>