<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.min.css" integrity="sha512-f0tzWhCwVFS3WeYaofoLWkTP62ObhewQ1EZn65oSYDZUg1+CyywGKkWzm8BxaJj5HGKI72PnMH9jYyIFz+GH7g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style-main/css/style-edit.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <title>Edit</title>
</head>
<body>
<div class="container-xl px-4 mt-4">
  <!-- Account page navigation-->
  <nav class="nav nav-borders">
    <a class="nav-link" href="${pageContext.request.contextPath}/Home">Home</a>
    <a class="nav-link active ms-0" href="${pageContext.request.contextPath}/Account/Profile">Profile</a>
    <a class="nav-link" href="edit-password.html">Security</a>
  </nav>
  <hr class="mt-0 mb-4">
  <div class="row">
    <div class="col-xl-4">
      <!-- Profile picture card-->
      <div class="card mb-4 mb-xl-0">
        <div class="card-header">Profile Picture</div>
        <div class="card-body text-center">
          <!-- Profile picture image-->
          <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
          <!-- Profile picture help block-->
          <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
          <!-- Profile picture upload button-->
          <button class="btn btn-primary" type="button">Upload new image</button>
        </div>
      </div>
    </div>
    <div class="col-xl-8">
      <!-- Account details card-->
      <div class="card mb-4">
        <div class="card-header">Account Details</div>
        <div class="card-body">
          <form>
            <!-- Form Row-->
            <div class="row gx-3 mb-3">
              <!-- Form Group (username)-->
              <div class="col-md-6">
                <label class="small mb-1" for="txtUsername">Username</label>
                <input class="form-control" name="username" id="txtUsername" type="text" placeholder="Enter your username">
              </div>
              <!-- Form Group (birthday)-->
              <div class="col-md-6">
                <label class="small mb-1" for="txtDOB">Birthday</label>
                <input class="form-control" id="txtDOB" type="text" name="dob" placeholder="Enter your birthday">
              </div>
            </div>
            <!-- Form Row-->
            <div class="row gx-3 mb-3">
              <!-- Form Group (first name)-->
              <div class="col-md-6">
                <label class="small mb-1" for="txtName">Name</label>
                <input class="form-control" name="name" id="txtName" type="text" placeholder="Enter your name">
              </div>
              <!-- Form Group (last name)-->
              <div class="col-md-6">
                <label class="small mb-1" for="txtSecondname">Second name</label>
                <input class="form-control" id="txtSecondname" name="second_name" type="text" placeholder="Enter your second name">
              </div>
            </div>
            <!-- Form Group (email address)-->
            <div class="mb-3">
              <label class="small mb-1" for="txtEmail">Email address</label>
              <input class="form-control" id="txtEmail" name="email" type="email" placeholder="Enter your email address">
            </div>
            <!-- Save changes button-->
            <button class="btn btn-primary" type="submit">Save changes</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" integrity="sha512-AIOTidJAcHBH2G/oZv9viEGXRqDNmfdPVPYOYKGy3fti0xIplnlgMHUGfuNRzC6FkzIo0iIxgFnr9RikFxK+sw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
  $('#txtDOB').datetimepicker({
    format: 'd/m/Y',
    timepicker: false,
    mask: true
  });
</script>
</body>
</html>
