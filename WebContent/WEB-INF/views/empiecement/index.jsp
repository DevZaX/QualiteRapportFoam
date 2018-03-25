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
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Acceuil > matiers premiers </h4>
              </c:if>
              <c:if test="${utilisateur.getLangue() == 'anglais' }">
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > matiers premiers </h4>
              </c:if>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                  <c:if test="${utilisateur.getLangue() == 'francais' }">
                    <h2>liste des matiers premieres</h2>
                    </c:if>
                    
                     <c:if test="${utilisateur.getLangue() == 'anglais' }">
                    <h2>raw materials</h2>
                    </c:if>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
     <div class="row">
        <div class="col-md-6 col-md-offset-2">
        <div>
        <form:form action="../empiecements/store" method="POST" modelAttribute="empiecement">
     	<table class="table">
     	    <c:if test="${utilisateur.getLangue() == 'francais' }">
     		<thead>
     			<th>ref</th>
     			<th>version</th>
     			<th>fournisseur</th>
     			<th>prix</th>
     			<th>projet</th>
     		</thead>
     		</c:if>
     		
     		 <c:if test="${utilisateur.getLangue() == 'anglais' }">
     		<thead>
     			<th>ref</th>
     			<th>version</th>
     			<th>supplier</th>
     			<th>price</th>
     			<th>project</th>
     		</thead>
     		</c:if>
     		
     		<tbody>
     			<tr>
     				<td><form:input required="required" path="ref" value="${ empiecement.ref}" placeholder="reference"/></td>
     				<td><form:input required="required" path="version" value="${ empiecement.version}" placeholder="version"/></td>
     				<td>
     					<select name="fournisseur" required="required">
						<c:forEach items="${items3 }" var="item3">
						<option><c:out value="${item3.getName()}"></c:out> </option>
						</c:forEach>
						</select>
     				</td>
     				<td><form:input required="required" path="price" value="${ empiecement.price}" placeholder="price" type="number" step="0.01"/></td>
     				<td>
	     				<select name="projet" required="required">
						<c:forEach items="${items2 }" var="item2">
						<option><c:out value="${item2.getTitle()}"></c:out> </option>
						</c:forEach>
						</select>
     				</td>
     				<td><button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button></td>
     			</tr>
     		</tbody>
     	
     	</table>
     	</form:form>
     	</div>
                  </div>
     </div>
                
                     
                     <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Réf</th>
                          <th>Version</th>
                          <th>Fournisseur</th>
                          <th>Prix</th>
                          <th>Projet</th>
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
	                      <td><c:out value="${item.getFournisseur() }"></c:out></td>
	                      <td><c:out value="${item.getPrice() }"></c:out> &euro;</td>
	                      <td><c:out value="${item.getProjet().getTitle() }"></c:out></td>
	                      
	                      <td>
	                      <a href="../empiecements/<c:out value="${item.getRef() }"></c:out>/delete" onClick="return confirm('confirmer le fait de la suppression d\'un utilisateur!')" type="button" class="btn btn-danger"><i class="fa fa-trash"></i></a>
	                       <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal<c:out value="${count}"></c:out>" data-whatever="@mdo"><i class="fa fa-pencil"></i></button>
	                      </td>
                   
                      
                        </tr>
                         <div class="modal fade" id="exampleModal<c:out value="${count}"></c:out>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="exampleModalLabel">Modifier une empiecement</h4>
							      </div>
							      <div class="modal-body">
							        <form action="../empiecements/update" method="POST">
							        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
											<div class="form-group">
											    <label>Nouveau Reference:</label>
											    <input name="ref" type="text" class="form-control"  value="${item.getRef() }" readonly="readonly">
											  </div>
											  
											  <div class="form-group">
											  <label>Nouvelle Version:</label>
											    <input name="version" type="text" class="form-control"  value="${item.getVersion() }">
											  </div>
											  
											  <div class="form-group">
											   <label>Nouveau Fournisseur:</label>
											    <input name="fournisseur" type="text" class="form-control"  value="${item.getFournisseur() }">
											  </div>
											  
											  <div class="form-group">
											  <label>Nouveau Prix:</label>
											    <input name="price" type="text" class="form-control"  value="${item.getPrice() }">
											  </div>
											  
											 
											  
											   <label>Modifier projet:</label>
											    <select name="projet" class="form-control">
												<c:forEach items="${elements }" var="element">
												<option><c:out value="${element.getTitle()}"></c:out> </option>
												</c:forEach>
												</select>
											  </div>
											  	
											  
																		         
							         
							          <div class="row">
							          <div class="col-md-3 col-md-offset-9">
							          <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-close"></i> </button>
							           <button  type="submit" class="btn btn-success" value="submit"><i class="fa fa-pencil"></i></button>
							          </div>
							          </div>
							          
							           
							        </form>
							      </div>
							      
							    </div>
							  </div>
						</div>
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
         <%@ include file="../app/footer.jsp" %>
