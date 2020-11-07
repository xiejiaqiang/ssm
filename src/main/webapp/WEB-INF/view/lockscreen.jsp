<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/4
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>上海佳一后台管理系统 - 登录超时</title>
    <meta name="keywords" content="keywordsxxxxxxxxxxxxxxx">
    <meta name="description" content="descriptionxxxxxxxxxxxxxxx">
    <%@ include file="/WEB-INF/common.jsp"%>
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

<div class="lock-word animated fadeInDown">
</div>
<div class="middle-box text-center lockscreen animated fadeInDown">
    <div>
        <div class="m-b-md">
            <img alt="image" class="img-circle circle-border" src="${path }/resources/img/未标题-1.png">
        </div>
        <h3 id = "usernameText"></h3>
        <p>您需要再次输入密码</p>
        <form class="m-t" role="form" action="">
            <div class="form-group">
                <input type="hidden" class="form-control" id = "usernameForm" name="username" hidden value="" required="">
                <input type="password" class="form-control" id = "password" name="password" placeholder="******" required="">
            </div>
            <button type="submit" id="submitBtn" class="btn btn-primary block full-width">登录到佳一后台管理系统</button>
        </form>
    </div>
    <form    class="m-t hide"   id="yhdenglu"  method="post"  autocomplete="off" onsubmit="return doSave()"  >
        <div class="form-group">
            <input type="text" class="form-control"  id="username" name="username" autofocus="autofocus"  placeholder="用户名" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control"   id="password" name="password"  autofocus="autofocus"  placeholder="密码" required="required">
        </div>
        <div class="alert alert-danger alert-dismissable" id = "errorClue" >
            <button aria-hidden="true" class="close" type="button" id = "errorClueButton">×</button>
            <font></font>
        </div>
        <button type="submit" id = "login_v2" class="btn btn-primary block full-width m-b">登 录</button>

        <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>| <a href="login.jsp">使用管理员登录</a>
        </p>

    </form>
</div>
<script type="text/javascript">
$(function(){
var url=window.location.search;
    if(url.indexOf("?")!=-1){
        result = url.substr(url.indexOf("=")+1);
        $("#usernameForm").val(result);
        $("#usernameText").text(result);
    }
    $("#submitBtn").click(function(){
        var params = {
            "username" : $("#usernameForm").val(),
            "password" : $("#password").val()
        };
        $("#yhdenglu #username").val($("#usernameForm").val()),
         $("#yhdenglu #password").val($("#password").val())
        if($("#username").val()!=""&&$("#password").val()!=""){
            callAjax(
                "userLogin.htm",
                params,
                null,
                function(resp) {
                    if (resp.data) {
                        var form2 = document.getElementById("yhdenglu");
                        form2.action="main.htm" ;
                        form2.submit();
                    } else {
                        $("#errorClue font").text(resp.message);
                        $("#errorClue").removeClass("hide");
                    }
                });
            return false
        }

    });
    //点击提交
    function doSave() {
        var params = {
            "username" : $("#yhdenglu #username").val(),
            "password" : $("#yhdenglu #password").val()
        };
        if($("#yhdenglu #username").val()!=""&&$("#yhdenglu #password").val()!=""){
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
                        layerAlert(resp.message, 2)
                    }
                });
            return false
        }

    };
})
</script>

</body>

</html>