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
 <form:form method="post" modelAttribute="addressDetails" action="/MusicWebsite/user/saveAddress">
        <table class="table table-dark table-striped-columns">
            <tr>
                <th colspan="2">Edit Address</th>
            </tr>
            <tr>
                <td>Sl No:</td>
                <td>${addressDetails.addressId}
                     <form:hidden path="addressId" size="30" maxlength="30"/></td>
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