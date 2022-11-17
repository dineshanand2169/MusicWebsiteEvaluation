<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body background="https://mobimg.b-cdn.net/v3/fetch/7b/7b6558540514d054a8d285377a6940e7.jpeg">
</br>
 <form:form method="post" modelAttribute="user" action="/MusicWebsite/user/saveUser">
        <table  class="table table-dark table-striped-columns">
            <tr>
                <th colspan="2">Edit User</th>
            </tr>
            <tr>
                <td>User ID:</td>
                <td>PIT${user.id}
                     <form:hidden path="id" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="name">Name:</form:label></td>
                <td>
                    <form:input path="name" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="phoneNumber">Phone Number:</form:label></td>
                <td>
                    <form:input path="phoneNumber" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="email">Email:</form:label></td>
                <td>
                    <form:input path="email" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                 <td><form:label path="userName">User Name:</form:label></td>
                  <td>
                      <form:input path="userName" size="30" maxlength="30"/></td>
             </tr>
            <tr>
                 <td><form:label path="password">Password:</form:label></td>
                  <td>
                      <form:input path="password" size="30" maxlength="30"/></td>
             </tr>
             <tr>
                <td colspan="2"><input type="submit"
                                       class="btn btn-secondary" /></td>
            </tr>
        </table>

    </form:form>
</body>
        </html>