window.onload = function()
{
    var nivel = document.getElementById("nivel").value;
    if(nivel > 2)
    {
        document.getElementById("aut").style.display = "block";
        document.getElementById("log").style.display = "block";
    }
    else if(nivel == 2)
    {
        
        document.getElementById("aut").style.display = "block";
        document.getElementById("log").style.display = "none";
    }
    else
    {
        document.getElementById("aut").style.display = "none";
        document.getElementById("log").style.display = "none";
    }
};

function redirect(action)
{
    var url = "/" + action + "/" + action + ".view.jsp";
    document.getElementById("pagina").value = url;
};