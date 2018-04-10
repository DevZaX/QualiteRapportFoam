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
                  
                 <div class="x_content">
              <h1>Les informations d'alert</h1>
              
             <ul>
             <li><p>defaut : ${alert.getDefaut() }</p></li>
             <li><p>nombre des pieces : ${alert.getNbr_pieces()}</p></li>
             <li><p>client : ${alert.getClient() }</p></li>
             <li><p>date de debut : ${alert.getDate_alert() }</p></li>
             <li>date de fin : ${alert.getDate_fin_alert() }</li>
             </ul>
             <p>message : ${alert.getMsg() } </p>
             
             <p>image</p>
             
             <img src="data:image/jpeg;base64,${ alert_picture}" width="500" height="500">
             
             <p>liste des projets</p>
             
             <c:forEach items="projets" var="e">
                 <p>${e.getTitle()}</p>
             </c:forEach>
                  
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
