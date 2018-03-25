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
                    <h2>Modifier votre profile</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                  <form action="../users/update" method="POST">
                  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                   <div class="form-group">
                   <label class="control-label">Username:</label>
                   <input type="text" name="username" value="${user.getUsername() }" class="form-control" readonly="readonly" />
                   </div>
                   <div class="form-group">
                   <label class="control-label">Nouveau mote de passe ou votre mote de passe actuel</label>
                   <input type="text" name="password"   class="form-control" required="required"/>
                   </div>
                   <p>Ecrire une indication de mote de passe</p>
                    <div class="form-group">
                   
                   <input type="text" name="indice" class="form-control" value="${user.getIndice() }" />
                   </div>
                   <button type="submit" class="btn btn-success"><i class="fa fa-pencil"></i></button>
                   <a href="../users/show" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></a>
                  </form>
                 
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
