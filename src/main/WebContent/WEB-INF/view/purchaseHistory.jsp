<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
    <h2>Purchase History<h2>
    <c:if test="${!empty purchaseDetailsList}">
        <table>
            <tr>
                <th width="80">Transaction ID</th>
                <th width="120">Billing Address ID</th>
                <th width="120">Payment Mode</th>
                <th width="120">Purchase Date</th>
                <th width="120">Bill Amount</th>
            </tr>
            <c:forEach items="${purchaseDetailsList}" var="purchaseDetails">
                <tr>
                    <td>TiEVEmW${purchaseDetails.purchaseId}</td>
                    <td>AD${purchaseDetails.billingAddressId}</td>
                    <td>${purchaseDetails.paymentMode}</td>
                    <td>${purchaseDetails.purchaseDate}</td>
                    <td>INR${purchaseDetails.billAmount}</td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <a href="http://localhost:8080/MusicWebsite/userHome">Home</a>
        </body>
        </html>