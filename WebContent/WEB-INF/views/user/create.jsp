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
                <h3>Qualite Rapport Foam</h3>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Nouveau Utilisateur</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                  
                  <form:form action="../users/store" method="POST" modelAttribute="utilisateurWrapper">

               <div class="form-group">
                    <form:input type="text" path="username" value="${ utilisateurWrapper.username}" placeholder="Username" class="form-control"/>
               </div>
              
               <div class="form-group">
                     <form:input type="password" path="password" value="${ utilisateurWrapper.password}" placeholder="Password" class="form-control"/>
               </div> 
               
               <h2>Affecter un role à l'utilisateur</h2>
               
                
                <div class="form-group">
                <form:select class="form-control" path="role" items="${ roles}"></form:select>
                </div>
                
              
                
               
           
             <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button> 
             <a href="../users/index" class="btn btn-success"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></a> 
               
               </form:form>             
         
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
