<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body background="https://mobimg.b-cdn.net/v3/fetch/7b/7b6558540514d054a8d285377a6940e7.jpeg">
</br>
<span class="badge text-bg-success">
    <h2>Song List<h2>
    <h3>Romance Songs</h3></span>
    <c:if test="${!empty romanceSongs}">
        <table class="table table-dark table-striped-columns">
            <tr>
                <th width="120">Song Name</th>
                <th width="120">Artist</th>
                <th width="120">Description</th>
                <th width="120">Download Count</th>
                <th width="120">Price</th>
                <th width="100">Basket</th>
            </tr>
            <c:forEach items="${romanceSongs}" var="song">
                <tr>
                    <td>${song.songName}</td>
                    <td>${song.artist}</td>
                    <td>${song.description}</td>
                    <td>${song.downloadCount}</td>
                    <td>${song.price}</td>
                    <td><a href="<c:url value='/basket/basketContent/${song.songId}/${basket.basketId}' />" >Add to Basket</a></td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <span class="badge text-bg-success">
    <h3>Party Songs</h3></span>
     <c:if test="${!empty partySongs}">
            <table class="table table-dark table-striped-columns">
                <tr>
                    <th width="120">Song Name</th>
                    <th width="120">Artist</th>
                    <th width="120">Description</th>
                    <th width="120">Download Count</th>
                    <th width="120">Price</th>
                    <th width="100">Add To Basket</th>
                </tr>
                <c:forEach items="${partySongs}" var="song">
                    <tr>
                        <td>${song.songName}</td>
                        <td>${song.artist}</td>
                        <td>${song.description}</td>
                        <td>${song.downloadCount}</td>
                        <td>${song.price}</td>
                        <td><a href="<c:url value='/basket/basketContent/${song.songId}/${basket.basketId}' />" >Add to Basket</a></td>
                    </tr>
                </c:forEach>
            </table>
            </c:if>
            <span class="badge text-bg-success">
     <h3>Melody Songs</h3></span>
      <c:if test="${!empty melodySongs}">
             <table class="table table-dark table-striped-columns">
                 <tr>
                     <th width="120">Song Name</th>
                     <th width="120">Artist</th>
                     <th width="120">Description</th>
                     <th width="120">Download Count</th>
                     <th width="120">Price</th>
                     <th width="100">Add To Basket</th>
                 </tr>
                 <c:forEach items="${melodySongs}" var="song">
                     <tr>
                         <td>${song.songName}</td>
                         <td>${song.artist}</td>
                         <td>${song.description}</td>
                         <td>${song.downloadCount}</td>
                         <td>${song.price}</td>
                         <td><a href="<c:url value='/basket/basketContent/${song.songId}/${basket.basketId}' />" >Add to Basket</a></td>
                     </tr>
                 </c:forEach>
             </table>
             </c:if>
             <span class="badge text-bg-success">
      <h3>Trending Songs</h3></span>
       <c:if test="${!empty trendingSongs}">
              <table class="table table-dark table-striped-columns">
                  <tr>
                      <th width="120">Song Name</th>
                      <th width="120">Artist</th>
                      <th width="120">Description</th>
                      <th width="120">Download Count</th>
                      <th width="120">Price</th>
                      <th width="100">Add To Basket</th>
                  </tr>
                  <c:forEach items="${trendingSongs}" var="song">
                      <tr>
                          <td>${song.songName}</td>
                          <td>${song.artist}</td>
                          <td>${song.description}</td>
                          <td>${song.downloadCount}</td>
                          <td>${song.price}</td>
                          <td><a href="<c:url value='/basket/basketContent/${song.songId}/${basket.basketId}' />" >Add to Basket</a></td>
                      </tr>
                  </c:forEach>
              </table>

</c:if>
<a href="http://localhost:8080/MusicWebsite/userHome">Home</a>
</body>
</html>