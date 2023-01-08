<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Register</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css" integrity="sha512-f0tzWhCwVFS3WeYaofoLWkTP62ObhewQ1EZn65oSYDZUg1+CyywGKkWzm8BxaJj5HGKI72PnMH9jYyIFz+GH7g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <!-- Font Icon -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style-login/fonts/material-icon/css/material-design-iconic-font.min.css">
  <!-- Main css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style-login/css/style.css"></head>
<body>
<div class="main">
  <!-- Sign up form -->
  <section class="signup">
    <div class="container">
      <div class="signup-content">
        <div class="signup-form">
          <h2 class="form-title">Sign up</h2>
          <form method="POST" class="register-form" id="frmRegister">
            <div class="form-group">
              <label for="txtUsername"><i class="zmdi zmdi-account material-icons-name"></i></label>
              <input type="text" name="username" id="txtUsername" placeholder="Username" autofocus required/>
            </div>
            <div class="form-group">
              <label for="txtName"><i class="zmdi zmdi-account-o"></i></label>
              <input type="text" id="txtName" name="name" placeholder="Your name" required/>
            </div>
            <div class="form-group">
              <label for="txtSecond_name"><i class="zmdi zmdi-accounts-outline"></i></label>
              <input type="text" id="txtSecond_name" name="second_name" placeholder="Your second name" required/>
            </div>
            <div class="form-group">
              <label for="txtEmail"><i class="zmdi zmdi-email"></i></label>
              <input type="email" name="email" id="txtEmail" placeholder="Your Email" required/>
            </div>
            <!-- Date of birth -->
            <div class="form-group">
              <label for="txtDOB"><i class="zmdi zmdi-calendar"></i></label>
              <input type="text" name="dob" id="txtDOB" placeholder="Date of birth" required/>
            </div>
            <div class="form-group">
              <label for="txtPassword"><i class="zmdi zmdi-lock"></i></label>
              <input type="password" name="rawpwd" id="txtPassword" placeholder="Password" required/>
            </div>
            <div class="form-group">
              <label for="txtRe_pass"><i class="zmdi zmdi-lock-outline"></i></label>
              <input type="password" id="txtRe_pass" placeholder="Repeat your password" required/>
            </div>
            <div class="form-group">
              <input type="checkbox" name="agree-term" id="agree-term" class="agree-term"/>
              <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
            </div>
            <div class="form-group form-button">
              <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
            </div>
          </form>
        </div>
        <div class="signup-image">
          <figure><img src="${pageContext.request.contextPath}/style/style-login/images/signup-image.jpg" alt="sing up image"></figure>
          <a href="${pageContext.request.contextPath}/Account/Login" class="signup-image-link">I am already member</a>
          <a href="${pageContext.request.contextPath}/Home" class="signup-image-link">Back to home</a>
        </div>
      </div>
    </div>
  </section>
</div>
<!-- JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" integrity="sha512-AIOTidJAcHBH2G/oZv9viEGXRqDNmfdPVPYOYKGy3fti0xIplnlgMHUGfuNRzC6FkzIo0iIxgFnr9RikFxK+sw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
  $('#frmRegister').on('submit', function (e){
    e.preventDefault();
    const username = $('#txtUsername').val();
    const password = $('#txtPassword').val();
    const re_pass = $('#txtRe_pass').val();
    if(password !== re_pass){
      alert("Password does not match!!!");
    }
    else
    {
      $.getJSON('${pageContext.request.contextPath}/Account/IsAvailable?user=' + username, function (data){
        if(data == true){
          if( $('#agree-term').is(':checked') )
          {
            $('#frmRegister').off('submit').submit();
            alert("Success!");
          }
          else {
            alert("You must agree all statements");
          }
        }
        else{
          alert('Username is not available.');
        }
      });
    }
  });

  $('#txtDOB').datetimepicker({
    format: 'd/m/Y',
    timepicker: false,
    mask: true
  });
</script>
</body>
</html>