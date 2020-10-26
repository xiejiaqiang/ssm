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
            <img alt="image" class="img-circle circle-border" src="${path }/resources/img/a1.jpg">
        </div>
        <h3>Beaut-zihan</h3>
        <p>您需要再次输入密码</p>
        <form class="m-t" role="form" action="main.htm">
            <div class="form-group">
                <input type="password" class="form-control" placeholder="******" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width">登录到佳一后台管理系统</button>
        </form>
    </div>
</div>


</body>

</html>