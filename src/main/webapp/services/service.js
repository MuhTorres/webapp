window.history.forward(1);

function backPage(valueName)
{
    valueName += '';
    var url = "&";
    url += valuename + "=" + document.getElementById(valueName).value;
    var nivel = document.getElementById("nivel").value;
    if(nivel && nivel != null && nivel !== '')  url += "&nivel=" + nivel;

    document.forms[0].action = "/Eleicao/redirect?pagina=/dashboards/Dashboard.view.jsp" + url;
    document.forms[0].method = "POST";
}

function goTo()
{
    window.location = "/Eleicao/redirect?pagina=/dashboards/Dashboard.view.jsp";
}