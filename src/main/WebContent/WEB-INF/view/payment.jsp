<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
<h3>Address List</h3>
    <c:if test="${!empty addressList}">
        <table>
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
        <table>
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
                                       class="blue-button" /></td>
            </tr>
        </table>
    </form:form>
 <button onclick="history.go(-2)">Back to Home</button>
</body>
        </html>