$(function () {
    orderInfoListURL = 'orderInfoList.htm' ;//查询
    reserveOrderInfoURL = 'reserveOrderInfo.htm' ;//修改
    deleteOrderInfoURL = 'deleteOrderInfo.htm' ;//删除
    batchImportURL = 'batchImport.htm' ;//批量导入
    exportURL = 'export.htm' ;//导出
    findMdseNoURL = 'findMdseNo.htm' ;//
    init();
    $("#btn_search").bind("click",function(){
        //先销毁表格
        $('#table_orderInfo').bootstrapTable('destroy');
        init();
    });


    var validator = $("#form_orderInfo").validate({
        submitHandler: function(form){
            var mdseNo = $("#form_orderInfo #mdseNo").val();
            $.ajax({
                url:findMdseNoURL,
                dataType:"json",
                data:{"mdseNo":mdseNo},
                type:"post",
                success:function(res){
                    if(res.success){
                        $(form).ajaxSubmit({
                            dataType:"json",
                            success: function (data) {
                                if(data.success && !data.errorMsg ){
                                    layerAlert("操作成功！",1)
                                    validator.resetForm();
                                    $('#modal_orderInfo_edit').modal('hide');
                                    $("#btn_search").click();
                                }else{
                                    layerAlert(data.errorMsg, 2)
                                }
                            }
                        });
                    }else{
                        layerAlert("根据商品编号未查询到商品信息", 2)
                    }
                }
            });

        }
    });
    $("#submit_form_order_info_btn").click(function(){
        $("#form_orderInfo").attr("action",reserveOrderInfoURL);
        $("#form_orderInfo").submit();
    });
});

