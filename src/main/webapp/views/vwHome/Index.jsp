<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Home</title>
<t:main_dash>
  <jsp:body>
    <!-- Hero Section Begin -->
    <section class="hero">
      <div class="hero__slider owl-carousel">
        <div class="hero__items set-bg" data-setbg="${pageContext.request.contextPath}/style/style-main/img/hero/hero-1.jpg">
          <div class="container">
            <div class="row">
              <div class="col-xl-5 col-lg-7 col-md-8">
                <div class="hero__text">
                  <h6>Summer Collection</h6>
                  <h2>Fall - Winter Collections 2030</h2>
                  <p>A specialist label creating luxury essentials. Ethically crafted with an unwavering
                    commitment to exceptional quality.</p>
                  <a href="#" class="primary-btn">Explore<span class="arrow_right"></span></a>
                  <div class="hero__social">
                    <a href="https://www.facebook.com/vhoang1810/"><i class="fa fa-facebook"></i></a>
                    <a href="https://www.instagram.com/_justzitcuazang_/"><i class="fa fa-instagram"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="hero__items set-bg" data-setbg="${pageContext.request.contextPath}/style/style-main/img/hero/hero-2.jpg">
          <div class="container">
            <div class="row">
              <div class="col-xl-5 col-lg-7 col-md-8">
                <div class="hero__text">
                  <h6>Summer Collection</h6>
                  <h2>Fall - Winter Collections 2030</h2>
                  <p>A specialist label creating luxury essentials. Ethically crafted with an unwavering
                    commitment to exceptional quality.</p>
                  <a href="#" class="primary-btn">Explore<span class="arrow_right"></span></a>
                  <div class="hero__social">
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-pinterest"></i></a>
                    <a href="#"><i class="fa fa-instagram"></i></a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Hero Section End -->

    <!-- Blog Section Begin -->
    <section class="blog spad">
        <div class="container">
          <div class="row">
<%--            <c:forEach var="a" begin="1" end="5">--%>
<%--              <div class="col-lg-4 col-md-6 col-sm-6">--%>
<%--                <div class="blog__item">--%>
<%--                  <div class="blog__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/style/style-main/img/blog/blog-1.jpg"></div>--%>
<%--                  <div class="blog__item__text">--%>
<%--                    <span><img src="style-main/img/icon/calendar.png" alt=""> 16 February 2020</span>--%>
<%--                    <h5>What Curling Irons Are The Best Ones</h5>--%>
<%--                    <a href="./blogdetails.html">Read More</a>--%>
<%--                  </div>--%>
<%--                </div>--%>
<%--              </div>--%>
<%--            </c:forEach>--%>
  <c:forEach items="${articles}" var="c">
    <tr>
      <td>${c.cat_id}</td>
      <td>${c.cat_name}</td>
      <td>
          ${c.parent_id}
      </td>
      <td>
        <button class="las la-edit"></button>
        <button class="las la-trash"></button>
      </td>
    </tr>
  </c:forEach>
          </div>
        </div>
    </section>
    <!-- Blog Section End -->
  </jsp:body>
</t:main_dash>