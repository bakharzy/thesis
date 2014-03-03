<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8,application/json">
        <title>Applications</title>
    </head>
    <body>
        <h1>Applications</h1>

        <h2>Add new application</h2>

        <div>
            Enter information and press submit:<br/>
            <form action="${pageContext.request.contextPath}/app/applications" method="POST">
                Name:  <input type="text" name="name" id="name"/><br/>
                Email: <input type="text" name="email" id="email"/><br/>
                <input type="submit"/>
            </form>
        </div>

        <h2>Existing applications</h2>

        <ol>
            <c:forEach var="application" items="${applications}">
                <li> Application ID: ${application.id} <br>
                    Application Name: ${application.name} <br>
                    Application Email: ${application.email} <br>
                    <form method="POST" action="${pageContext.request.contextPath}/app/applications/${application.id}">
                        <input type="submit" value="Remove" id="remove-${application.id}"/>
                    </form>
                    <form method="GET" action="${pageContext.request.contextPath}/app/applications/${application.id}/actions/show">
                        <input type="submit" value="Actions" />
                    </form><br/>
                </li>
            </c:forEach>
        </ol>

    </body>
</html>
