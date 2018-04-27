 <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src=" ${pageContext.request.contextPath}/images/admin.png" alt="">${utilisateur.getUsername()}
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="../users/show"> Profile</a></li>
                    <li><a href="<c:url value="../logout" />"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
                
                 <c:if test="${utilisateur.getLangue() == 'anglais' }">
                 <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Languages
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  </c:if>
                  
                   <c:if test="${utilisateur.getLangue() == 'francais' }">
                 <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Langues
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  </c:if>
                  
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="../users/francais"> Francais</a></li>
                    <li><a href="../users/anglais"> Anglais</a></li>
                  </ul>
                </li>

              
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->