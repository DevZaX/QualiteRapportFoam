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
                <h3><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > Controle d'Injection > index </h3>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Resultats</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                 
                
                     
                     <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>date</th>
                          <th>equipe</th>
                          <th>shift</th>
                          <th>matricule</th>
                          <th>ref</th>
                          <th>version</th>
                          <th>qte controller</th>
                          <th>qte accepter</th>
                          <th>qte retoucher</th>
                          <th>qte rejeter</th>
                          <th>defaut</th>
                          <th>zone</th>
                          <th>prototype</th>
                          <th></th>
                          
                        </tr>
                      </thead>
                      <tbody>
                      <c:set var="count" value="0" scope="page" />
                      <c:forEach items="${ controleInjectionIndexs}" var="controleInjectionIndex">
                        <tr>
                          <c:set var="count" value="${count + 1}" scope="page"/>
                          <th><c:out value="${count}"></c:out></th>
                          <td><c:out value="${controleInjectionIndex.getDate() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getEquipe() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getShift() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getMatricule() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getRef() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getVersion() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getQteController() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getQteAccepter()}"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getQteRetoucher() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getQteRejeter() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getDefaut() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getZone() }"></c:out></td>
	                      <td><c:out value="${controleInjectionIndex.getPrototype() }"></c:out></td>
	                      <td>
	                      <a href="../controle_injection/<c:out value="${controleInjectionIndex.getId() }"></c:out>/delete" onClick="return confirm('confirmer le fait de la suppression d\'un utilisateur!')" type="button" class="btn btn-danger"><i class="fa fa-trash"></i></a>
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
