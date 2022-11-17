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
<span class="badge rounded-pill text-bg-info">
<h3>File Upload:</h3> </span> <br/> <br/>
          Select a file to upload: <br />
          <form action = "/MusicWebsite/admin/upload" method = "post"
             enctype = "multipart/form-data">
             <input type = "file" name = "file" size = "50" />
             <br />
             <input type = "submit" value = "Upload File" />
          </form>
 <form:form method="post" modelAttribute="song" action="/MusicWebsite/admin/insertSong">

        <table class="table table-dark table-striped-columns">
        <tr>
            <tr>
                <th colspan="2">Add Song</th>
            </tr>
            <tr>
                <td><form:label path="songName">Song Name:</form:label></td>
                <td>
                    <form:input path="songName" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="artist">Artist:</form:label></td>
                <td>
                    <form:input path="artist" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="genre">Genre(Romance/Melody/Party/Trending):</form:label></td>
                <td>
                    <form:input path="genre" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="description">Description:</form:label></td>
                <td>
                    <form:input path="description" size="30" maxlength="30"/></td>
            </tr>
            <tr>
                <td><form:label path="price">Price:</form:label></td>
                <td>
                    <form:input path="price" size="30" maxlength="30"/></td>
            </tr>

            <tr>
                <td><form:label path="url">URL:</form:label></td>
                <td>
                    <form:input path="url" size="30" maxlength="30"/></td>
            </tr>
             <tr>
                            <td colspan="2"><input type="submit"
                                                   class="btn btn-info" /></td>
                        </tr>
                    </table>
                 </form:form>

                <button class="btn btn-warning" onclick="history.back()">Back to Home</button>
            </body>
                    </html>