<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 18032808537
  Date: 2020/6/15
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>我爱大数据</h1>
    <c:if test="${5>2}">
        <h1>嗯!</h1>
    </c:if>

    <c:choose >
        <c:when test="${3<1}">
            <h1>我不爱大数据</h1>
        </c:when>
        <c:when test="${2>1}">
            <h1>大数据爱我</h1>
        </c:when>
        <c:otherwise>
            <h1>我谁也不爱</h1>
        </c:otherwise>

    </c:choose>
    <hr/>





</body>
</html>
