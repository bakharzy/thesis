<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actions</title>
    </head>
    <body>
        <h1>Action List</h1>
 
        <h2>Existing actions for your application</h2>
 
        <ol>
            <c:forEach var="action" items="${actions}">
                <li> Action ID: ${action.id}<br>
                    Action Name: ${action.name} <br>
                    Action Username:${action.username} <br>
                </li>
            </c:forEach>
        </ol>
 
        <div><a href="${pageContext.request.contextPath}/app/applications">applications</a></div>
    </body>
</html>