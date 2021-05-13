<!DOCTYPE html>
<html lang="en">
<head>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script src="static/layui/layui.js"></script>
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>添加成员信息</legend>
</fieldset>
<form class="layui-form" id="addform" method="get">
    <input type="hidden" name="status" value="0" id="getSubgroup">
    <input type="hidden" name="adminStudentId" value="${(member.studentId)}" id="getSubgroup">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">活动名称</label>
            <div class="layui-input-block">
                <input type="text" name="activityName" lay-verify="required" lay-reqtext="活动名称是必填项，不能为空！" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">申请单位</label>
            <div class="layui-input-block">
                <input type="text" name="applicant" lay-verify="required" lay-reqtext="申请单位是必填项，不能为空！" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">活动地点</label>
            <div class="layui-input-block">
                <input type="text" name="location" lay-verify="required" lay-reqtext="活动地点是必填项，不能为空！" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">活动时间</label>
        <div class="layui-input-inline">
            <input type="text" name="activityTime" id="activityTime" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
            <label class="layui-form-label">所属分团</label>
            <div class="layui-input-inline">
                <select name="subgroup" lay-verify="required" lay-search="">
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
        <label class="layui-form-label">分团负责人</label>
            <div class="layui-input-block">
                <input type="text" name="subgroupAdmin" placeholder="请输入" autocomplete="off" lay-verify="required" lay-reqtext="分团负责人是必填项，不能为空！" class="layui-input">
            </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">申请人</label>
            <div class="layui-input-block">
                <input type="text" name="applicantName" placeholder="请输入" autocomplete="off" lay-verify="required" lay-reqtext="申请人是必填项，不能为空！" class="layui-input">
            </div>
    </div>
    <div class="layui-form-item">
            <label class="layui-form-label">申请人联系方式</label>
            <div class="layui-input-inline">
                <input type="tel" name="applicantPhone" lay-verify="required|phone" autocomplete="off" class="layui-input">
            </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">节目信息</label>
        <div class="layui-input-block">
            <textarea name="activityInformation" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" id="add">提交申请</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>

    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        form.render
        //日期
        laydate.render({
            elem: '#joinTime'
            , trigger: 'click'
        });

        form.render()

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题至少得5个字符啊';
                }
            }
            ,pass: [
                /^[\S]{6,12}$/
                ,'密码必须6到12位，且不能出现空格'
            ]
            ,content: function(value){
                layedit.sync(editIndex);
            }
        })

        /**
         * 监听表单的submit事件
         * form.on('submit(按钮元素的lay-filter属性值)',function (data){    })
         */
        form.on('submit(demo1)',function (data){
            var index = layer.msg("数据提交中，请稍候...", {
                icon: 16,   //图标
                time: false,  //不关闭
                shade: 0.8  //设置遮罩的透明度
            });

            //发送ajax请求
            var url = "/activity/add";   //添加操作
            $.post(url,data.field,function (result){
                //判断操作是否执行成功 200=成功
                if (result.code == 200){
                    //成功
                    //提示成功
                    layer.msg("操作成功！",{icon:6})
                    //关闭加载层
                    layer.close(index)
                    //关闭弹出层
                    layer.closeAll("iframe");
                    //刷新父窗口，重新加载数据表格的数据
                    parent.location.reload()
                } else {
                    //失败
                    layer.msg(result.msg,{icon:5})
                }
            });

            //组织表单提交
            return false;
        })



    });
</script>

</body>
</html>