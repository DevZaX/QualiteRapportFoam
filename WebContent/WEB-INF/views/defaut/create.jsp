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
                    <h2>Defauts</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                 <h2>Nouveau defaut</h2>
                 <div class="row">
                 <form:form action="../defauts/store" method="POST" modelAttribute="defaut">
                     <div class="col-md-4"><div class="form-group">
                           <form:input class="form-control" path="code" placeholder="code" value="${defaut.code }" required="required" />
                     </div></div>
                     <div class="col-md-4"><div class="form-group">
                           <form:input class="form-control" path="title" placeholder="title" value="${defaut.title }" required="required" />
                     </div></div>
                     <div class="col-md-4"><div class="form-group">
                           <form:select items="${sides }" class="form-control" path="side"  value="${defaut.side }" required="required" />
                     </div></div>
                     <div class="col-md-6">
<button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button> 
<a href="index" class="btn btn-success"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
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
