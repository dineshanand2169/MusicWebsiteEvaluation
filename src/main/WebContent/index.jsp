    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <html>
    <head>
   <!-- CSS only -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>eveMusic.com</title>

    </head>
    <body background="https://wallup.net/wp-content/uploads/2016/01/242827-vinyl-audio-minimalism-748x468.png">

    <div align="center">
        <span class="badge text-bg-success">
        <h2>Welcome to EVE Music!</h2></span>
        <br/>
        <span class="badge rounded-pill text-bg-success">

    <a href="userHome" class="link-dark">Click here for Customer Login </a>
    <br/></span>
    <span class="badge rounded-pill text-bg-info">
    <a href="adminHome" class="link-dark">Admin Page </a>
    <br/></span>
     <span class="badge rounded-pill text-bg-info">
    <a href="superAdminHome" class="link-dark">Super Admin Page </a>
    </span>
     </span>
    <form method="get"  action="/MusicWebsite/user/registration">
                        </br><input type="submit" class="btn btn-warning" value="Not a user? Register Here"/>
    </form>
    </div>
   </body>
   </html>