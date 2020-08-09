<%--
  Created by IntelliJ IDEA.
  User: dev_manuel
  Date: 9/08/20
  Time: 5:23 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="container">
        <!--
            JSTL -> Java Standard Tag Library
        -->
        <h1><c:out value="${mensaje}"/></h1>
        <h2><c:out value="${usuario.nombre}"/></h2>
        <h3><c:out value="${usuario.contrasena}"/></h3>

    </div>
</body>
</html>
