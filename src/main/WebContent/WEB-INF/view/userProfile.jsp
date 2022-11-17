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
<span class="badge text-bg-success">
<h3>User Profile</h3></span>
<c:if test="${!empty userList}">
    <table class="table table-success table-striped-columns">
        <tr>
            <th width="100">Name</th>
            <th width="100">Phone Number</th>
             <th width="100">Email ID</th>
             <th width="100">User Name</th>
             <th width="100">Password</th>

        </tr>
        <c:forEach items="${userList}" var="user">
           <tr>
                <td>${user.name}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.email}</td>
                <td>${user.userName}</td>
                <td>${user.password}</td>
           </tr>
        </c:forEach>
    </table>
</c:if>
<span class="badge text-bg-success">
    <h3>Address List</h3></span>
    <c:if test="${!empty addressDetailsList}">
        <table class="table table-success table-striped-columns">
            <tr>
                <th width="80">Sl Number</th>
                <th width="120">House Name</th>
                <th width="120">House Number</th>
                <th width="120">City</th>
                <th width="120">State</th>
                <th width="120">Pin Code</th>

            </tr>
            <c:forEach items="${addressDetailsList}" var="addressDetails">
                <tr>
                    <td>AD${addressDetails.addressId}</td>
                    <td>${addressDetails.houseName}</td>
                    <td>${addressDetails.houseNumber}</td>
                    <td>${addressDetails.city}</td>
                    <td>${addressDetails.state}</td>
                     <td>${addressDetails.pinCode}</td>
                </tr>
            </c:forEach>
        </table>
         <button class="btn btn-warning" onclick="history.back()">Back to Home</button>
</c:if>
</body>
</html>