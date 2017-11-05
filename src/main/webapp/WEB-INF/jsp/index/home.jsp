<%--
  Created by IntelliJ IDEA.
  User: renato
  Date: 25/10/17
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bem vindo ao sistema PayNow</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="PayNow - pague com simplicidade e eficiência">
    <link href="https://fonts.googleapis.com/css?family=Cantarell" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="/PayNow/resources/css/style.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">PayNow</a>
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
   
    <header class="intro-header">
      <div class="container">
        <div class="intro-message">
          <h1>PayNow</h1>
          <h3>Sua plataforma de pagamentos</h3>
          <hr class="intro-divider">
          <ul class="list-inline intro-social-buttons">
            <li class="list-inline-item">
              <a href="/PayNow/pagamento/selecionaPagamento" class="btn btn-secondary btn-lg">
                <i class="glyphicon glyphicon-usd"></i>
                <span class="network-name">Fazer pagamentos</span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="/PayNow/pagamento/statusPagamentos" class="btn btn-secondary btn-lg">
                <i class="glyphicon glyphicon-usd"></i>
                <span class="network-name">Pagamentos realizados</span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="/PayNow/usuario/adiciona" class="btn btn-secondary btn-lg">
                <i class="glyphicon glyphicon-user"></i>
                <span class="network-name">Adicionar usuário</span>
              </a>
            </li>
          </ul>
        </div>
      </div>
    </header>

</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" 
	crossorigin="anonymous"></script>
</html>
