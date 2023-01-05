<%@ tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style-dashboard/style-projects.css">
    <title>Admin</title>
</head>
<body>
<jsp:include page="../../views/partials/dashboard/left.jsp"/>
<div class="main-content">
    <jsp:include page="../../views/partials/dashboard/header.jsp"/>
    <jsp:doBody/>
</div>
</body>
</html>