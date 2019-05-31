
function changeInput()
{
	var candidato = document.getElementById('candidato').value;
	if(candidato)
	{
		if(candidato === "") candidato = "0";
		document.getElementById('voto').value = candidato;
		document.getElementById('imgCandidato').src = './votacao/images/' + candidato + '.jpg';
	}
}

function clear()
{
	location.reload();
};

function vote()
{
	var value = document.getElementById('candidato').value;
	document.getElementById('voto').value = value ? value : "0";
}