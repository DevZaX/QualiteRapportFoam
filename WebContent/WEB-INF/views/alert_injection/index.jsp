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
                 <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > Liste des zones des robots</h4>
                 </c:if>
                 
                  <c:if test="${utilisateur.getLangue() == 'anglais' }">
                  <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > Robots zones list</h4>
                  </c:if>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  
                 <div class="x_content">
                 <a href="../alert_injection/create" class="btn btn-success"><i class="fa fa-plus"></i></a>
                 <c:if test="${msgs.size() != 0 }">
                 <c:forEach items="${msgs }" var="x">
                 	<div class="alert alert-danger">
                   <p>${x }</p>
                   	</div>
                 </c:forEach>
                 </c:if>
                 <table id="data" class="table table-bordered">
                 	<thead>
                 	    <th style="background-color:#26B99A;color:white;">defaut</th>
                 		<th style="background-color:#26B99A;color:white;">projet id</th>
                 		<th style="background-color:#26B99A;color:white;">Date de creation</th>
                 		<th style="background-color:#26B99A;color:white;">Date fin d'alert</th>
                 		<th></th>
                 	</thead>
                 	<tbody>
                 		<c:forEach items="${alertInjections }" var="e">
                 			<tr>
                 				<td></td>
                 				<td>${e.getProjet_id() }</td>
                 				<td>${e.getDefaut() }</td>
                 				<td>${e.getDate_alert() }</td>
                 				<td>${e.getDate_fin_alert() }</td>
                 				<td>
                 					<a href="../alert_injection/${e.getId() }/edit" class="btn btn-primary"><i class="fa fa-pencil"></i></a>
                 					<a href="../alert_injection/${e.getId() }/show" class="btn btn-warning"><i class="fa fa-eye"></i></a>
                 					<a href="../alert_injection/${e.getId() }/delete" class="btn btn-danger"><i class="fa fa-trash"></i></a>
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
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
