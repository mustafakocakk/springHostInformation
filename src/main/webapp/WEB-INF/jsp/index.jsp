
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/denme_war" >Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/denme_war/proses">Proses List <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/denme_war/disk">Disk Memory Usage <span class="sr-only">(current)</span></a>
            </li>

        </ul>

    </div>
</nav>

<table class="table">
    <thead>
    <tr>
        <th scope="col">hostname</th>
        <th scope="col">network arayüzü</th>
        <th scope="col">ip adresi</th>
        <th scope="col">loopback addres</th>
        <th scope="col">subnet aralığı</th>
        <th scope="col">broadcast</th>
        <th scope="col">mac adres</th>
        <th scope="col">acık port</th>
    </tr>
    </thead>
    <tbody>
    <tr>
    <tr>
        <td>${infoHost.host}</td>
        <td>${infoHost.networkInterfaces}</td>
        <td>${infoHost.ipAdress}</td>
        <td>${infoHost.loopBack}</td>
        <td>${infoHost.subnet}</td>
        <td>${infoHost.broadcast}</td>
        <td>${infoHost.macAdress}</td>
        <td>${infoHost.openPorts}</td>
    </tr>
    </tbody>
</table>

</body>
</html>





<%@ page isELIgnored="false" %>