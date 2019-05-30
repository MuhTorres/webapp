
function changeInput()
{
	var candidato = document.getElementById('idcandidato').value;
	if(candidato)
	{
		document.getElementById('imgCandidato').src = './votacao/images/' + candidato + '.jpg';
	}
};

function vote(value)
{
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			alert(this.responseText);
		}
	};
	value = value === 0 ? 0 : document.getElementById('idcandidato').value;
	xhttp.open("POST", "/Eleicao/votar", true);
	xhttp.setRequestHeader("Content-type", "application/json");
	xhttp.send("{usuario: " + document.getElementById('titulo').value
			   + ", candidato: " + value + "}");
};