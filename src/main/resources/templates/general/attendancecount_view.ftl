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
<div>
    <input type="hidden" value="${(member.accountType)}" id="getAccountType">
    <input type="hidden" value="${(member.sex)}" id="getSex">
    <input type="hidden" value="${(member.specialtyType)}" id="getSpecialtyType">
    <input type="hidden" value="${(member.id)}" id="getId">
    <input type="hidden" value="${(member.subgroup)}" id="getSubgroup">
    <input type="hidden" value="${(member.school)}" id="getSchool">
    <input type="hidden" value="${(member.studentId)}" id="getStudentId">
</div>

<script>
    layui.use(['element', 'layer','table','form'], function(){
        var table = layui.table;
        var form = layui.form;

        var AccountType = $('#getAccountType').val()
        var Sex = $('#getSex').val()
        var SpecialtyType = $('#getSpecialtyType').val()
        var id = $('#getId').val()
        var studentId = $('#getStudentId').val()

        var tableIns = table.render({
            elem: '#test'
            ,url:'/general/queryAttendanceCount/'+ id
            ,toolbar: '#toolbarDemo'
            // ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                // , sort: true, totalRowText: '合计'
                // ,{field:'id', title:'ID', width:80, fixed: 'left', sort: true,unresize: true}
                ,{field:'accountName', title:'姓名', width:100}
                ,{field:'studentId', title:'学号', width:120, sort: true}
                ,{field:'subgroup', title:'所属分团', width:120, sort: true}
                ,{field:'attendanceCount', title:'考勤次数', templet:function (res) {
                        if (res.attendanceCount < 6)
                            return "<a style='color: red'>"+res.attendanceCount+"</a>";
                        else if (res.attendanceCount >= 6 )
                            return  "<a style='color: forestgreen'>"+res.attendanceCount+"</a>";
                    },
                    width:120, sort: true}
                ,{field:'attendanceCount', title:'提示', templet:function (res) {
                        if (res.attendanceCount < 6)
                            return "<a style='color: red'>"+"要及时参加训练哦~"+"</a>";
                        else if (res.attendanceCount >= 6 )
                            return  "<a style='color: forestgreen'>"+"参加训练很及时，再接再厉！"+"</a>";
                    },
                    width:200}
            ]]
            ,page: true
            // ,limits:[5,10,15,20,50,100]
            // ,limit:5
        });

        //搜索
        $(".search_btn").click(function (){
            tableIns.reload({
                where: {
                    accountName:$('#getAccountType').val()
                    , studentId:$('#getStudentId').val()
                    , id:$('#geId').val()
                }
                ,page: {
                    curr:1
                }
            })
        });

    });

</script>

</body>
</html>