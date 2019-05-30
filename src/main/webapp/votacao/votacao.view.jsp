<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<script type="text/javascript" src="./votacao/votacao.controller.js"></script>
<title>Votacao</title>
</head>
<body>
<div>
  <form class="container">
    <h1>Votar</h1>
    <input type="text" placeholder="numero do candidato" name="candidato" id="idcandidato" oninput="changeInput()">
    <input type="hidden" id="titulo" value="${sessionScope.titulo}">

    <button class="confirm" onclick="vote(1)">CONFIRMA</button>    
    <button class="null" onclick="vote(0)">BRANCO</button>
    <button class="clear" onclick="clear()">CORRIGE</button>
  </form>
</div>
<img id="imgCandidato" src="./votacao/images/0.png" alt="Cabo Daciolo" style="width:100%">
</body>
</html>