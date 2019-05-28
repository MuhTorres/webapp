function carregarValores()
{
    var query = location.search.slice(1);
    var partes = query.split('&');
    var data = {};
    partes.forEach(function (parte) {
        var chaveValor = parte.split('=');
        var chave = chaveValor[0];
        var valor = chaveValor[1];
        data[chave] = valor;
    });
    document.getElementById('func').value = data.titulo;
    document.getElementById('nivel').value = data.nivel;
}

function validar()
{
    carregarValores();
    var usuario = this.document.getElementById('titulo').value;
    var me = this;
    //var autorizador = '654321';
    $.ajax({
            type: 'GET',
            url: '/Eleicao/autorizar/'+'?titulo='+usuario,
            //data: { titulo: usuario, autBy: autorizador },
            context: me,
            async: false,
            beforeSend:function(){
                // this is where we append usually a loading image
            },
            success:function(data){
                alert(data);
            },
            error:function(error){
                alert(error);
            }
        });	  
}