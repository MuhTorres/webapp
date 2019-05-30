<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Zona Eleitoral</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" href="./css/styles.css" type="text/css"/>
        <script type='text/javascript' src='./dashboards/Dashboard.controller.js'></script>
    </head>
    
    <body>
        <form class="container" action="/Eleicao/redirect" method="POST">
            <h1>Area do Usuario</h1>     
                     
            <button class="confirm" onclick="redirect('votacao')">Votar</button>

            <button style="display: none;" id="aut" class="clear" onclick="redirect('autorizar')">Autorizar</button>
            <button style="display: none;" id="log" class="other" onclick="redirect('log')">Log de Sessão</button>
            <button style="display: none;" id="computarVotos" class="other" onclick="redirect('computarVotos')">Computar Votos</button>

            <input type="hidden" name="titulo" id="titulo" value="${sessionScope.titulo}"/>
            <input type="hidden" name="nivel" id="nivel" value="${requestScope.nivel}"/>
            <input type="hidden" name="pagina" id="pagina"/>
          </form>
    </body>
</html>
