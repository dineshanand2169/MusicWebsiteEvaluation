<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
    <h2>My Libray<h2>
    <c:if test="${!empty librarySongs}">
        <table>
            <tr>
                <th width="80">Song Name</th>
                <th width="120">Artist</th>
                <th width="120">Description</th>
                <th width="120">Play</th>
            </tr>
            <c:forEach items="${librarySongs}" var="song">
                <tr>
                    <td>${song.songName}</td>
                    <td>${song.artist}</td>
                    <td>${song.description}</td>
                 <td><a href="<c:url value='/user/playSong/${song.songId}' />" >Play</a></td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <a href="http://localhost:8080/MusicWebsite/userHome">Home</a>
        </body>
        </html>