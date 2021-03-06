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
                            <label class="layui-form-label">分团</label>
                            <div class="layui-inline">
                                <select name="subgroup" lay-search="" id="subgroup">
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
<#--<script type="text/html" id="toolbarDemo">-->
<#--    <div class="layui-btn-container">-->
<#--        <button class="layui-btn layui-btn-sm" lay-event="add">活动申请</button>-->
<#--    </div>-->
<#--</script>-->

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="ok">通过</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="no">拒绝</a>
</script>

<script>
    layui.use(['element', 'layer','table','form'], function(){
        var table = layui.table;
        var form = layui.form;

        var subgroup = $('#subgroup').val()

        var tableIns = table.render({
            elem: '#test'
            ,url:'/activity/queryByParams'
            ,toolbar: '#toolbarDemo'
            ,title: '活动审批信息表'
            // ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                // , sort: true, totalRowText: '合计'
                ,{field:'id', title:'ID', width:80, fixed: 'left', sort: true, unresize: true}
                ,{field:'status', title:'审批状态',templet:function (res) {
                    if (res.status == 0){
                        return "<a style='color: orange'>审批中</a>";
                    }
                    else if (res.status == 1) {
                        return "<a style='color: green'>通过</a>";
                    }
                    else if (res.status == 2) {
                        return "<a style='color: red'>未通过</a>";
                    }
                    }
                    , sort: true, width:120}
                ,{field:'activityName', title:'活动名称', width:120}
                ,{field:'applicant', title:'申请单位', width:100}
                ,{field:'location', title:'活动地点', sort: true, width:120}
                ,{field:'activityTime', title:'演出时间',sort: true, width:120}
                ,{field:'subgroup', title:'所属分团', width:150 }
                ,{field:'subgroupAdmin', title:'分团负责人', width:120, sort: true}
                ,{field:'applicantName', title:'申请人', width:120, sort: true}
                ,{field:'applicantPhone', title:'申请人联系方式', width:120, sort: true}
                ,{field:'activityInformation', title:'节目信息', width:120}
                ,{field:'remark', title:'备注', width:120}
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
                    subgroup:$("[name='subgroup']").val()
                }
                ,page: {
                    curr:1
                }
            })
        })

        //工具栏事件
        //监听数据表格的头部工具栏
        /**
         * 格式：
         *   table.on('toolbar(数据表格的lay-filter属性值)', function(obj){})
         */
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    //添加操作
                    openAddActivity();
            };
        });

        /**
         * 打开活动窗口层
         */
        function openAddActivity() {
            //iframe层
            //弹出层标题
            var title = "<h2>活动申请</h2>"
            var url = "/addactivity"
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


        function openUpdateActivity(id) {
            //iframe层
            //弹出层标题
            var title = "<h2>编辑活动申请</h2>"
            var url = "/updateactivity/" + id
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
            var status = data.status; //获取审批状态
            if(obj.event === 'no'){ //删除
                if (status == 1 ){
                    layer.confirm("审批已通过，无法操作")
                }
                else {
                    layer.confirm('拒绝该活动申请?', {
                        skin: 'layui-layer-molv',
                        offset: 'c',
                        icon: '0'
                    }, function (index) {
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            url: '/activity/refuse/' + data.id,
                            type: 'put',
                            success: function (res) {
                                console.log(res);
                                if (res.code == 200) {
                                    layer.msg('操作成功', {icon: 1, skin: 'layui-layer-molv', offset: 'c'});
                                } else {
                                    layer.msg('操作失败', {icon: 2, skin: 'layui-layer-molv', offset: 'c'});
                                }
                            }
                        })
                    });
                }
            }
            else if(obj.event === 'ok'){
                var data = obj.data;
                var status = data.status; //获取审批状态
                if (status == 1) {
                    layer.confirm("审批已通过，无法操作");
                }
                else {
                    layer.confirm('同意该活动申请?', {
                        skin: 'layui-layer-molv',
                        offset: 'c',
                        icon: '0'
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: '/activity/approve/' + data.id,
                            type: 'put',
                            success: function (res) {
                                console.log(res);
                                if (res.code == 200) {
                                    layer.msg('操作成功', {icon: 1, skin: 'layui-layer-molv', offset: 'c'});
                                } else {
                                    layer.msg('操作失败', {icon: 2, skin: 'layui-layer-molv', offset: 'c'});
                                }
                            }
                        })
                    });
                }
            }
        });
    });

</script>

</body>
</html>