$(function() {
    function search() {
        _this = this;
        // 定义url变量
        var baseURI = "orderInfo/";
        findOrderIndexURL = baseURI+'findOrderIndex.htm';// 查询订单
    };
    search.prototype = {
        // 初始化-------------------------------------------------------------------
        init : function() {
            $("#order_info_month").addClass("active");
            _this.eventEasyPieChart(2,3);
            _this.eventMapChart();
            _this.eventBind();
        },
        eventBind : function() {
            $("#order_info_date").bind("click", function() {
                $("#order_info_month").removeClass("active");
                $("#order_info_year").removeClass("active");
                $("#order_info_date").addClass("active");
                _this.eventEasyPieChart(1,1);
            }), $("#order_info_month").bind("click", function() {
                $("#order_info_date").removeClass("active");
                $("#order_info_year").removeClass("active");
                $("#order_info_month").addClass("active");
                _this.eventEasyPieChart(2,3);
            }),
                $("#order_info_year").bind("click", function() {
                    $("#order_info_date").removeClass("active");
                    $("#order_info_month").removeClass("active");
                    $("#order_info_year").addClass("active");
                    _this.eventEasyPieChart(3,30);
                });


        },
        eventEasyPieChart : function(a,b) {
            var params = {
                "queryListType" : a
            };
            $.ajax({
                url:findOrderIndexURL,
                dataType:"json",
                data:params,
                type:"post",
                success:function(res){
                    var orderData = res.data;
                    var maxAmount = res.str4;
                    $('.chart').easyPieChart({
                        barColor: '#f8ac59',
                        //                scaleColor: false,
                        scaleLength: 5,
                        lineWidth: 4,
                        size: 80
                    });

                    $('.chart2').easyPieChart({
                        barColor: '#1c84c6',
                        //                scaleColor: false,
                        scaleLength: 5,
                        lineWidth: 4,
                        size: 80
                    });
                    var dataAmount =[];
                    var dataAmountInfoList =[];
                    for (var i=0;i<orderData.length;i++){
                        var dataAmountInfo = [];
                        dataAmountInfo[0] = orderData[i].orderDate;
                        dataAmountInfo[1] = orderData[i].orderAmount;
                        dataAmountInfoList[i]=  dataAmountInfo;
                    }
                    dataAmount[0] = dataAmountInfoList;

                    var dataOrderSize =[];
                    var dataOrderSizeInfoList =[];
                    for (var i=0;i<orderData.length;i++){
                        var dataOrderSizeInfo = [];
                        dataOrderSizeInfo[0] = orderData[i].orderDate;
                        dataOrderSizeInfo[1] = orderData[i].remarks;
                        dataOrderSizeInfoList[i]=  dataOrderSizeInfo;
                    }
                    dataOrderSize[0] = dataOrderSizeInfoList;

                    var dataset = [
                        {
                            label: "订单金额",
                            data: dataAmount[0],
                            color: "#1ab394",
                            bars: {
                                show: true,
                                align: "center",
                                barWidth: 24 * 60 * 60 * 600,
                                lineWidth: 0
                            }

                        }, {
                            label: "订单数",
                            data: dataOrderSize[0],
                            yaxis: 2,
                            color: "#464f88",
                            lines: {
                                lineWidth: 1,
                                show: true,
                                fill: true,
                                fillColor: {
                                    colors: [{
                                        opacity: 0.2
                                    }, {
                                        opacity: 0.2
                                    }]
                                }
                            },
                            splines: {
                                show: false,
                                tension: 0.6,
                                lineWidth: 1,
                                fill: 0.1
                            },
                        }
                    ];


                    var options = {
                        xaxis: {
                            mode: "time",
                            tickSize: [b, "day"],
                            tickLength: 0,
                            axisLabel: "Date",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Arial',
                            axisLabelPadding: 10,
                            color: "#838383"
                        },
                        yaxes: [{
                            position: "left",
                            max: maxAmount,
                            color: "#838383",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: 'Arial',
                            axisLabelPadding: 3
                        }, {
                            position: "right",
                            clolor: "#838383",
                            axisLabelUseCanvas: true,
                            axisLabelFontSizePixels: 12,
                            axisLabelFontFamily: ' Arial',
                            axisLabelPadding: 67
                        }
                        ],
                        legend: {
                            noColumns: 2,
                            labelBoxBorderColor: "#000000",
                            position: "nw"
                        },
                        grid: {
                            hoverable: false,
                            borderWidth: 0,
                            color: '#838383'
                        }
                    };

                    function gd(year, month, day) {
                        return new Date(year, month - 1, day).getTime();
                    }

                    var previousPoint = null,
                        previousLabel = null;

                    $.plot($("#flot-dashboard-chart"), dataset, options);
                    //填充右侧
                    //最近一月订单
                    var acountOrderSize = res.acountOrderSize;
                    //最近一月订单增长数
                    var orderIncreaseNo = res.orderIncreaseNo;
                    //最近一月订单增长Class
                    var orderIncreaseValue = res.orderIncreaseValue;
                    //最近一月销售额
                    var acountOrderMonth1Amount = res.acountOrderMonth1Amount;
                    //最近一月销售额增长数
                    var orderAmountNo = res.orderAmountNo;
                    //最近一月订销售额Class
                    var orderAmountValue = res.orderAmountValue;
                    $("#order1Value").text(acountOrderSize);
                    $("#order1Text").html(orderIncreaseNo+"% <i class='fa "+orderIncreaseValue+" text-navy' ></i>");
                    $("#amount1Value").text(acountOrderMonth1Amount);
                    $("#amount1Text").html(orderAmountNo+"% <i class='fa "+orderAmountValue+" text-navy' ></i>");
                    $("#marginsId").text(res.countOrder);
                }
            });

        },
        eventMapChart : function() {

            var mapData = {
                "US": 298,
                "SA": 200,
                "DE": 220,
                "FR": 540,
                "CN": 120,
                "AU": 760,
                "BR": 550,
                "IN": 200,
                "GB": 120,
            };

            $('#world-map').vectorMap({
                map: 'world_mill_en',
                backgroundColor: "transparent",
                regionStyle: {
                    initial: {
                        fill: '#e4e4e4',
                        "fill-opacity": 0.9,
                        stroke: 'none',
                        "stroke-width": 0,
                        "stroke-opacity": 0
                    }
                },

                series: {
                    regions: [{
                        values: mapData,
                        scale: ["#1ab394", "#22d6b1"],
                        normalizeFunction: 'polynomial'
                    }]
                },
            });
        }
    };

    // 实例化JS-------------------------------
    var search = new search();
    search.init();
})
