<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
</br>
 <form:form method="post" modelAttribute="user" action="/MusicWebsite/user/saveUser">
        <table>
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
                                       class="blue-button" /></td>
            </tr>
        </table>

    </form:form>
</body>
        </html>