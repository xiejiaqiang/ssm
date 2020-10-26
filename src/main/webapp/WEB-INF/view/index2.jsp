<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>上海佳一后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>
</head>

<body class="gray-bg">
    <div class="row  border-bottom white-bg dashboard-header">
        <div class="col-sm-12">
            <blockquote class="text-warning" style="font-size:14px">
                <h4 class="text-danger">下一版本优化通知</h4>1.用户注册用户名需要重复性校验
                <br>2.主页密码修改表单显示问题
                <br>3.日志详情用弹框显示
                <br>4.主页排版UI订制
                <br>…………
            </blockquote>

            <hr>
        </div>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-sm-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>二次开发</h5>
                        </div>
                        <div class="ibox-content">
                            <p>这是是利用众多框架及前台插件开发的上海佳一后台管理系统。</p>
                            <p>使用时请注意如下声明：</p>
                            <ol>
                                <li>本系统仅供学习和交流使用，禁止用于商业用途！</li>
                                <li>本系统集成erp、监控管理、权限认证、上传下载、博客、定时器等大部分功能</li>
                                <li>您可以在git上参与本项目的开发 https://github.com/xiejiaqiang/ssm.git</li>
                                <li>Html页面（CSS+XHTML+jQuery）制作</li>
                            </ol>
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>更新日志</h5>
                        </div>
                        <div class="ibox-content no-padding">
                            <div class="panel-body">
                                <div class="panel-group" id="version">
                                    <c:forEach items="${logList}" varStatus="i" var="logs">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v${i.count}" class="collapsed" aria-expanded="false">v${logs.versionsNo}</a><code class="pull-right">${logs.createtime}</code>
                                            </h5>
                                        </div>
                                        <div id="v${i.count}" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
                                            <div class="panel-body">
                                                <ol>
                                                    <c:forEach items="${logs.content}" var="content">
                                                        <li>${content}</li>
                                                    </c:forEach>
                                                </ol>
                                            </div>
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <script>
                    $("#v1").addClass("in");
                    $("#v1").attr("aria-expanded",true)
                    $("#v1").attr("style",null)
                </script>
                <div class="col-sm-4">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>联系信息</h5>

                        </div>
                        <div class="ibox-content">
                            <p><i class="fa fa-send-o"></i> 博客：<a href="" target="_blank">暂无</a>
                            </p>
                            <p><i class="fa fa-qq"></i> QQ：<a href="http://wpa.qq.com/msgrd?v=3&amp;uin=707612722&amp;site=qq&amp;menu=yes" target="_blank">707612722</a>
                            </p>
                            <p><i class="fa fa-weixin"></i> 微信：<a href="javascript:;">mumu_xjq</a>
                            </p>
                            <p><i class="fa fa-credit-card"></i> 支付宝：<a href="javascript:;" class="支付宝信息">13651705010/ *解佳强</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </div>
</body>
</html>
