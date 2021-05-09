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
    <legend>编辑成员信息</legend>
</fieldset>
<form class="layui-form" id="addform" method="get">
    <div class="layui-form-item">
        <label class="layui-form-label">学号</label>
        <h4>${(member.studentId)!}</h4>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">在团职务</label>
        <div class="layui-input-block">
            <input type="radio" name="accountType" value="0" title="团长" >
            <input type="radio" name="accountType" value="1" title="副团长">
            <input type="radio" name="accountType" value="2" title="团员" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <h4>${(member.accountName)!}</h4>
    </div>
    <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <h4>${(member.mobile)!}</h4>
    </div>
    <div class="layui-form-item">
            <label class="layui-form-label">所属学院</label>
            <h4>${(member.school)!}</h4>
    </div>
    <div class="layui-form-item">
            <label class="layui-form-label">所属分团</label>
            <h4>${(member.subgroup)!}</h4>
    </div>
    <div class="layui-form-item">
            <label class="layui-form-label">指导老师</label>
            <h4>${(member.teacher)!}</h4>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="0" title="男">
            <input type="radio" name="sex" value="1" title="女">
        </div>
    </div>
    <div class="layui-form-item">
            <label class="layui-form-label">在团时间</label>
            <h4>${(member.inGroupTime)!}学期</h4>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" id="btn" >
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