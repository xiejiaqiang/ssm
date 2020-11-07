$(function () {
    mdseSalseListURL = 'mdseSalseList.htm' ;//查询
    reserveMdseSalseURL = 'reserveMdseSalse.htm' ;//修改
    deleteMdseSalseURL = 'deleteMdseSalse.htm' ;//删除
    findMdseNoURL = 'findMdseNo.htm' ;//
    init();
    $("#btn_search").bind("click",function(){
        //先销毁表格
        $('#table_mdseSalse').bootstrapTable('destroy');
        init();
    });


    var validator = $("#form_mdseSalse").validate({
        submitHandler: function(form){
            var mdseNo = $("#form_mdseSalse #mdseNo").val();
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
                                    $('#modal_mdseSalse_edit').modal('hide');
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
    $("#submit_form_mdse_salse_btn").click(function(){
        $("#form_mdseSalse").attr("action",reserveMdseSalseURL);
        $("#form_mdseSalse").submit();
    });
});

var init = function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
};

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#table_mdseSalse').bootstrapTable({
            url: mdseSalseListURL,         //请求后台的URL（*）
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
                    field: 'platformId',
                    title: '销售平台ID',
                    sortable:true
                },
                {
                    field: 'mdseNo',
                    title: '商品编号',
                    sortable:true
                },
                {
                    field: 'salesChannel',
                    title: '销售渠道',
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
                },
                {
                    field: 'dailyPrice',
                    title: '日常售价',
                    sortable:false
                },
                {
                    field: 'activityPrice',
                    title: '活动价',
                    sortable:true
                },
                {
                    field: 'promotionPrice',
                    title: '大销价',
                    sortable:true
                },
                {
                    field: 'preferentialAmount',
                    title: '优惠金额',
                    sortable:true
                },
                {
                    field: 'preferentialType',
                    title: '优惠方式',
                    sortable:true,
                    formatter:function(value,row,index){
                        if(value == '0'){
                            return '优惠券';
                        }else if(value == '1'){
                            return '满减';
                        }else if(value == '2'){
                            return '预售立减';
                        }else if(value == '3'){
                            return '限时秒杀';
                        }
                        return value;
                    }
                },
                {
                    field: 'salesSku',
                    title: '配额',
                    sortable:true
                },
                {
                    field: 'salesStatus',
                    title: '销售状态',
                    sortable:true,
                    formatter:function(value,row,index){
                        if(value == '0'){
                            return '待上架';
                        }else if(value == '1'){
                            return '已上架';
                        }else if(value == '2'){
                            return '已售罄';
                        }else if(value == '3'){
                            return '已下架';
                        }
                        return value;
                    }
                },
                {
                    field: 'mdseUrl',
                    title: '商品链接',
                    sortable:true,
                    formatter:function(value,row,index){
                        return "<a href='javascript:viewMdseSalseUrl(\""+value+"\")'>查看</a>";
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
            mdseNo: $("#txt_mdseNo").val(),
            salesChannel: $("#txt_search_salesChannel").val(),
            platformId: $("#txt_search_platformId").val(),
            salesStatus: $("#txt_search_salesStatus").val(),
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
        $("#btn_add").click(function () {
            $("#form_mdseSalse").resetForm();
            $('#modal_mdseSalse_edit').modal({backdrop: 'static', keyboard: false});
            $('#modal_mdseSalse_edit').modal('show');
        });

        $("#btn_edit").click(function () {
            var getSelections = $('#table_mdseSalse').bootstrapTable('getSelections');
            if (getSelections && getSelections.length == 1) {
                initEditOrderInfo(getSelections[0]);
                $('#modal_mdseSalse_edit').modal({backdrop: 'static', keyboard: false});
                $('#modal_mdseSalse_edit').modal('show');
            } else {
                parent.layer.msg('请选择一条数据');
            }

        });

        $("#btn_delete").click(function () {
            var getSelections = $('#table_mdseSalse').bootstrapTable('getSelections');
            if (getSelections && getSelections.length > 0) {
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
            } else {
                parent.layer.msg('请选择数据');
            }
        });
    };
        return oInit;
    };
function viewMdseSalseUrl(value){
    window.open("http://"+value);
}

    function initEditOrderInfo(getSelection) {
        $('#id').val(getSelection.id);
        $('#platformId').val(getSelection.platformId);
        $('#mdseNo').val(getSelection.mdseNo);
        $('#salesChannel').val(getSelection.salesChannel);
        $('#dailyPrice').val(getSelection.dailyPrice);
        $('#activityPrice').val(getSelection.activityPrice);
        $('#promotionPrice').val(getSelection.promotionPrice);
        $('#preferentialAmount').val(getSelection.preferentialAmount);
        $('#preferentialType').val(getSelection.preferentialType);
        $('#salesSku').val(getSelection.salesSku);
        $('#salesStatus').val(getSelection.salesStatus);
        $('#mdseUrl').val(getSelection.mdseUrl);
    }

    function delUser() {
        var getSelections = $('#table_mdseSalse').bootstrapTable('getSelections');
        var idArr = new Array();
        var ids;
        getSelections.forEach(function (item) {
            idArr.push(item.id);
        });
        ids = idArr.join(",");
        $.ajax({
            url: deleteMdseSalseURL,
            dataType: "json",
            data: {"ids": ids},
            type: "post",
            success: function (res) {
                if (res.success) {
                    swal("删除成功！", "您已经永久删除了这些信息。", "success");
                    $("#btn_search").click();
                } else {
                    swal("删除失败！", res.errorMsg, "error");
                }
            }
        });
    };

