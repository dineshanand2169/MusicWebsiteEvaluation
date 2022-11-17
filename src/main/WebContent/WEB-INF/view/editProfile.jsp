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
<h3>Person List</h3></span>
<form method="get"  action="/MusicWebsite/user/editPersonalDetails/${user.id}">
                        </br><input type="submit"class="btn btn-secondary" value="Edit Personal Details"/>
    </form>
    <form method="get"  action="/MusicWebsite/user/editAddressDetails/${user.id}">
                        </br><input type="submit" class="btn btn-secondary" value="Edit Address Details"/>
    </form>
 <button class="btn btn-warning" onclick="history.back()">Back to Home</button>