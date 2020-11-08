$(function () {
    giftInfoListURL = 'giftInfoList.htm' ;//查询
    reserveGiftInfoURL = 'reserveGiftInfo.htm' ;//修改
    deleteGiftInfoURL = 'deleteGiftInfo.htm' ;//删除
    batchUploadURL= 'batchUpload.htm' ;//图片上传
    init();
    $("#btn_search").bind("click",function(){
        //先销毁表格
        $('#table_giftInfo').bootstrapTable('destroy');
        init();
    });


    var validator = $("#form_giftInfo").validate({
        submitHandler: function(form){
                $(form).ajaxSubmit({
                    dataType: "json",
                    success: function (data) {
                        if (data.success && !data.errorMsg) {
                            layerAlert("操作成功！", 1)
                            validator.resetForm();
                            $('#modal_giftInfo_edit').modal('hide');
                            $("#btn_search").click();
                        } else {
                            layerAlert(data.errorMsg, 2)
                        }
                    }
                });
            }
    });

    $("#submit_form_gift_info_btn").click(function(){
            $("#form_giftInfo").attr("action",reserveGiftInfoURL);
            $("#form_giftInfo").submit();

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
    oFileInput.Init("txt_file", batchUploadURL);
};
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#table_giftInfo').bootstrapTable({
            url: giftInfoListURL,         //请求后台的URL（*）
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
                    field: 'giftNo',
                    title: '礼品编号',
                    sortable:true
                },
                {
                    field: 'giftName',
                    title: '礼品名称',
                    sortable:true
                },
                {
                    field: 'giftAmount',
                    title: '礼品金额',
                    sortable:true
                },
                {
                    field: 'channel',
                    title: '进货渠道',
                    sortable:true
                },
                {
                    field: 'giftLink',
                    title: '礼品链接',
                    sortable:false,
                    formatter:function(value,row,index){
                        return "<a href='javascript:viewGiftUrl(\""+value+"\")'>查看</a>";
                    }
                },
                {
                    field: 'giftImg',
                    title: '礼品图片',
                    sortable:true,
                    formatter:function(value,row,index){
                        return '<a href="javascript:viewGiftImg('+row.id+')">查看</a>';
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
            mdseName: $("#txt_giftName").val(),
            model: $("#txt_giftNo").val(),
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
            dropZoneTitle: '可以将图片拖放到这里 …支持多文件上传',
            uploadExtraData:function(previewId, index){
                var id = $("#upload_id").val();
                return {"upload_id": id};
            },
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions: ['jpg', 'png','jpeg'],//接收的文件后缀
            showUpload: true, //是否显示上传按钮
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            dropZoneEnabled: true,//是否显示拖拽区域
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            maxFileSize: 1024,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            maxFileCount: 10, //表示允许同时上传的最大文件个数
            uploadAsync: false,
            enctype: 'multipart/form-data',
            validateInitialCount:true,
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        });

        //同步上传返回结果处理
        $("#txt_file").on("filebatchuploadsuccess", function (event, data, previewId, index) {
            $(".fileinput-remove-button").click()
            $("#modal_btn_Upload").modal("hide");
            var success = data.response.success;
            var errorMsg = data.response.errorMsg;
            if (success == false) {
                layerAlert(errorMsg, 2)
                return;
            }else{
                swal({
                    title: "上传成功",
                    text: "图片已全部上传成功",
                    type: "success"
                });
                $("#btn_search").click();
            }

            //1.初始化表格
            var oTable = new TableInit();
            oTable.Init(data);
        });
    }
    return oFile;
};
function viewGiftUrl(value){
    window.open("http://"+value);
}
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
        $("#btn_add").click(function(){
            $("#form_giftInfo").resetForm();
            $('#modal_giftInfo_edit').modal({backdrop: 'static', keyboard: false});
            $('#modal_giftInfo_edit').modal('show');
        });

        $("#btn_edit").click(function(){
            var getSelections = $('#table_giftInfo').bootstrapTable('getSelections');
            if(getSelections && getSelections.length==1){
                initEditGiftInfo(getSelections[0]);
                $('#modal_giftInfo_edit').modal({backdrop: 'static', keyboard: false});
                $('#modal_giftInfo_edit').modal('show');
            }else{
                parent.layer.msg('请选择一条数据');
            }

        });

        $("#btn_delete").click(function(){
            var getSelections = $('#table_giftInfo').bootstrapTable('getSelections');
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
        $("#btn_import").click(function(){
            var getSelections = $('#table_giftInfo').bootstrapTable('getSelections');
            if(getSelections && getSelections.length==1){
            $("#upload_id").val(getSelections[0].id);
            $('#modal_btn_Upload').modal({backdrop: 'static', keyboard: false});
            $('#modal_btn_Upload').modal('show');
            }else{
                parent.layer.msg('请选择一数据');
            }
        });
        $('#modal_btn_gift_Img').on('hidden.bs.modal', function () {
            $('#spinner_wave_close').click();
        });
    };

    return oInit;
};


function initEditGiftInfo(getSelection){
    $('#form_giftInfo #id').val(getSelection.id);
    $('#form_giftInfo #giftNo').val(getSelection.giftNo);
    $('#form_giftInfo #giftName').val(getSelection.giftName);
    $('#form_giftInfo #giftLink').val(getSelection.giftLink);
    $('#form_giftInfo #giftAmount').val(getSelection.giftAmount);
    $('#form_giftInfo #channel').val(getSelection.channel);
    $('#form_giftInfo #giftImg').val(getSelection.giftImg);

}
function delUser(){
    var getSelections = $('#table_giftInfo').bootstrapTable('getSelections');
    var idArr = new Array();
    var ids;
    getSelections.forEach(function(item){
        idArr.push(item.id);
    });
    ids = idArr.join(",");
    $.ajax({
        url:deleteGiftInfoURL,
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

function viewGiftImg(value){
    $('#table_giftInfo').bootstrapTable("refresh")
    $('#modal_spinner_wave').modal('show');
    $.ajax({
        url:"viewImg.htm",
        dataType:"json",
        data:{"id":value},
        type:"post",
        success:function(res){
            if(res.success){
                var imgInfo = res.fileInfo;
               var dev='';
               if(imgInfo.length == 0){
                   parent.layer.msg('暂无图片');
                   $('#spinner_wave_close').click();
                   return
               }
                for (var i = 0; i <imgInfo.length ; i++) {
                    if(i==0){
                        dev = dev+"<div class='item active'> <img alt='image' class='img-responsive' src='data:image/png;base64,"+imgInfo[i].filePath+"'> <div class='carousel-caption'> <p>"+imgInfo[i].fileName+"</p> </div> </div>";

                    }else {
                        dev = dev+"<div class='item'> <img alt='image' class='img-responsive' src='data:image/png;base64,"+imgInfo[i].filePath+"'> <div class='carousel-caption'> <p>"+imgInfo[i].fileName+"</p> </div> </div>";

                    }

                }
                $("#imgInfo").html(dev);
                $('#modal_btn_gift_Img').modal({backdrop: 'static', keyboard: false});
                $('#modal_btn_gift_Img').modal('show');
            }else{
                swal("获取图片信息失败！", res.errorMsg, "error");
            }
        }
    });
}

$(function () { $("[data-toggle='popover']").popover(); });



