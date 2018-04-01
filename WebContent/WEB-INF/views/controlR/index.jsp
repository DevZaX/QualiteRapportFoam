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
                <h3><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home >Les controles de reception</h3>
                </c:if>
                
                 <c:if test="${utilisateur.getLangue() == 'anglais' }">
                <h3><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > Reception's controles</h3>
                </c:if>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                   
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                 
                  <div class="spacer2" >  
                  <form:form  action="store" method="POST"  modelAttribute="controlReceptionWrapper">
                  <table border="0" cellspacing="5">
                  						<c:if test="${utilisateur.getLangue() == 'francais' }">
                              			<tr>
                              				<td>Date creation:</td>
                              				<td>Ref:</td>
                              				<td>Numero de lot:</td>
                              				<td>Date de reception:</td>
                              				<td>Date de production:</td>
                              				<td>Quantite planifier:</td>
                              				<td>Quantite controller</td>
                              				<td>Quantite No Ok</td>
                              			</tr>
                              			</c:if>
                              			<c:if test="${utilisateur.getLangue() == 'anglais' }">
                              			<tr>
                              				<td>Creation date:</td>
                              				<td>Ref:</td>
                              				<td>Lot number :</td>
                              				<td>Reception date:</td>
                              				<td>Production date:</td>
                              				<td>Planified quantite:</td>
                              				<td>Controlled quantite</td>
                              				<td> No Ok quantite</td>
                              			</tr>
                              			</c:if>
                              			<tr>
                              				<td><input type="text" value="${date_creation}" readonly="readonly"/></td>
                              				<td><form:input  path="ref"  placeholder="ref"  value="${controlReceptionWrapper.ref }"/></td>
                              				<td>
                              				<form:input  path="numLot"  value="${controlReceptionWrapper.numLot}" placeholder="num lot"></form:input></td>
                              				<td><form:input  type="date" path="date_reception"  value="${controlReceptionWrapper.date_reception}"></form:input></td>
                              				<td><form:input  type="date" path="date_production"  value="${controlReceptionWrapper.date_production}"></form:input></td>
                              				<td><form:input  path="qte_planned" value="${controlReceptionWrapper.qte_planned }"/></td>
                              				<td><form:input  path="qte_controlled"  value="${controlReceptionWrapper.qte_controlled }"/></td>
                              				<td><form:input  path="qte_nonConfortable"  value="${controlReceptionWrapper.qte_nonConfortable }"/></td>
                              				<td><button type="submit" class="btn btn-success bl"><i class="fa fa-save"></i> </button></td>
                              				
                              			</tr>
                              			
                              		</table>
                              		
                  </form:form>  
                  </div> 
                  <div class="spacer2">
                  <table class="table table-bordered" id="data">
	                 		<thead>
	                 				<tr>
	                 						<th>#</th>
	                 						<th>Date creation</th>
	                 						<th>Utilisateur</th>
	                 						<th>Numero de controle</th>
	                 						<th>Réf</th>
	                 						<th>Version</th>
	                 						<th>Numero Lot</th>
	                 						<th>Planifier</th>
	                 						<th> quantite controller</th>
	                 						<th>quantite accepter</th>
	                 						<th>quantite no OK</th>
	                 						<th>Defauts</th>
	                 						<th>Fournisseur</th>
	                 						<th>Date Reception</th>
	                 						<th>Date Production</th>
	                 						<th></th>
	                 				</tr>
	                 		</thead>
	                 		<tbody>
	                 		<c:set var="count" value="0" scope="page" />
	                 		<c:forEach items="${controlRIndexs }" var="controlRIndex">
	                 				<tr>
	                 				<c:set var="count" value="${count + 1}" scope="page"/>
	                 					<th><c:out value="${count}"></c:out></th>
	                 					<td><c:out value="${controlRIndex.getDate_creation() }"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getUsername()}"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getNumero_control() }"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getRef() }"></c:out></td>	
	                 					<td><c:out value="${controlRIndex.getVersion()}"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getNumLot() }"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getQte_planned() }"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getQte_controlled() }"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getQte_accepter() }"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getQte_nonOK() }"></c:out></td>
	                 					<td>
<%-- 	                 						<c:out value="${controlRIndex.getDefautControlReceptions().size()}"></c:out> --%>
	                 					<c:if test="${controlRIndex.getDefautControlReceptions().size() == 0}">
	                 						<a class="btn btn-primary" href="../defaut_controle_reception/${controlRIndex.getNumero_control()}/create"><i class="fa fa-plus"></i></a>
	                 					</c:if>
	                 					<c:if test="${controlRIndex.getDefautControlReceptions().size() != 0}">
	                 						<a class="btn btn-primary" href="../defaut_controle_reception/${controlRIndex.getNumero_control()}/create"><i class="fa fa-eye"></i></a>
	                 					</c:if>
	                 					</td>
	                 					<td><c:out value="${controlRIndex.getFournisseur() }"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getDate_reception() }"></c:out></td>
	                 					<td><c:out value="${controlRIndex.getDate_production() }"></c:out></td>
	                 					<td>
	                 					<c:if test="${controlRIndex.getAlert_etat() == 0 }">
	                 						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal<c:out value="${count}"></c:out>" data-whatever="@mdo">Alert</button>
	                 					</c:if>
	                 					<c:if test="${controlRIndex.getAlert_etat() != 0 }">
	                 						<a href="../alerts/<c:out value="${ controlRIndex.getAlert_etat()}"></c:out>/show"  class="btn btn-danger"><i class="fa fa-eye"></i></a>
	                 					</c:if>
	                 					
	                 					<a onclick="return confirm('voulez vous supprimer cette controle ?')" href="${ controlRIndex.getNumero_control()}/delete" class="btn btn-danger"><i class="fa fa-trash"></i></a>
	                 					
	                 					</td>	
	                 				</tr>
	                 				<!-- model -->
                          <div class="modal fade" id="exampleModal<c:out value="${count}"></c:out>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="exampleModalLabel">Ajouter une alert</h4>
							      </div>
							      <div class="modal-body">
							        <form action="../alerts/store" method="POST">
							         <div class="form-group">
							            <label  class="control-label">Type</label>
							             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							            <input type="hidden" name="id" value="${controlRIndex.getNumero_control()}"/>
							            <select class="form-control" name="type">
							            <option>alert</option>
							            <option>qn</option>
							            </select>
							          </div>
							         
							         
							          <div class="row">
							          <div class="col-md-3 col-md-offset-9">
							          <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-close"></i> </button>
							           <button  type="submit" class="btn btn-success" value="submit"><i class="fa fa-check"></i></button>
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
        </div>
        <!-- /page content -->
       
         <%@ include file="../app/footer.jsp" %>
