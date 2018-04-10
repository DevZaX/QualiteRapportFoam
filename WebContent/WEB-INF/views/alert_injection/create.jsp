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
        
        <div class="container">
        <form:form action="../alert_injection/store" method="POST" modelAttribute="alertInjectionWrapper" enctype="multipart/form-data">
        	<button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button>
        	<a href="../alert_injection/index" class="btn btn-success"><i class="fa fa-home"></i></a>
        	
        	<div class="form-group">
        		<label class="control-label">Defaut</label>
        		<form:input path="defaut" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Nombre des pieces</label>
        		<form:input path="nbr_pieces" type="number" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Client</label>
        		<form:input path="client" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Date de creation</label>
        		<form:input  path="date_alert" type="date" class="form-control" required="required"  />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Date de fin d'alert</label>
        		<form:input path="date_fin_alert" type="date"  class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Image</label>
        		<form:input path="image" type="file"  class="form-control" required="required" size="1024" accept=".jpg, .jpeg, .png" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">message</label>
        		<form:textarea path="msg" cols="30" rows="5"  class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Projets</label>
        		<form:select multiple="true" class="form-control" path="id" items="${projets }" itemLabel="title" itemValue="id"></form:select>
        	</div>
        </form:form>	
        </div>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

 
 
       
         <%@ include file="../app/footer.jsp" %>
