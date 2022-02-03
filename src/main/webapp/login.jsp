
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= "Login" %></title>

    <%@include file="partials/head.jsp" %>
<%--    <link rel=" stylesheet" href="https://bootswatch.com/5/superhero/bootstrap.min.css">--%>
</head>


<body>
<%@include file="partials/navbar.jsp" %>


<section class="container-fluid">
    <form class="d-flex justify-content-center" action="${pageContext.request.contextPath}/login.jsp" method="POST">
        <fieldset>
            <legend class="">Login</legend>

            <div class="form-group">
                <label for="username" class="form-label mt-4">Username</label>
                <input type="text" class="form-control" id="username"  name="username" placeholder="Enter username">

            </div>
            <div class="form-group">
                <label for="password" class="form-label mt-4">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-success mt-3 " value="Log In">Submit</button>
        </fieldset>
    </form>
</section>

<c:choose>
    <c:when test="${param.username.equals('admin') && param.password.equals('password')}">
        <c:redirect url="/profile.jsp"/>
    </c:when>
</c:choose>





<%@include file="partials/scripts.jsp" %>
<%--<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>--%>
</body>
</html>