<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>Qualite Rapport Foam</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/css/bootstrap.min.css' />"  rel="stylesheet">
    <!-- Font Awesome -->
    <link href="<c:url value='/css/font-awesome.min.css' />" rel="stylesheet">
    <!-- NProgress -->
    <link href="<c:url value='/css/nprogress.css' />"  rel="stylesheet">
    
    <!-- Datatables --> 
   <link href="<c:url value='/css/jquery.dataTables.min.css' />"  rel="stylesheet">
   
    <!-- Custom Theme Style -->
    <link href="<c:url value='/css/custom.min.css' />" rel="stylesheet">
    
    
     <!-- Morris css -->
    <link href="<c:url value='/css/morris.css' />" rel="stylesheet">
    <link rel="shortcut icon" href="images/icon.jpg">
  </head>