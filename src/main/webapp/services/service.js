function url_redirect(url)
{
    var X = setTimeout(function()
    {
        window.location.replace(url);
        return true;
    }, 300);

    if(window.location = url)
    {
        clearTimeout(X);
        return true;
    } 
    else 
    {
        if( window.location.href = url )
        {
            clearTimeout(X);
            return true;
        }
        else
        {
            clearTimeout(X);
            window.location.replace(url);
            return true;
        }
    }
    return false;
};

function autorizar() {    
    var usuario = this.document.getElementById('titulo').value;
    var autorizador = '654321';
    var me = this;
    $.ajax({
          type: 'POST',
          url: '/Eleicao/autorizar',
          data: { titulo: usuario, autBy: autorizador },
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
};

function autenticar() {
    var me = this;
    var usuario = me.document.getElementById('titulo').value;
    var senha = me.document.getElementById('senha').value;
    $.ajax({
          type: 'POST',
          url: '/Eleicao/login',
          data: { titulo: usuario, senha: senha },
          context: me,
          async: false,
          beforeSend:function(){
              // this is where we append usually a loading image
              window.location.href = "https://www.google.com.br";
          },
          success: function(data){
            var obj = JSON.parse(data);   
            //var url = 'http://localhost:8080/Eleicao/autorizacao/autorizar.view.jsp';//?titulo=' + obj.titulo + '&nivel=' + obj.nivel;
            alert('Bem vindo ' + obj.nome);
            window.location.href = "http://www.google.com";
            return false;
          },
          error: function(error){
              alert(error.status);
          }
      });	  
};
