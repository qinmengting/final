<!DOCTYPE html>
<html lang="en">
<head>
    <script src="static/js/jquery-3.4.1.min.js"></script>
    <script src="static/layui/layui.js"></script>
    <script src="/static/echarts/echarts.min.js"></script>
    <link rel="stylesheet" href="static/layui/css/layui.css" media="all">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1100px;height:400px;"></div>
<div style="height: 30px;width: 1100px">
    <h2 align="center">分团成员人数柱状图</h2>
</div>
<script type="text/javascript">
    $.ajax({
        url:"/barVO",
        type: "POST",
        success:function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '分团成员人数柱状图'
                },
                tooltip: {},
                legend: {
                    data:['分团']
                },
                xAxis: {
                    data: data.names,
                    axisLabel:{
                        interval:0
                    }
                },
                yAxis: {},
                series: [{
                    name: '人数',
                    type: 'bar',
                    data: data.values
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    })

</script>
</body>
</html>