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
	<script src="<c:url value="/js/dashboard.js"/>"></script>
	<script src="<c:url value="/js/notif.js"/>"></script>
	<style>
		.dropbtn {
		  background-color: #000000;
		  color: white;
		  padding: 16px;
		  font-size: 16px;
		  border: none;
		  cursor: pointer;
		  border-radius: 15px;
		}
		
		.dropbtn:hover, .dropbtn:focus {
		  background-color: #2980B9;
		}
		
		.dropdownn {
		  position: relative;
		  display: inline-block;
		}
		
		.dropdown-content {
		  display: none;
		  position: absolute;
		  background-color: #f1f1f1;
		  min-width: 160px;
		  overflow: auto;
		  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
		  z-index: 1;
		}
		
		.dropdown-content a {
		  color: black;
		  padding: 12px 16px;
		  text-decoration: none;
		  display: block;
		}
		
		.dropdownn a:hover {background-color: #ddd;}
		
		.show {display: block;}
		</style>
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
					<div class="dropdownn">
					  <button onclick="myFunction()" class="dropbtn"><i class="fa fa-bell"></i> <span class="badge badge-light"></span></button>
					  <div id="myDropdown" class="dropdown-content">
					    <a href="#home">Home</a>
					    <a href="#about">About</a>
					    <a href="#contact">Contact</a>
					  </div>
					</div>
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
		<c:if test="${not empty userSessionObj}">
			<p id="idId" class="hide">${userSessionObj.id}</p>
		
		</c:if>
		<script type="text/javascript">
		function myFunction() {
			//document.getElementById("myDropdown").classList.toggle("show");
		}
		window.onclick = function(event) {
			/* 
				var dropdowns = document.getElementsByClassName("dropdown-content");
				var i;
				for (i = 0; i < dropdowns.length; i++) {
					var openDropdown = dropdowns[i];
					if (openDropdown.classList.contains('show')) {
						openDropdown.classList.remove('show');
					}
				}
			}  */
			/* if (!event.target.matches('.dropbtn')) {
				if($('#myDropdown').css('display') == 'block'){
					$('#myDropdown').css('display','none');
				}
			} */
		};
		</script>
	</body>
</html>