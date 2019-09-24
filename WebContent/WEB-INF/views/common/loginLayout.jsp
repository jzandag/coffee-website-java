<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="taglibs.jsp" %>

<html>
<head>
    
    <title><tiles:insertAttribute name="title" /></title>

    <script src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/js/common.js"/>"></script>

    <link rel="stylesheet" href="<c:url value="/css/stylepic.css"/>"> 

    <!-- RESPONSIVENESS CSS -->
    <link rel="stylesheet" href="<c:url value="/css/common-main.css"/>" />

    <link rel="shortcut icon" href="<c:url value="/image/coffeemask2.png"/>" /> 
	<style>
		body{
		    margin: 0;
		    padding: 0;
		    background: url(<c:url value="/image/coffee.jpg"/>);
		    background-size: cover;
		    background-position: center;
		    font-family: sans-serif;
		}
	</style>
</head>
    <body>
    	<div class="wrapper background-body">
			<tiles:insertAttribute name="body" />
		</div>
    </body>
</html>
