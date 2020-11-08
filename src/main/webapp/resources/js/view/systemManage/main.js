jQuery(document).ready(function(){
    //提示层
    parent.layer.msg('ssm 1.0-beta1');
    oldpassword.oninput=function(){
        $("#oldpassdev").removeClass("has-error");
        oldpassword.setCustomValidity("");
    };
    oldpassword.oninvalid=function(){
        oldpassword.setCustomValidity("您还没有输入旧密码");
    };
    newpassword.oninput=function(){
        $("[name='newpassdev']").removeClass("has-error");
        newpassword.setCustomValidity("");
    };
    newpassword.oninvalid=function(){
        newpassword.setCustomValidity("您还没有输入新密码");
    };
    newpassword2.oninput=function(){
        $("[name='newpassdev']").removeClass("has-error");
        newpassword2.setCustomValidity("");
    };
    newpassword2.oninvalid=function(){
        newpassword2.setCustomValidity("您还没有确认新密码");
    };

});
var index;
$(function () {
    function search() {
        _this = this;
        // 定义url变量
        var baseURI = "user";
        editPasswordFormURL = baseURI+'/editPassword.htm' ;//修改密码
    };

    search.prototype = {
        // 初始化-------------------------------------------------------------------
        init : function() {
            //_this.eventBind();

        },
        eventBind : function() {
            $("#editPasswordForm").bind("click", function() {
                _this.doSave();
            });

        },

    };
    // 实例化JS-------------------------------
    var search = new search();
    search.init();


    if($("#loginFlag").val().length>0){
        //弹出提示框
        toastr.options = {
            "closeButton": true,
            "debug": false,
            "progressBar": true,
            "positionClass": "toast-bottom-right",
            "showDuration": "400",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut",
            "onclick" : function () {
                layer.open({
                    type: 1,
                    title: '用户登录信息',
                    skin: 'layui-layer-rim',
                    area: ['600px', '400px'],
                    content: $('#userLonginInfoDiv')
                });
            }
        }
        callToastr(
            "你好，欢迎来到佳一后台管理系统！",
            "上次登录时间："+$("#loginTime").val(),
            toastr,
            "info"
        );
        //清除session
        var params = {
            "key" : "loginFlag",
        };
        callAjax(
            "remSession.htm",
            params,
            null,
            function(resp) {
                if (!resp.data) {
                    $("#errorClue font").text(resp.message);
                    $("#errorClue").removeClass("hide");
                }
            });
    }



})
//点击提交
function doSave() {
    var oldpassword = $.trim($("#oldpassword").val());
    var newpassword = $.trim($("#newpassword").val());
    var newpassword2 = $.trim($("#newpassword2").val());
    var params = $('#editPasswordForm').serializeObject();

    if (newpassword == newpassword2) {
        parent.layer.close(index)
        swal({
                title: "您确定要修改密码吗？",
                text: "修改后请牢记您的新密码，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "是的，我要修改！",
                cancelButtonText: "让我再考虑一下…",
                closeOnConfirm: false,
                closeOnCancel: false
            },
            function (isConfirm) {
                if (isConfirm) {
                    callAjax(
                        editPasswordFormURL,
                        params,
                        null,
                        function (resp) {

                            if (resp.data) {
                                swal("密码修改成功！", "请牢记您的新密码。", "success");
                            } else {
                                swal("密码修改失败！", resp.message, "error");
                                swal({
                                    title: "密码修改失败！",
                                    text: resp.message,
                                    type: "error",
                                },function(){
                                    editPassword();
                                    $("#oldpassdev").addClass("has-error");
                                })
                            }
                        });

                } else {
                    swal("已取消", "您取消了修改密码操作！", "error");
                }
            });
        return false;
        /*parent.layer.confirm('您确认要修改密码吗？', {
            btn: ['确认','取消'], //按钮
            //shade: false//不显示遮罩
        }, function(){
            callAjax(
                editPasswordFormURL,
                params,
                null,
                function (resp) {
                    if (resp.data) {
                        parent.layer.msg('密码修改成功！', {icon: 1});
                        $('.layui-layer-setwin a').click();
                    } else {
                        parent.layer.msg(resp.message, {icon: 2});
                    }
                });
        }, function(){
            parent.layer.msg('您已取消修改密码的操作', {shift: 6});
            $('.layui-layer-setwin a').click();
        });*/
        return false;
    }else{
        layer.alert("两次输入密码不一致!", {icon: 2});
        $("[name='newpassdev']").addClass("has-error");
        return false;
    }

}
function editPassword () {
    $("#editPasswordDiv").removeClass("hide");
    //-- shift:0平滑放大(默认)、shift:1从上掉落、shift:2从最底部往上滑、shift:3从左滑入、
    // shift:4从左翻滚、shift:5渐显、shift:6抖动 3.0之后版本用anim
    index = layer.open({
        type: 1,
        shift:3,
        title: '修改密码',
        skin: 'layui-layer-rim',
        area: ['600px', '400px'],
        content: $('#editPasswordDiv')
    });
}
function tipsTest() {

//小tips
    layer.tips('我是一个tips，我只是想提示一些你想知道的东西啊。', '.page-tabs-content', {
        tips: [1, '#3595CC'],
        time: 4000
    });
}

