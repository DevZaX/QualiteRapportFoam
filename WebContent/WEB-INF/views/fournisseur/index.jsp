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
                <h3>Qualite Rapport Foam</h3>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>QualiteRapportFoam/fournisseurs/index</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                
          <div class="container">
          		<div class="row">
          				<div class="col-md-12">
          						<form:form action="../fournisseurs/store" method="POST" modelAttribute="fournisseur">
          								<div class="form-group">
          										<form:input path="name" value="${fournisseur.name }" placeholder="name..."  class="form-control"/>
          								</div>
          								<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button> 
          						</form:form>
          				</div>
          		</div>
          </div>
          
          <hr>
          
          <div class="container">
          		<div class="row">
          				<div class="col-md-12">
          					<table class="table table-bordered">
          						<thead>
	          						<th>#</th>
	          						<th>Fournisseur</th>
	          						<th></th>
          						</thead>
          						<tbody>
          						<c:set var="count" value="0" scope="page" />
          						<c:forEach items="${items }" var="item">
          							<tr>
          							<c:set var="count" value="${count + 1}" scope="page"/>
          								<td><c:out value="${count}"></c:out></td>
          								<td><c:out value="${item.getName()}"></c:out></td>
          								<td><a href="../fournisseurs/<c:out value="${item.getId() }"></c:out>/delete" onClick="return confirm('confirmer le fait de la suppression d\'un fournisseur!')" type="button" class="btn btn-danger"><i class="fa fa-trash"></i></a></td>
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
            </div>
          </div>
        </div>
        <!-- /page content -->
        
        
       
      
         <%@ include file="../app/footer.jsp" %>
