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
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home > injection controle </h4>
                </c:if>
                <c:if test="${utilisateur.getLangue() == 'francais' }">
                <h4><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Acceuil > controle d'injection</h4>
                </c:if>
              </div>

              
            </div>

         

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                 	<div class="x_content">
<div class="row">
	<div class="col-md-6">
		<form  id="form" action='../controle_injection/filter' method="POST">
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
				<label class="control-label">filtrer par zone:</label>
				<select name="zone" class="form-control"><option>All</option><c:forEach items="${zones }" var="zone"><option><c:out value="${zone.getTitle() }" /></option></c:forEach></select>
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
		<p>Scrap Global Injection : <font color="blue">${scrap_global_injection} %</font></p>
		<p>IPPM Global Injection : <font color="blue">${IPPM_global_injection }</font></p>
		<p>RFT Global Injection : <font color="blue">${RFT_global_injection }</font></p>
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
		<th style="background-color:#da0000;color:white;">ref</th>
		<th style="background-color:#da0000;color:white;">famille</th>
		<th style="background-color:#da0000;color:white;">projet</th>
		<th style="background-color:#da0000;color:white;">ok</th>
		<th style="background-color:#da0000;color:white;">scrap</th>
		<th style="background-color:#da0000;color:white;">controller</th>
		<th style="background-color:#da0000;color:white;">retouche1</th>
		<th style="background-color:#da0000;color:white;">retouche2</th>
		<th style="background-color:#da0000;color:white;">scrap rate</th>
		<th style="background-color:#da0000;color:white;">ippm</th>
		<th style="background-color:#da0000;color:white;">RFT</th>
		<th style="background-color:#da0000;color:white;">scrap cost</th>
		<th style="background-color:#da0000;color:white;">scrap cost(totale)</th>
		<th style="background-color:#da0000;color:white;">prix produit chimie </th>
		<th style="background-color:#da0000;color:white;">prix produit chimie (totale)</th>
		<th style="background-color:#da0000;color:white;">poid produit chimie</th>
		<th style="background-color:#da0000;color:white;">poid produit chimie (totale)</th>
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
					<td><a href="../controle_injection/${e.get('ref') }/${date1 }/${date2 }/info"><i class="fa fa-eye"></i></a></td>
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
