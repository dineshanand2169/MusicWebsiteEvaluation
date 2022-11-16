<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
    <h3>Purchase Request Management</h3>
    <c:if test="${!empty basketList}">
        <table>
            <tr>
                <th width="80">User ID</th>
                <th width="120">Basket Status</th>
                <th width="120">View Content</th>
            </tr>
            <c:forEach items="${basketList}" var="basket">
                <tr>
                    <td>${basket.userId}</td>
                    <td>${basket.basketStatus}</td>
                    <td><a href="<c:url value='/admin/viewContent/${basket.basketId}' />" >View Content</a></td>
                </tr>
            </c:forEach>
        </table>
         <a href="http://localhost:8080/MusicWebsite/adminHome">Home</a>
</c:if>
</body>
</html>