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
  

     	<div class="row" style="margin-top:50px;">
     	<div class="col-md-4 col-md-offset-4">
     		
     		<form id="F" action='../getControlInjectionByRefAndDate' method="post">
     		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     			<div class="form-group"> 
     				<input id="id" name="ref" class="form-control" value="${ ref }" type="text"  />
     			</div>
     		</form>	
     			
     	</div>	
     	</div>
     	<div class="row" style="margin-top:50px;">
     		<div class="col-md-12">
     			<table class="table">
     				<thead>
     				<th>Code</th>
     				<th>Defaut</th>
     				
     				<th>Retouche</th>
     				<th>Scrap</th>
     				</thead>
     				<tbody>
     				
     				
     				
     				
     			    <c:set var="count" value="0" scope="page" />
     				<c:forEach items="${defautInjectionVues }" var="e">
     				<c:set var="count" value="${count + 1}" scope="page"/>
     				<tr>
     					<td><c:out value="${e.getCode() }"></c:out></td>
	     				<td><c:out value="${e.getTitle() }"></c:out></td>
	     				<td>
	     				  <form  action="../controle_injection/storeRetouche" method="POST">
	     				  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	     				  <input name="code" type="hidden" value="${e.getCode() }">
	     				  <input name="title" type="hidden" value="${e.getTitle() }">
	     				  <input name="type" type="hidden" value="Retouche">
	     				  <input name="ref" type="hidden" value="${ref }" >
	     				  <input name="qte" type="numerique" style="width:50px;" value="${e.getQteR() }">	     			
	     				  <button type="submit">+</button>
	     				
	     				  </form>  
	     				</td>
	     				<td>
	     				    <form  action="../controle_injection/storeScrap" method="POST">
	     				    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	     				    <input name="code" type="hidden" value="${e.getCode() }">
	     				    <input name="title" type="hidden" value="${e.getTitle() }">
	     				    <input name="type" type="hidden" value="Scrap">
	     				    <input name="ref" type="hidden" value="${ref }" >
		     				 <input  name="qte" type="numerique" style="width:50px;" value="${e.getQteS() }">
	     				    <button type="submit">+</button>
	     				    </form>
	     				</td>
	     				</tr>
	     			</c:forEach>	
     			
     				
	     				
	     				
     				
     				</tbody>
     			</table>
     		</div>
     	</div>
     	
     	<c:if test="${entre }">
     		<script>
     			document.getElementById("F").submit();
     		</script>
     	</c:if>

    <script>
    function activer(){
    	document.getElementById("id").focus();
    }
   
    </script>
    <!-- Bootstrap -->
    <script src="<c:url value='/js/bootstrap.min.js' />"></script>
  </body>
</html>
  