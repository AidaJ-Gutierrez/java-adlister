<%--
  Created by IntelliJ IDEA.
  User: aidajimenez
  Date: 2/7/22
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
<jsp:include page="/partials/head.jsp">
  <jsp:param name="title" value="Viewing All Ads"/>
</jsp:include>
  </head>
  <body>
  <%@include file="/partials/navbar.jsp"%>
  <h1>Here are all the ads:</h1>

  <c:forEach var="ad" items="${ads}">
    <div class="ad">
      <h2>${ad.title}</h2>
      <p>${ad.description}</p>
    </div>
  </c:forEach>



  </body>
</html>
