<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.laptop.pojo.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Laptop Center</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      
    
    </style>
    <link href="css/bootstrap-responsive.css" rel="stylesheet">

    
  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Laptop Center</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Brand Options <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Dell</a></li>
                     <li class="divider"></li>
                  <li><a href="lenovo-home.jsp">Lenovo</a></li>
                     <li class="divider"></li>
                  <li><a href="#">Sony</a></li>
                    <li class="divider"></li>
                 <li><a href="#">HP</a></li>
                </ul>
              </li>
            </ul>
         
          </div><!--/.nav-collapse -->
          
          <div class="nav-collapse collapse pull-right">
          <%
          String userName = "";
             if(session.getAttribute("user")!=null)
             {
            	 User userDto = (User)session.getAttribute("user");
            	 userName = userDto.getUsername();
             }
          
          %>
            <ul class="nav">
            <li style = "color:white; padding-top:10px;"><i class="icon-user icon-white"></i> <%= userName%> </li>
            <li><a href="#" > Logout</a></li>
            
        	</ul>
           
       </div>
        </div>
      </div>
    </div>

    <div class="container">
    
       <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src="img/Lenovo.jpg" alt="">
        <!--    <div class="container">
            <div class="carousel-caption">
              <h1>Example headline.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="#">Sign up today</a>
            </div>
          </div> -->
        </div>
        <div class="item">
          <img src="img/Lenovo.jpg" alt="">
        <!--   <div class="container">
            <div class="carousel-caption">
              <h1>Another example headline.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="#">Learn more</a>
            </div>
          </div> -->
        </div>
        <div class="item">
        <img src="img/Lenovo.jpg" alt="">
         <!--   <div class="container">
            <div class="carousel-caption">
              <h1>One more for good measure.</h1>
              <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <a class="btn btn-large btn-primary" href="#">Browse gallery</a>
            </div>
          </div> -->
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div><!-- /.carousel -->
      <!-- Main hero unit for a primary marketing message or call to action -->
      <div class="well">
        <h1>Welcome to Laptop Center!</h1>
        <p><h4> One stop shop for your kind of laptop. Select the brand that suits your needs and get started. </h4></p>
      
      </div>
       <!-- Example row of columns -->
      <div class="row-fluid">
            <ul class="thumbnails">
              <li class="span3">
                <div class="thumbnail">
                  <img data-src="" alt="">
                  <div class="caption">
                    <h3>Dell Laptops</h3>
                    <p>For more than 28 years, Dell has empowered countries, communities, customers and people everywhere to use technology to realize their dreams.</p>
                    <p><a href="#" class="btn btn-primary">Start Here</a> </p>
                  </div>
                </div>
              </li>
              <li class="span3">
                <div class="thumbnail">
                  <img data-src="" alt="">
                  <div class="caption">
                    <h3>Lenovo Laptops</h3>
                       <p>Lenovo strives to be a new world company that makes award-winning PCs for our customers. They design innovative for their customers needs.</p>
                    <p><a href="lenovo-home.jsp" class="btn btn-primary">Start Here</a> </p>
                  </div>
                </div>
              </li>
              <li class="span3">
                <div class="thumbnail">
                  <img data-src="" alt="">
                  <div class="caption">
                    <h3>Sony Laptops</h3>
                      <p>Customize a VAIO PC exactly the way you want, exclusively at Sony Store. Select a the right VAIO PC tailored to your exact specifications.</p>
                    <p><a href="#" class="btn btn-primary">Start Here</a> </p>
                  </div>
                </div>
              </li>
               <li class="span3">
                <div class="thumbnail">
                  <img data-src="" alt="">
                  <div class="caption">
                    <h3>HP Laptops</h3>
                      <p>HP focuses on building the best laptops in the market with the latest technology available in the market to provide value for customer's money.'</p>
                    <p><a href="#" class="btn btn-primary">Start Here</a> </p>
                  </div>
                </div>
              </li>
            </ul>
          </div>
     
      <hr>

      <footer>
        <p>&copy; Laptop Center 2013</p>
      </footer>

    </div> <!-- /container -->

    <!-- 
    ================================================== -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
     <script>
      !function ($) {
        $(function(){
          // carousel demo
          $('#myCarousel').carousel()
        })
      }(window.jQuery)
    </script>

  </body>
</html>
