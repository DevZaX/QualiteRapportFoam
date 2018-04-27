
        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Lear Corporation - Qualite Rapport Foam - zakariae aboud
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>
<!-- jQuery -->
    <script src='<c:url value="/js/jquery.min.js" />'></script>
    
    <!-- Datatables -->
    <script src="<c:url value='/js/jquery.dataTables.min.js' />"></script>
    
    
    
    <!-- Bootstrap -->
    <script src="<c:url value='/js/bootstrap.min.js' />"></script>
    <!-- FastClick -->
    <script src="<c:url value='/js/fastclick.js' />"></script>
    <!-- NProgress -->
    <script src="<c:url value='/js/nprogress.js' />"></script>
    
    <!--  raphael-min.js -->
    <script src="<c:url value='/js/raphael-min.js' />"></script>
    
    
     <!-- Morris js -->
    <script src="<c:url value='/js/morris.js' />"></script>
    
    
    <!-- Custom Theme Scripts -->
    <script src="<c:url value='/js/custom.min.js' />"></script>
    
    <!-- Chart -->
     <script src="<c:url value='/js/Chart.js' />"></script>
     
     <script>
       var table =  $('#data').DataTable();
     // Apply the search
        table.columns().every( function () {
            var that = this;
     
                  } );
        </script>
         <script>
            
			$(document).ready(function(){
			    $("#btn").click(function(){
			    	 if ( $('#form').css('visibility') == 'hidden' )
			    		    $('#form').css('visibility','visible');
			    		  else
			    		    $('#form').css('visibility','hidden');
			    });
			});
		</script>
  </body>
</html>
