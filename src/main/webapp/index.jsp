<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= "Welcome" %></title>
</head>
<body>
<%--    <c:if test="true">--%>
<%--        <h1>Variable names should be very descriptive</h1>--%>
<%--    </c:if>--%>
<%--    <c:if test="false">--%>
<%--        <h1>single letter variable names are good</h1>--%>
<%--    </c:if>--%>

    <%! String hello = "Welcome"; %>



<%--<%--%>
<%--    int [] numbers = {1, 2,3, 4, 5};--%>
<%--    int total = 0;--%>
<%--    for (int num : numbers){--%>
<%--        total += num;--%>
<%--    }--%>
<%--    int avg = total / numbers.length;--%>
<%--    %>--%>
<h1>  <%= hello %></h1>


<%--<c: choose>--%>
<%--    <c:when  test="true">--%>
<%--        <h1>Variable names should be very descriptive</h1>--%>
<%--    </c:when>--%>
<%--    <c:if test="false">--%>
<%--        <h1>single letter variable names are good</h1>--%>
<%--    </c:if>--%>
<%--</c:>--%>

</body>
</html>
