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
    <meta http-equiv="refresh" content="15">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Qualite Rapport Foam</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/css/bootstrap.min.css' />"  rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value='/css/font-awesome.min.css' />" rel="stylesheet">
    <!-- jQuery -->
    <script src='<c:url value="/js/jquery.min.js" />'></script>
  </head>
  
  <body onload="activer()">
  

   <div class="row">
   
   		<div class="col-md-8">
   			<div style="border-bottom: 1px solid black;width:100%;height:50px;">
   			<h1 style="text-align:center;color:red;">Contrôle</h1>
   			</div>
   			<div class="row" style="margin-top:10px;line-height: 0.6em">
   				<div class="col-md-6 col-md-offset-1">
   				<p>date</p>
   				<p>matricule</p>
   				<p>shift</p>
   				<p>zone</p>
   				<p>poste</p>
   				</div>
   				<div class="col-md-5">
   				<table>
   					<tr><td>reference</td><td>:</<td><input id="ref" type="text"></td></tr>
   				</table>
   				
   				<p>projet</p>
   				</div>
   			</div>
   			<div style="text-align:center;">
   				<button style="background-color: #1ECE79;padding:20px;color:white;border:0;margin-right:50px;width:100px;">ok</button>
   				<button style="background-color: #E20A35;padding:20px;color:white;border:0;margin-right:50px;width:100px;">scrap</button>
   				<button style="background-color: #4DD0E2;padding:20px;color:white;border:0;margin-right:50px;width:100px;">retouche1</button>
   				<button style="background-color: #305ED4;padding:20px;color:white;border:0;margin-right:50px;width:100px;">retouche2</button>
   			</div>
   			<div class="row">
   			<div class="col-md-offset-2">
   			<div style="margin-top:15px;">
   			<c:forEach var="i" begin="1" end="13">
   				<button style="background-color: #3898EC;border:0;padding:14px;color:white;">i600</button>
   			</c:forEach>
   			</div>
   			</div>
   			</div>
   			<div class="row">
   				<div class="col-md-2 col-md-offset-1" style="text-align:right;">
   				<div style="display: flex;">
   				<div>
   				<c:forEach var="i" begin="1" end="10">
   				<button style="background-color: #3898EC;border:0;padding:16px;color:white;margin-top:5px;">i600</button>
   				<br>
   				</c:forEach>
   				</div>
   				<div>
   				<c:forEach var="i" begin="1" end="10">
   				<button style="background-color: #3898EC;border:0;padding:16px;color:white;margin-top:5px;">i600</button>
   				<br>
   				</c:forEach>
   				</div>
   				</div>
   				</div>
   				<div class="col-md-6">
   				<div style="padding:5px;border:1px solid black;margin-top:5px;text-align:center;">
   				<img  src="../images/111.jpg" width="500" height="500">
   				</div>
   				</div>
   				<div class="col-md-3">
   				<div style="display: flex;">
   				<div>
   				<c:forEach var="i" begin="1" end="10">
   				<button style="background-color: #3898EC;border:0;padding:16px;color:white;margin-top:5px;">i600</button>
   				<br>
   				</c:forEach>
   				</div>
   				<div>
   				<c:forEach var="i" begin="1" end="10">
   				<button style="background-color: #3898EC;border:0;padding:16px;color:white;margin-top:5px;">i600</button>
   				<br>
   				</c:forEach>
   				</div>
   				</div>
   				</div>
   			</div>
   			
   			<div class="row">
   			<div class="col-md-offset-2">
   			<div style="margin-top:15px;">
   			<c:forEach var="i" begin="1" end="13">
   				<button style="background-color: #3898EC;border:0;padding:14px;color:white;">i600</button>
   			</c:forEach>
   			</div></div></div>
   			
   			
   		</div>
   		
   		<div class="col-md-4" style="border-left: 1px solid black;"> 
   			<div style="border-bottom: 1px solid black;width:100%;height:50px;" >
   			<h1 style="text-align:center;color:red;">Affichage des alertes</h1>
   			</div>
   			<div class="row" style="margin-top:15px;">
   				<div class="col-md-6">
   				<p>produit</p>
   				<p>reference</p>
   				<p>defaut</p>
   				<p>nombre de pieces</p>
   				<p>client</p>
   				</div>
   				<div class="col-md-6">
   				<p>date d'alert</p>
   				<p>date fin d'alert</p>
   				</div>
   			</div>
   			<div ><h2 style="text-align:center;color:red;">defaut</h2></div>
   			<div><img src="" alt="image" /></div>
   			<div><p>paragraph</p></div>
   		</div>
   
   </div>
     	
 
     <script>
    function activer(){
    	document.getElementById("ref").focus();
    }
   
    </script>
    <!-- Bootstrap -->
    <script src="<c:url value='/js/bootstrap.min.js' />"></script>
  </body>
</html>
  