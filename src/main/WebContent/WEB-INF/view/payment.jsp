<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body background="https://mobimg.b-cdn.net/v3/fetch/7b/7b6558540514d054a8d285377a6940e7.jpeg">
</br><span class="badge rounded-pill text-bg-success">
<h3>Address List</h3></span> <br/> <br/>
    <c:if test="${!empty addressList}">
        <table  class="table table-dark table-striped-columns">
            <tr>
                <th width="80">Sl Number</th>
                <th width="120">House Name</th>
                <th width="120">House Number</th>
                <th width="120">City</th>
                <th width="120">State</th>
                <th width="120">Pin Code</th>
            </tr>
            <c:forEach items="${addressList}" var="address">
                <tr>
                    <td>${address.addressId}</td>
                    <td>${address.houseName}</td>
                    <td>${address.houseNumber}</td>
                    <td>${address.city}</td>
                    <td>${address.state}</td>
                    <td>${address.pinCode}</td>
                </tr>
            </c:forEach>
        </table>
         </c:if>

 <form:form method="post" modelAttribute="purchaseDetails" action="/MusicWebsite/basket/savePurchase">
        <table class="table table-dark table-striped-columns">
            <tr>
                <th colspan="2">Payment Portal</th>
            </tr>
            <tr>
                <td><form:label path="billingAddressId">Billing Address ID(Select from the Address ID)</form:label></td>
                <td>
                    <form:input path="billingAddressId" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                            <td><form:label path="paymentMode">Payment Method(UPI, NetBanking , Card)</form:label></td>
                            <td>
                                <form:input path="paymentMode" size="30" maxlength="30"/></td>
                        </tr>
            <tr>
                <td>Bill Amount</td>
                <td>Rs ${purchaseDetails.billAmount}
                <form:hidden path="billAmount" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                            <form:hidden path="basketId" size="30" maxlength="30"/></td>
                        </tr>
            <tr>
                <td colspan="2"><input type="submit"
                                       class="btn btn-info" /></td>
            </tr>
        </table>
    </form:form>
 <button onclick="history.go(-2)">Back to Home</button>
</body>
        </html>