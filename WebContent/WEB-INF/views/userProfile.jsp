<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="common/taglibs.jsp"%>

<!-- <script src="../js/homepage.js"></script> -->
<script src="<c:url value="/js/viewusers.js"/>"></script>

<link rel="stylesheet" href="<c:url value="/css/dashboard.css"/>" />

<style type="text/css">
	.form-control-feedback {
		width: 63px !important;
		line-height: 32px !important;
	}
</style>


<!--Create user form -->
<div class="">
	<form:form method="post" id="submit_form" action="${pageContext.request.contextPath}/coffee/save" commandName="userCommand">
		<div class="page-header" style="margin-top: 75px;">
			<div class="container-fluid"></div>
		</div>
		<div class="">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 align="center">
							<i class="fa fa-user"></i> User Profile
						</h1>
					</div>
					<c:choose>
						<c:when test="${not empty userCommand.id}">
							<form:hidden path="id" />
							
						</c:when>
					</c:choose>
					<div class="panel-body">
					
						<div class="form-group col-md-6 col-lg-6 col-xs-12 col-sm-12">
							<label for="username" class="control-label"><b>Username:</b> </label> 
							<form:input class="form-control" path="username" autocomplete="off" />
						</div>
						
						<div class="clearfix"></div>
						
						<div class="form-group col-md-6 col-lg-6 col-xs-12 col-sm-12">
							<label for="email" class="control-label"><b>Email:</b> </label> 
							<form:input class="form-control" path="email" autocomplete="off" />
						</div>

						<div class="clearfix"></div>
						<!-- for type of user -->
						<div class="form-group col-lg-4 col-md-4 col-sm-12 col-xs-12 dropdown-input">
							<label class="control-label">Role</label>
							<form:select path="role" items="${roleList}" cssClass="form-control" />
						</div>
						
						<div class="clearfix"></div>
						
						<div class="form-group col-md-6 col-lg-6 col-xs-12 col-sm-12">
							<label for="password" class="control-label"><b>Password:</b> </label> 
							<form:password class="form-control" path="password" autocomplete="off" />
						</div>
						<div class="clearfix"></div>

						<button type="submit" name="signup-submit" class="btn btn-primary btn-flat btn-submit col-lg-2 col-xs-12 col-sm-12">SUBMIT</button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>

