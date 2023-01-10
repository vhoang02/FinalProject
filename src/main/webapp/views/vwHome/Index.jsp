<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--<jsp:useBean id="listtop3" scope="request" type="java.util.List<com.example.finalproject.beans.Articles>"/>--%>
<%--<jsp:useBean id="ArticleTop10" scope="request" type="java.util.List<com.example.finalproject.beans.Articles>"/>--%>
<title>Home</title>
<t:main>
    <jsp:body>
        <!-- Hero Section Begin -->
        <section class="hero">
            <div class="container-fluid">
                <div class="hero__slider owl-carousel">
                    <div class="hero__items set-bg"
                         data-setbg="${pageContext.request.contextPath}/style/style-main/img/hero/hero-1.jpg">
                        <div class="container">
                            <div class="row">
                                <div class="col-xl-5 col-lg-7 col-md-8">
                                    <div class="hero__text">
<%--                                        <h6>Summer Collection</h6>--%>
<%--                                        <h2>Fall - Winter Collections 2030</h2>--%>
                                        <p>A specialist label creating luxury essentials. Ethically crafted with an
                                            unwavering
                                            commitment to exceptional quality.</p>
                                        <div class="hero__social">
                                            <a href="https://www.facebook.com/vhoang1810/"><i
                                                    class="fa fa-facebook"></i></a>
                                            <a href="https://www.instagram.com/_justzitcuazang_/"><i
                                                    class="fa fa-instagram"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="hero__items set-bg"
                         data-setbg="${pageContext.request.contextPath}/style/style-main/img/hero/hero-2.jpg">
                        <div class="container">
                            <div class="row">
                                <div class="col-xl-5 col-lg-7 col-md-8">
                                    <div class="hero__text">
<%--                                        <h6>Summer Collection</h6>--%>
<%--                                        <h2>Fall - Winter Collections 2030</h2>--%>
                                        <p>A specialist label creating luxury essentials. Ethically crafted with an
                                            unwavering
                                            commitment to exceptional quality.</p>
                                        <div class="hero__social">
                                            <a href="#"><i class="fa fa-facebook"></i></a>
                                            <a href="#"><i class="fa fa-instagram"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->
        <hr NOSHADE SIZE="5" class="mt-lg-5">
        <!-- Blog Section Begin -->
        <section class="blog spad">
            <div class="container">
                <div class="row">
                    <div class="col-xl-8">
                        <div class="card h-60">
                            <div class="h4 align-self-center">
                                Mới nhất
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <c:forEach var="c" items="${listtop10new}">
                                        <div class="col">
                                            <div class="blog__item">
                                                <div class="blog__item__pic set-bg"
                                                     data-setbg="${pageContext.request.contextPath}/public/imgs/articles/${c.articles_id}/1.jpg"></div>
                                                <div class="blog__item__text">
                                                    <span>
                                                        <input type="datetime-local" value="${c.publish_date}" name="resumeUrl" />
                                                    </span>
                                                    <h5>${c.title}</h5>
                                                    <a href="${pageContext.request.contextPath}/Article/Detail?id=${c.articles_id}" role="button">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Noi bat -->
                    <div class="col-md-4 col-sm-6">
                        <div class="card h-60">
                            <div class="h4 align-self-center">
                                Nổi Bật
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <c:forEach var="c" items="${listtop3}">
                                        <div>
                                            <div class="blog__item">
                                                <span></span>
                                                <div class="blog__item__pic set-bg"
                                                     data-setbg="${pageContext.request.contextPath}/public/imgs/articles/${c.articles_id}/1.jpg"></div>
                                                <div class="blog__item__text">
                                                    <span>
                                                        <input type="datetime-local" value="${c.publish_date}" name="resumeUrl" />
                                                    </span>
                                                    <h5>${c.title}</h5>
                                                    <a href="${pageContext.request.contextPath}/Article/Detail?id=${c.articles_id}" role="button">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Noi bat -->
                </div>
            </div>
        </section>
        <!-- Blog Section End -->
        <!-- section Chuyên mục -->
        <hr NOSHADE SIZE="5">
        <section class="blog spad">
            <div class="container-fluid">
                <div class="row">
                    <div class="col">
                        <div class="card h-60">
                            <div class="h4 align-self-center">
                                Top 10 xem nhiều nhất
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <c:forEach var="c" items="${listtop10view}">
                                        <div class="col">
                                            <div class="blog__item">
                                                <div class="blog__item__pic set-bg"
                                                     data-setbg="${pageContext.request.contextPath}/public/imgs/articles/${c.articles_id}/1.jpg"></div>
                                                <div class="blog__item__text">
                                                    <span>
                                                        <input type="datetime-local" value="${c.publish_date}" name="resumeUrl" />
                                                    </span>
                                                    <h5>${c.title}</h5>
                                                    <a href="${pageContext.request.contextPath}/Article/Detail?id=${c.articles_id}" role="button">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <hr NOSHADE SIZE="5">
        <section>
            <div class="container">
                <h2>Chuyên mục</h2>
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="row">
                                <c:forEach var="c" begin="0" end="2">
                                    <div class="col">
                                        <div class="flip-card">
                                            <div class="flip-card-inner">
                                                <div class="flip-card-front">
                                                    <img src="${pageContext.request.contextPath}/style/style-main/img/hero/hero-1.jpg"
                                                         alt="Avatar"
                                                         style="width:300px;height:420px;">
                                                </div>
                                                <div class="flip-card-back">
                                                    <h1>John Doe</h1>
                                                    <p>Architect & Engineer</p>
                                                    <p>We love that guy</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item ">
                            <div class="row">
                                <c:forEach var="c" begin="0" end="2">
                                    <div class="col">
                                        <div class="flip-card">
                                            <div class="flip-card-inner">
                                                <div class="flip-card-front">
                                                    <img src="${pageContext.request.contextPath}/style/style-main/img/hero/hero-1.jpg"
                                                         alt="Avatar"
                                                         style="width:300px;height:420px;">
                                                </div>
                                                <div class="flip-card-back">
                                                    <h1>John Doe</h1>
                                                    <p>Architect & Engineer</p>
                                                    <p>We love that guy</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item ">
                            <div class="row">
                                <c:forEach var="c" begin="0" end="2">
                                    <div class="col">
                                        <div class="flip-card">
                                            <div class="flip-card-inner">
                                                <div class="flip-card-front">
                                                    <img src="${pageContext.request.contextPath}/style/style-main/img/hero/hero-1.jpg"
                                                         alt="Avatar"
                                                         style="width:300px;height:420px;">
                                                </div>
                                                <div class="flip-card-back">
                                                    <h1>John Doe</h1>
                                                    <p>Architect & Engineer</p>
                                                    <p>We love that guy</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item ">
                            <div class="row">
                                <c:forEach var="c" begin="0" end="2">
                                    <div class="col">
                                        <div class="flip-card">
                                            <div class="flip-card-inner">
                                                <div class="flip-card-front">
                                                    <img src="${pageContext.request.contextPath}/style/style-main/img/hero/hero-1.jpg"
                                                         alt="Avatar"
                                                         style="width:300px;height:420px;">
                                                </div>
                                                <div class="flip-card-back">
                                                    <h1>John Doe</h1>
                                                    <p>Architect & Engineer</p>
                                                    <p>We love that guy</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </section>
    </jsp:body>
</t:main>