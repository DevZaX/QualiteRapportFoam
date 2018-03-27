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
                
    <div class="container">
  	<div class="row">
  		<div class="col-md-4">
  			<table>
  				<thead>
  					<th></th>
  					<th></th>
  				</thead>
  				<tbody>
  					<tr><td>start date:</td><td><input type="date"></td></tr>
  					<tr><td>end date:</td><td><input type="date"></td></tr>
  					<tr><td><select><option>C20&C22&TT30</option></select></td></tr>
  					<tr><td><select><option>A&B&C</option></select></td></tr>
  					<tr><td><select><option>Serie</option></select></td></tr>
  					
  				</tbody>
  			</table>
  		</div>	 
  		
  		<div class="col-md-4">
  			<center><img src="../images/lear.png" width="200" height="200">
  			<h1>Global Report </h1></center>
  		</div>
  		
  		<div class="col-md-4">
  			<p>Global Scrap : 0.61</p>
  			<p>Global RFT : 87.06 </p>
  		</div>
  		
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
