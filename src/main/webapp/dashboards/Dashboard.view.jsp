<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Zona Eleitoral</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" href="./css/bootstrap-responsive.min.css" type="text/css"/>
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
        <script type='text/javascript' src='./dashboards/Dashboard.controller.js'></script>
        <script type="text/javascript" src="./services/service.js"></script>
    </head>
    
    <body>
        <form class="container" action="/Eleicao/redirect" method="POST">
            <h1>Area do Usuario</h1>     
                     
            <button class="confirm" onclick="redirect('votacao')">Votar</button>

            <button style="display: none;" id="aut" class="clear" onclick="redirect('autorizar')">Autorizar</button>
            <button style="display: none;" id="logs" class="other" onclick="redirect('logs')">Log de Sessão</button>
            <button style="display: none;" id="computarVotos" class="other" onclick="redirect('computarVotos')">Computar Votos</button>

            <input type="hidden" name="titulo" id="titulo" value="${sessionScope.titulo}"/>
            <input type="hidden" name="nivel" id="nivel" value="${sessionScope.nivel}"/>
            <input type="hidden" name="pagina" id="pagina"/>
          </form>
    </body>
</html>
