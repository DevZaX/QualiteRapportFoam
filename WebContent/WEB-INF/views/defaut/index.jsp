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
                 <h2><a href="../defauts/create" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></a></h2>
                     <h1>liste des defauts</h1>
                      <table class="table table-bordered" border="0">
                      <c:set var="count" value="0" scope="page" />
                     <c:forEach items="${ defauts}" var="e">
                     <tr>
                     <c:set var="count" value="${count + 1}" scope="page"/>
                     <th><c:out value="${count}"></c:out></th>
                     <td><c:out value="${e.getCode() }"></c:out></td>
                     <td><c:out value="${e.getTitle() }"></c:out></td>
                      
                     <td><a href="${e.getCode()}/delete"><i style="color:red;" class="fa fa-trash"></i></a></td>
                     
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
