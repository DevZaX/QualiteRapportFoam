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
<!--     <meta http-equiv="refresh" content="10"> -->
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
   
   		<div class="col-md-8" style="border-right: 1px solid black;">
   			<div style="border-bottom: 1px solid black;width:100%;height:50px;">
   			<h1 style="text-align:center;color:red;">Contrôle</h1>
   			</div>
   			<div class="row" style="margin-top:10px;line-height: 0.6em">
   				<div class="col-md-6 col-md-offset-1">
   				<p><a href="../controle_injection/arreter" class="btn btn-danger">arreter</a></p>
   				<p>date : <c:out value="${sessionScope.date}" /></p>
   				<p>matricule :<c:out value="${sessionScope.mat}" /> </p>
   				<p>shift : <c:out value="${sessionScope.shift}" /> </p>
   				<p>zone : <c:out value="${sessionScope.zone}" /> </p>
   				<p>poste : <c:out value="${sessionScope.poste}" /> </p>
   				<p id="actuel"></p>
   				</div>
   				<input type="hidden" value="${sessionScope.mat}" id="mat">
   				<input type="hidden" value="${sessionScope.shift}" id="shift">
   				<input type="hidden" value="${sessionScope.zone}" id="zone">
   				
   				<input type="hidden" value="${sessionScope.mat_e}" id="matE">
   				<input type="hidden" value="${sessionScope.prototype}" id="prototype">
   				<input type="hidden" value="${sessionScope.equipe}" id="equipe">
   				<div class="col-md-5">
   				<table>
   					<tr><td>reference</td><td>:</td>
   					<form id="F" action='../controle_injection/get' method="post">
     				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   					<td><input id="ref" type="text" name="ref"  value="${ref }"></td>
   					<tr><td><p>projet : ${projet_title }</p></td></tr>
   					</form>
   					</tr>
   				</table>
   				
   				
   				</div>
   			</div>
   			<div style="text-align:center;">
   			<c:if test="${picture != null }">
   				<button id="ok" style="background-color: #1ECE79;padding:20px;color:white;border:0;margin-right:50px;width:100px;">ok</button>
   				<button id="scrap" style="background-color: #E20A35;padding:20px;color:white;border:0;margin-right:50px;width:100px;">scrap</button>
   				<button id="retouche1" style="background-color: #4DD0E2;padding:20px;color:white;border:0;margin-right:50px;width:100px;">retouche1</button>
   				<button id="retouche2" style="background-color: #305ED4;padding:20px;color:white;border:0;margin-right:50px;width:100px;">retouche2</button>
   			</c:if>
   			</div>
   			
   			<c:if test="${picture != null}">
   			<div class="row">
   			<div class="col-md-offset-2">
   			<!-- top -->
   			<div style="margin-top:15px;">
   			<c:forEach items="${defautsTop }" var="e">
   				<button onclick="add(this)" style="background-color: #3898EC;border:0;padding:14px;color:white;width:80px;"><c:out value="${e.getCode()}" /></button>
   			</c:forEach>
   			</div>
   			</div>
   			</div>
   			<div class="row">
   				<div class="col-md-2 col-md-offset-1">
   				<div style="display: flex;">
   				<!-- left-2 -->
   				<div>
   				<c:forEach items="${defautsLeft2 }" var="e">
   				<button onclick="add(this)" style="background-color: #3898EC;border:0;padding:16px;color:white;width:80px;margin-top:5px;margin-right:5px;"><c:out value="${e.getCode()}" /></button>
   				<br>
   				</c:forEach>
   				</div>
   				<!-- left-1 -->
   				<div>
   				<c:forEach items="${defautsLeft1 }" var="e">
   				<button onclick="add(this)" style="background-color: #3898EC;border:0;padding:16px;color:white;width:80px;margin-top:5px;"><c:out value="${e.getCode()}" /></button>
   				<br>
   				</c:forEach>
   				</div>
   				</div>
   				</div>
   				<div class="col-md-6">
   				<div style="padding:5px;border:1px solid black;margin:30px 20px;text-align:center;">
   				

   			
   				<img  src="data:image/jpeg;base64,${picture }" width="500" height="500">
   				
   				
   				</div>
   				</div>
   				<div class="col-md-3">
   				<div style="display: flex;">
   				<!-- right-1 -->
   				<div>
   				<c:forEach items="${defautsRight1 }" var="e">
   				<button onclick="add(this)" style="background-color: #3898EC;border:0;padding:16px;color:white;margin-top:5px;width:80px;"><c:out value="${e.getCode()}" /></button>
   				<br>
   				</c:forEach>
   				</div>
   				<!-- right-2 -->
   				<div>
   				<c:forEach items="${defautsRight2}" var="e">
   				<button onclick="add(this)" style="background-color: #3898EC;border:0;padding:16px;color:white;margin-top:5px;width:80px;"><c:out value="${e.getCode()}" /></button>
   				<br>
   				</c:forEach>
   				</div>
   				</div>
   				</div>
   			</div>
   			
   			<div class="row">
   			<div class="col-md-offset-2">
   			<!-- bottom -->
   			<div style="margin-top:15px;">
   			<c:forEach items="${defautsBottom }" var="e">
   				<button onclick="add(this)" style="background-color: #3898EC;border:0;padding:14px;color:white;width:80px;"><c:out value="${e.getCode()}" /></button>
   			</c:forEach>
   			</div></div></div>
   			
   			<div class="row">
   				<div class="col-md-6 col-md-offset-3">
   				<div style="margin-top:20px;">
   				<button class="btn btn-success" style="margin-right:5px;width:120px;height:120px;">
   				<h4>OK</h4>
   				<p id="s1">${ok }</p>
   				</button>
   				<button class="btn btn-danger" style="margin-right:5px;width:120px;height:120px;">
   				<h4>Scrap</h4>
   				<p id="s2">${scrap }</p>
   				</button>
   				<button class="btn btn-info" style="margin-right:5px;width:120px;height:120px;">
   				<h4>Retouche1</h4>
   				<p id="s3">${retouche1 }</p>
   				</button><button class="btn btn-warning" style="margin-right:5px;width:120px;height:120px;">
   				<h4>Retouche2</h4>
   				<p id="s4">${retouche2 }</p>
   				</button>
   				</div>
   				
   				</div>
   			</div>
   			</c:if>
   			
   		</div>
   		<c:if test="${alert != null }">
   		<div class="col-md-4"> 
   			<div style="border-bottom: 1px solid black;width:100%;height:50px;" >
   			<h1 style="text-align:center;color:red;">Affichage des alertes</h1>
   			</div>
   			<div class="row" style="margin-top:15px;">
   				<div class="col-md-6">
   				<p>produit : ${projet_title }</p>
   				<p>reference : ${ref }</p>
   				<p>defaut : ${alert.getDefaut() }</p>
   				<p>nombre de pieces : ${alert.getNbr_pieces() }</p>
   				<p>client : ${alert.getClient() }</p>
   				</div>
   				<div class="col-md-6">
   				<p>date d'alert : ${alert.getDate_alert() }</p>
   				<p>date fin d'alert : ${alert.getDate_fin_alert() }</p>
   				</div>
   			</div>
   			<div ><h2 style="text-align:center;color:red;">defaut : ${alert.getDefaut() }</h2></div>
   			<div><img src="data:image/jpeg;base64,${ alert_picture}" alt="image" width="500"  /></div>
   			<div style="margin-top:15px;"><center><b><p>${alert.getMsg() }</p></b></center></div>
   			
   		</div>
   		</c:if>
   
   </div>
   
   <script>
   function activer(){
   	$('#ref').focus();
   }
   </script>
     	
 <c:if test="${picture != null }">
     <script>
     
    var typeG = "";
    
    $('#scrap').click(function(){
    	typeG="scrap";
    	$('p#actuel').html('type actuel : scrap');
    	
    });
    $('#retouche1').click(function(){
    	typeG="retouche1";
    	$('#actuel').html('type actuel : retouche1');
    });
    $('#retouche2').click(function(){
 	    typeG="retouche2";
 	   $('#actuel').html('type actuel : retouche2');
 
    });
     
   
    
    $('#ok').click(function(){
    	if($('#ref').val() != ''){
    		
    		var data = {
    			 _csrf:'${_csrf.token}',
               	 ref:$('#ref').val(),
               	 code:'ok',
               	 type:'ok',
               	 equipe:$('#equipe').val(),
               	 matricule:$('#mat').val(),
               	 prototype:$('#prototype').val(),
               	 matriculeE:$('#matE').val(),
               	 shift:$('#shift').val(),
               	 zone:$('#zone').val()
    		}
    		
    		 $.ajax({
                 url:'${pageContext.request.contextPath}/controle_injection/store',
                 type:'post',
                 data:data, 
                 success:function(d){
                	 d = JSON.parse(d);
                	 $('#s1').html('');
                     $('#s1').html(d.ok);
                     $('#s2').html('');
                     $('#s2').html(d.scrap);
                     $('#s3').html('');
                     $('#s3').html(d.retouche1)
                     $('#s4').html('');
                     $('#s4').html(d.retouche2)
                     $('#ref').val("");
                	 $('#actuel').html('controle ajouter avec success !');
                	 setTimeout(() => {
                       $('#actuel').html('');
					}, 1500);
                 }
        });	
    	}
    	$('#ref').focus();
    });
    
    function add(x){
    	if($('#ref').val() != '' && typeG != ''){
    		var data = {
       			 _csrf:'${_csrf.token}',
                  	 ref:$('#ref').val(),
                  	 code:x.innerHTML,
                  	 type:typeG,
                  	 equipe:$('#equipe').val(),
                  	 matricule:$('#mat').val(),
                  	 prototype:$('#prototype').val(),
                  	 matriculeE:$('#matE').val(),
                  	 shift:$('#shift').val(),
                  	 zone:$('#zone').val()
       		}
       		
       		 $.ajax({
                    url:'${pageContext.request.contextPath}/controle_injection/store',
                    type:'post',
                    data:data, 
                    success:function(d){
                    	d = JSON.parse(d);
                    	 $('#s1').html('');
                    	 $('#s1').html(d.ok);
                    	 $('#s2').html('');
                         $('#s2').html(d.scrap);
                         $('#s3').html('');
                         $('#s3').html(d.retouche1)
                         $('#s4').html('');
                         $('#s4').html(d.retouche2)
                        $('#ref').val("");
                    	 $('#actuel').html('controle ajouter avec success !');
                    	 setTimeout(() => {
                             $('#actuel').html('');
      					}, 1500);
                    }
           });	
    		
    	}
    	$('#ref').focus();
    }
  
    </script>
    </c:if>
    <!-- Bootstrap -->
    <script src="<c:url value='/js/bootstrap.min.js' />"></script>
  </body>
</html>
  