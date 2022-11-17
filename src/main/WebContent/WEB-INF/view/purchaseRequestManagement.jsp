<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body background="https://mobimg.b-cdn.net/v3/fetch/7b/7b6558540514d054a8d285377a6940e7.jpeg">
</br><span class="badge rounded-pill text-bg-info">
    <h3>Purchase Request Management</h3></span> <br/> <br/>
    <c:if test="${!empty basketList}">
        <table class="table table-dark table-striped-columns">
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

</c:if>
<button class="btn btn-warning" onclick="history.back()">Back to Home</button>
</body>
</html>