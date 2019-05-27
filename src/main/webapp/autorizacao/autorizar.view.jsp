<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./votar/styles.css" type="text/css"/>
<script type="text/javascript" src="./services/service.js"></script>
<script type="text/javascript" src="./autorizacao/autorizar.controller.js"></script>
<title>Autorizar votacao</title>
</head>
<body>
    <form class="conainer">
        <div class="aut">
          <label>Titulo de Eleitor</label>
            <input type="text" name="titulo" id="titulo" required/>
        </div>            
        <div class="aut">
          <label>Nome</label>
          <input type="text" name="nome" id="nome" readonly/>
        </div>
        <button class="confirm" onclick="autorizar()">Autorizar</button>
    </form>
</body>
</html>