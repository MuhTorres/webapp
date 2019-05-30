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

var usuario = "";//this.document.getElementById('titulo').value;
var senha = "";//this.document.getElementById('senha').value;
 //this.post('/Eleicao/login', { titulo: usuario, senha: senha });



 function autenticar() {
    var me = this;
    usuario = me.document.getElementById('titulo').value;
    senha = me.document.getElementById('senha').value;
    // $.post('/Eleicao/login', { titulo: usuario, senha: senha }, function(returnedData){
    //     console.log(returnedData);
    //     const url = '/Eleicao/autorizacao/autorizar.view.jsp';
    //     window.href = url;
    // }).fail(function(){
    //     console.log("error");
    // });
     $.ajax({
           type: 'POST',
           url: '/Eleicao/login',
           data: { titulo: usuario, senha: senha },
           dataType: 'json',
           success: function(data){
             //var obj = JSON.parse(data);   
             const url = '/Eleicao/autorizacao/autorizar.view.jsp';
             //alert('Bem vindo ' + obj.nome);
             document.forms[0].action = url;
           },
           error: function(jqXHR, textStatus){
               alert(jqXHR);
           }
       });	  
};
