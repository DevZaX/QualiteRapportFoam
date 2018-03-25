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
                    <h2><u>Références</u></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                  <div class="row">
                  <a href="../users/create" class="btn btn-success"><i class="fa fa-plus"></i></a>
                  </div>
                
                     <h1>liste des Utilisateurs</h1>
                     <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>#</th>
                          <th>Username</th>
                          <th>Role</th>
                         <th></th>
                         
                        </tr>
                      </thead>
                      <tbody>
                      <c:set var="count" value="0" scope="page" />
                      <c:forEach items="${ items}" var="item">
                        <tr>
                          <c:set var="count" value="${count + 1}" scope="page"/>
                          <th><c:out value="${count}"></c:out></th>
                          <td><c:out value="${item.getUsername() }"></c:out></td>
                          <td><c:out value="${item.getRole() }"></c:out></td>
                          <td>
                          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal<c:out value="${count}"></c:out>" data-whatever="@mdo"><i class="fa fa-pencil"></i></button>
                          <a href="../users/<c:out value="${item.getId() }"></c:out>/delete" onClick="return confirm('confirmer le fait de la suppression d\'un utilisateur!')" type="button" class="btn btn-danger"><i class="fa fa-trash"></i></a>
                           </td>
                        </tr>
                        <!-- model -->
                        <div class="modal fade" id="exampleModal<c:out value="${count}"></c:out>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title" id="exampleModalLabel">Modifier la famille</h4>
							      </div>
							      <div class="modal-body">
							        <form action="../users/update" method="POST">
							         <div class="form-group">
							            <label  class="control-label">Titre:</label>
							            <input name="title" type="text" class="form-control" value="${item.getUsername()}" readonly="readonly" />
							            <input name="title" type="hidden" class="form-control" value="${item.getId()}"  />
							            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							          </div>
							          <h2>modifier le role de l'utilisateur</h2>
							          <div class="form-group">
							            <select name="role"  class="form-control">
							            <c:forEach items="${roles }" var="role">
							             <option><c:out value="${role }"></c:out></option>
							            </c:forEach>
							           
							            </select>
							          </div>
							          
							          <div class="row">
							          <div class="col-md-3 col-md-offset-9">
							          <button type="button" class="btn btn-default" data-dismiss="modal"><i class="fa fa-close"></i> </button>
							           <button  type="submit" class="btn btn-success" value="submit"><i class="fa fa-pencil"></i></button>
							          </div>
							          </div>
							           
							        </form>
							      </div>
							      
							    </div>
							  </div>
						</div>
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
