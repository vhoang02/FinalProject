<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>login</title>

  <!-- Font Icon -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style-login/fonts/material-icon/css/material-design-iconic-font.min.css">
  <!-- Main css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style-login/css/style.css">
</head>
<body>
<!-- Page Preloder -->
<div id="preloder">
  <div class="loader"></div>
</div>
<!-- Page Preloader -->

<div class="main">
  <!-- Sing in  Form -->
  <section class="sign-in">
    <div class="container">
      <div class="signin-content">
        <div class="signin-image">
          <figure><img src="${pageContext.request.contextPath}/style/style-login/images/signin-image.jpg" alt="sing up image"></figure>
          <a href="<c:url value="Register.jsp"/>" class="signup-image-link">Create an account</a>
          <a href="<c:url value="../vwHome/Index.jsp"/>" class="signup-image-link">Back to home</a>
        </div>
        <div class="signin-form">
          <h2 class="form-title">Sign in</h2>
          <form method="POST" class="register-form" id="login-form">
            <div class="form-group">
              <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
              <input type="text" name="your_name" id="your_name" placeholder="Your Name"/>
            </div>
            <div class="form-group">
              <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
              <input type="password" name="your_pass" id="your_pass" placeholder="Password"/>
            </div>
            <div class="form-group">
              <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
              <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
            </div>
            <div class="form-group form-button">
              <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>
</div>
<!-- JS -->
<script src="${pageContext.request.contextPath}/style/style-login/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/style/style-login/js/main.js"></script>
</body>
</html>