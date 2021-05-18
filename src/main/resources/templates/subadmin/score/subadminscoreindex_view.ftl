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
    <legend>请进行绩效比例设定</legend>
</fieldset>

<form class="layui-form" id="addform" method="get">
    <div class="layui-form-item">
            <label class="layui-form-label">所在分团</label>
            <div class="layui-input-inline">
                <input type="tel" name="subgroup" value="${(member.subgroup)!}" autocomplete="off" class="layui-input" disabled>
<#--                <input type="hidden" name="subgroup" value="${(member.subgroup)}" id="getSubgroup">-->
            </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">考勤总次数</label>
            <div class="layui-input-inline">
                <input type="text" name="totalAttendance" lay-verify="required|number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">考勤分占比</label>
            <div class="layui-input-inline">
                <input type="text" name="attendanceProp" lay-verify="required|number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">平时分占比</label>
            <div class="layui-input-inline">
                <input type="text" name="usuallyProp" lay-verify="required|number" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">期末考核分占比</label>
            <div class="layui-input-inline">
                <input type="text" name="workProp" lay-verify="required|number" autocomplete="off" class="layui-input">
            </div>
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
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" id="add">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<div style="padding: 20px; background-color: #F2F2F2;">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header"><span style="margin-right: 10px; margin-bottom: 2px" class="layui-badge-dot"></span>提示</div>
                <div class="layui-card-body">
                    <div class="layui-btn-container" style="margin-top: 5px;">
                        <button data-method="confirmTrans" id="touming" class="layui-btn">考勤总次数设置后，考勤分自动生成</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>

    layui.use(['form', 'layedit', 'laydate','element'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        form.render()

        var confirmTrans = function(){
            //配置一个透明的询问框
            layer.msg('考勤成绩为【成员考勤次数/考勤总次数*100】<br>当所属分团考勤总次数设置后，考勤分由系统生成', {
                time: 20000, //20s后自动关闭
                btn: ['明白了', '好的']
            });
        }

        $("#touming").click(confirmTrans())


        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');


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
            var url = "/score/addprop";   //添加操作
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
            //阻止表单提交
            return false;
        })



    });
</script>

</body>
</html>