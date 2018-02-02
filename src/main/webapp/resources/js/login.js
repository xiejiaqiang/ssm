//----------------------------------
//登录注册界面js
//----------------------------------
// 执行查询检索

jQuery(document).ready(function(){
    $("#errorClue").addClass("hide")
    $("#errorClueButton").click(function () {
        $("#errorClue").addClass("hide")
    })
    username.oninput=function(){
        username.setCustomValidity("");
        $("#errorClue").addClass("hide")
    };
    username.oninvalid=function(){
        username.setCustomValidity("您还没有输入账号");
    };
    password.oninput=function(){
        password.setCustomValidity("");
        $("#errorClue").addClass("hide")
    };
    password.oninvalid=function(){
        password.setCustomValidity("您还没有输入密码");
    };
    if($("#imageCode").val()!=null){
        imageCode.oninput=function(){
            imageCode.setCustomValidity("");
            $("#errorClue").addClass("hide")
        };
        imageCode.oninvalid=function(){
            imageCode.setCustomValidity("您还没有输入验证码");
        };
    }

});
$(function() {
	function search() {
		_this = this;
		// 定义url变量
		var baseURI = "ssm";
		userLoginURL = 'userLogin.htm';// 登录检索
        loginURL = 'login.htm';//管理员登录界面
        mainURL = 'main.htm' ;//主页面
	};

	$("#msg").dialog
	search.prototype = {
		// 初始化-------------------------------------------------------------------
		init : function() {
			//_this.eventBind();
		},
		eventBind : function() {
			$("#login_v2").bind("click", function() {
				_this.doSave();
			}),
            $("#login").bind("click", function() {
                _this.doSave2();
            });

		},

	};
	// 实例化JS-------------------------------
	var search = new search();
	search.init();

});
//点击提交
function doSave() {
    var params = {
        "username" : $("#username").val(),
        "password" : $("#password").val()
    };
    if($("#username").val()!=""&&$("#password").val()!=""){
        callAjax(
            userLoginURL,
            params,
            null,
            function(resp) {
                if (resp.data) {
                    var form2 = document.getElementById("yhdenglu");
                    form2.action=mainURL ;
                    form2.submit();
                } else {
                    $("#errorClue font").text(resp.message);
                    $("#errorClue").removeClass("hide");
                }
            });
        return false
    }

};
function doSave2() {
    if(!$("#auto").is(":checked")){
        $("#auto").val("off")
    }
    var params = {
        "username" : $("#username").val(),
        "password" : $("#password").val(),
        "imageCode" : $("#imageCode").val(),
        "auto" : $("#auto").val()
    };
        callAjax(
            loginURL,
            params,
            null,
            function(resp) {
                if (resp.data) {
                    var form2 = document.getElementById("form1");
                    form2.action=mainURL ;
                    form2.submit();
                } else {
                    $("#errorClue font").text(resp.message);
                    $("#errorClue").removeClass("hide");
                }
            });
        return false


}