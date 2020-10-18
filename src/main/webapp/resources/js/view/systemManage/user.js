$(function () {
    queryUserListURL = 'userList.htm' ;//查询
    deleteUserURL = 'deleteUser.htm' ;//删除
    init();
    $("#btn_search").bind("click",function(){
        //先销毁表格
        $('#table_user').bootstrapTable('destroy');
        init();
    });
    var validator = $("#form_user").validate({
        submitHandler: function(form){
            $(form).ajaxSubmit({
                dataType:"json",
                success: function (data) {

                    if(data.success && !data.errorMsg ){
                        layerAlert("操作成功！",1)
                        validator.resetForm();
                        $('#modal_user_edit').modal('hide');
                        $("#btn_search").click();
                    }else{
                        layerAlert(data.errorMsg, 2)
                    }
                }
            });
        }
    });
    $("#submit_form_user_btn").click(function(){
        $("#form_user").submit();
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
        $('#table_user').bootstrapTable({
            url: queryUserListURL,         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType : "application/x-www-form-urlencoded",
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortName: "userid",
            sortOrder: "desc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 75, 100],    //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "userid",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            },
                {
                    field: 'userid',
                    title: '用户编号',
                    sortable:true
                },
                {
                    field: 'username',
                    title: '用户名',
                    sortable:true
                }, {
                    field: 'roleid',
                    title: '角色',
                    sortable:true,
                    formatter:function(value,row,index){
                        return row.role.rolename;
                    }
                }, {
                    field: 'userdescription',
                    title: '描述'
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
            username: $("#txt_search_username").val(),
            roleid: $("#txt_search_roleid").val(),
            usertype: $("#txt_search_usertype").val(),
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
            $('#password').attr("readOnly",false).val(getSelection.password);
            $("#form_user").resetForm();
            document.getElementById("hidden_txt_userid").value='';
            $('#modal_user_edit').modal({backdrop: 'static', keyboard: false});
            $('#modal_user_edit').modal('show');
        });

        $("#btn_edit").click(function(){
            var getSelections = $('#table_user').bootstrapTable('getSelections');
            if(getSelections && getSelections.length==1){
                initEditUser(getSelections[0]);
                $('#modal_user_edit').modal({backdrop: 'static', keyboard: false});
                $('#modal_user_edit').modal('show');
            }else{
                parent.layer.msg('请选择一条数据');
            }

        });

        $("#btn_delete").click(function(){
            var getSelections = $('#table_user').bootstrapTable('getSelections');
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


    };

    return oInit;
};


function initEditUser(getSelection){
    $('#hidden_txt_userid').val(getSelection.userid);
    $('#roleid').val(getSelection.roleid);
    $('#username').val(getSelection.username);
    $('#userdescription').val(getSelection.userdescription);
    $('#password').attr("readOnly",true).val(getSelection.password);
}

function delUser(){
    var getSelections = $('#table_user').bootstrapTable('getSelections');
    var idArr = new Array();
    var ids;
    getSelections.forEach(function(item){
        idArr.push(item.userid);
    });
    ids = idArr.join(",");
    $.ajax({
        url:deleteUserURL,
        dataType:"json",
        data:{"ids":ids},
        type:"post",
        success:function(res){
            if(res.success){
                $('#modal_user_del').modal('hide');
                swal("删除成功！", "您已经永久删除了这些信息。", "success");
                $("#btn_search").click();
            }else{
                layerAlert(res.errorMsg, 2)
            }
        }
    });
};