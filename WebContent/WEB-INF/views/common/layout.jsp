<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="taglibs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">


	<title><tiles:insertAttribute name="title" /></title>
        
    <script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrapValidator.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap-datetimepicker.min.js"/>"></script>
	<script src="<c:url value="/js/common.js"/>"></script>

	<!-- plugins -->
	<!-- <script src="<c:url value="/js/plugins/Chart.min.js"/>"></script>
	<script src="<c:url value="/js/plugins/jquery.dataTables.min.js"/>"></script>
	<script src="<c:url value="/js/plugins/dataTables.bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/plugins/morris.min.js"/>"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	 -->
	
	<!-- <link rel="stylesheet" href="../css/plugins/AdminLTE.min.css" /> -->
	<link rel="stylesheet" href="<c:url value="/css/bootstrap/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/font-awesome.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap-datetimepicker.min.css"/>" />
	<link rel="stylesheet" href="<c:url value="/css/bootstrapValidator.min.css"/>" />
	
	<!-- plugins -->
	<!-- <link rel="stylesheet" href="<c:url value="/css/plugins/dataTables.bootstrap.css"/>" />
	<link rel="stylesheet" href="<c:url value="/css/plugins/jquery.dataTables.min.css"/>" />
	<link rel="stylesheet" href="<c:url value="/css/plugins/morris.css"/>" /> -->

	<link rel="shortcut icon" href="<c:url value="/image/coffeemask2.png"/>" />

	</head>
	<body class="hold-transition skin-red-light sidebar-mini fixed">
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-main">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="${pageContext.request.contextPath}/coffee/dashboard"><i class="fa fa-coffee" aria-hidden="true"></i>${userSessionObj.role}${userSessionObj.id}</a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse-main">
					<ul class="nav navbar-nav navbar-right">
						<li><a class="active" href="${pageContext.request.contextPath}/coffee/dashboard"><i class="fa fa-home"></i> Home</a></li>
						<li><a href="${pageContext.request.contextPath}/coffee/aboutUs"><i class="fa fa-info-circle"></i> About</a></li>	
						<c:choose>
							<c:when test="${userSessionObj.role == 'admin'}">
								<li><a href="${pageContext.request.contextPath}/coffee/viewUsers"><i class="fa fa-gear"></i> System Configuration</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/coffee/myProfile?id=${userSessionObj.id}"><i class="fa fa-gear"></i> My Profile</a></li>
							</c:otherwise>
						</c:choose>
						<li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> LOGOUT</a></li>
					</ul>
				</div>
			</div>
		</nav>
	
		<div id="notif-template" class="hide">
			<div class="alert new alert-default fade in alert-dismissible" role="alert">
				<span class="notif-message desc-message font-weight-bold">This is alert message</span><br/>
				<span class="notif-message info-message">This is alert message</span>
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div> 
	
		<div id="notif-alert" class="row ml-auto pull-right" style="right: 15px !important;">
			<div class="alert-group"></div>
		</div>
		
		<div class="wrapper background-body">
			<tiles:insertAttribute name="body" />
		</div>
	</body>
</html>