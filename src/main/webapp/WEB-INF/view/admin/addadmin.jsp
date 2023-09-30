<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Favicons -->
  <link href="../../../assets/img/favicon.jpg" rel="icon">
  <link href="../../../assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="../../../assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="../../../assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="../../../assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="../../../assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="../../../assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="../../../assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="../../../assets/css/Userstyle.css" rel="stylesheet">
    <!-- <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet"> -->
    <style>
      .error {
        color: red;
      }
      
    </style>
  </head>
  <body>
    <br>
    <div class="card mx-auto" style="width: 28rem; background-color: rgba(0,0,0,0.2); color:antiquewhite; width:45rem; margin-top:3rem;">
    <div class="card-header">
      <h2>Admin Sign Up</h2>

      <div class="card-body" style="margin-top: 20px;margin-bottom: 20px;padding: 20px;height: 500px;">
        <div class="row">
          <form:form action="/admin/addadmin" method="post" modelAttribute="admin">
            <div class="form-group">
                <label for="userName">User Name:</label>
                <form:input path="userName" class="form-control" id="userName" name="userName" />
              </div>
              <div class="form-group">
                <label for="emailId">Email:</label>
                <form:input path="emailId" type="email" class="form-control" id="emailId" name="email" />
              </div>
              <div class="form-group">
                <label for="mobileNumber">Mobile Numer:</label>
                <form:input path="mobileNumber" class="form-control" id="mobileNumber" name="mobileNumber" />
              </div>
              <div class="form-group">
                <label for="password">Password:</label>
                <form:input path="password" type="password" class="form-control" id="password" name="password" />
              </div>
              <div class="form-group">
                <label for="pwdConfirm">Confirm Password:</label>
                <input type="password" class="form-control" id="pwdConfirm" />
              </div>
            <div class="form-group">
              <button class="btn btn-primary" id ="submit">Sign UP</button>
            </div>
          </form:form>
          <p class="error" id="error"></p>
        </div>
      </div>
      </div>

    <script>
      // const form = document.querySelector("#signupForm");
      // const error = document.querySelector("#error");
      const password =document.querySelector("#password");
      const confirmPassword =document.querySelector("#pwdConfirm");

confirmPassword.addEventListener("input",function(){
  if (password.value !== confirmPassword.value) {
          error.textContent = "Passwords do not match";
        } else {
          error.textContent = "";
          // Perform signup action (e.g., send data to server)
        }
});
      // form.addEventListener("submit", e => {
      //   e.preventDefault();
      //   const name = document.querySelector("#username").value;
      //   const email = document.querySelector("#email").value;
      //   const pwd = document.querySelector("#password").value;
      //   const pwdConfirm = document.querySelector("#pwdConfirm").value;

      
      // });
    </script>
  </body>
</html>
