<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
</br>
 <form:form method="post" modelAttribute="user" action="/MusicWebsite/user/saveNewUser">

        <table>
        <tr>
            <tr>
                <th colspan="2">User Registration Form</th>
            </tr>
            <tr>
                <td><form:label path="name">Full Name:</form:label></td>
                <td>
                    <form:input path="name" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="phoneNumber">Phone Number:</form:label></td>
                <td>
                    <form:input path="phoneNumber" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="email">Email ID:</form:label></td>
                <td>
                    <form:input path="email" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="userName">User Name:</form:label></td>
                <td>
                    <form:input path="userName" size="30" maxlength="30"/></td>
            </tr>
             <tr>
                 <td><form:label path="password">Password :</form:label></td>
                 <td>
                     <form:input path="password" size="30" maxlength="30"/></td>
             </tr>


           <tr>
           <form:form   modelAttribute="addressDetails" >
                          <table>
                              <tr>
                                  <th colspan="2">Add Address</th>
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
                              </table>
           </tr>
         </tr>
            <tr>
                <td colspan="2"><button type="submit" value="Submit" class="btn btn-primary">Submit
                </button></td>

            </tr>
        </table>
     </form:form>
    </form:form>


     <button onclick="history.back()">Back to Home</button>
</body>
        </html>