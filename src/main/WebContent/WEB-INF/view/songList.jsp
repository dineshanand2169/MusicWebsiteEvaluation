<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
</br>
    <h2>Song List<h2>
    <h3>Romance Songs</h3>
    <c:if test="${!empty romanceSongs}">
        <table>
            <tr>
                <th width="80">Song Name</th>
                <th width="120">Artist</th>
                <th width="120">Description</th>
                <th width="120">Download Count</th>
                <th width="120">Price</th>
            </tr>
            <c:forEach items="${romanceSongs}" var="song">
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
    <h3>Party Songs</h3>
     <c:if test="${!empty partySongs}">
            <table>
                <tr>
                    <th width="80">Song Name</th>
                    <th width="120">Artist</th>
                    <th width="120">Description</th>
                    <th width="120">Download Count</th>
                    <th width="120">Price</th>
                </tr>
                <c:forEach items="${partySongs}" var="song">
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
     <h3>Melody Songs</h3>
      <c:if test="${!empty melodySongs}">
             <table>
                 <tr>
                     <th width="80">Song Name</th>
                     <th width="120">Artist</th>
                     <th width="120">Description</th>
                     <th width="120">Download Count</th>
                     <th width="120">Price</th>
                 </tr>
                 <c:forEach items="${melodySongs}" var="song">
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
      <h3>Trending Songs</h3>
       <c:if test="${!empty trendingSongs}">
              <table>
                  <tr>
                      <th width="80">Song Name</th>
                      <th width="120">Artist</th>
                      <th width="120">Description</th>
                      <th width="120">Download Count</th>
                      <th width="120">Price</th>
                  </tr>
                  <c:forEach items="${trendingSongs}" var="song">
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