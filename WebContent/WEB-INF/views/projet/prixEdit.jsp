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
        <form:form action="../../../prix/update" method="POST" modelAttribute="prixWrapper">
        	<button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button>
        	<a href="../prix/index" class="btn btn-success"><i class="fa fa-home"></i></a>
        	<div class="form-group">
        		<label class="control-label">Référence</label>
        		<form:input path="ref" type="text" class="form-control" readonly="true" />
        		<form:input path="id" type="hidden" class="form-control" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Designation</label>
        		<form:input path="version" type="text" class="form-control" readonly="true" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Prix d'appui-tete</label>
        		<form:input path="priceA" type="number" class="form-control" required="required" step="0.01" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Prix de produit chimie</label>
        		<form:input path="priceP" type="number" class="form-control" required="required" step="0.01" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Poids de produit chimie</label>
        		<form:input  path="poidsP" type="number" class="form-control" required="required" step="0.01" />
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
