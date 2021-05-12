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
                <div class="layui-card-header"><span style="margin-right: 10px; margin-bottom: 2px" class="layui-badge-dot"></span>您所在的分团为</div>
                <div class="layui-card-body">
                    <form class="layui-form" id="addform" method="get">
                        <div class="layui-form-item">
                            <label class="layui-form-label">${(member.subgroup)}</label>
                            <div class="layui-inline">
                                <input type="hidden" name="subgroup" value="${(member.subgroup)}" id="getSubgroup">
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
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">添加考勤记录</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    </div>
</script>

<script>
    layui.use(['element', 'layer','table','form'], function() {
        var table = layui.table;
        var form = layui.form;

        var subgroup = $('#getSubgroup').val()

        //温馨提示：默认由前端自动合计当前行数据。从 layui 2.5.6 开始： 若接口直接返回了合计行数据，则优先读取接口合计行数据。
        //详见：https://www.layui.com/doc/modules/table.html#totalRow
        var tableIns = table.render({
            elem: '#test'
            , url: '/sub/queryByParams/'+ subgroup
            , toolbar: '#toolbarDemo'
            , title: '大学生艺术团成员信息表'
            // ,totalRow: true
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                // , sort: true, totalRowText: '合计'
                , {field: 'id', title: 'ID',fixed: 'left', sort: true, unresize: true}
                , {field: 'accountName', title: '姓名'}
                , {field: 'studentId', title: '学号', sort: true}
                , {field: 'subgroup', title: '所属分团', sort: true}
            ]]
            , page: true
            // ,limits:[5,10,15,20,50,100]
            // ,limit:5
        });

        //搜索
        $(".search_btn").click(function () {
            tableIns.reload({
                where: {
                    subgroup: $("[name='subgroup']").val()
                }
                , page: {
                    curr: 1
                }
            })
        });

        // 监听头部工具栏
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'getCheckData':
                    var data = checkStatus.data;
                    addattendance(data);
                    // layer.alert(JSON.stringify(data));
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


        function addattendance(data) {
            var index = layer.msg("添加考勤中，请稍候...", {
                icon: 16,   //图标
                time: false,  //不关闭
                shade: 0.8  //设置遮罩的透明度
            });

            //发送ajax请求
            var url = "/attendance/add";   //添加操作
            $.ajax({
                type: "POST",
                url: url,
                data: JSON.stringify(data),
                contentType: 'application/json',
                success: function(result) {
                    //判断操作是否执行成功 200=成功
                    if (result.code == 200) {
                        //成功
                        //提示成功
                        layer.msg("操作成功！", {icon: 6})
                        //关闭加载层
                        layer.close(index)
                        //关闭弹出层
                        layer.closeAll("iframe");
                        //刷新父窗口，重新加载数据表格的数据
                        // parent.location.reload()
                    } else {
                        //失败
                        layer.msg(result.msg, {icon: 5})
                    }
                }
            });
        }

    })
</script>

</body>
</html>