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
  </head>
  
  <body>
  
  <div class="container">
  
  <div class="row">
  <div class="col-md-11 col-md-offset-1">
      <h2>Réf:</h2>
  </div>
  </div>
  
  <div class="row">
  <div class="col-md-4">
      <h3>Date:</h3>
  </div>
   <div class="col-md-4">
      <h3>Zone:</h3>
  </div>
   <div class="col-md-4">
      <h3>Prototype:</h3>
  </div>
  </div>
  
   <div class="row">
  <div class="col-md-4">
    <h3>Matricule:</h3> 
  </div>
  <div class="col-md-4">
     <h3>Shift:</h3>
  </div>
  <div class="col-md-4">
     <h3>Equipe:</h3>
  </div>
  </div>
  
  
  
  <div class="row">
  <div class="col-md-12">
  <h3>liste des defauts</h3>
<table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Code</th>
                          <th>Defaut</th>
                          <th>Retouche</th>
                          <th>Scrap</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:set var="count" value="0" scope="page" />
                      <c:forEach items="${items }" var="item">
                       <c:set var="count" value="${count + 1}" scope="page"/>
                      <tr>
                          <th><c:out value="${count}"></c:out></th>
                          <td><c:out value="${item.getCode()}"></c:out></td>
                          <td><c:out value="${item.getTitle()}"></c:out></td>
                          <td>@twitter</td>
                          <td>@twitter</td>
                        </tr>
                       </c:forEach>
                        
                      </tbody>
                    </table>
  </div>
  </div>
  
  
  </div>
  
  </body>
     <!-- footer content -->
        <footer>
          <div class="pull-right">
            Lear Corporation - Qualite Rapport Foam - zakariae aboud
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

    <!-- jQuery -->
    <script src='<c:url value="/js/jquery.min.js" />'></script>
    <!-- Bootstrap -->
    <script src="<c:url value='/js/bootstrap.min.js' />"></script>
  </body>
</html>