<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>编辑成员信息</title>
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
        <div class="layui-input-block">
            <input type="text" name="studentId" value="${(dto.studentId)!}" lay-verify="required" lay-reqtext="学号是必填项，不能为空！" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" value="${(dto.password)!}" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">学生类型</label>
        <div class="layui-input-block">
            <input type="radio" name="accountType" value="0" title="团长" >
            <input type="radio" name="accountType" value="1" title="副团长">
            <input type="radio" name="accountType" value="2" title="团员" >
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="accountName" value="${(dto.accountName)!}" lay-verify="required" lay-reqtext="姓名是必填项，不能为空！" placeholder="请输入" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="tel" name="mobile" value="${(dto.mobile)!}" lay-verify="required|phone" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">所属学院</label>
            <div class="layui-input-inline">
                <select name="school" lay-verify="required" lay-search="">
                    <option value="${(dto.school)!}">${(dto.school)!}</option>
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
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">所属分团</label>
            <div class="layui-input-inline">
                <select name="subgroup"  lay-verify="required" lay-search="">
                    <option value="${(dto.subgroup)!}">${(dto.subgroup)!}</option>
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
        <div class="layui-inline">
            <label class="layui-form-label">指导老师</label>
            <div class="layui-input-block">
                <input type="text" name="teacher" value="${(dto.teacher)!}" placeholder="请输入" autocomplete="off" class="layui-input">
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
        <label class="layui-form-label">特长生</label>
        <div class="layui-input-block">
            <input type="radio" name="specialtyType" value="1" title="是">
            <input type="radio" name="specialtyType" value="0" title="否">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">入团时间</label>
            <div class="layui-input-inline">
                <input type="text" name="joinTime" value="${(dto.joinTime)!}" id="joinTime" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">在团学期数</label>
            <div class="layui-input-inline">
                <input type="text" name="inGroupTime" value="${(dto.inGroupTime)!}" lay-verify="required|number" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block">
            <textarea name="remark" value="${(dto.remark)!}" placeholder="请输入内容" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1" id="add">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    <div>
        <input type="hidden" value="${(dto.accountType)}" id="getAccountType">
        <input type="hidden" value="${(dto.sex)}" id="getSex">
        <input type="hidden" value="${(dto.specialtyType)}" id="getSpecialtyType">
        <input type="hidden" value="${(dto.id)}" id="getId">
        <input type="hidden" value="${(dto.subgroup)}" id="getSubgroup">
        <input type="hidden" value="${(dto.school)}" id="getSchool">
    </div>
</form>

<script>

    layui.use(['form', 'layedit', 'laydate'], function() {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate;

        var AccountType = $('#getAccountType').val()
        var Sex = $('#getSex').val()
        var SpecialtyType = $('#getSpecialtyType').val()
        var id = $('#getId').val()

        //下拉框动态赋值
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

        //自定义验证规则
        form.verify({
            title: function (value) {
                if (value.length < 5) {
                    return '标题至少得5个字符啊';
                }
            }
            , pass: [
                /^[\S]{6,12}$/
                , '密码必须6到12位，且不能出现空格'
            ]
            , content: function (value) {
                layedit.sync(editIndex);
            }
        })

        /**
         * 监听表单的submit事件
         * form.on('submit(按钮元素的lay-filter属性值)',function (data){    })
         */
        form.on('submit(demo1)', function (data) {
            var index = layer.msg("数据提交中，请稍候...", {
                icon: 16,   //图标
                time: false,  //不关闭
                shade: 0.8  //设置遮罩的透明度
            });

            //发送ajax请求
            var url = "/member/update/"+id ;   //更新操作
            $.get(url, data.field, function (result) {
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
                    parent.location.reload()
                } else {
                    //失败
                    layer.msg(result.msg, {icon: 5})
                }
            });


            //组织表单提交
            return false;
        })
    });
</script>
</body>
</html>