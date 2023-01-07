<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>
<!-- header section begin -->
<header class="header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-4 col-md-3 ">
                <div>
                    <div class="dropdown">
                        <button class="btn" style="border-color: #fff" type="button" data-toggle="dropdown" aria-expanded="false">
                            <img src="${pageContext.request.contextPath}/style/style-main/img/avt.jpg" style="border-radius: 50%;" width="60px" height="60px" alt="img avatar" >
                        </button>
                        <div class="dropdown-menu align-items-center">
                            <span class="dropdown-item">Hello, Viet Hoang</span>
                            <a class="dropdown-item" href="<c:url value="../Login-Register/Login.jsp"/>">Log in</a>
                            <a class="dropdown-item" href="<c:url value="../Login-Register/Register.jsp"/>">Sign up</a>
                            <a href="admin-dashboard.html" class="dropdown-item">Admin</a>
                            <a class="dropdown-item" href="edit-profile.html">Edit profile</a>
                            <a class="dropdown-item" href="#">Exit</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-7 col-md-3">
                <div class="header__logo">
                    <a href="${pageContext.request.contextPath}/Home/Index"><img src="${pageContext.request.contextPath}/style/style-main/img/logo.png" alt="logo"></a>
                </div>
            </div>
            <div class="col">
                <div class="dropdown">
                    <button class="btn btn-outline-dark" type="button" data-toggle="dropdown" aria-expanded="false"><i class="fa-solid fa-bars-progress"></i></button>
                    <div class="dropdown-menu align-items-center">
                        <a class="dropdown-item" href="login.html">Nông sản</a>
                        <a class="dropdown-item" href="signup.html"></a>
                        <a href="admin-dashboard.html" class="dropdown-item"></a>
                        <a class="dropdown-item" href="edit-profile.html"></a>
                        <a class="dropdown-item" href="#"></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- header section end -->
