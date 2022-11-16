    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <html>
    <head>
   <!-- CSS only -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>makemyflight.com</title>
    </head>
    <body>
    <div align="center">
            <h2>Welcome to EVE Music!</h2>
    <a href="userHome" class="link-dark">Click here for Customer Login </a>
    <br/>
    <a href="adminHome" class="link-dark">Admin Page </a>
    <br/>
    <a href="superAdminHome" class="link-dark">Super Admin Page </a>


    <form method="get"  action="/MusicWebsite/user/registration">
                        </br>Register here for new user!<input type="submit" class="blue-button" value="Click Here"/>
    </form>
    </div>
   </body>
   </html>