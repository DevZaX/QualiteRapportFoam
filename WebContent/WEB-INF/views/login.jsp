<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/login.css" type="text/css" />
<style>
	body{
	 	background-image: url("images/417018.jpg");
	 	background-position: center;
	 	background-size: 100%;
	 	background-repeat: no-repeat;
	}
 .form-control:focus {
    border-color: #ff6666;
    box-shadow: 0 0 8px rgba(255, 102, 102,0.5);
}
</style>
</head>
<body>




<div class="container spacer3">    
        
    <div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3"> 
        
       
       
        <div class="panel panel-danger" >
            <div class="panel-heading">
                <div class="panel-title text-center">
                 <img src="images/lear1.png" width="320" height="86" />
                <h3 style="color:#FF5555;font-family: arial;font-weight: bold;">Rapport Qualite Foam</h3>
                </div>
            </div>     

            <div class="panel-body" >

                <form:form action="login" name="f" id="form" class="form-horizontal"  method="POST">
                   
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="user" type="text" class="form-control" name="username" value="" placeholder="User">                                        
                    </div>

                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input id="password" type="password" class="form-control" name="password" placeholder="Password">
                    </div>                                                                  

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-sm-12 controls">
                            <button type="submit" href="#" class="btn btn-danger pull-right"><i class="glyphicon glyphicon-log-in"></i> Log in</button>  
                            <a  href="users/recovery" class="btn btn-primary">Lost your password?</a>                          
                                                    
                        </div>
                    </div>

                </form:form>     

            </div>                     
        </div>  
    </div>
</div>

<div id="particles"></div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>