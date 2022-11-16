<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>

</head>
<body>
</br>
 <form:form method="post" modelAttribute="song" action="/MusicWebsite/admin/insertSong">

        <table>
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
                                                   class="blue-button" /></td>
                        </tr>
                    </table>
                 </form:form>

                <a href="http://localhost:8080/MusicWebsite/adminHome">Home</a>
            </body>
                    </html>