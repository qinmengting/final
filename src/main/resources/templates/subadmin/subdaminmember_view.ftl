<!DOCTYPE html>
<html lang="en">
<head>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script src="static/layui/layui.js"></script>
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>

<div>
    <input type="hidden" value="${(member.subgroup)}" id="getSubgroup">
</div>

<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md10">
            <div class="layui-card">
                <div class="layui-card-header"><span style="margin-right: 10px; margin-bottom: 2px" class="layui-badge-dot"></span>快速搜索</div>
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
                            <label class="layui-form-label">学院</label>
                            <div class="layui-inline">
                                <select name="school" lay-search="">
                                    <option value="">直接选择或搜索选择</option>
                                    <option value="地球科学与资源学院">地球科学与资源学院</option>
                                    <option value="工程技术学院">工程技术学院</option>
                                    <option value="材料科学与工程学院">材料科学与工程学院</option>
                                    <option value="信息工程学院">信息工程学院</option>
                                    <option value="水资源与环境学院">水资源与环境学院</option>
                                    <option value="能源学院">能源学院</option>
                                    <option value="经济管理学院">经济管理学院</option>
                                    <option value="外国语学院">外国语学院</option>
                                    <option value="珠宝学院">珠宝学院</option>
                                    <option value="地球物理与信息技术学院">地球物理与信息技术学院</option>
                                    <option value="海洋学院">海洋学院</option>
                                    <option value="土地科学技术学院">土地科学技术学院</option>
                                    <option value="马克思主义学院">马克思主义学院</option>
                                    <option value="数理学院">数理学院</option>
                                </select>
                            </div>
                            <div class="layui-inline">
                                <label class="layui-form-label">指导老师</label>
                                <div class="layui-input-block">
                                    <input type="text" name="teacher" placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label">手机号</label>
                                <div class="layui-input-block">
                                    <input type="text" name="mobile" placeholder="请输入" autocomplete="off" class="layui-input">
                                </div>
                                <input type="hidden" name="subgroup" value="${(member.subgroup)}" id="getSubgroup">
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
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">添加成员信息</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['element', 'layer','table','form'], function(){
        var table = layui.table;
        var form = layui.form;

        var subgroup = $('#getSubgroup').val()


        var tableIns = table.render({
            elem: '#test'
            ,url:'/sub/queryByParams/'+subgroup
            ,toolbar: '#toolbarDemo'
            ,method: "get"
            ,title: '大学生艺术团成员信息表'
            // ,totalRow: true
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                // , sort: true, totalRowText: '合计'
                ,{field:'id', title:'ID', width:80, fixed: 'left', sort: true,unresize: true}
                ,{field:'username', title:'用户名', width:120}
                ,{field:'password', title:'密码', width:120}
                ,{field:'accountName', title:'姓名', width:100}
                ,{field:'accountType', title:'学生类型', templet:function (res) {
                    if (res.accountType == 0)
                        return "团长";
                    else if (res.accountType == 1)
                        return  "副团长";
                    else if (res.accountType == 2)
                        return "团员"
                        },
                        sort: true, width:120}
                ,{field:'studentId', title:'学号',sort: true, width:120}
                ,{field:'mobile', title:'手机号', width:150
                    // totalRow: true, edit: 'text', templet: function(res){
                    //     return '<em>'+ res.email +'</em>'}
                        }
                ,{field:'school', title:'学院', width:150, sort: true}
                ,{field:'studentId', title:'学号', width:120, sort: true}
                ,{field:'subgroup', title:'所属分团', width:120, sort: true}
                ,{field:'sex', title:'性别', width:100, templet:function (res) {
                        if (res.sex == 0)
                            return "男";
                        else if (res.sex == 1)
                            return  "女";
                    },
                    sort: true}
                ,{field:'teacher', title:'指导老师', width:100, sort: true}
                ,{field:'specialtyType', title:'是否为特长生',  templet:function (res) {
                        if (res.specialtyType == 0)
                            return "否";
                        else if (res.specialtyType == 1)
                            return  "是";
                    },
                    width:100, sort: true}
                ,{field:'joinTime', title:'入团时间', width:120 ,sort: true}
                ,{field:'inGroupTime', title:'在团学期',templet:function (res) {
                        if (res.inGroupTime < 4)
                            return "<a style='color: red'>"+res.inGroupTime+"</a>";
                        else if (res.inGroupTime >= 4 )
                            return  "<a style='color: forestgreen'>"+res.inGroupTime+"</a>";
                    },
                    width:120, sort: true}
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
                    accountName:$("[name='accountName']").val()
                    , studentId:$("[name='studentId']").val()
                    , subgroup:$("[name='subgroup']").val()
                    , mobile:$("[name='mobile']").val()
                    , school:$("[name='school']").val()
                    , teacher:$("[name='teacher']").val()
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

</script>

</body>
</html>