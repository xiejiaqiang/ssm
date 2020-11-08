$(function() {
    function search() {
        _this = this;
        // 定义url变量
        var baseURI = "orderInfo/";
        orderInfoListURL = baseURI+'orderInfoList.htm' ;//查询
        findOrderIndexURL = baseURI+'findOrderIndex.htm';// 查询订单
        findOrderGroupMdseNoURL = baseURI+'findOrderGroupMdseNo.htm';// 查询订单 根据商品编号分组
        findMdseRegionByMdseCatURL = 'mdseInfo/findMdseRegionByMdseCat.htm';// 查询商品销售地区信息
    };
    search.prototype = {
        // 初始化-------------------------------------------------------------------
        init : function() {
            //1.初始化Table
            var oTable = new TableInit();
            oTable.Init();
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
            var params = {
               };
            $.ajax({
                url:findMdseRegionByMdseCatURL,
                dataType:"json",
                data:params,
                type:"post",
                success:function(res){
                    var mapData = res.data;
                    var dataStatus= res.dataStatus;
                    $('#world-map').vectorMap({
                        // 此处更改地图
                        map: 'cn_mill',
                        backgroundColor: "transparent",
                        regionsSelectableOne: true,
                        regionsSelectable: true,
                        /*zoomMin: 0.9, // 鼠标缩放时的最小比例
                        zoomMax: 2.4, // 鼠标缩放时的最大比例*/
                        regionStyle: {
                            initial: {
                                fill: '#e4e4e4',// 地图颜色
                                "fill-opacity": 1, // 省份（州）是否隐藏，鼠标滑动时显示; 1：显示，2：隐藏。
                                stroke: 'none',
                                "stroke-width": 0,
                                "stroke-opacity": 0
                            },
                            selected: {
                                fill: '#d6cfd8'
                            },
                        },
                        /* hover: {
                             fill: '#cc0009',  // 鼠标滑动至某省份的高亮颜色。
                             "fill-opacity": 1
                         },*/
                        series: {
                            regions: [{
                                values: mapData,
                                scale: ["#1ab394", "#22d6b1"],
                                normalizeFunction: 'polynomial'
                            }]
                        },
                        //显示各地区名称和活动
                        onRegionLabelShow: function (event, label, code) {
                            $.each(dataStatus, function (i, items) {
                                if (code == items.id) {
                                    label.html(items.name + items.event);
                                }
                            });
                        },
                        //鼠标移动显示文本
                        onRegionTipShow: function (e, el, code) {
                            var flg = false;
                            $.each(dataStatus, function (i, items) {
                                if (code == items.id) {
                                    flg = true;
                                    el.html("<span><b style='font-size:12px;color:yellow;'>{0}</b>{1}</span>".format([items.name, ' '+items.event+'台 点击查看详情']));
                                }
                            });
                            if(flg == false){
                                el.html("<span><b style='font-size:12px;color:yellow;'>{0}</b>{1}</span>".format(['该地区销量为0', ' 点击查看全部数据']));
                            }
                        },
                        //点击有活动的省份区域，打开对应活动列表页面
                        onRegionClick: function(event, code){
                            $.each(dataStatus, function (i, items) {
                               // if ((code == items.id) && (items.event != '')) {
                                    window.open("mdseSales/mdseSalseMap.htm?menuid=28");
                             //   }
                            });
                        },
                        //鼠标移入省份区域，改变鼠标状态
                        onRegionOver: function(event, code){
                            $.each(dataStatus, function (i, items) {
                                if ((code == items.id) && (items.event != '')) {
                                    $('#world-map').css({cursor:'pointer'});

                                }

                            });

                        },
                        //鼠标移出省份区域，改回鼠标状态
                        onRegionOut: function(event, code){
                            $.each(dataStatus, function (i, items) {
                                if ((code == items.id) && (items.event != "")) {
                                    $('#world-map').css({cursor:'auto'});
                                }
                            });
                        }

                    });
                    /* markerStyle: {
                                        initial: {
                                            fill: '#fd8888', // 足迹位置的填充颜色
                                            stroke: '#fff'   // 足迹位置的描边颜色
                                        },
                                        hover: {
                                            fill: '#fd2020', // 鼠标滑动至足迹位置后的填充颜色
                                            stroke: '#fff',  // 鼠标滑动至足迹位置后的描边颜色
                                            "fill-opacity": 0.8
                                        },
                                    },*///显示各地区名称和活动
                }
            });
        }
    };
    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#table_orderInfo').bootstrapTable({
                url: orderInfoListURL,         //请求后台的URL（*）
                method: 'post',
                contentType : "application/x-www-form-urlencoded",
                striped: false,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: false,                     //是否启用排序
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 75, 100],    //可供选择的每页的行数（*）
                search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: false,
                showColumns: false,                  //是否显示所有的列
                showRefresh: false,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: false,                //是否启用点击选中行
                height: 450,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns: [
                    {
                        field: 'mdseNo',
                        title: '商品编号',
                        sortable:true
                    },
                    {
                        field: 'custName',
                        title: '客户姓名',
                        sortable:true
                    },
                    {
                        field: 'orderAmount',
                        title: '订单金额',
                        sortable:true
                    },
                    {
                        field: 'orderStatus',
                        title: '订单状态',
                        sortable:true,
                        formatter:function(value,row,index){
                            if(value == '0'){
                                return '待支付';
                            }else if(value == '1'){
                                return '已付款';
                            }else if(value == '2'){
                                return '已发货';
                            }else if(value == '3'){
                                return '已收货';
                            }else if(value == '4'){
                                return '退款中';
                            }else if(value == '5'){
                                return '已退款';
                            }
                            return value;
                        }
                    },
                    {
                        field: 'orderDate',
                        title: '订单日期',
                        sortable:true,
                        formatter:function(value,row,index){
                            return changeDateFormat8(value);
                        }
                    },
                    {
                        field: 'orderChannel',
                        title: '订单渠道',
                        sortable:true,
                        formatter:function(value,row,index){
                            if(value == '1'){
                                return '天猫';
                            }else if(value == '2'){
                                return '京东';
                            }else if(value == '3'){
                                return '淘宝';
                            }else if(value == '4'){
                                return '拼多多';
                            }
                            return value;
                        }
                    }],
                onClickRow: function (row) {
                }
            });
            $('#table_orderInfo2').bootstrapTable({
                url: findOrderGroupMdseNoURL,         //请求后台的URL（*）
                method: 'post',
                contentType : "application/x-www-form-urlencoded",
                striped: false,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: false,                   //是否显示分页（*）
                sortable: false,                     //是否启用排序
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 75, 100],    //可供选择的每页的行数（*）
                search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: false,
                showColumns: false,                  //是否显示所有的列
                showRefresh: false,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: false,                //是否启用点击选中行
                height: 250,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns: [
                    {
                        field: 'id',
                        title: '序号',
                        sortable:true,
                        formatter: function (value, row, index) {
                            return index + 1;
                        }
                    },
                    {
                        field: 'mdseNo',
                        title: '型号',
                        sortable:true
                    },
                    {
                        field: 'remarks',
                        title: '销售数量',
                        sortable:true
                    },
                    {
                        field: 'orderAmount',
                        title: '销售金额',
                        sortable:true
                    }],
                onClickRow: function (row) {
                }
            });
        };
        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {//这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                orderNo: $("#txt_orderNo").val(),
                custName: $("#txt_custName").val(),
                numberNo: $("#txt_numberNo").val(),
                orderStatus: $("#txt_search_orderStatus").val(),
                orderChannel: $("#txt_search_orderChannel").val(),
                start: $("#txt_search_start").val(),
                end: $("#txt_search_end").val(),
                search:params.search,
                order: params.order,
                ordername: params.sort
            };
            return temp;
        };
        return oTableInit;
    };
    // 实例化JS-------------------------------
    var search = new search();
    search.init();
})
