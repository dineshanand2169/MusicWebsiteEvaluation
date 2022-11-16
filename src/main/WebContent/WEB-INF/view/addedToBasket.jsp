<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
</br>
<h3>Song Successfully Added to Basket!!</h3>
   <button onclick='window.location ="/MusicWebsite/userHome"' class="blue-button">Back Home</button>
   <button onclick='window.location ="/MusicWebsite/user/musicList/${userId}"' class="blue-button">
   Add More Songs  </button>
</body>
        </html>