<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
    <h3>Address List</h3>
    <c:if test="${!empty addressDetailsList}">
        <table>
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
         <button onclick="history.back()">Back to Home</button>
</c:if>
</body>
</html>