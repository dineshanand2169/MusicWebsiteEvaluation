<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body background="https://mobimg.b-cdn.net/v3/fetch/7b/7b6558540514d054a8d285377a6940e7.jpeg">
</br><span class="badge rounded-pill text-bg-success">
    <h2>User List</h2></span> <br/> <br/>
    <span class="badge rounded-pill text-bg-info">
    <h3>Users</h3></span> <br/> <br/>
    <c:if test="${!empty userList}">
        <table class="table table-dark table-striped-columns">
            <tr>
                <th width="80">Name</th>
                <th width="120">Phone Number</th>
                <th width="120">Email</th>
                <th width="120">User Name</th>
                <th width="120">Status</th>
                <th width="120">Address Details</th>
                <th width="120">Remove Admin</th>
            </tr>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.email}</td>
                    <td>${user.userName}</td>
                    <td>${user.status}</td>
                    <td><a href="<c:url value='/admin/addressDetails/${user.id}' />" >Address Details</a></td>
                    <td><a href="<c:url value='/superAdmin/removeAdmin/${user.id}' />" >Remove Admin</a></td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <a href="http://localhost:8080/MusicWebsite/superAdmin">Home</a>
        </body>
        </html>
