<%@ page import="com.rktirtho.amarbazar.model.UserRegistrationRequest" %>
<%@ page import="com.rktirtho.amarbazar.service.UserService" %>
<%@ page import="com.rktirtho.amarbazar.service.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: rktirtho
  Date: ১৮/৬/২২
  Time: ৮:৪৯ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="registrationRequest" class="com.rktirtho.amarbazar.model.UserRegistrationRequest"></jsp:useBean>
<jsp:setProperty property="*" name="registrationRequest"></jsp:setProperty>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    UserService userService = new UserServiceImpl();
    int status = userService.save(registrationRequest);

    if (status==1){
        response.getWriter().print("<h2>Account Created</h2><a href=\"login\">Login</a>");
    }else if (status == -1){
        response.getWriter().print("<h2>User already registered</h2> <a href=\"registration\">Try Again</a>");
    }else {
        response.getWriter().print("<h2>Registration failed</h2> <a href=\"registration\">Try Again</a>");
    }



%>

</body>
</html>
