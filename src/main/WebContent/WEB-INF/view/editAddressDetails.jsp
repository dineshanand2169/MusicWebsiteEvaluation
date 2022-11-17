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
    <h3>Address List</h3></span>
    <c:if test="${!empty addressDetailsList}">
        <table class="table table-dark">
            <tr>
                <th width="80">Sl Number</th>
                <th width="120">House Name</th>
                <th width="120">House Number</th>
                <th width="120">City</th>
                <th width="120">State</th>
                <th width="120">Pin Code</th>
                <th>Edit</th>
            </tr>
            <c:forEach items="${addressDetailsList}" var="addressDetails">
                <tr>
                    <td>${addressDetails.addressId}</td>
                    <td>${addressDetails.houseName}</td>
                    <td>${addressDetails.houseNumber}</td>
                    <td>${addressDetails.city}</td>
                    <td>${addressDetails.state}</td>
                    <td>${addressDetails.pinCode}</td>
                    <td><a href="<c:url value='/user/editSelectedAddress/${addressDetails.addressId}' />" >Edit</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="<c:url value='/user/addAddress/${userId}' />" >Add another address</a>
         <button class="btn btn-warning" onclick="history.back()">Back to Home</button>
</c:if>
</body>
</html>