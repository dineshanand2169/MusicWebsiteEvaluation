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
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>CheckOut Complete</title>
</head>
<body background="https://mobimg.b-cdn.net/v3/fetch/7b/7b6558540514d054a8d285377a6940e7.jpeg">
    <div align="center">
    <span class="badge rounded-pill text-bg-success">
        <h2>Thank you for an awesome purchase!</h2></span> <br/> <br/>
        <span class="badge rounded-pill text-bg-info">
         <h3>Purchased Songs</h3></span> <br/> <br/>
            <c:if test="${!empty songList}">
                <table class="table table-dark table-striped-columns">
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
                <span class="badge rounded-pill text-bg-info">
                 <h3>Your songs are imported to your Library. Enjoy your Music!</h3></span> <br/> <br/>
                 <button onclick='window.location ="/MusicWebsite/basket/export/pdf/${purchaseDetails.purchaseId}"' class="btn btn-info" >Download Invoice</button>
                 <a href="http://localhost:8080/MusicWebsite/userHome">Home</a>
            </div>
        </body>
        </html>