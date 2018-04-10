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
                  <div class="x_title">
                    <h2><u>Références</u></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  
                  
<%-- <c:if test="${utilisateur.getLangue() == 'francais' }">                 --%>
<c:if test="true">              
                  <div class="x_content">
        
        <div class="container">
        <form:form action="../projets/store" method="POST" modelAttribute="projetWrapper" enctype="multipart/form-data">
        	<button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button>
        	<a href="../projets/index" class="btn btn-success"><i class="fa fa-home"></i></a>
        	<div class="form-group">
        		<label class="control-label">titre de projet</label>
        		<form:input path="title" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">titre du famille</label>
        		<form:input path="famille" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">référence du piece</label>
        		<form:input path="ref" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">designation du piece</label>
        		<form:input path="version" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">choisir les images du piece</label>
        		<form:input  path="images" type="file" class="form-control" required="required" size="4048" multiple="multiple" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">choisir les postes où la piece controller</label>
        		<form:select path="posts" items="${postes }" itemLabel="title" itemValue="title" class="form-control" required="required" multiple="true"/>
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
 </c:if> 
 
 
       
         <%@ include file="../app/footer.jsp" %>
