<%@ include file="../app/head.jsp" %>
<style>
.tableTD{margin-right:10px;width:150px;}
</style>

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

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                  
                    <c:if test="${utilisateur.getLangue() == 'francais' }">
                    <h2>les prix et les poids de chaque famille</h2>
                    </c:if>
                    
                     <c:if test="${utilisateur.getLangue() == 'anglais' }">
                    <h2>family prices and weights</h2>
                    </c:if>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                
                <div class="container"> 
                	<form action="../../zone40f/store" method="post">
                	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                	
                	<table>
                		<thead>
                			<th>numero d'alert</th>
                			<th>quantité</th>
                			<th>id_mgz</th>
                			<th>emplacement</th>
                			<th><button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button></th>
                		</thead>
                		<tbody>
                			<tr>
                				<td class="tableTD"><input type="text" name="id_alert" required="required" placeholder="numero d'alert" value="<c:out value='${id_alert }'></c:out>" readonly="readonly"></td>
                				<td class="tableTD"><input type="number" name="qte" required="required" placeholder="quantite"></td>
                				<td class="tableTD"><input type="text" name="id_mgz" required="required" placeholder="id_mgz"></td>
                				<td class="tableTD"><input type="text" name="emplacement" required="required" placeholder="emplacement"></td>
                			</tr>
                		</tbody>
                	</table>
                	</form>
                </div>
                <br>
                 <div class="container">
              	<table id="data" class="table table-bordered spacer3">
              		<thead>
              			<th style="background-color:#26B99A;color:white;">Numero d'alert</th>
              			<th style="background-color:#26B99A;color:white;">Date de mouvement</th>
              			<th style="background-color:#26B99A;color:white;">Quantité</th>
              			<th style="background-color:#26B99A;color:white;">id_mgz</th>
              			<th style="background-color:#26B99A;color:white;">emplacement</th>
              			<th style="background-color:#26B99A;color:white;">Date de sortie</th>
              			<th></th>
              		</thead>
              		<tbody>
              			<c:forEach items="${ zone40fs}" var="e">
              				<tr>
              					<td><c:out value="${e.getAlert() }"></c:out></td>
              					<td><c:out value="${e.getDate_mouvement() }"></c:out></td>
              					<td><c:out value="${e.getQte() }"></c:out></td>
              					<td><c:out value="${e.getId_mgz() }"></c:out></td>
              					<td><c:out value="${e.getEmplacement() }"></c:out></td>
              					<td><c:out value="${e.getDate_sortie() }"></c:out></td>
              					<td>
              						<a onclick="return confirm('voulez vous supprimer cette donnée ?')" class="btn btn-danger" href="../../zone40f/${ e.getId()}/delete"><i class="fa fa-trash"></i></a>
              						<c:if test="${e.getDate_sortie() == null }">
              						<a class="btn btn-danger" href="../../zone40f/${ e.getId()}/close"><i class="fa fa-close"></i></a>
              						</c:if>
              						<a href="../../zone40f/${e.getId() }/edit" class="btn btn-primary"><i class="fa fa-pencil"></i></a>
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
