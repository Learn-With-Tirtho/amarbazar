<%@ page import="com.rktirtho.amarbazar.service.UserService" %>
<%@ page import="com.rktirtho.amarbazar.service.UserServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    UserService userService = new UserServiceImpl();
    boolean isUserLogin = userService.login(email, password);

    if (isUserLogin){
        // here we are keeping login status at the session. bcoz, all of the jsp file call get this data fron this session.
        // Basically out plan is checking that a user is login in the system
        session.setAttribute("loginStatus", "yes");
        response.sendRedirect("user/home");
        System.out.println("Login success");
    }else {
        response.sendRedirect("login?loginStatus=false");
    }

%>

</body>
</html>
