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
                    <h2>Nouveau Projet</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                  
                  <form:form action="../phases/store" method="POST" modelAttribute="phase">

               <div class="form-group">
               <form:label path="duree" class="label-control">Le nom de la phase :</form:label>
                    <form:input path="title" value="${ phase.title}" placeholder="title" class="form-control"/>
               </div>
              
               <div class="form-group">
               <form:label path="duree" class="label-control">La duree du phase</form:label>
                     <form:input path="duree" value="${ phase.duree}" placeholder="en jours" class="form-control"/>
               </div> 
                
               
                
               
                
              
           
             <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button> 
             <a href="index" class="btn btn-success"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></a> 
               
               </form:form>             
         
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
