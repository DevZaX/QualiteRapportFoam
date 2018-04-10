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
                      
 <form:form action="../../alert_injection/update_picture" method="POST" modelAttribute="alertInjectionWrapper" enctype="multipart/form-data">
	 <button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button>
	 <a href="../../alert_injection/index" class="btn btn-success"><i class="fa fa-home"></i></a>
	 <div class="form-group">
        		<label class="control-label">Image</label>
        		<form:input path="image" type="file"  class="form-control" required="required" size="1024" accept=".jpg, .jpeg, .png" />
        		<input type="hidden" name="id" value="${id }">
     </div>
 </form:form>
                      
 <img src="data:image/jpeg;base64,${ alert_picture}" width="500" height="500">
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

 
 
       
         <%@ include file="../app/footer.jsp" %>
