<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
    <h2>User List<h2>
    <h3>Users</h3>
    <c:if test="${!empty userList}">
        <table>
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
