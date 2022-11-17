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
    <h2>Basket Content</h2></span> <br/> <br/>
    <c:if test="${!empty songList}">
        <table class="table table-dark table-striped-columns">
            <tr>
                <th width="80">Song Name</th>
                <th width="120">Artist</th>
                <th width="120">Description</th>
                <th width="120">Download Count</th>
                <th width="120">Price</th>
            </tr>
            <c:forEach items="${songList}" var="song">
                <tr>
                    <td>${song.songName}</td>
                    <td>${song.artist}</td>
                    <td>${song.description}</td>
                    <td>${song.downloadCount}</td>
                    <td>${song.price}</td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <a href="<c:url value='/admin/approveRequest/${basketId}' />" >Approve Basket</a>
        <a href="<c:url value='/admin/rejectRequest/${basketId}' />" >Reject Basket</a>
      <button class="btn btn-warning" onclick="history.back()">Back to Home</button>
        </body>
        </html>