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
                    <h2>Profile d'utilisateur</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                  <div class="container">
                       <div class="row">
                       <div class="col-md-4">
                         <img src="../images/user.png" width="100" height="100" />
                       </div>
                       <div class="col-md-8">
                         <p>username : <c:out value="${user.getUsername() }"></c:out></p>  
                         <p>role : <c:out value="${user.getUtilisateurRoles().get(0).getRole() }"></c:out></p>
                         <p><a href="../users/edit" class="btn btn-success">modifier votre profile</a></p>
                       </div>
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
