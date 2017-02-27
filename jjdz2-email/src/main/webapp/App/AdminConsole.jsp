<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JBD Email Search Engine</title>
    <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <link href="../resources/css.css" rel="stylesheet" type="text/css">
</head>
<body class="body">
<jsp:directive.include file="../header.jsp"/>
<div id="container">
    <script type="text/javascript" src="LogoutFB.js">
    </script>
    <div class="jumbotron">
        <h1>Welcome</h1>
        <p>Add new admins or edit existing one</p>
        <p>Welcome! ${sessionData.username} </p>
    </div>
    <div class="underJumbotron">
        <div class="col-md-3">
            <form method="post" action="search">
                <button class="btn btn-warning" onclick="location.href=search">Search</button>
            </form>

            <p>
            <form action="../index.jsp">
            </form>
            </p>
            <form method="get" action="createReport">
                <button class="btn btn-warning" onclick="location.href=createReport">createReport</button>
            </form>
            <p>
            <form action="../index.jsp">
                <input class="btn btn-warning" type="submit" value="Go to main page" name="goBackToKeywordsFinder">
            </form>
            </p>


        </div>
        <div class="col-md-9" name="headerText">
            <c:set var="Counter" scope="request" value="0"></c:set>
            <ul class="list-group">
                <c:forEach items="${reportList}" var="report">
                    <c:if test="${Counter == 0}">
                        <li class="list-group-item list-group-item-action active">Dzien i ostatnia aktywność - Osoba - Ilosc Logowan</li>
                        <c:set var="Counter" value="${Counter = Counter + 1}"></c:set>
                    </c:if>
                    <li class="list-group-item justify-content-between">${report.getUser().getLoginTime()}
                        - ${report.getUser().getUsername()}
                        <span class="badge badge-default badge-pill">${report.getCounter()}</span>
                    </li>
                </c:forEach>
            </ul>
            <form method="post" action="update">
                <c:set var="Admin" scope="session" value="Admin"/>
                <c:set var="Local" scope="session" value="Local User"/>
                <c:set var="Priv" scope="session" value="0"/>

                <ul>
                    <c:forEach items="${userList}" var="user">
                        <c:if test="${user.privilege == 1}">
                            <li> ${user.id} . ${user.username} - ${Admin} <input type="checkbox" name="isPrivileged"
                                                                                 value=${user.id}></li>
                        </c:if>
                        <c:if test="${user.privilege == 2}">
                            <li> ${user.id} . ${user.username} - ${Local} <input type="checkbox" name="isPrivileged"
                                                                                 value=${user.id}></li>
                        </c:if>
                    </c:forEach>

                </ul>
                <input class="btn btn-warning" type="submit" value="Update">
            </form>
        </div>
    </div>
    <jsp:directive.include file="../footer.jsp"/>
</div>
</body>
</html>
