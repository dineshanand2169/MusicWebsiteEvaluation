<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
    <h2>Hurray! Your Basket is Approved by the Admin!</h2>
    <h3>Basket List<h3>
    <h4>Kindly click on the checkout option to proceed for Payment</h4>
    <c:if test="${!empty approvedSongList}">
        <table>
            <tr>
                <th width="80">Song Name</th>
                <th width="120">Artist</th>
                <th width="120">Description</th>
                <th width="120">Download Count</th>
                <th width="120">Price</th>
            </tr>
            <c:forEach items="${approvedSongList}" var="song">
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
<button onclick='window.location ="/MusicWebsite/basket/checkOut/${userId}/$(basketId)" '>  Check Out </button>
    <h4>Songs added after approval</h4>
    <c:if test="${!empty pendingSongList}">
        <table>
            <tr>
                <th width="80">Song Name</th>
                <th width="120">Artist</th>
                <th width="120">Description</th>
                <th width="120">Download Count</th>
                <th width="120">Price</th>
            </tr>
            <c:forEach items="${pendingSongList}" var="song">
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
<button onclick="history.back()">Back to Home</button>
</body>
</html>










