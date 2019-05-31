
function changeInput()
{
	var candidato = document.getElementById('candidato').value;
	if(candidato)
	{
		document.getElementById('imgCandidato').src = './votacao/images/' + candidato + '.jpg';
	}
};

// function vote(value)
// {
	// value = value === 0 ? 0 : document.getElementById('candidato').value;
	// document.forms[0].action += "?user="+document.getElementById('user').value + "&candidato=" + value;	
    // document.forms[0].method = "POST";
// };

function clear()
{
	window.location = "/votacao/votacao.view.jsp"
	document.getElementById('candidato').value = "";
	document.getElementById('imgCandidato').src = './votacao/images/0.jpg';
};