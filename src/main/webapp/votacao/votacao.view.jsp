<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="./css/bootstrap-responsive.min.css" type="text/css"/>
<script type="text/javascript" src="./votacao/votacao.controller.js"></script>
<script type="text/javascript" src="./services/service.js"></script>
<title>Votacao</title>
</head>
<body>
<div>
  <form class="container" method="POST" action="/Eleicao/votar">
    <h1>Votar</h1>
    <input type="text" placeholder="numero do candidato" name="candidato" id="candidato" oninput="changeInput()">
    <input type="text" id="user" name="user" value="${sessionScope.titulo}" readonly>

    <input type="hidden" id="voto" name="voto" readonly>
    <button class="confirm" onclick="vote()">CONFIRMA</button>    
    <button class="null" onclick="vote()">BRANCO</button>
    <!--<button class="clear" onclick="clear()">CORRIGE</button>-->
    <button class="other" onclick="backPage('titulo')">VOLTAR</button>
  </form>
</div>
<img id="imgCandidato" src="./votacao/images/0.png" style="width:100%">
</body>
</html>