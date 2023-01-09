<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>
<!-- header section begin -->
<div id="logo" class="container">
    <img src="${pageContext.request.contextPath}/style/style-main/img/logo.png">
</div>
<nav>
    <ul>
        <li><a href="#" title="Chuyên mục">Chuyên mục</a>
            <!-- menu con sổ xuống cấp 1 -->
            <ul style="height:50px">
                <li>
                    <a href="#">Kinh doanh</a>
                    <!-- menu con sổ ngang cấp 2 -->
                    <ul>
                        <li><a href="#">Nông sản</a></li>
                        <li><a href="#">Hải sản</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Kinh doanh</a>
                    <!-- menu con sổ ngang cấp 2 -->
                    <ul>
                        <li><a href="#">Nông sản</a></li>
                        <li><a href="#">Hải sản</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Kinh doanh</a>
                    <!-- menu con sổ ngang cấp 2 -->
                    <ul>
                        <li><a href="#">Nông sản</a></li>
                        <li><a href="#">Hải sản</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Kinh doanh</a>
                    <!-- menu con sổ ngang cấp 2 -->
                    <ul>
                        <li><a href="#">Nông sản</a></li>
                        <li><a href="#">Hải sản</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">Kinh doanh</a>
                    <!-- menu con sổ ngang cấp 2 -->
                    <ul>
                        <li><a href="#">Nông sản</a></li>
                        <li><a href="#">Hải sản</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li>
            <div>
                <div>
                    <div class="dropdown">
                        <button class="btn" type="button" data-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
                        </button>
                        <div class="dropdown-menu align-items-center">
                            <span class="dropdown-item">Hello, Viet Hoang</span>
                            <a class="dropdown-item" href="login.html">Log in</a>
                            <a class="dropdown-item" href="signup.html">Sign up</a>
                            <a href="admin-dashboard.html" class="dropdown-item">Admin</a>
                            <a class="dropdown-item" href="edit-profile.html">Edit profile</a>
                            <a class="dropdown-item" href="#">Exit</a>
                        </div>
                    </div>
                </div>
            </div>
        </li>
    </ul>
</nav>
<!-- header section end -->