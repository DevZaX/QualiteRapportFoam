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
                <c:if test="${utilisateur.getLangue() == 'anglais' }">
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > families </h4>
                </c:if>
                <c:if test="${utilisateur.getLangue() == 'francais' }">
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Acceuil > familles</h4>
                </c:if>
              </div>

              
            </div>

         

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                 	<div class="x_content">
<div class="row">
	<div class="col-md-12">
		<h1>Réference : ${ref }</h1>
		<p>Date debut:${date_debut} - Date fin:${date_fin}</p>
	</div>
	<div class="col-md-12">
		<table class="table table-bordered" id="data">
			<thead>
				<th>Matricule</th>
				<th>Matricule emballeur</th>
				<th>Shift</th>
				<th>Prototype</th>
				<th>Equipe</th>
				<th>Code</th>
				<th>qte</th>
				<th></th>
			</thead>
			<tbody>
				<c:forEach items="${model}" var="e">
				<tr>
					<td>${e.getMatricule() }</td>
					<td>${e.getMatriculeControlleur() }</td>
					<td>${e.getShift() }</td>
					<td>${e.getPrototype() }</td>
					<td>${e.getEquipe() }</td>
					<td>${e.getCode() }</td>
					<td>${e.getQte() }</td>
					<td>
				    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><i class="fa fa-pencil"></i></button>
				    <!-- model -->
				    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
								  <div class="modal-dialog" role="document">
								    <div class="modal-content">
								      <div class="modal-header">
								        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								        <h4 class="modal-title" id="exampleModalLabel">New message</h4>
								      </div>
								      <div class="modal-body">
								        <form action="../defautControleMur/update" method="post">
								        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
								          <div class="form-group">
								            <label for="recipient-name" class="control-label">qte:</label>
								            <input name="id" type="hidden" class="form-control" value="${e.getId() }">
								             <input name="qte" type="number" class="form-control" value="${e.getQte() }">
								          </div>
								        <button type="submit">update</button>
								        </form>
								      </div>
								      <div class="modal-footer">
								        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								   
								      </div>
								    </div>
								  </div>
					 </div>
				    <!-- fin model -->
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
            </div>
          </div>
        </div>
        <!-- /page content -->
        
        
       
      
         <%@ include file="../app/footer.jsp" %>
