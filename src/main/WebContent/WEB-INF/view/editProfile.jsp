<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
</br>
<h3>Person List</h3>
<form method="get"  action="/MusicWebsite/user/editPersonalDetails/${user.id}">
                        </br><input type="submit" class="blue-button" value="Edit Personal Details"/>
    </form>
    <form method="get"  action="/MusicWebsite/user/editAddressDetails/${user.id}">
                        </br><input type="submit" class="blue-button" value="Edit Address Details"/>
    </form>
 <button onclick="history.back()">Back to Home</button>