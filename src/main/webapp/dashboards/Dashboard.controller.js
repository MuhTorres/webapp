window.onload = function()
 {
	 btnVotar = document.getElementById('btnVotar');
	 btnLiberar = document.getElementById('btnLiberar');
	 btnRelatorio = document.getElementById('btnRelatorio');
	 
	 
     fVotar = document.getElementById('votar');
     fliberar = document.getElementById('liberar');
     fRelatorio = document.getElementById('relatorio');
     
     fliberar.classList.add('invisivel');
     fRelatorio.classList.add('invisivel');
     
     btnVotar.onclick = function(){
    	 fVotar.classList.remove('invisivel');
    	 fVotar.classList.add('visivel');
    	 fliberar.classList.remove('visivel');
    	 fliberar.classList.add('invisivel');
    	 fRelatorio.classList.remove('visivel');
    	 fRelatorio.classList.add('invisivel');
     };
     
     btnLiberar.onclick = function(){
    	 fliberar.classList.remove('invisivel');
    	 fliberar.classList.add('visivel');
         fVotar.classList.remove('visivel');
         fVotar.classList.add('invisivel');
         fRelatorio.classList.remove('visivel');
    	 fRelatorio.classList.add('invisivel');
     }; 
     
     btnRelatorio.onclick = function(){
    	 fliberar.classList.remove('visivel');
    	 fliberar.classList.add('invisivel');
         fVotar.classList.remove('visivel');
         fVotar.classList.add('invisivel');
         fRelatorio.classList.remove('invisivel');
    	 fRelatorio.classList.add('visivel');
     }; 
 };