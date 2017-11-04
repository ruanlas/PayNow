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
    <title>Pagamento</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./dist/jquery.mask.js"> </script>
<script type="application/javascript">


function lidarMetodoPagamento() {
    if(document.getElementById("metodoPagamento").value == "CARTAO_DE_CREDITO") {
        document.getElementById("dadosCartao").style.display = "block";
    } else {
        document.getElementById("dadosCartao").style.display = "none";
    }
}
//lidarMetodoPagamento();
</script>
<form action="/PayNow/pagamento/confirmacao" method="post">
    <input type="hidden" name="pagamentoRequest.valor" value="${pagamentoRequest.valor}">
    <input type="hidden" name="pagamentoRequest.redirecionarPara" value="${pagamentoRequest.redirecionarPara}">
    <label> Pagador
        <select name="pagamentoRequest.pagador">
            <c:forEach var="e" items="${usuarios}">
                <option value="${e.id}">${e.nome}</option>
            </c:forEach>
        </select>
    </label>
    <label> Recebedor
        <select name="pagamentoRequest.recebedor">
            <c:forEach var="e" items="${usuarios}">
                <option value="${e.id}">${e.nome}</option>
            </c:forEach>
        </select>
    </label>
    <label> Forma de pagamento
        <select id="metodoPagamento" name="pagamentoRequest.metodoPagamento" onchange="lidarMetodoPagamento(); return false;">
            <option value="CARTAO_DE_CREDITO">Cartão de crédito</option>
            <option value="BOLETO">Boleto</option>
        </select>
    </label>
    <section id="dadosCartao">
        <label>Número do cartão
            <input type="text" name="pagamentoRequest.numeroCartao" value="123456">
        </label>
        <label>DataVencimento
            <input type="text" name="pagamentoRequest.dataVencimento" data-mask="00/00" data-mask-selectonfocus="true" >
        </label>
        <label>Número do cartão
            <input type="text" name="pagamentoRequest.digitosVerificadores" value="987">
        </label>
    </section>
    <h3>Valor a pagar: R$ ${pagamentoRequest.valor}</h3>
    <input type="submit" value="Confirmar" />
</form>
</body>
</html>
