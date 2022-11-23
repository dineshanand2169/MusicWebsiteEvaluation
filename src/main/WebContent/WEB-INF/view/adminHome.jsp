     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <html>
    <head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Admin Home</title>
    </head>
    <body background="https://mobimg.b-cdn.net/v3/fetch/7b/7b6558540514d054a8d285377a6940e7.jpeg">
    <div align="center">
    <span class="badge text-bg-success">
            <h2>Welcome ${user.name} !</h2></span>
    <form method="get"  action="/MusicWebsite/admin/getAllUser">
                        </br><input type="submit" class="btn btn-secondary" value="All Users"/>
    </form>
    <form method="get"  action="/MusicWebsite/admin/viewPurchaseRequest/">
                        </br><input type="submit" class="btn btn-secondary" value="View Purchase Request"/>
    </form>
    <form method="get"  action="/MusicWebsite/user/allSongs">
                                </br><input type="submit" class="btn btn-secondary" value="All Songs in Website"/>
    </form>
     <form method="get"  action="/MusicWebsite/admin/viewRegistrationRequest">
                        </br><input type="submit" class="btn btn-secondary" value="Registration Request"/>
    </form>
    <form method="get"  action="/MusicWebsite/admin/addNewSong">
                            </br><input type="submit" class="btn btn-secondary" value="Add New Song"/>
    </form>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<a href="${logoutUrl}">Log Out</a>

</body>
</html>
