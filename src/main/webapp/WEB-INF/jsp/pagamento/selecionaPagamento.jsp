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
<form action="/PayNow/pagamento/confirmacao">
    <label> Recebedor
        <select name="recebedor">
            <c:forEach var="e" items="${usuarios}">
                <option value="${e.id}">${e.nome}</option>
            </c:forEach>
        </select>
    </label>
    <label> Recebedor
        <select name="pagador">
            <c:forEach var="e" items="${usuarios}">
                <option value="${e.id}">${e.nome}</option>
            </c:forEach>
        </select>
    </label>
    <label> Forma de pagamento
        <select name="pagador">
            <option value="CARTAO_DE_CREDITO">Cartão de crédito</option>
            <option value="BOLETO">Boleto</option>
        </select>
    </label>
    <label> Forma de pagamento
        <select name="pagador">
            <option value="CARTAO_DE_CREDITO">Cartão de crédito</option>
            <option value="BOLETO">Boleto</option>
        </select>
    </label>
    <h3>Valor a pagar: R$ ${pagamento.valor}</h3>
    <input type="submit" value="Confirmar" />
</form>
<jsp:text>
    O usuário é : ${usuarios[0].nome}
</jsp:text>
</body>
</html>
