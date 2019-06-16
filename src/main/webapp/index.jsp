<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">		
        <meta name="viewport" content="width=device-width, initial-scale=1.0">         
        <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
        <link rel="stylesheet" href="css/styles.css" type="text/css"/>  
        <script type="text/javascript" src="./services/jquery.js"></script>
        <script type="text/javascript" src="./services/service.js"></script>
		<title>Justica Eleitoral</title>
		</head>
	<body>
    <form class="container" action="/Eleicao/autenticar" method="POST">
      <h1>Justica Eleitoral</h1>
      <div class="login">
        <label>Titulo de Eleitor</label>
          <input type="text" name="titulo" id="titulo" required/>
      </div>            
      <div class="login">
        <label>Senha</label>
        <input type="password" name="senha" id="senha" required/>
      </div>
      <button class="confirm" type="submit">Entrar</button>
    </form>
	</body>
</html>