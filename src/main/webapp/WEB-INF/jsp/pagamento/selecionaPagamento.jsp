<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: renato
  Date: 30/10/17
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fazer novo pagamento</title>
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
        <a class="navbar-brand" href="/PayNow/">PayNow</a>
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
				<form action="/PayNow/pagamento/confirmacao" method="post" id="form_add_payment">
				    <input type="hidden" name="pagamentoRequest.valor" value="${pagamentoRequest.valor}">
				    <input type="hidden" name="pagamentoRequest.redirecionarPara" value="${pagamentoRequest.redirecionarPara}">
				    <div class="field" data-toggle="tooltip">
					    <label for="pay_user"> Pagador</label>
					    <select name="pagamentoRequest.pagador" id="pay_user"  class="form-control">
				            <c:forEach var="e" items="${usuarios}">
				                <option value="${e.id}">${e.nome}</option>
				            </c:forEach>
				        </select>
				    </div>
				    <div class="field" data-toggle="tooltip">
				    		<label for="pay_user2" > Recebedor</label>
				    		<select name="pagamentoRequest.recebedor" id="pay_user2" class="form-control">
				            <c:forEach var="e" items="${usuarios}">
				                <option value="${e.id}">${e.nome}</option>
				            </c:forEach>
				        </select>
				    </div>
				   <div class="field" data-toggle="tooltip">
				   		<label for="pay_method"> Forma de pagamento</label>
				   		<select id="metodoPagamento" name="pagamentoRequest.metodoPagamento" onchange="lidarMetodoPagamento(); return false;" id="pay_method" class="form-control">
				            <option value="CARTAO_DE_CREDITO">Cartão de crédito</option>
				            <option value="BOLETO">Boleto</option>
				        </select>
				   </div>
				   <section id="dadosCartao">
				   		<div class="field" data-toggle="tooltip">
				   			<label for="pay_numberpay_number">Número do cartão</label>
				            <input type="text" name="pagamentoRequest.numeroCartao" id="pay_number" class="form-control">
				   		</div>
				        <div class="field" data-toggle="tooltip">
					        <label for="pay_date">DataVencimento</label>
					        <input type="text" name="pagamentoRequest.dataVencimento" data-mask="00/00" data-mask-selectonfocus="true" id="pay_date" class="form-control">
				        </div>
				        <div class="field" data-toggle="tooltip">
				        		<label for="pay_ccv">CCV (Código de Segurança)</label>
				            <input type="text" name="pagamentoRequest.digitosVerificadores" id="pay_ccv" class="form-control">
				        </div>
				    </section>
				    <h3>Valor a pagar: R$ ${pagamentoRequest.valor}</h3>
				    <input type="submit" value="Confirmar" class="btn btn-secondary btn-lg" />
				</form>
			</div>
		</div>
	</main>

<script type="application/javascript">

function lidarMetodoPagamento() {
    if(document.getElementById("metodoPagamento").value == "CARTAO_DE_CREDITO") {
        document.getElementById("dadosCartao").style.display = "block";
    } else {
        document.getElementById("dadosCartao").style.display = "none";
    }
}

</script>
</body>
</html>
