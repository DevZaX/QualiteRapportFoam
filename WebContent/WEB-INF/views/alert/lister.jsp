e<%@ include file="../app/head.jsp" %>
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
                  		<div class="container">
                  			<form action="../../alerts/index" method="post">
                  				<select name="phase" onchange="this.form.submit()">
                  					<c:forEach items="${items }" var="i">
                  						<option>${i }</option>
                  					</c:forEach>
                  					
                  				</select>
                  			</form>
                  		</div>
                  		<div class="container">
                  		<table id="data" class="table table-bordered">
                  	<thead>
                  	<th>#</th>
                  	<th>Date creation</th>
                  	<th>Version</th>
                  	<th>Numero</th>
                  	<th>Status</th>
                  	<th>Phase</th>
                  	<th>Type</th>
                  	<th>Date fermeture</th>
                  	<th>Chargeback</th>
                  	<th></th>
                  	</thead>
                  	<tbody>
                  	<c:set var="count" value="0" scope="page" />
                  	<c:forEach items="${ dangers}" var="alert">
                  		<tr>
                  			<c:set var="count" value="${count + 1}" scope="page"/>
                  			<td><c:out value="${count}"></c:out></td>
                  			<td><c:out value="${alert.getDate_creation()}"></c:out></td>
                  			<td><c:out value="${alert.getControlReception().getEmballage().getEmpiecement().getVersion()}"></c:out></td>
                  			<td><c:out value="${alert.getNumero()}"></c:out></td>
                  			<td><c:out value="${alert.getStatus()}"></c:out></td>
                  			<td><c:out value="${alert.getPhase()}"></c:out></td>
                  			<td><c:out value="${alert.getType()}"></c:out></td>
                  			<td><c:out value="${alert.getDate_close()}"></c:out></td>
                  			<td><c:out value="${alert.getChargeback()}"></c:out> &euro;</td>
                  			<td>
                  			<a href="../alerts/${alert.getNumero() }/show" class="btn btn-primary"><i class="fa fa-eye"></i></a>
                  			<a href="../alerts/${alert.getNumero()}/delete" onclick="return confirm('vous voulez supprimer cette alert ?')" class="btn btn-danger"><i class="fa fa-trash"></i></a>
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
         <!-- /page content -->
<%@ include file="../app/footer.jsp" %>
