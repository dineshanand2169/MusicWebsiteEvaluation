<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CheckOut Complete</title>
</head>
<body>
    <div align="center">
        <h2>Thank you for an awesome purchase!</h2>
         <h3>Purchased Songs</h3>
            <c:if test="${!empty songList}">
                <table>
                    <tr>
                        <th width="80">Song Name</th>
                        <th width="120">Artist</th>
                        <th width="120">Description</th>
                    </tr>
                    <c:forEach items="${songList}" var="song">
                        <tr>
                            <td>${song.songName}</td>
                            <td>${song.artist}</td>
                            <td>${song.description}</td>
                        </tr>
                    </c:forEach>
                </table>
                </c:if>
                 <h3>Your songs are imported to your Library. Enjoy your Music!</h3>
                 <button onclick='window.location ="/MusicWebsite/basket/export/pdf/${purchaseDetails.purchaseId}"' class="blue-button">Download Invoice</button>
                 <a href="http://localhost:8080/MusicWebsite/userHome">Home</a>
            </div>
        </body>
        </html>