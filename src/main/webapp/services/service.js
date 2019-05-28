function doVote(requestData) {
    var me = this;
    global.request({
        type: 'POST',
        url: String.format('/Eleicao/votar'),
        data: JSON.stringify(requestData.data),
        dataType: 'json',
        context: me,
        async: false,
        error: function (xhr, status, error) {
            requestData.failure.call(requestData.scope, { msg: treatError.getErrorMsg(xhr, status, error) });
        },
        success: function (response) {
            requestData.success.call(requestData.scope, response);
        }
    });
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
          //context: me,
          async: false,
          //beforeSend:function(){
              // this is where we append usually a loading image
          //},
          success: function(data){
            var obj = JSON.parse(data);   
            var url = 'http://localhost:8080/Eleicao/autorizacao/autorizar.view.jsp?titulo=' + obj.titulo + '&nivel=' + obj.nivel;
            location.href = url;
            return location.href;
          },
          error: function(error){
              alert(error.status);
          }
      });	  
};
