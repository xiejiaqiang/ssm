<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

    <title>用户登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/common.jsp"%>
    <link href="${path }/resources/css/login.css" rel="stylesheet">
    <script type="text/javascript" src="${path }/resources/js/login.js"></script>
    <![endif]-->
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

</head>

<body class="gray-bg" style=" background-repeat:no-repeat ;background-size:100% 100%; background-attachment: fixed;"   background="${path }/resources/img/win1002.jpg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">佳</h1>

        </div>
        <h3>欢迎登录佳一后台管理系统</h3>

        <form    class="m-t"   id="yhdenglu"  method="post"  autocomplete="off" onsubmit="return doSave()"  >
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
</div>


<%--
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
--%>
<!--统计代码，可删除-->

</body>

</html>