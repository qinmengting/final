<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>个人信息</title>
    <script src="/static/js/jquery-3.4.1.min.js"></script>
    <script src="/static/layui/layui.js"></script>
    <link rel="stylesheet" href="/static/layui/css/layui.css">
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
    <legend>个人信息</legend>
</fieldset>
<form class="layui-form" id="addform" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">学号</label>
        <div class="layui-input-block">
            <input type="text" name="studentId" value="${(member.studentId)!}" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="accountName" value="${(member.accountName)!}" autocomplete="off" class="layui-input" disabled>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="tel" name="mobile" value="${(member.mobile)!}" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">所属学院</label>
            <div class="layui-input-inline">
                <input type="tel" name="school" value="${(member.school)!}" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">所属分团</label>
            <div class="layui-input-inline">
                <input type="tel" name="subgroup" value="${(member.subgroup)!}" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">指导老师</label>
            <div class="layui-input-block">
                <input type="text" name="teacher" value="${(member.teacher)!}" autocomplete="off" class="layui-input" disabled>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="0" title="男">
            <input type="radio" name="sex" value="1" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">在团时间</label>
            <label class="layui-form-label">${(member.inGroupTime)!}学期</label>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" value="${(member.remark)!}" class="layui-textarea" disabled></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn"  lay-filter="demo1" id="add">
                <a  href="/generalupdate" target="admin-list">编辑个人信息</a>
            </button>
        </div>
    </div>
    <div>
        <input type="hidden" value="${(member.accountType)}" id="getAccountType">
        <input type="hidden" value="${(member.sex)}" id="getSex">
        <input type="hidden" value="${(member.specialtyType)}" id="getSpecialtyType">
        <input type="hidden" value="${(member.id)}" id="getId">
        <input type="hidden" value="${(member.subgroup)}" id="getSubgroup">
        <input type="hidden" value="${(member.school)}" id="getSchool">
    </div>
</form>


<#--    <div class="layui-form-item">-->
<#--        <div class="layui-input-block">-->
<#--            <button class="layui-btn layui-btn-normal" id="btn" >-->
<#--                <a  href="/generalupdate" target="admin-list">编辑个人信息</a>-->
<#--            </button>-->
<#--        </div>-->
<#--    </div>-->


<script>

    layui.use(['element', 'layer','table','form'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        var AccountType = $('#getAccountType').val()
        var Sex = $('#getSex').val()
        var SpecialtyType = $('#getSpecialtyType').val()
        var id = $('#getId').val()


        function openUpdateMember(id) {
            //iframe层
            //弹出层标题
            var title = "<h2>编辑个人信息</h2>"
            var url = "/generalupdate/" + id
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

        $("#btn").click(function (){
            var id = $('#getId').val();
            openUpdateMember(id);
        })

        //单选框动态赋值
        $('[name=accountType]').each(function (i, item) {
            if ($(item).val() == AccountType) {
                //更改选中值
                $(item).prop('checked', true);
                //重新渲染
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            }
        });

        $('[name=sex]').each(function (i, item) {
            if ($(item).val() == Sex) {
                //更改选中值
                $(item).prop('checked', true);
                //重新渲染
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            }
        });

        $('[name=specialtyType]').each(function (i, item) {
            if ($(item).val() == SpecialtyType) {
                //更改选中值
                $(item).prop('checked', true);
                //重新渲染
                layui.use('form', function () {
                    var form = layui.form;
                    form.render();
                });
            }
        });

        form.render
        //日期
        laydate.render({
            elem: '#joinTime'
            , trigger: 'click'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

    });
</script>
</body>
</html>