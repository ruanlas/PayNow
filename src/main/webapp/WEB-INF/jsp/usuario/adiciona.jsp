<%--
  Created by IntelliJ IDEA.
  User: renato
  Date: 21/10/17
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Usuário</title>
    <%--<script src="/WEB-INF/js/sendRequisition.js" type="application/javascript" ></script>--%>
    <%--<script type="application/javascript">--%>
        <%----%>
    <%--</script>--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="PayNow - pague com simplicidade e eficiência">
    <link href="https://fonts.googleapis.com/css?family=Cantarell" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="/PayNow/resources/css/style.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
	crossorigin="anonymous"></script>
 	<script src="/PayNow/resources/js/validations.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
      <div class="container">
        <a class="navbar-brand" href="/">PayNow</a>
        <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#navbarResponsive">
		    <span class="sr-only">Toggle navigation</span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		  </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="nav navbar-nav navbar-right">
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <main class="bg-site">
      <div class="container">
      	<div class="container-form">
	      	<h1>Cadastro de Usuário</h1>
			<form action="/paynow/usuario/salva" method="post" enctype='application/json' id="form_add_user">
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_name">Nome</label>
			    		<input type="text" name="pagante.nome" class="form-control" id="user_name" autofocus="autofocus">
			    </div>
			    <div id="block_cpf">
				    <div class="field" data-toggle="tooltip">
				    		<label for="user_cpf">CPF</label>
				    		<a href"#" class="toggle-pessoa" onclick="togglePessoa();">Pessoa Jurídica</a>
				    		<input type="number" name="pagante.cpf" class="form-control" id="user_cpf" >
				    </div>
			    </div>
			    <div id="block_cnpj" class="hidden">
				    <div class="field" data-toggle="tooltip">
				    		<label for="user_cnpj">CNPJ</label>
				    		<a href"#" class="toggle-pessoa" onclick="togglePessoa();">Pessoa Física</a>
				    		<input type="number" name="pagante.cnpj" class="form-control" id="user_cnpj" >
				    </div>
			    </div>
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_email">E-mail</label>
			    		<input type="email" name="pagante.email" class="form-control" id="user_email" >
			    </div>
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_tel">Telefone</label>
			    		<input type="number" name="pagante.telefone" class="form-control" id="user_tel" >
			    </div>
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_nasc">Data de Nascimento</label>
			    		<input type="datetime-local" name="pagante.dataNascimento" class="form-control" id="user_nasc" >
			    </div>
			    
			    <input type="submit" value="Salvar" formenctype="application/json" class="btn btn-secondary btn-lg" />
			</form>
      	</div>
      </div>
     </main>
</body>
</html>
