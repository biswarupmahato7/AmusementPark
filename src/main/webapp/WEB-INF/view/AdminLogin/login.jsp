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
    <style>
      .error {
        color: red;
      }
    </style>
  </head>
  <body>
    <br>
    <div class="card mx-auto" style="width: 45rem; background-color: rgba(0,0,0,0.2); color:aliceblue; margin-top: 5rem;">
    <div class="card-header">
      <h2>Admin Login</h2>
      <!-- <br> -->

      <div class="card-body" style="margin-top: 20px;margin-bottom: 20px;padding: 20px;height: 250px;">
        <div class="row">
          <form:form action="/admin/validadmin" method="post" modelAttribute="admin">
            <div class="form-group">
                <label for="userName">UserName:</label>
                <form:input path="userName" class="form-control" id="userName" />
              </div>
             
              <div class="form-group">
                <label for="pwd">Password:</label>
                <form:input path="Password" type="password" class="form-control" id="pwd" />
              </div>
              
            <div class="form-group">
              <button class="btn btn-primary">Login</button>
            </div>
          </form:form>
          <p class="error" id="error"></p>
        </div>
      </div>
    </div>
</div>
    
  </body>
</html>
