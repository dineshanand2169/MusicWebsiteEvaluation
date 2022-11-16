<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
    <h2>Basket Content<h2>
    <c:if test="${!empty songList}">
        <table>
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
        <a href="http://localhost:8080/MusicWebsite/userHome">Home</a>
        </body>
        </html>