<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="article" scope="request" class="com.example.finalproject.beans.Articles" />

<title>Detail</title>
<t:main>
    <jsp:body>
        <!-- Blog Details Hero Begin -->
        <section class="blog-hero spad">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-9 text-center">
                        <div class="blog__hero__text">
                            <h2>${article.abstracts}</h2>
                            <ul>
                                <li>${article.publish_date}</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog Details Hero End -->

        <!-- Blog Details Section Begin -->
        <section class="blog-details spad">
            <div class="container">
                <div class="row d-flex justify-content-center">
                    <div class="col-lg-12">
                        <div class="blog__details__pic">
                            <img src="${pageContext.request.contextPath}/public/imgs/articles/${article.articles_id}/main.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="blog__details__content">
                            <div class="blog__details__text">
                                ${article.content}
                            </div>
                            <div class="blog__details__option">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <div class="blog__details__author">
                                            <div class="blog__details__author__pic">
                                                <img src="style-main/img/blog/details/blog-author.jpg" alt="">
                                            </div>
                                            <div class="blog__details__author__text">
                                                <h5>Aiden Blair</h5>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6">
                                        <div class="blog__details__tags">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="blog__details__comment">
                                <h4>Leave A Comment</h4>
                                <form action="#">
                                    <div class="row">
                                        <div class="col-lg-4 col-md-4">
                                            <input type="text" placeholder="Name">
                                        </div>
                                        <div class="col-lg-4 col-md-4">
                                            <input type="text" placeholder="Email">
                                        </div>
                                        <div class="col-lg-4 col-md-4">
                                            <input type="text" placeholder="Phone">
                                        </div>
                                        <div class="col-lg-12 text-center">
                                            <textarea placeholder="Comment"></textarea>
                                            <button type="submit" class="site-btn">Post Comment</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog Details Section End -->
    </jsp:body>
</t:main>