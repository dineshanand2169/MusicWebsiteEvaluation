<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
</br>
 <form:form method="post" modelAttribute="addressDetails" action="/MusicWebsite/user/saveAddress">
        <table>
            <tr>
                <th colspan="2">Edit Address</th>
            </tr>
            <tr>
                <td><form:label path="houseName">House Name:</form:label></td>
                <td>
                    <form:input path="houseName" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="houseNumber">House Number:</form:label></td>
                <td>
                    <form:input path="houseNumber" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="city">City:</form:label></td>
                <td>
                    <form:input path="city" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="state">State:</form:label></td>
                <td>
                    <form:input path="state" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                 <td><form:label path="pinCode">Pin Code:</form:label></td>
                  <td>
                      <form:input path="pinCode" size="30" maxlength="30"/></td>
             </tr>
              <tr>
                                         <form:hidden path="userId" size="30" maxlength="30"/></td>
                                     </tr>
                         <tr>
             <tr>
                <td colspan="2"><input type="submit"
                                       class="blue-button" /></td>
            </tr>
        </table>
       <a href="http://localhost:8080/MusicWebsite/userHome">Home</a>
    </form:form>
</body>
        </html>