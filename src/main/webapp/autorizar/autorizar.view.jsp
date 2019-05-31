<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css"/>
<link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="./css/bootstrap-responsive.min.css" type="text/css"/>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="./autorizar/autorizar.controller.js"></script>
<script type="text/javascript" src="./services/service.js"></script>
<title>Autorizar votacao</title>
</head>
<body>
    <form class="container" action="/Eleicao/autorizar" id="form" method="POST">
        <div class="aut">
          <label>Titulo do Eleitor</label>
            <input type="text" name="usuario" id="usuario" placeholder="titulo do eleitor" value="${requestScope.usuario}"/>
        </div>            
        <div class="aut">
          <label>Nome</label>      
          <input type="text" id="nome" name="nome" value="${requestScope.nome}" readonly/>
          <label>Autorizado a votar?</label>
          <input type="text" id="liberado" name="liberado" value="${requestScope.liberado}" readonly/>
          <label>Ja votou?</label>
          <input type="text" id="javotou" name="javotou" value="${requestScope.javotou}" readonly/>
          <input type="hidden" id="func" name="func" value="${sessionScope.titulo}" readonly/>  
          <input type="hidden" id="nivel" name="nivel" value="${sessionScope.nivel}" readonly/>
        </div>
        <button class="clear" onclick="validar()">Validar</button>
        <button class="confirm" onclick="autorizar()">Autorizar</button>        
        <button class="other" onclick="backPage('usuario')">Voltar</button>
    </form>
</body>
</html>