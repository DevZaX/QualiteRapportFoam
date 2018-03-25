<div class="navbar nav_title" style="border: 0;">
              <a href="" class="site_title"><span>Qualite Rapport Foam</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="<c:url value="../images/admin.png" />" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Bonjour</span>
                <h2>${name }</h2>
              </div>
              <div class="clearfix"></div>
            </div>
            <!-- /menu profile quick info -->
            <!-- /menu profile quick info -->

            <br />
            
            
            
            
            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                <c:if test="${
                (role == 'Technicient qualite') ||
                (role == 'Responsable qualite') ||
                (role == 'Injenieur qualite') ||
                (role == 'Qualite client') ||
               ( role == 'Coordinateur injection')
               }">
                  <li><a><i class="fa fa-bookmark"></i> Partie Reception <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="../controlR/index">Controle de reception</a></li>
                      <li><a href="../empiecements/index">Les matiers premiers</a></li>
                      <li><a href="../defauts/index">Liste des defauts de reception</a></li>
                      <li><a href="../phases/index">Les phases</a></li>
                    </ul>
                    </li>
                    </c:if>
                    <c:if test="${
                    role == 'Technicient qualite' ||
                    role == 'Responsable qualite' ||
                    role == 'Injenieur qualite' ||
                    role == 'Controlleur reception' ||
                    role == 'Coordinatrice'
                     }">
                    <li><a><i class="fa fa-bookmark"></i> Partie Injection <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="../injection/index">Les controles d'injection</a></li>
                      <li><a href="../projets/index">Liste des references</a></li>
                      <li><a href="../zones/index">Les zones des robots</a></li>
                      <li><a href="../familles/index">Les prix et les poids des produits chimies</a></li>
                    </ul>
                  </li>
                  </c:if>
                  
                  <c:if test="${
                    role == 'Technicient qualite' ||
                    role == 'Responsable qualite' ||
                    role == 'Injenieur qualite'
                   }">
                  	<li><a href="../users/index"><i class="fa fa-users"></i>  Les utilisateurs </a></li>
                  	</c:if>	
                  	<c:if test="${
                  		role == 'Technicient qualite' ||
		                role == 'Responsable qualite' ||
		                role == 'Injenieur qualite' ||
		                role == 'Qualite client' ||
		                role == 'Controlleur reception' ||
                        role == 'Coordinatrice' ||
                        role == 'Coordinateur couture' ||
                        role == 'Coordinatrice'    
                  	 }">
                  	<li><a href="../users/show"><i class="fa fa-user"></i> Mon profile </a>
                     </li>
                     </c:if>
                
                
                
                 
                
                </ul>
              </div>
             

            </div>
            <!-- /sidebar menu -->