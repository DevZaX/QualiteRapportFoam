<%@ include file="../app/head.jsp" %>

  <body class="nav-md">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
           

 

          
<%@ include file="../app/sidebarmenu2.jsp" %>

           
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
                    <h2><u>Références</u></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                <div class="row">
                <div class="col-md-12">
                <p>numero de controle : <c:out value="${ id}"></c:out></p>
                </div>
                
                 <div class="row">
                 <div class="col-md-2">
                 <form action="../../defaut_controle_reception/${id }/store" method="POST">
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                 <table class="table">
                 	<thead>
                 		<th>defaut</th>
                 		<th>quantite</th>
                 		<th><button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button></th>
                 		<th><a href="../../controlR/index" class="btn btn-success"><i class="fa fa-arrow-left"></i></a></th> 
                 	</thead>
                 	<tbody>
                 	<tr>
                 		<td>
                 			<select name="defaut">
                 			<c:forEach items="${defautReceptions }" var="e">
                 				<option><c:out value="${ e.getTitle()}"></c:out></option>
                 			</c:forEach>
                 			</select>
                 		</td>
                 		<td><input type="number" name="qte"> </td>
                 	</tr>
                 	</tbody>
                 </table>
                 </form>
                 </div>
                 </div> 
                 </div>
                 
                   <div class="row">
                   		<div class="col-md-12">
                   			<table class="table">
                   				<thead>
                   					<th> code de defaut</th>
                   					<th> titre de defaut</th>
                   					<th> quantite</th>
                   				</thead>
                   				<tbody>
                   				<c:forEach items="${ defautControlReceptions}" var="e">
                   				<c:if test="${e.getEtat() != 0 }">
                   				<tr>
                   					<td><c:out value="${e.getCode() }"></c:out></td>
                   					<td><c:out value="${e.getTitle() }"></c:out></td>
                   					<td><c:out value="${e.getQte() }"></c:out></td>
                   					<td><a onclick="return confirm('voulez vous supprimer cette defaut?')" class="btn btn-danger" href="../${ e.getId()}/delete"><i class="fa fa-trash"></i></a></td>
                   				<tr>
                   				</c:if>
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
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
