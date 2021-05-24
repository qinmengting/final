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
<div id="main" style="width: 1100px;height:550px;align-content: center"></div>
<script type="text/javascript">
    $.ajax({
        url:"/sectorVO",
        method:"POST",
        success:function (data) {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '分团成员人数玫瑰图',
                    left:'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend: {
                    left: 'center',
                    top: 'bottom',
                    data: function (data){
                        for (i = 0; i < data.length ;i++){
                            return data.get(i).value
                        }
                    }
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                series: [
                    {
                        name: '面积模式',
                        type: 'pie',
                        radius: [50, 250],
                        center: ['50%', '50%'],
                        roseType: 'area',
                        itemStyle: {
                            borderRadius: 8
                        },
                        data: data
                    }
                ]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    })

</script>
</body>
</html>