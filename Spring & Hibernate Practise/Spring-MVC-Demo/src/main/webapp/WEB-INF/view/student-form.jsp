<%--
  Created by IntelliJ IDEA.
  User: mvven
  Date: 02-02-2022
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    Student Form
<form:form action="processStudentForm" modelAttribute="student">
    First Name: <form:input path="firstName"/>
    Last Name: <form:input path="lastName"/>
    <form:select path="countries">
        <form:options items="${student.countryOptions}"/>
    </form:select>
    Favorite Language<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>
    Linux<form:checkbox path="operatingSystems" value="Linux"/>
    Mac<form:checkbox path="operatingSystems" value="Mac"/>
    <input type="submit" value="SUBMIT">
</form:form>
</body>
</html>
