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
        <c:if test="${utilisateur.getLangue() == 'francais' }">
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
        		<label class="control-label">prototype de projet</label>
        		<form:select path="prototype"  class="form-control" required="required">
        			<option>Serie</option>
        			<option>New Project</option>
        		</form:select>
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
        </c:if>
        
         <c:if test="${utilisateur.getLangue() == 'anglais' }">
        <form:form action="../projets/store" method="POST" modelAttribute="projetWrapper" enctype="multipart/form-data">
       
        	<button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button>
        	<a href="../projets/index" class="btn btn-success"><i class="fa fa-home"></i></a>
        	<div class="form-group">
        		<label class="control-label">Project title</label>
        		<form:input path="title" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">family title</label>
        		<form:input path="famille" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Project prototype</label>
        		<form:select path="prototype"  class="form-control" required="required">
        			<option>Serie</option>
        			<option>New Project</option>
        		</form:select>
        	</div>
        	<div class="form-group">
        		<label class="control-label">Part reference</label>
        		<form:input path="ref" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Part designation</label>
        		<form:input path="version" type="text" class="form-control" required="required" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Chose a picture for the part</label>
        		<form:input  path="images" type="file" class="form-control" required="required" size="4048" multiple="multiple" />
        	</div>
        	<div class="form-group">
        		<label class="control-label">Chose the posts for the part</label>
        		<form:select path="posts" items="${postes }" itemLabel="title" itemValue="title" class="form-control" required="required" multiple="true"/>
        	</div>
        </form:form>	
        </c:if>
        </div>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

 
 
       
         <%@ include file="../app/footer.jsp" %>
