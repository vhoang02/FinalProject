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
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
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
          <a href="${pageContext.request.contextPath}/Account/Register" class="signup-image-link">Create an account</a>
          <a href="${pageContext.request.contextPath}/Home" class="signup-image-link">Back to home</a>
        </div>
        <div class="signin-form">
          <h2 class="form-title">Sign in</h2>
          <c:if test="${hasError}">
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
              <strong>Login failed!</strong> ${errorMessage}
              <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
          </c:if>
          <form method="POST" class="register-form" id="login-form">
            <div class="form-group">
              <label for="txtUsername"><i class="zmdi zmdi-account material-icons-name"></i></label>
              <input type="text" name="username" id="txtUsername" placeholder="Your Name"/>
            </div>
            <div class="form-group">
              <label for="txtPassword"><i class="zmdi zmdi-lock"></i></label>
              <input type="password" name="password" id="txtPassword" placeholder="Password"/>
            </div>
            <div class="form-group">
              <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
              <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
            </div>
            <div class="form-group form-button">
              <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
            </div>
          </form>
          <div class="social-login">
            <span class="social-label">Or login with</span>
            <ul class="socials">
              <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
              <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
              <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>
<!-- JS -->
<script src="${pageContext.request.contextPath}/style/style-login/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/style/style-login/js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</body>
</html>