<%@ include file="../app/head.jsp" %>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
           

 

          
<%@ include file="../app/sidebarmenu.jsp" %>

           
          </div>
        </div>

       <%@ include file="../app/topnavigation.jsp" %>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <c:if test="${utilisateur.getLangue() == 'francais' }">
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Acceuil > Liste Réferences</h4>
                </c:if>
                <c:if test="${utilisateur.getLangue() == 'anglais' }">
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > References List</h4>
                </c:if>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><u>Références</u></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  
                  
<c:if test="${utilisateur.getLangue() == 'francais' }">                
                  <div class="x_content">
                  <div class="row">
                 
                 
                   
                  </div>
                  
                  <div class="row">
                  	<div class="col-md-12">
                  		 <form:form  id="form" action="../projets/store" method="POST" modelAttribute="projetWrapper">
                  		<table class="table table-bordered">
                  		<thead>
                  			<th>Nom projet</th>
                  			<th>Nom famille</th>
                  			<th>Réference</th>
                  			<th>Désignation</th>
                  			
                  			<th></th>
                  		</thead>
                  		<tbody>
                  			<tr>
                  				<td><form:input path="title" value="${ projetWrapper.title}" placeholder="projet" required="required"/></td>
                  				<td><form:input path="famille" value="${ projetWrapper.famille}" placeholder="famille" required="required"/></td>
                  				<td><form:input path="ref" value="${ projetWrapper.ref}" placeholder="ref" required="required"/></td>
                  				<td><form:input path="version" value="${ projetWrapper.version}" placeholder="version" required="required"/></td>
                  				
                  				<td><button type="submit" class="btn btn-success bl"><i class="fa fa-save" required></i> </button></td>		
                  			</tr>
                  		</tbody>
                  		</table>
                  		</form:form>
                  	</div>
                  </div>
                
                     <h3>liste des Références</h3>
                     <table id="data" class="table table-bordered">
                      <thead>
                        <tr>
                          <th style="background-color:#26B99A;color:white;">#</th>
                          <th style="background-color:#26B99A;color:white;">Réf</th>
                          <th style="background-color:#26B99A;color:white;">Version</th>
                          <th style="background-color:#26B99A;color:white;">Famille</th>
                          <th style="background-color:#26B99A;color:white;">Projet</th>
                         
                          <th></th>
                         
                         
                        </tr>
                      </thead>
                      <tbody>
                      <c:set var="count" value="0" scope="page" />
                      <c:forEach items="${ items}" var="item">
                        <tr>
                          <c:set var="count" value="${count + 1}" scope="page"/>
                          <th><c:out value="${count}"></c:out></th>
                          <td><c:out value="${item.getRef() }"></c:out></td>
                      <td><c:out value="${item.getVersion() }"></c:out></td>
                      <td><c:out value="${item.getFamille() }"></c:out></td>
                      <td><c:out value="${item.getTitle() }"></c:out></td>
                     
                      <td>
                           <a href="../projets/<c:out value="${item.getRef() }"></c:out>/delete" onClick="return confirm('voulez vous supprimer cette references ?')" type="button" class="btn btn-danger"><i class="fa fa-trash"></i></a>
                      </td>
                     
                        </tr>
                       
                          </c:forEach>
                      </tbody>
                    </table>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
 </c:if> 
 
 
    
 <c:if test="${utilisateur.getLangue() == 'anglais' }">
<div class="x_content">
                  <div class="row">
                 
               
                   
                  </div>
                  
                  <div class="row">
                  	<div class="col-md-12">
                  		 <form:form  id="form" action="../projets/store" method="POST" modelAttribute="projetWrapper">
                  		<table class="table table-bordered">
                  		<thead>
                  			<th>Project name</th>
                  			<th>Family name</th>
                  			<th>Reference</th>
                  			<th>Designation</th>
                  			
                  			<th></th>
                  		</thead>
                  		<tbody>
                  			<tr>
                  				<td><form:input path="title" value="${ projetWrapper.title}" placeholder="project" required="required"/></td>
                  				<td><form:input path="famille" value="${ projetWrapper.famille}" placeholder="family" required="required"/></td>
                  				<td><form:input path="ref" value="${ projetWrapper.ref}" placeholder="ref" required="required"/></td>
                  				<td><form:input path="version" value="${ projetWrapper.version}" placeholder="designation" required="required"/></td>
                  				
                  				<td><button type="submit" class="btn btn-success bl"><i class="fa fa-save"></i> </button></td>		
                  			</tr>
                  		</tbody>
                  		</table>
                  		</form:form>
                  	</div>
                  </div>
                
                     <h3>References list</h3>
                     <table id="data" class="table table-bordered">
                      <thead>
                        <tr>
                          <th  style="background-color:#26B99A;color:white;">#</th>
                          <th  style="background-color:#26B99A;color:white;">Réf</th>
                          <th  style="background-color:#26B99A;color:white;">Designation</th>
                          <th  style="background-color:#26B99A;color:white;">Family</th>
                          <th  style="background-color:#26B99A;color:white;">Project</th>
                      
                          <th></th>
                         
                         
                        </tr>
                      </thead>
                      <tbody>
                      <c:set var="count" value="0" scope="page" />
                      <c:forEach items="${ items}" var="item">
                        <tr>
                          <c:set var="count" value="${count + 1}" scope="page"/>
                          <th ><c:out value="${count}"></c:out></th>
                          <td><c:out value="${item.getRef() }"></c:out></td>
                      <td><c:out value="${item.getVersion() }"></c:out></td>
                      <td><c:out value="${item.getFamille() }"></c:out></td>
                      <td><c:out value="${item.getTitle() }"></c:out></td>
                    
                      <td>
                      	   <a href="../projets/<c:out value="${item.getRef() }"></c:out>/delete" onClick="return confirm('would you like to delete this reference ?')" type="button" class="btn btn-danger"><i class="fa fa-trash"></i></a>
                      </td>
                     
                        </tr>
                    
                          </c:forEach>
                      </tbody>
                    </table>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
 </c:if>   
       
         <%@ include file="../app/footer.jsp" %>