var init = function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    //初始化fileinput
    var oFileInput = new FileInput();
    oFileInput.Init("txt_file", batchImportURL);
};

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#table_orderInfo').bootstrapTable({
            url: orderInfoListURL,         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType : "application/x-www-form-urlencoded",
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortName: "id",
            sortOrder: "desc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 75, 100],    //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            },
                {
                    field: 'id',
                    title: 'ID',
                    sortable:true
                },
                {
                    field: 'orderNo',
                    title: '订单编号',
                    sortable:true
                },
                {
                    field: 'mdseNo',
                    title: '商品编号',
                    sortable:true
                },
                {
                    field: 'mdseName',
                    title: '商品名称',
                    sortable:false
                },
                {
                    field: 'custName',
                    title: '客户姓名',
                    sortable:true
                },
                {
                    field: 'numberNo',
                    title: '手机号',
                    sortable:true
                },
                {
                    field: 'address',
                    title: '收货地址',
                    sortable:true
                },
                {
                    field: 'orderAmount',
                    title: '订单金额',
                    sortable:true
                },
                {
                    field: 'actPayAmount',
                    title: '实付金额',
                    sortable:true
                },
                {
                    field: 'discountType',
                    title: '优惠分类',
                    sortable:true,
                    formatter:function(value,row,index){
                        if(value == '1'){
                            return '店铺券';
                        }else if(value == '2'){
                            return '平台券';
                        }else if(value == '3'){
                            return '满减';
                        }else if(value == '4'){
                            return '客服优惠';
                        }
                        return value;
                    }
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
                    field: 'logisticsNo',
                    title: '物流单号',
                    sortable:true
                },
                {
                    field: 'invoiceFlg',
                    title: '开票说明',
                    sortable:true,
                    sortable:true,
                    formatter:function(value,row,index){
                        if(value == '1'){
                            return '已开票';
                        }else if(value == '2'){
                            return '未开票';
                        }else if(value == '3'){
                            return '开票中';
                        }
                        return value;
                    }
                },
                {
                    field: 'invoiceType',
                    title: '开票类型',
                    sortable:true,
                    formatter:function(value,row,index){
                        if(value == '1'){
                            return '普票';
                        }else if(value == '2'){
                            return '专票';
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
                    field: 'orderQuantity',
                    title: '订单数量',
                    sortable:true
                },
                {
                    field: 'purchasePrice',
                    title: '进货价格',
                    sortable:true
                },
                {
                    field: 'purchaseSource',
                    title: '进货来源',
                    sortable:true
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
                }, {
                    field: 'remarks',
                    title: '备注'
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
//初始化fileinput
var FileInput = function () {
    var oFile = new Object();

    //初始化fileinput控件（第一次初始化）
    oFile.Init = function(ctrlName, uploadUrl) {
        var control = $('#' + ctrlName);

        //初始化上传控件的样式
        control.fileinput({
            language: 'zh', //设置语言
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions: ['xls', 'xlsx'],//接收的文件后缀
            showUpload: true, //是否显示上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            //dropZoneEnabled: false,//是否显示拖拽区域
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            maxFileCount: 10, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        });

        //导入文件上传完成之后的事件
        $("#txt_file").on("fileuploaded", function (event, data, previewId, index) {
            $(".fileinput-remove-button").click()
            $("#modal_btn_import").modal("hide");
            var success = data.response.success;
            var dataInfo = data.response.data;
            var errorMsg= data.response.errorMsg;
            if (success == false) {
                layerAlert(errorMsg, 2)
                return;
            }else{
                if(dataInfo == undefined ||dataInfo[0] == undefined){
                    swal({
                        title: "导入成功",
                        text: "文件已全部导入成功",
                        type: "success"
                    });
                }else{
                    swal({
                        title: "文件导入成功",
                        text: data.response.msg,
                        type: "success",
                        showCancelButton: true,
                        confirmButtonColor: "#466cdd",
                        confirmButtonText: "导出失败数据",
                        closeOnConfirm: false
                    }, function () {
                            // 要导出的json数据
                            const jsonData = dataInfo;
                            // 列标题，逗号隔开，每一个逗号就是隔开一个单元格
                            let str = `失败原因,订单编号\n`;
                            // 增加\t为了不让表格显示科学计数法或者其他格式
                            for(let i = 0 ; i < jsonData.length ; i++ ){
                                for(const key in jsonData[i]){
                                    str+=`${jsonData[i][key] + '\t'},`;
                                }
                                str+='\n';
                            }
                            // encodeURIComponent解决中文乱码
                            const uri = 'data:text/csv;charset=utf-8,\ufeff' + encodeURIComponent(str);
                            // 通过创建a标签实现
                            const link = document.createElement("a");
                            link.href = uri;
                            // 对下载的文件命名
                            link.download =  "失败数据列表.csv";
                            link.click();
                    });

                }
                $("#btn_search").click();
            }

            //1.初始化表格
            var oTable = new TableInit();
            oTable.Init(data);
            $("#div_startimport").show();
        });
    }
    return oFile;
};
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
        $("#btn_add").click(function(){
            $("#form_orderInfo").resetForm();
            $('#modal_orderInfo_edit').modal({backdrop: 'static', keyboard: false});
            $('#modal_orderInfo_edit').modal('show');
        });

        $("#btn_edit").click(function(){
            var getSelections = $('#table_orderInfo').bootstrapTable('getSelections');
            if(getSelections && getSelections.length==1){
                initEditOrderInfo(getSelections[0]);
                $('#modal_orderInfo_edit').modal({backdrop: 'static', keyboard: false});
                $('#modal_orderInfo_edit').modal('show');
            }else{
                parent.layer.msg('请选择一条数据');
            }

        });

        $("#btn_delete").click(function(){
            var getSelections = $('#table_orderInfo').bootstrapTable('getSelections');
            if(getSelections && getSelections.length>0){
                    swal({
                            title: "您确定要删除这条信息吗",
                            text: "删除后将无法恢复，请谨慎操作！",
                            type: "warning",
                            showCancelButton: true,
                            confirmButtonColor: "#DD6B55",
                            confirmButtonText: "是的，我要删除！",
                            cancelButtonText: "让我再考虑一下…",
                            closeOnConfirm: false,
                            closeOnCancel: false
                        },
                        function (isConfirm) {
                            if (isConfirm) {
                                delUser();
                            } else {
                                swal("已取消", "您取消了删除操作！", "error");
                            }
                        });
            }else{
                parent.layer.msg('请选择数据');
            }
        });

        $("#btn_export").click(function(){
            var temp = {//这里的键的名字和控制器的变量名必须一致，这边改动，控制器也需要改成一样的
                orderNo: $("#txt_orderNo").val(),
                custName: $("#txt_custName").val(),
                numberNo: $("#txt_numberNo").val(),
                orderStatus: $("#txt_search_orderStatus").val(),
                orderChannel: $("#txt_search_orderChannel").val(),
                start: $("#txt_search_start").val(),
                end: $("#txt_search_end").val(),
            };
            $("#searchFrom").attr("action",exportURL);
            $("#searchFrom").submit();

        });
        $("#btn_import").click(function(){
            var getSelections = $('#table_payOrder').bootstrapTable('getSelections');
            $('#modal_btn_import').modal({backdrop: 'static', keyboard: false});
            $('#modal_btn_import').modal('show');

        });
    };

    return oInit;
};


function initEditOrderInfo(getSelection){
    $('#id').val(getSelection.id);
    $('#orderNo').val(getSelection.orderNo);
    $('#mdseNo').val(getSelection.mdseNo);
    $('#custName').val(getSelection.custName);
    $('#numberNo').val(getSelection.numberNo);
    $('#address').val(getSelection.address);
    $('#orderAmount').val(getSelection.orderAmount);
    $('#actPayAmount').val(getSelection.actPayAmount);
    $('#discountType').val(getSelection.discountType);
    $('#orderStatus').val(getSelection.orderStatus);
    $('#logisticsNo').val(getSelection.logisticsNo);
    $('#invoiceFlg').val(getSelection.invoiceFlg);
    $('#invoiceType').val(getSelection.invoiceType);
    $('#editOrderDate').val(changeDateFormat8(getSelection.orderDate));
    $('#orderQuantity').val(getSelection.orderQuantity);
    $('#purchasePrice').val(getSelection.purchasePrice);
    $('#purchaseSource').val(getSelection.purchaseSource);
    $('#orderChannel').val(getSelection.orderChannel);
    $('#remarks').val(getSelection.remarks);
}

function delUser(){
    var getSelections = $('#table_orderInfo').bootstrapTable('getSelections');
    var idArr = new Array();
    var ids;
    getSelections.forEach(function(item){
        idArr.push(item.id);
    });
    ids = idArr.join(",");
    $.ajax({
        url:deleteOrderInfoURL,
        dataType:"json",
        data:{"ids":ids},
        type:"post",
        success:function(res){
            if(res.success){
                swal("删除成功！", "您已经永久删除了这些信息。", "success");
                $("#btn_search").click();
            }else{
                swal("删除失败！", res.errorMsg, "error");
            }
        }
    });
};

