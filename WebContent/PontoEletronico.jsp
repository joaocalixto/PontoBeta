<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Ponto Eletronico</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/jquery.dataTables.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 20px;
        padding-bottom: 60px;
      }

      /* Custom container */
      .container {
        margin: 0 auto;
        max-width: 1000px;
      }
      .container > hr {
        margin: 60px 0;
      }

      /* Main marketing message and sign up button */
      .jumbotron {
        margin: 80px 0;
        text-align: center;
      }
      .jumbotron h1 {
        font-size: 100px;
        line-height: 1;
      }
      .jumbotron .lead {
        font-size: 24px;
        line-height: 1.25;
      }
      .jumbotron .btn {
        font-size: 21px;
        padding: 14px 24px;
      }

      /* Supporting marketing content */
      .marketing {
        margin: 60px 0;
      }
      .marketing p + h4 {
        margin-top: 28px;
      }


      /* Customize the navbar links to be fill the entire space of the .navbar */
      .navbar .navbar-inner {
        padding: 0;
      }
      .navbar .nav {
        margin: 0;
        display: table;
        width: 100%;
      }
      .navbar .nav li {
        display: table-cell;
        width: 1%;
        float: none;
      }
      .navbar .nav li a {
        font-weight: bold;
        text-align: center;
        border-left: 1px solid rgba(255,255,255,.75);
        border-right: 1px solid rgba(0,0,0,.1);
      }
      .navbar .nav li:first-child a {
        border-left: 0;
        border-radius: 3px 0 0 3px;
      }
      .navbar .nav li:last-child a {
        border-right: 0;
        border-radius: 0 3px 3px 0;
      }
    </style>
    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
                    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
                                   <link rel="shortcut icon" href="../assets/ico/favicon.png">
  </head>

  <body>

    <div class="container">

      <div class="masthead">
        <h3 class="muted">PontoEletronico</h3>
        <div class="navbar">
          <div class="navbar-inner">
            <div class="container">
              <ul class="nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">...</a></li>
                <li><a href="#">...</a></li>
                <li><a href="#">...</a></li>
                <li><a href="#">...</a></li>
                <li><a href="#">...</a></li>
              </ul>
            </div>
          </div>
        </div><!-- /.navbar -->
      </div>

      <!-- Jumbotron -->
      <form action="registrarHora">
	      
	      <div class="jumbotron">
	        <h1 id="localclock">Marketing stuff!</h1>
	       <!--  <a class="btn btn-large btn-success" href="#">Registrar Hora</a>--> 
	        
				
					<input type="text" id="usuario" name="usuario"  autocomplete="on" placeholder="Digite aqui seu usuario" required>
					<br/>
	       <select id="selectTipoEntrada" name="selectTipoEntrada" style="height: 45px;margin-top: 7px;text-align: justify;font-size:30px;">
				<option value="ENTRADA">Entrada</option>
				<option value="ALMOCO">Almoco</option>
				<option value="VOLTAALMOCO">Volta Almoco</option>
				<option value="SAIDA">Saida</option>
			</select>			
	        <button class="btn btn-large btn-success" type="submit">Registrar Hora</button>
	        <br/>
	          <div id="sucessAlert" style="display: none;" class="alert alert-success">
				<button  class="close" data-dismiss="alert" type="button">×</button>
				<strong>Parabens!</strong>
					Suas horas foram registradas com sucesso.
		  	 </div>
	      </div>
	  </form>
      <hr>

      <!-- Example row of columns -->
      <div class="row-fluid">
        <div class="span12">
          <h2>Relatorio</h2>
          <table class="table table-striped" id="datatable">
              <thead>
                <tr>
                  <th>Dia</th>
                  <th>Usuario</th>
                  <th>Entrada</th>
                  <th>Almoco</th>
                  <th>Volta Almoco</th>
                  <th>Saida</th>
                </tr>
              </thead>
              <tbody id="tbody">
              
              
               
              
              </tbody>
            </table>
        </div>
       

      <hr>

      <div class="footer">
        <p>&copy; Company 2014</p>
      </div>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-1.9.0.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jsclock-0.8.min.js"></script>  
    <script src="js/jquery.dataTables.js"></script>  
    
    <script type="application/javascript">
    $(document).ready(function(){
    	   $("#localclock").jsclock();
    	   $("#datatable").dataTable();
    	  var msg= "<%=request.getAttribute("msg") %>";
    	  
    	  var horario = <%=request.getAttribute("horarios") %>;
    	  
    	  $("#tbody").children().remove();
    	  $.each(horario, function(i, item) {
    		    var linha = "<tr>";
    		    linha+= "<td>"+item.dia+"</td>";
    		    linha+= "<td>"+item.usuario+"</td>";
    		    linha+= "<td>"+item.horaEntrada+"</td>";
    		    linha+= "<td>"+item.horaAlmoco+"</td>";
    		    linha+= "<td>"+item.horaVoltaAlmoco+"</td>";
    		    linha+= "<td>"+item.horaSaida+"</td>";
				linha+="</tr>";                
            	$("#tbody").append(linha);
    		});
    	  if(msg == "sucesso"){
    		 $("#sucessAlert").fadeIn("slow");
    	  } else if(msg == "erro"){
    		  $("#sucessAlert").fadeIn("slow");
    	  }
    	});
 </script>

  </body>
</html>
