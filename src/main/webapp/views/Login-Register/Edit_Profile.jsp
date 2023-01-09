<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="style-main/css/style-edit.css">
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
    <a class="nav-link" href="index.html">Home</a>
    <a class="nav-link active ms-0" href="edit-profile.html">Profile</a>
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
            <!-- Form Group (username)-->
            <div class="mb-3">
              <label class="small mb-1" for="inputUsername">Username (how your name will appear to other users on the site)</label>
              <input class="form-control" id="inputUsername" type="text" placeholder="Enter your username">
            </div>
            <!-- Form Row-->
            <div class="row gx-3 mb-3">
              <!-- Form Group (first name)-->
              <div class="col-md-6">
                <label class="small mb-1" for="inputFirstName">First name</label>
                <input class="form-control" id="inputFirstName" type="text" placeholder="Enter your first name">
              </div>
              <!-- Form Group (last name)-->
              <div class="col-md-6">
                <label class="small mb-1" for="inputLastName">Last name</label>
                <input class="form-control" id="inputLastName" type="text" placeholder="Enter your last name">
              </div>
            </div>
            <!-- Form Row        -->
            <div class="row gx-3 mb-3">
              <!-- Form Group (organization name)-->
              <div class="col-md-6">
                <label class="small mb-1" for="inputOrgName">Organization name</label>
                <input class="form-control" id="inputOrgName" type="text" placeholder="Enter your organization name">
              </div>
              <!-- Form Group (location)-->
              <div class="col-md-6">
                <label class="small mb-1" for="inputLocation">Location</label>
                <input class="form-control" id="inputLocation" type="text" placeholder="Enter your location">
              </div>
            </div>
            <!-- Form Group (email address)-->
            <div class="mb-3">
              <label class="small mb-1" for="inputEmailAddress">Email address</label>
              <input class="form-control" id="inputEmailAddress" type="email" placeholder="Enter your email address">
            </div>
            <!-- Form Row-->
            <div class="row gx-3 mb-3">
              <!-- Form Group (phone number)-->
              <div class="col-md-6">
                <label class="small mb-1" for="inputPhone">Phone number</label>
                <input class="form-control" id="inputPhone" type="tel" placeholder="Enter your phone number">
              </div>
              <!-- Form Group (birthday)-->
              <div class="col-md-6">
                <label class="small mb-1" for="inputBirthday">Birthday</label>
                <input class="form-control" id="inputBirthday" type="text" name="birthday" placeholder="Enter your birthday">
              </div>
            </div>
            <!-- Save changes button-->
            <button class="btn btn-primary" type="button">Save changes</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</body>
</html>
