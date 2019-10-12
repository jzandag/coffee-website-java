<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="common/taglibs.jsp" %>
 <%@ page isThreadSafe="false"  %>
<div class="login-box">
    <img src="<c:url value="/image/coffeemask2.png"/>" class="avatar">
        <h1>Login Here</h1>
            <form method="post" action="${pageContext.request.contextPath}/login">
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password">

          
            <input type="submit" name="login-submit" value="Login">
            <span id="error"></span> 
            </form>
        
        
        </div>

        
        <script type="text/javascript">
            $(document).ready(function() {
              update_list_main();

              setInterval(function(){
                update_list_main();
              },5000);


            });
        </script>
