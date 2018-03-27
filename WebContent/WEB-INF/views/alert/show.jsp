<%@ include file="../app/head.jsp" %>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
           

 

          
<%@ include file="../app/sidebarmenu2.jsp" %>

           
          </div>
        </div>

       <%@ include file="../app/topnavigation2.jsp" %>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > References > index </h3>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Liste des references</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
              <div class="container">
              	<h3>Numero de l'alert : <c:out value="${alert.getNumero() }"></c:out></h3>
              	<p>Date de creation : <c:out value="${alert.getDate_creation() }"></c:out></p>
              	<p>Type : <c:out value="${alert.getType() }"></c:out></p>
              	<p>Status : <c:out value="${alert.getStatus() }"></c:out></p>
                <p>Phase : <c:out value="${alert.getPhase() }"></c:out></p>
                <p>Chargeback : <c:out value="${alert.getChargeback() }"></c:out> &euro;</p>
                <a href="../../alerts/<c:out value="${alert.getNumero() }"></c:out>/close" class="btn btn-success">Close</a>
                
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"><i class="fa fa-pencil"></i></button>
                <a class="btn btn-warning" href="../../zone40f/<c:out value="${alert.getNumero() }"></c:out>/show">crieer une mouvement 40F</a>
              </div>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
        <!--  model  -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="exampleModalLabel">Modifier alert</h4>
							      </div>
							      <div class="modal-body">
							        <form action="../../alerts/update" method="POST">
							        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							        <input type="hidden" name="numero" value="${alert.getNumero() }">
											<div class="form-group">
											    <label>Phase:</label>
											    <select class="form-control" name="phase">
											    	<c:forEach items="${phases }" var="phase">
											    	<option><c:out value="${phase.getTitle() }"></c:out></option>
											    	</c:forEach>
											    	
											    </select>
											  </div>
											  
											  <div class="form-group">
											  <label>Chargeback :</label>
											    <input name="chargeback" type="text" class="form-control"  value="0">
											  </div>
											  
											  <div class="form-group">
											   <label>Type:</label>
											    <select class="form-control" name="type">
											    <option>qn</option>
											    <option>alert</option>
											    </select>
											  </div>
											  
											  
											  
											 
											  
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
         <%@ include file="../app/footer.jsp" %>
