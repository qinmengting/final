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
                            <input type="hidden" name="subgroup" value="${(member.subgroup)}" id="getSubgroup">
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <a class="layui-btn search_btn" datatype="reload"><i class="layui-icon">&#xe615</i>搜索</a>
<#--                                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" id="add">搜索</button>-->
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
<#--    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>-->
</script>

<script>
    layui.use(['element', 'layer','table','form'], function(){
        var table = layui.table;
        var form = layui.form;

        var subgroup = $('#getSubgroup').val()

        var tableIns = table.render({
            elem: '#test'
            ,url: '/sub/queryByParams/'+ subgroup
            ,toolbar: '#toolbarDemo'
            ,title: '考勤信息表'
            // ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                // , sort: true, totalRowText: '合计'
                ,{field:'id', title:'ID', width:80, fixed: 'left', sort: true,unresize: true}
                ,{field:'accountName', title:'姓名', width:100}
                ,{field:'studentId', title:'学号', width:120, sort: true}
                ,{field:'subgroup', title:'所属分团', width:120, sort: true}
                ,{field:'attendanceScore', title:'考勤成绩', templet:function (res) {
                        if (res.attendanceScore < 60)
                            return "<a style='color: red'>"+res.attendanceScore+"</a>";
                        else if (res.attendanceScore >= 60 )
                            return  "<a style='color: forestgreen'>"+res.attendanceScore+"</a>";
                    },width:120, sort: true}
                ,{field:'usuallyScore', title:'平时成绩', edit:'text',  templet:function (res) {
                        if (res.usuallyScore < 60)
                            return "<a style='color: red'>"+res.usuallyScore+"</a>";
                        else if (res.usuallyScore >= 60 )
                            return  "<a style='color: forestgreen'>"+res.usuallyScore+"</a>";
                    },width:120, sort: true}
                ,{field:'workScore', title:'期末考核成绩', edit:'text',  templet:function (res) {
                        if (res.workScore < 60)
                            return "<a style='color: red'>"+res.workScore+"</a>";
                        else if (res.workScore >= 60 )
                            return  "<a style='color: forestgreen'>"+res.workScore+"</a>";
                    },width:120, sort: true}
                ,{field:'totalScore', title:'总成绩',  templet:function (res) {
                        if (res.totalScore < 60)
                            return "<a style='color: red'>"+res.totalScore+"</a>";
                        else if (res.totalScore >= 60 )
                            return  "<a style='color: forestgreen'>"+res.totalScore+"</a>";
                    },width:120, sort: true}
                ,{field:'attendanceCount', title:'考勤次数', templet:function (res) {
                        if (res.attendanceCount < 6)
                            return "<a style='color: red'>"+res.attendanceCount+"</a>";
                        else if (res.attendanceCount >= 6 )
                            return  "<a style='color: forestgreen'>"+res.attendanceCount+"</a>";
                    },width:120, sort: true}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
            // ,limits:[5,10,15,20,50,100]
            // ,limit:5
        });

        var confirmTrans = function(){
            //配置一个透明的询问框
            layer.msg('请先设置分团各分数比例，再录入成绩<br>总成绩为【各分数占比*成绩】之和<br>总成绩由系统生成，不可直接更改', {
                time: 20000, //20s后自动关闭
                btn: ['明白了', '好的']
            });
        }

        //搜索
        $(".search_btn").click(function (){
            tableIns.reload({
                where: {
                    accountName:$("[name='accountName']").val()
                    , studentId:$("[name='studentId']").val()
                    , subgroup:$("[name='subgroup']").val()
                    , attendanceCount:$("[name='attendanceCount']").val()
                    , attendanceScore:$("[name='attendanceScore']").val()
                    , usuallyScore:$("[name='usuallyScore']").val()
                    , workScore:$("[name='workScore']").val()
                    , totalScore:$("[name='totalScore']").val()
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
                if(layEvent === 'edit'){ //编辑
                // 发送更新请求
                $.ajax({
                    url: '/score/updatesocre/' + data.id,
                    method: 'put',
                    data: JSON.stringify({
                        accountName: data.accountName,
                        studentId: data.studentId,
                        subgroup: data.subgroup,
                        attendanceCount: data.attendanceCount,
                        attendanceScore: data.attendanceScore,
                        usuallyScore: data.usuallyScore,
                        workScore: data.workScore,
                        totalScore: data.totalScore
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
                                attendanceCount: data.attendanceCount,
                                attendanceScore: data.attendanceScore,
                                usuallyScore: data.usuallyScore,
                                workScore: data.workScore,
                                totalScore: data.totalScore
                            })
                            tableIns.reload({
                                where: {
                                    accountName:$("[name='accountName']").val()
                                    , studentId:$("[name='studentId']").val()
                                    , subgroup:$("[name='subgroup']").val()
                                    , attendanceCount:$("[name='attendanceCount']").val()
                                    , attendanceScore:$("[name='attendanceScore']").val()
                                    , usuallyScore:$("[name='usuallyScore']").val()
                                    , workScore:$("[name='workScore']").val()
                                    , totalScore:$("[name='totalScore']").val()
                                }
                                ,page: {
                                    curr:1
                                }
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