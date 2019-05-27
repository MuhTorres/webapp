<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Zona Eleitoral</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" href="../css/styles.css" type="text/css"/>
        <script type='text/javascript' src='Dashboard.controller.js'></script>
    </head>
    
    <body>
    <div class="tab">
        <button id=btnVotar class="botao">Votar</button>
        <button id=btnLiberar class="botao">Liberar candidato</button>
        <button id=btnRelatorio class="botao">Relatorio de se�ao</button>
    </div>
        <div id=votar class="conteudo">            
            <form>            
                <label> Numero do candidato </label>
                <input id=idCandidato type="text"/>
                <button>CONFIRMA</button>
				<button>CORRIGE</button>
				<button>BRANCO</button>
				
                <img src="../51.jpg" alt="Candidato" align="Right">
            </form>
        </div>
        <div id=liberar class="conteudo">
        <form>
            <label> Número do titulo do eleitor </label>
            <input id=idEleitor type="text"/>
            <button>Liberar</button>
        </form>
        </div>
        <div id=relatorio class="conteudo">
        <form>
            <label> Printar logs de sessão </label>
            <button>OK</button>
        </form>
        </div>
    </body>

    
</html>
