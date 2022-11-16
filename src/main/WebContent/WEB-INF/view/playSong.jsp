<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Play Song</title>
</head>
<body>
    <div align="center">
        <h2>EVE Music.com</h2>
        <h3>Music Player</h3>
        <form:form method="get" modelAttribute="song">
            <table border="2" cellpadding="5">

                <tr>
                    <td>Song Name: </td>
                    <td>${song.songName}</td>
                </tr>
                <tr>
                    <td>Artist: </td>
                    <td>${song.artist}</td>
                </tr>
                <tr>
                    <td>Genre: </td>
                    <td>${song.genre}</td>
                </tr>
                <tr>
                    <td>Description: </td>
                    <td>${song.description}</td>
                </tr>
                <tr>
                    <td>Download Count: </td>
                    <td>${song.downloadCount}</td>
                </tr>
                <tr>
                    <td>Click to Play: </td>
                    <td><iframe width="350" height="25"
                    src="${song.url}" title="YouTube video player"
                    frameborder="0" allow="accelerometer; autoplay;
                    clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen=false></iframe>
                    </td>
                </tr>
            </table>
                    </form:form>
                    <button onclick="history.back()">My Library</button>
                    <a href="http://localhost:8080/MusicWebsite/userHome">Home</a>
                            </body>
                            </html>