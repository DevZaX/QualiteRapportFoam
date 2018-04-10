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
                  
                  
                  
              
                  <div class="x_content">
                     <table id="data" class="table table-bordered">
                     	<thead>
                     		<th style="background-color:#26B99A;color:white;">Référence</th>
                     		<th style="background-color:#26B99A;color:white;">Designation</th>
                     		<th style="background-color:#26B99A;color:white;">Prix d'appui-tete</th>
                     		<th style="background-color:#26B99A;color:white;">Prix de produit chimie</th>
                     		<th style="background-color:#26B99A;color:white;">Poids de produit chimie</th>
                     		<th></th>
                     	</thead>
                     	<tbody>
                     		<c:forEach items="${items }" var="e">
                     			<tr>
                     				<td>${e.getRef() }</td>
                     				<td>${e.getVersion() }</td>
                     				<td>${e.getPriceA() } &euro;</td>
                     				<td>${e.getPriceP() } &euro;</td>
                     				<td>${e.getPoidsP() } &euro;</td>
                     				<td><a href="../prix/${e.getRef() }/${e.getId() }/edit" class="btn btn-primary"><i class="fa fa-pencil"></i></a></td>
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

 
 
       
         <%@ include file="../app/footer.jsp" %>
