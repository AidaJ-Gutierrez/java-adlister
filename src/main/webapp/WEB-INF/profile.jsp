
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<%--<%--%>
<%--//Jay example:--%>
<%--//    session.setAttribute("isDarkMode", true);--%>
<%--    //session.removeAttribute("isDarkMode");--%>
<%--%>--%>

<%--<c:if test="${isDarkMode}">--%>
<%--    <body style="background-color: black">--%>
<%--</c:if>--%>
<body>
    <jsp:include page="../partials/navbar.jsp" />

<c:if test = "${user}">
    <div>User View</div>
</c:if>
    <div class="container">
<%--        <h1>Viewing your profile.</h1>--%>
<%--    Use this key to redirect unauthorized users that try to visit the /profile page: --%>

        <h1> Welcome to your profile ${user}!</h1>


    </div>

</body>
</html>
