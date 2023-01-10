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
            <ul>
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
                    <c:choose>
                        <c:when test="${auth}">
                            <form id="frmLogout" action="${pageContext.request.contextPath}/Account/Logout" method="post" ></form>
                            <div class="dropdown">
                                <button class="btn" type="button" data-toggle="dropdown" aria-expanded="false">
                                    <i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
                                </button>
                                <div class="dropdown-menu align-items-center">
                                    <c:choose>
                                        <c:when test="${authUser.role == 0}">
                                            <span class="dropdown-item">Hello, ${authUser.name}</span>
                                            <a href="${pageContext.request.contextPath}/Admin/Project" class="dropdown-item">Admin</a>
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Account/Profile">Profile</a>
                                            <a class="dropdown-item" href="javascript: $('#frmLogout').submit()">Sign out</a>
                                        </c:when>
                                        <c:when test="${authUser.role == 1}">
                                            <span class="dropdown-item">Hello, ${authUser.name}</span>
                                            <a href="${pageContext.request.contextPath}/Editor/Project?eId=${authUser.user_id}" class="dropdown-item">Edit project(editor)</a>
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Account/Profile">Profile</a>
                                            <a class="dropdown-item" href="javascript: $('#frmLogout').submit()">Sign out</a>
                                        </c:when>
                                        <c:when test="${authUser.role == 2}">
                                            <span class="dropdown-item">Hello, ${authUser.name}</span>
                                            <a href="admin-dashboard.html" class="dropdown-item">Edit (writer)</a>
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Account/Profile">Profile</a>
                                            <a class="dropdown-item" href="javascript: $('#frmLogout').submit()">Sign out</a>
                                        </c:when>
                                        <c:when test="${authUser.role == 3}">
                                            <span class="dropdown-item">Hello, ${authUser.name}</span>
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/Account/Profile">Profile</a>
                                            <a class="dropdown-item" href="javascript: $('#frmLogout').submit()">Sign out</a>
                                        </c:when>
                                    </c:choose>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="dropdown">
                                <button class="btn" type="button" data-toggle="dropdown" aria-expanded="false">
                                    <i class="fa fa-user-circle-o fa-2x" aria-hidden="true"></i>
                                </button>
                                <div class="dropdown-menu align-items-center">
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/Account/Login">Log in</a>
                                    <a class="dropdown-item" href="${pageContext.request.contextPath}/Account/Register">Sign up</a>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </li>
    </ul>
</nav>
<!-- header section end -->