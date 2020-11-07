$(function () {
    var regionData = new Array();
    //ajax后台取值
    var params = {
        "parentId" : -1
    };
    $.ajax({
        url:"getRegionData.htm",
        dataType:"json",
        data:params,
        type:"post",
        success:function(res){
            var mdseRegionData = res.mdseRegionsList;
            var dataList = mdseRegionData[0].data;
            var maxValue = res.maxValue;
            var countOrderSize = res.countOrderSize;
            var series = res.seriesList;
            for (var i=0;i<mdseRegionData.length;i++){
                regionData[i] = mdseRegionData[i].name;
            }
            var mapChart = echarts.init(document.getElementById("echarts-map-chart"));
            var mapoption = {
                title : {
                    text: '商品总销量',
                    subtext: '累计销量('+countOrderSize+')统计结果可能稍有偏差,请以实际为准',
                    x:'center'
                },
                tooltip : {
                    formatter:function(params,ticket, callback){
                        return params.seriesName+'<br />'+params.name+'：'+params.value
                    }
                },
                legend: {
                    orient: 'vertical',
                    x:'left',
                    data:regionData
                },
                dataRange: {
                    min: 0,
                    max: maxValue,
                    x: 'left',
                    y: 'bottom',
                    text:['高','低'],           // 文本，默认为数值文本
                    calculable : true
                },
                toolbox: {
                    show: true,
                    orient : 'vertical',
                    x: 'right',
                    y: 'center',
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                roamController: {
                    show: true,
                    x: 'right',
                    mapTypeControl: {
                        'china': true
                    }
                },
                series :series
            };
            mapChart.setOption(mapoption);
            $(window).resize(mapChart.resize);

        }
    });
});
function setMdseCat(value){
    var values = value.split("|");
    var regionData = new Array();
    //ajax后台取值
    var params = {
        "parentId" : values[0]
    };
    $.ajax({
        url:"getRegionData.htm",
        dataType:"json",
        data:params,
        type:"post",
        success:function(res){
            var mdseRegionData = res.mdseRegionsList;
            var dataList = mdseRegionData[0].data;
            var maxValue = res.maxValue;
            var series = res.seriesList;
            var countOrderSize = res.countOrderSize;
            for (var i=0;i<mdseRegionData.length;i++){
                regionData[i] = mdseRegionData[i].name;
            }
            var mapChart = echarts.init(document.getElementById("echarts-map-chart"));
            var mapoption = {
                title : {
                        text: values[1]+"全国累计销售图",
                    subtext: '累计销量('+countOrderSize+')统计结果可能稍有偏差,请以实际为准',
                    x:'center'
                },
                tooltip : {
                    formatter:function(params,ticket, callback){
                        return params.seriesName+'<br />'+params.name+'：'+params.value
                    }
                },
                legend: {
                    orient: 'vertical',
                    x:'left',
                    data:regionData
                },
                dataRange: {
                    min: 0,
                    max: maxValue,
                    x: 'left',
                    y: 'bottom',
                    text:['高','低'],           // 文本，默认为数值文本
                    calculable : true
                },
                toolbox: {
                    show: true,
                    orient : 'vertical',
                    x: 'right',
                    y: 'center',
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                roamController: {
                    show: true,
                    x: 'right',
                    mapTypeControl: {
                        'china': true
                    }
                },
                series :series
            };
            mapChart.setOption(mapoption);
            $(window).resize(mapChart.resize);

        }
    });
}
