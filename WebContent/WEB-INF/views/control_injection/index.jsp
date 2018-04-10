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
<div class="row">
	<div class="col-md-12">
		<table class="table table-bordered">
			<thead>
			    <th>R�f</th>
				<th>quantit� rejeter</th>
				<th>quantit� retoucher la premi�re foie</th>
				<th>quantit� retoucher la deuxi�me foie</th>
				<th>quantit� ok</th>
				<th>quantit� controller</th>
				<th>scrape %</th>
				<th>IPPM</th>
				<th>prix des pieces rejet�es</th>
				<th>prix totale des pieces controller</th>
				<th>prix produit chimie rejet�</th>
				<th>prix produit chimie utilis�</th>
				<th>poid produit chimie rejet�</th>
				<th>poid produit chimie utilis�</th>
			</thead>
			<tbody>
			<c:forEach items="${items }" var="e">
				<tr>
					<td>${e.getRef() }</td>
					<td>${e.getQteScrap()}</td>
					<td>${e.getQteRetouche1()}</td>
					<td>${e.getQteRetouche2() }</td>
					<td>${e.getQteOK() }</td>
					<td>${e.getQteController() }</td>
					<td>${e.getScrapRate() } %</td>
					<td>${e.getIPPM()}</td>
					<td>${e.getScrapCost() } &euro;</td>
					<td>${e.getScrapTotalCost() } &euro;</td>
					<td>${e.getPCCostScrap()} &euro;</td>
					<td>${e.getPCCostTotal()} &euro;</td>
					<td>${e.getPCWScrap()} kg</td>
					<td>${e.getPCWTotal() } kg</td>
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
