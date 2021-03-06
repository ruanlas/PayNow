<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastro de Gerente</title>
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.min.js" ></script>
 	<script src="/PayNow/resources/js/validations.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
      <div class="container">
        <a class="navbar-brand" href="/PayNow">PayNow</a>
        <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#navbarResponsive">
		    <span class="sr-only">Toggle navigation</span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		  </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="nav navbar-nav navbar-right">
            <li class="nav-item">
              <a class="nav-link" href="${linkTo[PagamentoController].selecionaPagamento()}">Fazer pagamentos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${linkTo[PagamentoController].statusPagamentos()}">Pagamentos realizados</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${linkTo[IndexController].adiciona()}">Adicionar usuário</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${linkTo[GerenteController].adiciona()}">Adicionar gerente</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <main class="bg-site">
      <div class="container">
      	<div class="container-form">
	      	<h1>Cadastro de Gerente</h1>
			<form action="/PayNow/gerente/salva" method="post" id="form_add_gerente">
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_name">Nome</label>
			    		<input type="text" name="gerente.nome" class="form-control" id="gerente_name" autofocus="autofocus">
			    </div>
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_cpf">CPF</label>
			    		<input type="text" name="gerente.cpf" class="form-control" id="gerente_cpf" >
				</div>
				<div class="field" data-toggle="tooltip">
			    		<label for="user_cpf">Matrícula</label>
			    		<input type="text" name="gerente.matricula" class="form-control" id="gerente_matricula" >
				</div>
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_email">E-mail</label>
			    		<input type="email" name="gerente.email" class="form-control" id="gerente_email" >
			    </div>
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_tel">Telefone</label>
			    		<input type="text" name="gerente.telefone" class="form-control" id="gerente_tel" >
			    </div>
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_tel">Usuario</label>
			    		<input type="text" name="gerente.usuario" class="form-control" id="gerente_usuario" >
			    </div>
			    <div class="field" data-toggle="tooltip">
			    		<label for="user_tel">Senha</label>
			    		<input type="text" name="gerente.senha" class="form-control" id="gerente_senha" >
			    </div>
			    
			    <input type="submit" value="Salvar"  class="btn btn-secondary btn-lg" />
			</form>
      	</div>
      </div>
     </main>
</body>
</html>