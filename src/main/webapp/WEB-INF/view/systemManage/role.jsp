<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>角色主页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/WEB-INF/common.jsp"%>
<script src="${path }/resources/js/view/systemManage/role.js"></script>
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
						<label  class="control-label">角色名称</label>
						<input type="test"   placeholder="请输入角色名称" id="txt_search_rolename" class="form-control">
					</div>
				</div>
				<button class="btn btn-primary" id="btn_search" type="button">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
				</button>
				</button>
			</form>
		</div>


        <table id="table_role"></table>
		
	</div>
	
	<!-- 新增和修改对话框 -->
	<div class="modal fade" id="modal_role_edit" role="dialog" aria-labelledby="modal_role_edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<form id="form_role" method="post" action="reserveRole.htm">
						<input type="hidden" name="roleid" id="hidden_txt_roleid" value=""/>
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td>角色名称：</td>
								<td><input type="text" id="rolename" name="rolename"
									class="form-control" aria-required="true" required/></td>
								<td>&nbsp;&nbsp;</td>
							</tr>
							<tr>
								<td valign="middle">备注：</td>
								<td colspan="2"><textarea rows="7" cols="50"
										name="roledescription" id="roledescription"></textarea></td>
							</tr>
						</table>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"  id="submit_form_role_btn">保存</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						</div>
					</form>

				</div>
				
			</div>

		</div>

	</div>
	
	
	<!-- 删除对话框 -->
	<div class="modal fade" id="modal_role_del" role="dialog" aria-labelledby="modal_role_del" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					 <h4 class="modal-title" id="modal_user_role_head"> 刪除  </h4>
				</div>
				<div class="modal-body">
							删除所选记录？
				</div>
				<div class="modal-footer">
				<button type="button" class="btn btn-danger"  id="del_role_btn">刪除</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			</div>
			</div>
		</div>
	</div>


</body>
</html>
