<%--
  Created by IntelliJ IDEA.
  User: mvven
  Date: 02-02-2022
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
    First Name is: ${student.firstName}<br>
    Last Name is: ${student.lastName}<br>
    Country is: ${student.countries}<br>
    Favorite Programming Language is: ${student.favoriteLanguage}<br>
    Operating Systems:
    <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
        </c:forEach>
    </ul>

</body>
</html>
