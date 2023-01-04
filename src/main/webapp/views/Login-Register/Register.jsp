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
  <link rel="stylesheet" href="<c:url value="/style/style-login/fonts/material-icon/css/material-design-iconic-font.min.css"/> ">
  <!-- Main css -->
  <link rel="stylesheet" href="<c:url value="/style/style-login/css/style.css"/>">
</head>
<body>
<div class="main">
  <!-- Sign up form -->
  <section class="signup">
    <div class="container">
      <div class="signup-content">
        <div class="signup-form">
          <h2 class="form-title">Sign up</h2>
          <form method="POST" class="register-form" id="register-form">
            <div class="form-group">
              <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
              <input type="text" name="name" id="name" placeholder="Your Name"/>
            </div>
            <div class="form-group">
              <label for="email"><i class="zmdi zmdi-email"></i></label>
              <input type="email" name="email" id="email" placeholder="Your Email"/>
            </div>
            <div class="form-group">
              <label for="pass"><i class="zmdi zmdi-lock"></i></label>
              <input type="password" name="pass" id="pass" placeholder="Password"/>
            </div>
            <div class="form-group">
              <%--@declare id="re-pass"--%><label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
              <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
            </div>
            <div class="form-group">
              <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
              <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
            </div>
            <div class="form-group form-button">
              <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
            </div>
          </form>
        </div>
        <div class="signup-image">
          <figure><img src="<c:url value="/style/style-login/images/signup-image.jpg"/>" alt="sing up image"></figure>
          <a href="<c:url value="Login.jsp"/>" class="signup-image-link">I am already member</a>
          <a href="<c:url value="../vwHome/Index.jsp"/>" class="signup-image-link">Back to home</a>
        </div>
      </div>
    </div>
  </section>
</div>
<!-- JS -->
<script src="<c:url value="/style/style-login/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/style/style-login/js/main.js"/>"></script>
</body>
</html>