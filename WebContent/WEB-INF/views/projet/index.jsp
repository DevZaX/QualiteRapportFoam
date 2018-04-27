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
                      <a href="create" class="btn btn-success">Ajouter une piece</a>
                      </c:if>
                      <c:if test="${utilisateur.getLangue() == 'anglais' }">
                      <a href="create" class="btn btn-success">Add a part</a>
                      </c:if>
                      <table id="data" class="table table-bordered">
                      <thead>
                        <tr>
                        <c:if test="${utilisateur.getLangue() == 'francais' }">
                          <th style="background-color:#26B99A;color:white;">Photo</th>
                          <th style="background-color:#26B99A;color:white;">Réf</th>
                          <th style="background-color:#26B99A;color:white;">Version</th>
                           <th style="background-color:#26B99A;color:white;">Prototype</th>
                          <th style="background-color:#26B99A;color:white;">Famille</th>
                          <th style="background-color:#26B99A;color:white;">Projet</th>        
                          <th></th>
                          </c:if>
                           <c:if test="${utilisateur.getLangue() == 'anglais' }">
                          <th style="background-color:#26B99A;color:white;">Picture</th>
                          <th style="background-color:#26B99A;color:white;">Ref</th>
                          <th style="background-color:#26B99A;color:white;">Version</th>
                           <th style="background-color:#26B99A;color:white;">Prototype</th>
                          <th style="background-color:#26B99A;color:white;">Family</th>
                          <th style="background-color:#26B99A;color:white;">Project</th>        
                          <th></th>
                          </c:if>
                        </tr>
                      </thead>
                      <tbody>
                     
                      <c:forEach items="${ items}" var="item">
                        <tr>
                         
                      <td><img src="data:image/jpeg;base64,${item.getPicture() }" width="100" height="100" /></td>   
                      <td><c:out value="${item.getRef() }"></c:out></td>
                      <td><c:out value="${item.getVersion() }"></c:out></td>
                       <td><c:out value="${item.getPrototype() }"></c:out></td>
                      <td><c:out value="${item.getFamille() }"></c:out></td>
                      <td><c:out value="${item.getTitle() }"></c:out></td>
                     
                      <td>
                           <a href="../projets/<c:out value="${item.getFamilleId() }"></c:out>/<c:out value="${item.getRef() }"></c:out>/delete" onClick="return confirm('voulez vous supprimer cette references ?')" type="button" class="btn btn-danger"><i class="fa fa-trash"></i></a>
                           <a href="../projets/${item.getRef() }/show" class="btn btn-warning"><i class="fa fa-eye"></i></a>
                           
                      </td>
                     
                        </tr>
                       
                          </c:forEach>
                      </tbody>
                    </table>
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

 
 
    
  
       
         <%@ include file="../app/footer.jsp" %>
         
