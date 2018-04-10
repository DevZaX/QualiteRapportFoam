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
    <!-- jQuery -->
    <script src='<c:url value="/js/jquery.min.js" />'></script>
    <style>
    body{
	 	background-image: url("../images/417018.jpg");
	 	background-position: center;
	 	background-size: 100%;
	 	background-repeat: no-repeat;
	}
    </style>
  </head>
  
  <body>
  
  				<div class="container" style="margin-top:100px;">
  				<div class="row">
  					<div class="col-md-6 col-md-offset-3">
  						<center><img style="border-radius: 50%;margin-bottom:10px;" src="../images/lear.png" width="300" height="200" /></center>
  					</div>
  				</div>
  						<div class="row">
  							<div class="col-md-6 col-md-offset-3">
  								<form action="../controle_mur/auth" method="post">
  								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
  									<div class="form-group">
  										<input name="mat" style="padding:25px;" type="text" class="form-control" placeholder="Votre matricule">
  									</div>
  									<div class="form-group">
  										<input name="mat_c" style="padding:25px;" type="text" class="form-control" placeholder="Matricule de controlleur">
  									</div>
  									<div class="form-group">
  										<select name="shift" class="form-control">
  											<c:forEach items="${ shifts}" var="shift">
  												<option><c:out value="${ shift}"></c:out></option>
  											</c:forEach>
  										</select>
  									</div>
  									<div class="form-group">
  										<select name="zone" class="form-control">
  											<c:forEach items="${ zones}" var="zone">
  												<option><c:out value="${ zone}"></c:out></option>
  											</c:forEach>
  										</select>
  									</div>
  									<div class="form-group">
  										<select name="prototype" class="form-control">
  											<c:forEach items="${ prototypes}" var="prototype">
  												<option><c:out value="${ prototype}"></c:out></option>
  											</c:forEach>
  										</select>
  									</div>
  									<div class="form-group" class="form-control">
  										<select name="equipe" class="form-control">
  											<c:forEach items="${ equipes}" var="equipe">
  												<option><c:out value="${ equipe}"></c:out></option>
  											</c:forEach>
  										</select>
  									</div>
  									<div class="form-group">
  										<select name="poste" class="form-control">
  											<c:forEach items="${ postes}" var="poste">
  												<option><c:out value="${ poste}"></c:out></option>
  											</c:forEach>
  										</select>
  									</div>
  									<button type="submit" class="btn btn-primary btn-lg"><i class="fa fa-check"></i></button>
  								</form>
  							</div>
  						</div>
  				</div>

 
    
    <!-- Bootstrap -->
    <script src="<c:url value='/js/bootstrap.min.js' />"></script>
  </body>
</html>
  