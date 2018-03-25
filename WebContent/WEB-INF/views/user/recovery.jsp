<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Qualite Rapport Foam</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/css/bootstrap.min.css' />"  rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value='/css/font-awesome.min.css' />" rel="stylesheet">
    
    <style>
    .center-div{margin-top: 250px;margin-left:auto;margin-right:auto;}
    </style>
   
  </head>
  
  <body>
  
  <div class="container">
  <div class="center-div">
 <div class="row">
   <div class="col-md-6 col-md-offset-4">
   <h2>Recuperer votre mote de passe </h2>
   <form action="../users/forgot" method="POST">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="form-group">
  <label class="control-label">Ecrire votre nom d'utilisateur</label>
  <input value='<c:out value="${user.getUsername() }"></c:out>' type="text" name="username" class="form-control" required="required"/>
  </div>
  
  <p><c:out value="votre indication est :${indice }"></c:out></p>
  <button class="btn btn-danger"><i class="fa fa-check"></i></button>
  </form>
   </div>
 </div> 
  </div>
  
  </div>
  
  </body>
  
  </html>