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
                <h3><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > References > create</h3>
              </div>

              
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Nouveau reference</h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  	<div class="container">
                  			<div class="col-md-6 col-md-offset-3">
                  					 <form:form action="../alerts/store" method="POST" modelAttribute="alert">
                 
             
              
               <div class="form-group">
                     <label class="control-label">Numero</label>
                     <form:input path="numero" value="${ alert.ref}" placeholder="reference" class="form-control"/>
               </div> 
                
             
                <div class="form-group">
                       <form:input path="version" value="${ empiecement.version}" placeholder="version" class="form-control"/>
                </div>
   
                 <div class="form-group">
					<select name="fournisseur" class="form-control">
					<c:forEach items="${items2 }" var="item2">
					<option><c:out value="${item2.getName()}"></c:out> </option>
					</c:forEach>
					</select>
                </div>
                
                <div class="form-group">
                     <form:input path="price" value="${ empiecement.price}" placeholder="price" class="form-control"/>
                </div>
                
                 <div class="form-group">
					<select name="projet" class="form-control">
					<c:forEach items="${items }" var="item">
					<option><c:out value="${item.getTitle()}"></c:out> </option>
					</c:forEach>
					</select>
                </div>
               
           
             <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button> 
             <a href="../empiecements/index" class="btn btn-success"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></a> 
               
               </form:form>             
         
                  			</div>
                  	</div>
                  
                 
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
         <%@ include file="../app/footer.jsp" %>
