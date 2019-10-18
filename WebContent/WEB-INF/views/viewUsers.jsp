<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="common/taglibs.jsp"%>
<script src="<c:url value="/js/viewusers.js"/>"></script>

<link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>" />


<!-- Page heading-->
<div class="page-header">
	<div class="container-fluid" style="margin-top: 75px;"></div>
</div>

<!--show users-->
<div class="col-md-12">
	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="pull-right" style="margin-top: 1%">
				<a href="${pageContext.request.contextPath}/coffee/userProfileNew" data-toggle="tooltip" class="btn btn-primary btn-flat" data-original-title="Add New User"><i class="fa fa-plus"></i>
				</a>
				<button data-toggle="tooltip" class="btn btn-default btn-flat" value="Reload Page" onClick="document.location.reload(true)" data-original-title="Refresh">
					<i class="fa fa-refresh"></i>
				</button>
			</div>
			<h1>
				<i class="fa fa-users"></i> Users 
				
				<c:choose>
					<c:when test="${configStatus eq 1}">
						<a href=# data-href="${pageContext.request.contextPath}/coffee/maintenanceOff" data-toggle="modal" data-target="#confirm">
							<button data-toggle="tooltip" class="btn btn-success btn-flat" value="Reload Page" data-original-title="Refresh">
								<i class="fa fa-refresh"></i> Maintenance
							</button>
						</a>
					</c:when>
					<c:otherwise>
						<a href=# data-href="${pageContext.request.contextPath}/coffee/maintenanceOn" data-toggle="modal" data-target="#confirm">
							<button data-toggle="tooltip" class="btn btn-danger btn-flat" value="Reload Page" data-original-title="Refresh">
								<i class="fa fa-refresh"></i> Maintenance
							</button>
						</a>
						<a href=# data-href="${pageContext.request.contextPath}/coffee/cupTest" data-toggle="modal" data-target="#confirm"><button data-toggle="tooltip" class="btn btn-default btn-danger btn-flat" value="Reload Page" data-original-title="Refresh">
								<i class="fa fa-refresh"></i> Cup Test
							</button>
						</a> 
						<a href=# data-href="${pageContext.request.contextPath}/coffee/clean" data-toggle="modal" data-target="#confirm">
							<button data-toggle="tooltip" class="btn btn-danger btn-flat" value="Reload Page" data-original-title="Refresh">
								<i class="fa fa-refresh"></i> Clean
							</button>
						</a>
					</c:otherwise>
				</c:choose>
			</h1>
		</div>
		<div class="panel-body">
			<!-- users list-->
			<table class="table table-hover table-striped table-responsive" style="margin-top: 1px;">
				<thead>
					<tr>
						<th>No.</th>
						<th>Username</th>
						<th>Email</th>
						<th class="td-right">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${!empty users}">
							<c:forEach items="${users}" var="obj" varStatus="index">
								<tr class="">
									<td><c:out value="${index.count}" /></td>
									<td>${obj.username}</td>
									<td>${obj.emailDesc}</td>
									<td>
										<div class="input-group">
											<div class="input-group-btn">
												<button type="button" class="btn btn-primary btn-flat dropdown-toggle" data-toggle="dropdown">
													<span class="fa fa-gear"> <i class="filesIcon fa fa-caret-down icon"></i></span>
												</button>
												<ul class="dropdown-menu">
													<li><a href="${pageContext.request.contextPath}/coffee/userProfile?id=${obj.id}"><i class="filesIcon fa fa-edit icon"></i> Edit</a></li>
													<li><a href="#" data-href="${pageContext.request.contextPath}/coffee/deleteUser?id=${obj.id}" data-toggle="modal" data-target="#confirm"><i class="filesIcon fa fa-eye icon"></i> Delete</a></li>
												</ul>
											</div>
											<!-- /btn-group -->
										</div>
									</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div class="panel-footer">
			<a href=# data-href="${pageContext.request.contextPath}/coffee/xlsx" data-toggle="modal" data-target="#confirm">
				<button data-toggle="tooltip" class="btn btn-success btn-flat" value="Reload Page" data-original-title="Refresh">
					<i class="fa fa-file-excel-o"></i> Export Excel
				</button>
			</a>
		</div>
	</div>
</div>

<!-- confirm modal-->
<div class="modal fade" id="confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Confirm Message</h4>
			</div>
			<div id="modal-confirm-message" class="modal-body reminder-modal">
				Click "confirm" to confirm
			</div>
			<div class="modal-footer" align="right">
				<button type="button" class="btn btn-default confirm-no" data-dismiss="modal" style="width: 20%;">Close</button>
				<a class="btn btn-primary btn-ok" style="width: 20%;">Confirm</a>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<c:if test="${excel eq true}">
	<script>
		alert("Excel generated at C:/New Folder");
	</script>
</c:if>

