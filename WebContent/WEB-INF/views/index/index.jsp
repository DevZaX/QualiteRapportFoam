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
  				     <p>Date d'aujourd'hui ${currentDate}</p>
  					<tr><td>start date:</td><td><input type="date" value="${currentDate }"></td></tr>
  					<tr><td>end date:</td><td><input type="date" value="${currentDate }"></td></tr>
  					<tr><td><select><option>C20&C22&TT30</option></select></td></tr>
  					<tr><td><select><option>A&B&C</option></select></td></tr>
  					<tr><td><select><option>Serie</option></select></td></tr>
  					
  				</tbody>
  			</table>
  			
  			<table class="table table-bordered" style="margin-top:64px;">
  		    	<tbody>
  		    	<tr><td>Global Scrap :</td><td>0.61</td></tr>
  		    	<tr><td>Global RFT :</td><td> 87.06</td></tr>
  		    	</tbody>
  		    </table>
  		</div>	 
  		
  		<div class="col-md-4">
  			<center><img src="../images/lear.png" width="200" height="200">
  			<h1>Global Report </h1></center>
  		</div>
  		
  		<div class="col-md-4">
  		    
  			
  		</div>
  		
  </div>
  </div>
  
  <div class="container">
  
  <table class="table table-bordered">
  <thead>
  	<th style="background-color:#26B99A;color:white;">Project</th>
  	<th style="background-color:#26B99A;color:white;">Family</th>
  	<th style="background-color:#26B99A;color:white;">Total Controlled</th>
  	<th style="background-color:#26B99A;color:white;">Qty accepted</th>
  	<th style="background-color:#26B99A;color:white;">Qty rejected</th>
  	
  	<th style="background-color:#26B99A;color:white;">Qty reworked</th>
  	<th style="background-color:#26B99A;color:white;">Scrap rate %</th>
  	<th style="background-color:#26B99A;color:white;">RFT %</th>
  	<th style="background-color:#26B99A;color:white;">Taux de retouche %</th>
  	<th style="background-color:#26B99A;color:white;">IPPM</th>
  	
  	<th style="background-color:#26B99A;color:white;">Scrap cost % </th>
  	<th style="background-color:#26B99A;color:white;">Avg price</th>
  	<th style="background-color:#26B99A;color:white;">Total cost</th>
  	<th style="background-color:#26B99A;color:white;">Scrap cost</th>
  	<th style="background-color:#26B99A;color:white;">Total chemicals weight (kg)</th>
  	<th style="background-color:#26B99A;color:white;">Total chemicals price ($)</th>

  </thead>
  
  <tbody>
     <tr>
     <td>A515</td>
     <td>FA51</td>
     <td>428</td>
     <td>425</td>
     <td>3</td>
     
     <td>102</td>
     <td>0.7%</td>
     <td>75.4%</td>
     <td>82%</td>
     <td>6504</td>
     
     <td>0.7%</td>
     <td>6 &euro;</td>
     <td>2000 &euro;</td>
     <td>18.6 &euro;</td>
     <td>88 kg</td>
     <td>102 $</td>

     </tr>
  </tbody>
  </table>
  
  </div>
  
                
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->
        
        
       
      
         <%@ include file="../app/footer.jsp" %>
