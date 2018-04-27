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
                <c:if test="${utilisateur.getLangue() == 'francais' }">
                <h1>les informations des postes où la piece ${model.get('ref') } controller</h1>
                </c:if>
                <c:if test="${utilisateur.getLangue() == 'anglais' }">
                <h1>List of posts where the part ${model.get('ref') } can be controlled</h1>
                </c:if>
               <a href="../../projets/index" class="btn btn-success"><i class="fa fa-home"></i></a>
               <div class="row">
               <div class="col-md-6 col-md-offset-3">
               <table class="table table-bordered">
               		<thead>
               		    <c:if test="${utilisateur.getLangue() == 'francais' }">
               			<th>réference</th>
               			<th>poste</th>
               			</c:if>
               			 <c:if test="${utilisateur.getLangue() == 'anglais' }">
               			<th>reference</th>
               			<th>post</th>
               			</c:if>
               		</thead>
               		<tbody>
               		<c:forEach items="${model.get('posts') }" var="e">
               		<tr>
               			<td>${model.get("ref") }</td>
               			<td>${e.getTitle() }</td>
               		</tr>
               		</c:forEach>
               		</tbody>
               </table>      
                   </div>
                    </div>
                    <div class="row">
                   		 <div class="col-md-12">       		 
            <form:form action="../../projets/update" method="POST" modelAttribute="projetWrapper" enctype="multipart/form-data">
             <input name="ref" value="${model.get('ref') }" type="hidden" />
        	<button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button>
        	<c:if test="${utilisateur.getLangue() == 'francais' }">
            <label class="control-label">choisir les images du piece</label>
            </c:if>
            <c:if test="${utilisateur.getLangue() == 'anglais' }">
            <label class="control-label">Choose part pictures</label>
            </c:if>
            <form:input  path="images" type="file" class="form-control"  size="1024" multiple="multiple" />
        	</div>
        	<div class="form-group">
        	<c:if test="${utilisateur.getLangue() == 'francais' }">
            <label class="control-label">choisir les postes où la piece controller</label>
            </c:if>
            <c:if test="${utilisateur.getLangue() == 'anglais' }">
            <label class="control-label">Choose the posts</label>
            </c:if>
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
        </div>
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
         
