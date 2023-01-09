<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <c:if test="${auth}">
      <div class="col">
        <!-- Account details card-->
        <div class="card mb-4">
          <div class="card-header">Account Details</div>
          <div class="card-body">
            <form action="${pageContext.request.contextPath}/Account/edit_profile" method="post">
              <!-- Form Row-->
              <div class="row gx-3 mb-3">
                <!-- Form Group (username)-->
                <div class="col-md-4">
                  <label class="small mb-1" for="txtUsername">Username</label>
                  <input class="form-control" name="username" id="txtUsername" type="text" value="${authUser.username} " readonly>
                </div>
                <!-- Form Group (name)-->
                <div class="col-md-4">
                  <label class="small mb-1" for="txtName">Name</label>
                  <input class="form-control" name="name" id="txtName" type="text" value="${authUser.name} " readonly>
                </div>
                <!-- Form Group (second_name)-->
                <div class="col-md-4">
                  <label class="small mb-1" for="txtSecondname">Name</label>
                  <input class="form-control" name="second_name" id="txtSecondname" type="text" value="${authUser.second_name} " readonly>
                </div>
              </div>
              <div class="row gx-3 mb-3">
                <!-- Form Group (issue_at)-->
                <div class="col-md-4">
                  <label class="small mb-1" for="txtIssue_at">Issue at</label>
                  <input class="form-control" name="issue_at" id="txtIssue_at" type="text" value="${authUser.issue_at} " readonly>
                </div>
                <!-- Form Group (expiration)-->
                <div class="col-md-4">
                  <label class="small mb-1" for="txtExpiration">Expiration</label>
                  <input class="form-control" name="expiration" id="txtExpiration" type="text" value="${authUser.expiration} days left" readonly>
                </div>
                <!-- Form Group (dob)-->
                <div class="col-md-4">
                  <label class="small mb-1" for="txtDOB">Day of Birth</label>
                  <input class="form-control" name="dob" id="txtDOB" type="datetime-local" value="${authUser.dob}" readonly>
                </div>
              </div>
              <div class="row gx-3 mb-3">
                <div class="col">
                  <label class="small mb-1" for="txtEmail">Email</label>
                  <input class="form-control" name="email" id="txtEmail" type="text" value="${authUser.email}" readonly>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
  </c:if>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-datetimepicker/2.5.20/jquery.datetimepicker.full.min.js" integrity="sha512-AIOTidJAcHBH2G/oZv9viEGXRqDNmfdPVPYOYKGy3fti0xIplnlgMHUGfuNRzC6FkzIo0iIxgFnr9RikFxK+sw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
</html>
