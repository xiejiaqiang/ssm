<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>管理员登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ include file="/WEB-INF/common.jsp"%>
    <link href="${path }/resources/css/login.css" rel="stylesheet">
    <script type="text/javascript" src="${path }/resources/js/login.js"></script>
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
    </script>

    <script type="text/javascript">
        function loadimage() {
            document.getElementById("randImage").src = "${path }/getRandImage.jsp?t=" + Math.random();
        }

    </script>
    <%
        boolean auto = false;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i=0; i<cookies.length; i++) {
                Cookie cookie = cookies[i];
                if("autoLogin".equals(cookie.getName())){
                    auto = true;
                    break;
                }
            }
        }
        if(auto){
            response.sendRedirect("auto.htm");
        }
    %>
</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>[ -SSM- ]</h1>
                </div>
                <div class="m-b"></div>
                <h4>欢迎使用 <strong>SSM</strong></h4>
                <ul class="m-b">
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势一</li>
                    <p>
                        我最开始也这样，给你个建议哈，别硬背html标签了，知道并理解这个标签怎么用就行。然后把CSS看完并理解。
                    </p>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势二</li>
                    <p>
                        作用Linux系统中grep命令是一种强大的文本搜索工具，它能使用正则表达式搜索文本，并把匹 配的行打印出来。grep全称是Global Regular Expression Print，表示全局正则表达式版本，它的使用权限是所有用户。
                    </p>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势三</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势四</li>
                    <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 优势五</li>
                </ul>
                <strong>我是新管理员？ <a href="#">立即阅读系统说明书&raquo;</a></strong>
            </div>
        </div>
        <div class="col-sm-5">
            <form id="form1" name="form1" method="post"  autocomplete="off" onsubmit="return doSave2()" >
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md">登录到私人订制ssm框架</p>
                <input type="text" class="form-control uname" placeholder="用户名" name="username" id="username"   placeholder="请输入用户名" required="required" value="${userName }"/>
                <input type="password" class="form-control pword m-b" placeholder="密码" id="password" name="password" placeholder="请输入密码"  required="required" value="${password }"/>
                     <!--  onkeydown="if(event.keyCode==13)form1.submit()" -->
                <input type="text" class="form-control ucode" placeholder="验证码"
                       required="required" value="${imageCode }" name="imageCode"
                       id="imageCode"  />
                <div class="alert alert-danger alert-dismissable" id = "errorClue" >
                    <button aria-hidden="true" class="close" type="button" id = "errorClueButton">×</button>
                    <font></font>
                </div>
                <p class="text-muted text-center">
                    <a href="login_v2.jsp"><small>№会员登录</small></a> | <input type="checkbox" name="auto" id="auto" >记住我 | <img onclick="javascript:loadimage();" title="换一张试试" name="randImage" id="randImage" src="${path }/getRandImage.jsp" height="20" border="1">
                </p>
                <button type="submit" class="btn btn-success btn- " id="login">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2017 All Rights Reserved. H+
        </div>
    </div>
</div>
</body>

</html>