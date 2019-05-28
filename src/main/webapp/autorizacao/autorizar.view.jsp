<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../votar/styles.css" type="text/css"/>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="./autorizar.controller.js"></script>
<script type="text/javascript" src="../services/service.js"></script>
<title>Autorizar votacao</title>
</head>
<body>
    <form class="conainer">
        <div class="aut">
          <label>Titulo do Eleitor</label>
            <input type="text" name="titulo" id="titulo" required/>
        </div>            
        <div class="aut">
          <label>Nome</label>
          <input type="text" id="usuario" name="nome" readonly/>
          <input type="hidden" id="func" name="func" readonly/>          
          <input type="hidden" id="nivel" name="nivel" readonly/>
        </div>
        <button class="clear" onclick="validar()">Validar</button>
        <button class="confirm" onclick="autorizar()">Autorizar</button>
    </form>
</body>
</html>