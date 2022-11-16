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
    <c:if test="${!empty registeredUserList}">
        <table>
            <tr>
                <th width="80">Name</th>
                <th width="120">Phone Number</th>
                <th width="120">Email</th>
                <th width="120">User Name</th>
                <th width="120">Status</th>
                <th width="120">Approve</th>
                <th width="120">Reject</th>
            </tr>
            <c:forEach items="${registeredUserList}" var="user">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.email}</td>
                    <td>${user.userName}</td>
                    <td>${user.status}</td>
                    <td><a href="<c:url value='/admin/approveRegistration/${user.id}' />" >Approve</a></td>
                    <td><a href="<c:url value='/admin/rejectRegistration/${user.id}' />" >Reject</a></td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
                <a href="http://localhost:8080/MusicWebsite/adminHome">Home</a>
                </body>
                </html>