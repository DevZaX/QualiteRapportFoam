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

         

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                 	<div class="x_content">
<div class="row">
	<div class="col-md-6">
		<form  id="form" action='../controle_mur/filter' method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
			<div class="form-group">
				<label class="control-label">filtrer par date:</label>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">date debut:</label>
							<input value="${date}" type="date" name="date_debut" class="form-control" required="required">
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label class="control-label">date fin:</label>
							<input value="${date}" type="date" name="date_fin" class="form-control" required="required">
						</div>
					</div>
				</div>
			</div>
			
			<div class="form-group">
			    <label class="control-label">filtrer par prototype:</label>
				<select name="prototype" class="form-control"><option>All</option><option>Serie</option><option>New Project</option></select>
			</div>
			<div class="form-group">
			    <label class="control-label">filtrer par equipe:</label>
				<select name="equipe" class="form-control"><option>All</option><option>A</option><option>B</option><option>C</option></select>
			</div>
			<button type="submit" class="btn btn-success"><i class="fa fa-filter"></i> Filter</button>
		<form>
	</div>
	<div class="col-md-6">
		<h1>Controle injection informations</h1>
		<p>Scrap Global Mur : <font color="blue">${scrap_global_mur} %</font></p>
		<p>IPPM Global Mur : <font color="blue">${IPPM_global_mur}</font></p>
		<p>RFT Global Mur : <font color="blue">${RFT_global_mur }</font></p>
		<p>Date debut : ${date1 }</p>
		<p>Date fin : ${date2 }</p>
		<p>Zone : ${zone }</p>
		<p>Equipe : ${equipe }</p>
		<p>Prototype : ${prototype }</p>
	</div>
</div>
<div class="row">
	
	<table id='data' class="table table-bordered">
	<thead>
		<th>ref</th>
		<th>famille</th>
		<th>projet</th>
		<th>ok</th>
		<th>scrap</th>
		<th>controller</th>
		<th>retouche1</th>
		<th>retouche2</th>
		<th>scrap rate</th>
		<th>ippm</th>
		<th>RFT</th>
		<th>scrap cost</th>
		<th>scrap cost(totale)</th>
		<th>prix produit chimie </th>
		<th>prix produit chimie (totale)</th>
		<th>poid produit chimie</th>
		<th>poid produit chimie (totale)</th>
		<th></th>
	</thead>
	<tbody>
	<c:forEach items="${controles }" var="e">
				<tr>
					<td>${e.get("ref") }</td>
					<td>${e.get("famille") }</td>
					<td>${e.get("projet") }</td>
					<td>${e.get("ok") }</td>
					<td>${e.get("scrap") }</td>
					<td>${e.get("controller") }</td>
					<td>${e.get("retouche1") }</td>
					<td>${e.get("retouche2") }</td>
					<td>${e.get("scrap_rate") } %</td>
					<td>${e.get("IPPM") }</td>
					<td>${e.get("RFT") }</td>
					<td>${e.get("scrap_cost")} &euro;</td>
					<td>${e.get("totale_cost") } &euro;</td>
					<td>${e.get("product_price_scrap") } &euro;</td>
					<td>${e.get("product_price_totale") } &euro;</td>
					<td>${e.get("product_weight_scrap") } kg</td>
					<td>${e.get("product_weight_totale") } kg</td>
					<td><a href="../controle_mur/${e.get('ref') }/${date1 }/${date2 }/info"><i class="fa fa-eye"></i></a></td>
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
          </div>
        </div>
        <!-- /page content -->
        
        
       
      
         <%@ include file="../app/footer.jsp" %>
