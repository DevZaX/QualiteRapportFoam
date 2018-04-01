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
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
         <!-- /page content -->
<%@ include file="../app/footer.jsp" %>
