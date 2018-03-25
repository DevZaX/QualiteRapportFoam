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
                 <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > Liste des zones des robots</h4>
                 </c:if>
                 
                  <c:if test="${utilisateur.getLangue() == 'anglais' }">
                  <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > Robots zones list</h4>
                  </c:if>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Zones</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                  <div class="row">
                  
                  <table class="table">
                  <form:form action="../zones/store" modelAttribute="zone" method="POST">
                  
                  
                  <tbody>
                  <tr>
                  <c:if test="${utilisateur.getLangue() == 'francais' }">
                    <td><form:input type="text" path="title" value="${zone.title}" required="required" placeholder="titre de zone"  /></td>
                    </c:if>
                     <c:if test="${utilisateur.getLangue() == 'anglais' }">
                    <td><form:input type="text" path="title" value="${zone.title}" required="required" placeholder="zone title"  /></td>
                    </c:if>
                    <td><button type="submit" class="btn btn-success"><i class="fa fa-save"></i></button> </td>
                    </tr>
                  </tbody>
                  
                  </table>
                  </form:form>
                  </div>
                  
                     <c:forEach items="${ zones}" var="e">
                     <p><c:out value="${e.getTitle() }"></c:out> : <a href="${e.getId()}/delete"><i style="color:red;" class="fa fa-trash"></i></a></p>
                     </c:forEach>
                     
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
