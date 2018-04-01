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
                  
	                   <h1>Top 10 defects</h1>
	                   <div id="myfirstchart" style="height: 250px;"></div>
          
                
                
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      
        <!-- /page content -->
        
        
       
      
         <%@ include file="../app/footer.jsp" %>
         
          <script>
        new Morris.Bar({
        	  // ID of the element in which to draw the chart.
        	  element: 'myfirstchart',
        	  // Chart data records -- each entry in this array corresponds to a point on
        	  // the chart.
        	  data: [
        	    { defaut: 'Défaut Tissu/Cuir/Vinyl', value: 8 },
        	    { defaut: 'Rides ', value: 6 },
        	    { defaut: 'Plis', value:5 },
        	    { defaut: 'Smile', value:3},
        	    { defaut: 'Pincement', value: 2 },
        	    { defaut: 'Enfoncement-face avant ', value: 1 },
        	    { defaut: 'Enfoncement-face arrière', value: 1 },
        	    { defaut: 'Couture cassée', value: 1 },
        	    { defaut: 'Point sauté', value: 1 },
        	    { defaut: 'Mousse visible-Smile', value: 1}
        	  ],
        	  // The name of the data record attribute that contains x-values.
        	  xkey: 'defaut',
        	  // A list of names of data record attributes that contain y-values.
        	  ykeys: ['value'],
        	  // Labels for the ykeys -- will be displayed when you hover over the
        	  // chart.
        	  labels: ['Value'],
        	  hideHover:'auto'
        	});
        </script>
