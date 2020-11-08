<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>上海佳一后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>
<link href="${path }/resources/css/style.css" rel="stylesheet">
<!-- toastr Alert -->
<link href="${path }/resources/css/plugins/toastr/toastr.min.css" rel="stylesheet">
<!-- Sweet Alert -->
<link href="${path }/resources/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${path }/resources/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
<link href="${path }/resources/css/animate.css" rel="stylesheet">
<script src="${path }/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${path }/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${path }/resources/js/plugins/layer/layer.min.js"></script>
<script src="${path }/resources/js/hplus.js?v=4.1.0"></script>
<script src="${path }/resources/js/contabs.js"></script>
<script src="${path }/resources/js/plugins/pace/pace.min.js"></script>
<script src="${path }/resources/js/jquery.form.min.js"></script>
<!-- Toastr  -->
<script src="${path }/resources/js/plugins/toastr/toastr.min.js"></script>
<!-- Sweet alert -->
<script src="${path }/resources/js/plugins/sweetalert/sweetalert.min.js"></script>
<!-- 自定义js -->
<script src="${path }/resources/js/content.js?v=1.0.0"></script>
<script src="${path }/resources/js/view/systemManage/main.js"></script>
</head>
<body class="fixed-sidebar full-height-layout gray-bg"
	style="overflow: hidden">
	<div id="wrapper">
		<!--左侧导航开始-->
		<nav class="navbar-default navbar-static-side" role="navigation">
			<div class="nav-close">
				<i class="fa fa-times-circle"></i>
			</div>
			<div class="sidebar-collapse">
				<ul class="nav" id="side-menu">
					<li class="nav-header">
						<div class="dropdown profile-element">
							<span><img alt="image" class="img-circle"
								src="${path }/resources/img/profile_small.jpg" /></span> <a
								data-toggle="dropdown" class="dropdown-toggle" href="#"> <span
								class="clear"> <span class="block m-t-xs"><strong
										class="font-bold">${currentUser.username }</strong></span> <span
									class="text-muted text-xs block">${currentUser.roleName }<b
										class="caret"></b></span>
							</span>
							</a>
							<ul class="dropdown-menu animated fadeInRight m-t-xs">
								<li><a class="J_menuItem" href="form_avatar.html">修改头像</a>
								</li>
								<li><a class="J_menuItem" href="profile.html">个人资料</a></li>
								<li><a class="J_menuItem" href="contacts.html">联系我们</a></li>
								<li><a class="J_menuItem" href="mailbox.html">信箱</a></li>
								<li class="divihder"></li>
								<li><a href="logout.htm">安全退出</a></li>
							</ul>
						</div>
						<div class="logo-element">佳一</div>
					</li>
					<c:forEach items="${menuTree.children }" var="menu">
						<li><a href="${menu.attributes.menuUrl }?menuid=${menu.id}">
						 <i class="${menu.iconCls }"></i> <span class="nav-label">${menu.text }</span>
								<c:if test="${menu.state eq 'isParent'}"><span class="fa arrow"></span></c:if>
							</a> 
							<c:if test="${fn:length(menu.children) gt 0 }">
								<ul class="nav nav-second-level">
									<c:forEach items="${menu.children }" var="menu_c">
										<li><a class="J_menuItem" href="${menu_c.attributes.menuUrl }?menuid=${menu_c.id}">
											<i class="${menu_c.iconCls }"></i><span class="nav-label">${menu_c.text }</span>
											<c:if test="${menu_c.state eq 'isParent'}"><span class="fa arrow"></span></c:if>
											</a>
										<c:if test="${fn:length(menu_c.children) gt 0 }">
											<ul class="nav nav-third-level">
												<c:forEach items="${menu_c.children}" var="menu_c_c">
													<li><a class="J_menuItem" href="${menu_c_c.attributes.menuUrl }?menuid=${menu_c_c.id}">
														<i class="${menu_c_c.iconCls }"></i><span class="nav-label">${menu_c_c.text }</span></a>
													</li>
												</c:forEach>
											</ul>
										</c:if>
										</li>
									</c:forEach>
								</ul>
							</c:if>
						</li>
					</c:forEach>
				</ul>
			</div>
		</nav>
		<!--左侧导航结束-->

		<!--右侧部分开始-->
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="row border-bottom">
				<nav class="navbar navbar-static-top" role="navigation"
					style="margin-bottom: 0">
					<div class="navbar-header">
						<a class="navbar-minimalize minimalize-styl-2 btn btn-primary "
							href="javascript:void(0)"><i class="fa fa-bars"></i> </a>
						<form role="search" class="navbar-form-custom" method="post"
							action="search_results.html">
							<div class="form-group">
								<input type="text" placeholder="请输入您需要查找的内容 …"
									class="form-control" name="top-search" id="top-search">
							</div>
							<!-- 用户是否由登录界面进入判断 -->
							<input type="hidden" class="form-control" value="${loginFlag}"  id="loginFlag">
							<!-- 上次登录时间 -->
							<input type="hidden" class="form-control" value="${loginTime}"  id="loginTime">
						<%--	<input type="hidden" class="form-control" value="${currentUser.username}"  id="userName">--%>

						</form>
					</div>
					<ul class="nav navbar-top-links navbar-right">
						<li class="dropdown"><a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i class="fa fa-envelope"></i>
								<span class="label label-warning">16</span>
						</a>
						</li>
						<li class="dropdown"><a class="dropdown-toggle count-info"
							data-toggle="dropdown" href="#"> <i class="fa fa-bell"></i> <span
								class="label label-primary">8</span>
						</a>
						</li>
						<li class="dropdown hidden-xs"><a
							class="right-sidebar-toggle" aria-expanded="false"> <i
								class="fa fa-tasks"></i> 导航
						</a></li>
					</ul>
				</nav>
			</div>
			<div class="row content-tabs">
				<button class="roll-nav roll-left J_tabLeft">
					<i class="fa fa-backward"></i>
				</button>
				<nav class="page-tabs J_menuTabs">
					<div class="page-tabs-content">
						<a href="javascript:tipsTest();" class="J_menuTab active"
							data-id="index.htm?v=4.0">首页</a>
					</div>
				</nav>
				<button class="roll-nav roll-right J_tabRight">
					<i class="fa fa-forward"></i>
				</button>
				<div class="btn-group roll-nav roll-right">
					<button class="dropdown J_tabClose" data-toggle="dropdown">
						关闭操作<span class="caret"></span>

					</button>
					<ul role="menu" class="dropdown-menu dropdown-menu-right">
						<li class="J_tabShowActive"><a>定位当前选项卡</a></li>
						<li class="divider"></li>
						<li class="J_tabCloseAll"><a>关闭全部选项卡</a></li>
						<li class="J_tabCloseOther"><a>关闭其他选项卡</a></li>
					</ul>
				</div>
				<a href="logout.htm?menuid=4" class="roll-nav roll-right J_tabExit"><i
					class="fa fa fa-sign-out"></i> 退出</a>
			</div>
			<div class="row J_mainContent" id="content-main">
				<!-- -->
				<iframe class="J_iframe" name="iframe0" width="100%" height="100%"
					src="index.htm?v=4.0" frameborder="0" data-id="index.htm?v=4.0"
					seamless></iframe>
			</div>
			<div class="footer">
				<div class="pull-right">
					©2020&nbsp;ShangHaiJiaYi&nbsp;
					<span class="lh">(沪)-经营性-2020-2020</span>
					<a href="http://beian.miit.gov.cn/" target="_blank">
						<span class="lh">沪ICP备2020033046号</span>
					</a>
				</div>
			</div>
		</div>
		<!--右侧部分结束-->
		<!--右侧边栏开始-->
		<div id="right-sidebar">
			<div class="sidebar-container">

				<ul class="nav nav-tabs navs-3">

					<li class="active"><a data-toggle="tab" href="#tab-1"> <i
							class="fa fa-gear"></i> 主题
					</a></li>
					<li class=""><a data-toggle="tab" href="#tab-2"> 通知 </a></li>
					<li><a data-toggle="tab" href="#tab-3"> 项目进度 </a></li>
				</ul>

				<div class="tab-content">
					<div id="tab-1" class="tab-pane active">
						<div class="sidebar-title">
							<h3>
								<i class="fa fa-comments-o"></i> 主题设置
							</h3>
							<small><i class="fa fa-tim"></i>
								你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
						</div>
						<div class="skin-setttings">
							<div class="title">主题设置</div>
							<div class="setings-item">
								<span>收起左侧菜单</span>
								<div class="switch">
									<div class="onoffswitch">
										<input type="checkbox" name="collapsemenu"
											class="onoffswitch-checkbox" id="collapsemenu"> <label
											class="onoffswitch-label" for="collapsemenu"> <span
											class="onoffswitch-inner"></span> <span
											class="onoffswitch-switch"></span>
										</label>
									</div>
								</div>
							</div>
							<div class="setings-item">
								<span>固定顶部</span>

								<div class="switch">
									<div class="onoffswitch">
										<input type="checkbox" name="fixednavbar"
											class="onoffswitch-checkbox" id="fixednavbar"> <label
											class="onoffswitch-label" for="fixednavbar"> <span
											class="onoffswitch-inner"></span> <span
											class="onoffswitch-switch"></span>
										</label>
									</div>
								</div>
							</div>
							<div class="setings-item">
								<span> 固定宽度 </span>

								<div class="switch">
									<div class="onoffswitch">
										<input type="checkbox" name="boxedlayout"
											class="onoffswitch-checkbox" id="boxedlayout"> <label
											class="onoffswitch-label" for="boxedlayout"> <span
											class="onoffswitch-inner"></span> <span
											class="onoffswitch-switch"></span>
										</label>
									</div>
								</div>
							</div>
							<div class="title">皮肤选择</div>
							<div class="setings-item default-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-0">
										默认皮肤 </a>
								</span>
							</div>
							<div class="setings-item blue-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-1">
										蓝色主题 </a>
								</span>
							</div>
							<div class="setings-item yellow-skin nb">
								<span class="skin-name "> <a href="#" class="s-skin-3">
										黄色/紫色主题 </a>
								</span>
							</div>
						</div>
					</div>
					<div id="tab-2" class="tab-pane">
						<div class="sidebar-title">
							<h3> <i class="fa fa-comments-o"></i> 最新通知</h3>
							<small><i class="fa fa-tim"></i> 您当前有3条未读信息</small>
						</div>
						<div>

							<div class="sidebar-message">
								<a href="#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar" src="${path }/resources/img/a1.jpg">

										<div class="m-t-xs">
											<i class="fa fa-star text-warning"></i>
											<i class="fa fa-star text-warning"></i>
										</div>
									</div>
									<div class="media-body">

										听说你代码写的稀巴烂，明天人事部领工资不用来了
										<br>
										<small class="text-muted">今天 4:21</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar" src="${path }/resources/img/a2.jpg">
									</div>
									<div class="media-body">
										其实这就是一个测试消息的文字，听说你们没有见过，那么我帮你弄一下，你觉得如何
										<br>
										<small class="text-muted">昨天 2:45</small>
									</div>
								</a>
							</div>
							<div class="sidebar-message">
								<a href="#">
									<div class="pull-left text-center">
										<img alt="image" class="img-circle message-avatar" src="${path }/resources/img/a3.jpg">

										<div class="m-t-xs">
											<i class="fa fa-star text-warning"></i>
											<i class="fa fa-star text-warning"></i>
											<i class="fa fa-star text-warning"></i>
											<i class="fa fa-star text-warning"></i>
										</div>
									</div>
									<div class="media-body">
										写的好！与您分享
										<br>
										<small class="text-muted">昨天 1:10</small>
									</div>
								</a>
							</div>
						</div>
					</div>
					<div id="tab-3" class="tab-pane">
						<div class="sidebar-title">
							<h3> <i class="fa fa-cube"></i> 最新任务</h3>
							<small><i class="fa fa-tim"></i> 您当前有4个任务，0个已完成</small>
						</div>
						<ul class="sidebar-list">
							<li>
								<a href="#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>市场调研</h4> 按要求接收教材；

									<div class="small">已完成： 22%</div>
									<div class="progress progress-mini">
										<div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
									</div>
									<div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
								</a>
							</li>
							<li>
								<a href="#">
									<span class="label label-primary pull-right">NEW</span>
									<h4>设计阶段</h4>
									<!--<div class="small pull-right m-t-xs">9小时以后</div>-->
									项目进度报告(Project Progress Report)
									<div class="small">已完成： 22%</div>
									<div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
								</a>
							</li>
							<li>
								<a href="#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>可行性报告研究报上级批准 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

									<div class="small">已完成： 80%</div>
									<div class="progress progress-mini">
										<div style="width: 80%;" class="progress-bar"></div>
									</div>
								</a>
							</li>
							<li>
								<a href="#">
									<div class="small pull-right m-t-xs">9小时以后</div>
									<h4>立项阶段</h4> 东风商用车公司 采购综合综合查询分析系统项目进度阶段性报告武汉斯迪克科技有限公司

									<div class="small">已完成： 14%</div>
									<div class="progress progress-mini">
										<div style="width: 14%;" class="progress-bar progress-bar-info"></div>
									</div>
								</a>
							</li>
						</ul>
					</div>

				</div>
			</div>
		</div>

		<!--右侧边栏结束-->
		<div id="editPasswordDiv" class="ibox-content hide" >
			<form class="form-horizontal " id = "editPasswordForm" method="post"  autocomplete="off" onsubmit="return doSave()">
				<div class="form-group" id="oldpassdev" >
					<label class="col-sm-3 control-label">旧密码：</label>

					<div class="col-sm-8">
						<input type="password" placeholder="请输入旧密码" name="oldpassword"  id="oldpassword" required  class="form-control">
					</div>
				</div>
				<div class="form-group" name="newpassdev">
					<label class="col-sm-3 control-label">新密码：</label>

					<div class="col-sm-8">
						<input type="password" name="newpassword" id="newpassword"  placeholder="请输入新密码" class="form-control"required>
					</div>
				</div>
				<div class="form-group"  name="newpassdev">
					<label class="col-sm-3 control-label">确认密码:</label>

					<div class="col-sm-8">
						<input type="password" name="newpassword2" id="newpassword2" placeholder="请再次输入密码" class="form-control" required>
					</div>
				</div>
					<div class="text-center">
						<button data-toggle="modal" class="btn btn-primary" id="editPasswordForm"  type="submit">&nbsp &nbsp 修  改 &nbsp &nbsp</button>
					</div>

			</form>
		</div>

		<div id="userLonginInfoDiv" style="display: none">
			<div class="ibox-content">

				<table class="table table-bordered">
					<thead>
					<tr>
						<th>序号</th>
						<th>登录时间</th>
						<th>登录地点</th>
						<th>IP</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td>1</td>
						<td>2017-11-29 14:31:04</td>
						<td>上海</td>
						<td>127.0.0.1</td>
					</tr>
					<tr>
						<td>2</td>
						<td>2017-11-30 02:39:42</td>
						<td>北京</td>
						<td>192.168.1.1</td>
					</tr>
					<tr>
						<td>3</td>
						<td>2017-12-01 14:21:04</td>
						<td>深圳</td>
						<td>168.1.20.122</td>
					</tr>
					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>

</html>
