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
                <c:if test="${utilisateur.getLangue() == 'anglais' }">
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > families </h4>
                </c:if>
                <c:if test="${utilisateur.getLangue() == 'francais' }">
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Acceuil > familles</h4>
                </c:if>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                  
                    <c:if test="${utilisateur.getLangue() == 'francais' }">
                    <h2>les prix et les poids de chaque famille</h2>
                    </c:if>
                    
                     <c:if test="${utilisateur.getLangue() == 'anglais' }">
                    <h2>family prices and weights</h2>
                    </c:if>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                
                <table class="table table-bordered" id="data">
                      <thead>
                        <tr>
                          <th style="background-color:#26B99A;color:white;">#</th>
                          <c:if test="${utilisateur.getLangue() == 'anglais' }">
                          <th style="background-color:#26B99A;color:white;">Title</th>
                          <th style="background-color:#26B99A;color:white;">Price</th>
                          <th style="background-color:#26B99A;color:white;">Weight</th>
                          </c:if>
                           <c:if test="${utilisateur.getLangue() == 'francais' }">
                          <th style="background-color:#26B99A;color:white;">Titre</th>
                          <th style="background-color:#26B99A;color:white;">Prix</th>
                          <th style="background-color:#26B99A;color:white;">Poids</th>
                          </c:if>
                          <th></th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:set var="count" value="0" scope="page" />
                      <c:forEach items="${items }" var="item">
                      <tr>
                       <c:set var="count" value="${count + 1}" scope="page"/>
                          <th><c:out value="${count}"></c:out></th>
                          <td><c:out value="${item.getTitle()}"></c:out></td>
                          <td><c:out value="${item.getPrice()}"></c:out> &euro;</td>
                          <td><c:out value="${item.getWeight()}"></c:out> Kg</td>
                          <td>
                          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal<c:out value="${count}"></c:out>" data-whatever="@mdo"><i class="fa fa-pencil"></i></button>
                          </td>
                        </tr>
                        <!-- model -->
                          <div class="modal fade" id="exampleModal<c:out value="${count}"></c:out>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							  <div class="modal-dialog" role="document">
							    <div class="modal-content">
							      <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <c:if test="${utilisateur.getLangue() == 'francais' }">
							        <h4 class="modal-title" id="exampleModalLabel">Modifier la famille</h4>
							        </c:if>
							        <c:if test="${utilisateur.getLangue() == 'anglais' }">
							        <h4 class="modal-title" id="exampleModalLabel">Update family</h4>
							        </c:if>
							      </div>
							      <div class="modal-body">
							        <form action="../familles/update" method="POST">
							         <div class="form-group">
							            <c:if test="${utilisateur.getLangue() == 'francais' }">
							            <label  class="control-label">Titre:</label>
							            </c:if>
							            <c:if test="${utilisateur.getLangue() == 'anglais' }">
							            <label  class="control-label">Title:</label>
							            </c:if>
							            <input name="title" type="text" class="form-control" value="${item.getTitle()}" readonly="readonly" />
							            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							          </div>
							          <div class="form-group">
							          <c:if test="${utilisateur.getLangue() == 'francais' }">
							            <label  class="control-label">Nouveau prix:</label>
							            </c:if>
							            <c:if test="${utilisateur.getLangue() == 'anglais' }">
							            <label  class="control-label">New price:</label>
							            </c:if>
							            <input name="price" type="text" class="form-control" value="${item.getPrice()}" />
							          </div>
							          <div class="form-group">
							           <c:if test="${utilisateur.getLangue() == 'francais' }">
							            <label  class="control-label">Nouveau Poids:</label>
							            </c:if>
							            <c:if test="${utilisateur.getLangue() == 'anglais' }">
							            <label  class="control-label">New weight:</label>
							            </c:if>
							            <input name="weight"  type="text" value="${item.getWeight()}" class="form-control" />
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
