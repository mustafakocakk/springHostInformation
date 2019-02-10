
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
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
<div class="row">
    <div class="col-md-6">
        <legend>Proses List</legend>
        <form>
        <table id="example" class="table table-striped table-bordered"
               cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>USER</th>
                <th>PID</th>
                <th>CPU</th>
                <th>MEM</th>
                <th>VSZ</th>
                <th>RSS</th>
                <th>TTY</th>
                <th>STAT</th>
                <th>START</th>
                <th>TIME</th>
                <th>COMMAND</th>
                <th>KİLL</th>
            </tr>
            </thead>
            <tbody>

            <!-- Kayitlari listeleyelim... -->
            <c:forEach items="${allProses}" var="proses">
                <tr>
                    <td><c:out value="${proses.user}" /></td>
                    <td><c:out value="${proses.pid}" /></td>
                    <td><c:out value="${proses.cpu}" /></td>
                    <td><c:out value="${proses.mem}" /></td>
                    <td><c:out value="${proses.vsz}" /></td>
                    <td><c:out value="${proses.rss}" /></td>
                    <td><c:out value="${proses.tty}" /></td>
                    <td><c:out value="${proses.stat}" /></td>
                    <td><c:out value="${proses.start}" /></td>
                    <td><c:out value="${proses.time}" /></td>
                    <td><c:out value="${proses.command}" /></td>
                    <td><input class='myclass' type='button' value="${proses.pid}" onclick="prosesKill(${proses.pid})" /></td>




                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
       </form>
    </div>
</div>
<script>

    function prosesKill(id){
        var url="${pageContext.request.contextPath}/kill";
        $.ajax({
            type: 'POST',
            url: url,
            data:{id:id},
            success:function (data) {

            }
        });
    }




</script>

</body>
</html>





<%@ page isELIgnored="false" %>