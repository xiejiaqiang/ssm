$(function () {
    mdseInfoListURL = 'mdseInfoList.htm' ;//查询
    reserveMdseInfoURL = 'reserveMdseInfo.htm' ;//修改
    deleteMdseInfoURL = 'deleteMdseInfo.htm' ;//删除
    exportURL = 'export.htm' ;//导出
    init();
    $("#btn_search").bind("click",function(){
        //先销毁表格
        $('#table_mdseInfo').bootstrapTable('destroy');
        init();
    });


    var validator = $("#form_mdseInfo").validate({
        submitHandler: function(form){
            $(form).ajaxSubmit({
                dataType:"json",
                success: function (data) {

                    if(data.success && !data.errorMsg ){
                        layerAlert("操作成功！",1)
                        validator.resetForm();
                        $('#modal_mdseInfo_edit').modal('hide');
                        $("#btn_search").click();
                    }else{
                        layerAlert(data.errorMsg, 2)
                    }
                }
            });
        }
    });
    $("#submit_form_mdse_info_btn").click(function(){
        $("#form_mdseInfo").attr("action",reserveMdseInfoURL);
        $("#form_mdseInfo").submit();
    });
});

var init = function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
    $("#costRange").ionRangeSlider({
        min: 0,
        max: 10000,
        from:0,
        to: 10000,
        type: 'double',//设置类型
        step: 1,
        prefix: "¥",//设置数值前缀
        postfix: "元",//设置数值后缀
        prettify: true,
        hasGrid: true,
        grid: true,//滑块上方显示网格
        onChange:function (obj) {
            $("#costRange #start").val(obj.fromNumber);
            $("#costRange #end").val(obj.toNumber);
        }
    });
};

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#table_mdseInfo').bootstrapTable({
            url: mdseInfoListURL,         //请求后台的URL（*）
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
                    hidden : true,
                    sortable:true,
                    visible: false
                },
                {
                    field: 'mdseNo',
                    title: '商品编号',
                    sortable:true
                },
                {
                    field: 'mdseName',
                    title: '商品名称',
                    sortable:true
                },
                {
                    field: 'title',
                    title: '标题',
                    sortable:false
                },
                {
                    field: 'colour',
                    title: '颜色',
                    sortable:true
                },
                {
                    field: 'model',
                    title: '型号',
                    sortable:true
                },
                {
                    field: 'mdseCat',
                    title: '商品分类',
                    sortable:true,
                    formatter:function(value,row,index){
                        var str = JSON.parse($("#view_mdseCat").val());
                        for (var i=0;i<str.length;i++){
                            if(str[i].id==value){
                                return str[i].name;
                                break;
                            }
                        }
                        return value;
                    }
                },
                {
                    field: 'mdseSku',
                    title: '商品库存',
                    sortable:true
                },
                {
                    field: 'mdseStatus',
                    title: '商品状态',
                    sortable:true,
                    formatter:function(value,row,index){
                        if(value == '0'){
                            return '待上市';
                        }else if(value == '1'){
                            return '已上市';
                        }else if(value == '2'){
                            return '已下市';
                        }
                        return value;
                    }
                },
                {
                    field: 'brand',
                    title: '品牌',
                    sortable:true
                },
                {
                    field: 'series',
                    title: '系列',
                    sortable:true
                },
                {
                    field: 'sellingPoint',
                    title: '卖点',
                    sortable:true
                },
                {
                    field: 'parameter1',
                    title: '参数1',
                    sortable:true
                },
                {
                    field: 'parameter2',
                    title: '参数2',
                    sortable:true
                },
                {
                    field: 'createTime',
                    title: '创建时间',
                    sortable:true,
                    visible: false
                },
                {
                    field: 'updateTime',
                    title: '更新时间',
                    sortable:true,
                    visible: false
                }, {
                    field: 'retailPrice',
                    title: '零售指导价',
                    sortable:false
                }, {
                    field: 'buyingPrice',
                    title: '进货价',
                    sortable:false,
                    visible: false
                }, {
                    field: 'floorPrice',
                    title: '底价',
                    sortable:false,
                    visible: false
                }, {
                    field: 'tradePrice',
                    title: '批发价',
                    sortable:false,
                    visible: false
                }, {
                    field: 'profit',
                    title: '利润',
                    sortable:false,
                    visible: false
                }, {
                    field: 'profitMargin',
                    title: '利润率',
                    sortable:false,
                    visible: false
                }, {
                    field: 'priceId',
                    title: '价格表ID',
                    sortable:false,
                    visible: false
                },
                {
                    title: '价格管理',
                    sortable:true,
                    formatter:function(value,row,index){
                            return '<a href="javascript:viewMdsePrice()">查看</a>';
                    }
                },
                {
                    field: 'pictureId',
                    title: '图片管理',
                    sortable:true,
                    formatter:function(value,row,index){
                        return '<a href="javascript:viewMdseImg('+value+')">查看</a>';
                    }
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
            mdseName: $("#txt_mdseName").val(),
            model: $("#txt_model").val(),
            colour: $("#txt_colour").val(),
            mdseStatus: $("#txt_mdseStatus").val(),
            mdseCat: $("#txt_mdseCat").val(),
            start: $("#start").val(),
            end: $("#end").val(),
            search:params.search,
            order: params.order,
            ordername: params.sort
        };
        return temp;
    };
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
        $("#btn_add").click(function(){
            $("#form_mdseInfo").resetForm();
            $('#modal_mdseInfo_edit').modal({backdrop: 'static', keyboard: false});
            $('#modal_mdseInfo_edit').modal('show');
        });

        $("#btn_edit").click(function(){
            var getSelections = $('#table_mdseInfo').bootstrapTable('getSelections');
            if(getSelections && getSelections.length==1){
                initEditmdseInfo(getSelections[0]);
                $('#modal_mdseInfo_edit').modal({backdrop: 'static', keyboard: false});
                $('#modal_mdseInfo_edit').modal('show');
            }else{
                parent.layer.msg('请选择一条数据');
            }

        });

        $("#btn_delete").click(function(){
            var getSelections = $('#table_mdseInfo').bootstrapTable('getSelections');
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


function initEditmdseInfo(getSelection){
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
    var getSelections = $('#table_mdseInfo').bootstrapTable('getSelections');
    var idArr = new Array();
    var ids;
    getSelections.forEach(function(item){
        idArr.push(item.id);
    });
    ids = idArr.join(",");
    $.ajax({
        url:deleteMdseInfoURL,
        dataType:"json",
        data:{"ids":ids},
        type:"post",
        success:function(res){
            if(res.success){
                swal("删除成功！", "您已经永久删除了这些信息。", "success");
                $("#btn_search").click();
            }else{
                layerAlert(res.errorMsg, 2)
            }
        }
    });
};
function setMdseCat(value){
    var values = value.split("|");
    $("#dLabel").text(values[1]);
    $("#txt_mdseCat").val(values[0]);
}
function setMdseeditCat(value){
    var values = value.split("|");
    $("#dLabel_edit").text(values[1]);
    $("#mdseCat").val(values[0]);
}
function viewMdseImg(value){
    $('#modal_btn_mdse_Img').modal({backdrop: 'static', keyboard: false});
    $('#modal_btn_mdse_Img').modal('show');
}
function viewMdsePrice(getSelection){
    var getSelection = $("#table_mdseInfo").bootstrapTable('getSelections')[0];
    $("[name='btSelectItem']").removeAttr("checked")
    $('#modal_mdse_price_edit #id').val(getSelection.priceId);
    $('#modal_mdse_price_edit #mdseNo').val(getSelection.mdseNo);
    $('#modal_mdse_price_edit #buyingPrice').val(getSelection.buyingPrice);
    $('#modal_mdse_price_edit #retailPrice').val(getSelection.retailPrice);
    $('#modal_mdse_price_edit #floorPrice').val(getSelection.floorPrice);
    $('#modal_mdse_price_edit #tradePrice').val(getSelection.tradePrice);
    $('#modal_mdse_price_edit #profit').val(getSelection.profit);
    $('#modal_mdse_price_edit #profitMargin').val(getSelection.profitMargin);
    $('#modal_mdse_price_edit').modal({backdrop: 'static', keyboard: false});
    $('#modal_mdse_price_edit').modal('show');

}
$(function () { $("[data-toggle='popover']").popover(); });



