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
                 <h2><a href="../dreception/create" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></a></h2>
                     <h1>Liste des defauts de Réception</h1>
                      <table class="table table-bordered" border="0">
                     
                     <c:forEach items="${ items}" var="item">
                     <tr>
                     
                  
                     <td><c:out value="${item.getCode() }"></c:out></td>
                     <td><c:out value="${item.getTitle() }"></c:out></td>
                      
                     <td><a onClick="return confirm('confirmer le fait de la suppression d\'un defaut!')" href="${item.getCode()}/delete"><i style="color:red;" class="fa fa-trash"></i></a></td>
                     
                     </tr>

                     </c:forEach>
                      </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
