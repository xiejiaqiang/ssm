<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>用户主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>

<script src="${path }/resources/js/view/systemManage/user.js"></script>
</head>
<body class="gray-bg">
	<div class="panel-body">
		<div id="toolbar" class="btn-group">
			<c:forEach items="${operationList}" var="oper">
				<privilege:operation operationId="${oper.operationid }" id="${oper.operationcode }" name="${oper.operationname }" clazz="${oper.iconcls }"  color="#093F4D"></privilege:operation>
			</c:forEach>
        </div>
		<div class="row">
		<form role="form" class="form-inline">
			<div class="col-sm-3">
			<div class="form-group">
				<label  class="control-label">用户名</label>
				<input type="test" name="username"  placeholder="请输入用户名" id="txt_search_username" class="form-control">
			</div>
			</div>
			<div class="col-sm-2">
			<div class="form-group">
				<label  class="control-label">角色</label>
				<select class="form-control" name="txt_search_roleid" id = "txt_search_roleid">
					<option value="0">---请选择---</option>
					<c:forEach items="${roleList }" var="r">
						<option value="${r.roleid }">${r.rolename }</option>
					</c:forEach>
				</select>
			</div>
			</div>
				<button class="btn btn-primary" id="btn_search" type="button">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
				</button>
			</button>
		</form>
		</div>
        <table id="table_user"></table>

	</div>
	
	<!-- 新增和修改对话框 -->
	<div class="modal fade" id="modal_user_edit" role="dialog" aria-labelledby="modal_user_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="momodal_user_deldal-body">
					<form id="form_user" method="post" action="reserveUser.htm">
						<input type="hidden" name="userid" id="hidden_txt_userid" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>用户名：</td>
								<td><input type="text" id="username" name="username"
									class="form-control" aria-required="true" required/></td>
								<td>&nbsp;&nbsp;</td>
								<td>密码：</td>
								<td><input type="password" id="password" name="password"
									class="form-control" aria-required="true" required/></td>
							</tr>
							<tr>
								<td>角色：</td>
								<td colspan="4">
									<select class="form-control" name="roleid" id = "roleid" aria-required="true" required>
										<option value="">---请选择---</option>
										<c:forEach items="${roleList }" var="r">
										 	<option value="${r.roleid }">${r.rolename }</option>
										</c:forEach>
				                	</select>
								</td>
							</tr>
							<tr>
								<td valign="middle">备注：</td>
								<td colspan="4"><textarea rows="7" cols="50"
										name="userdescription" id="userdescription"></textarea></td>
							</tr>
						</table>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_user_btn">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>

				</div>
				
			</div>

		</div>

	</div>



</body>
</html>