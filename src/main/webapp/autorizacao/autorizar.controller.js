function autorizar()
{
    var that = this;
    var value = 
    {
        titulo: "123456",
        autBy: "654321"
    };
    authorize({
        data: value,
        scope: that.document,
        failure: function (xhr, status, error) {
            alert(treatError.getErrorMsg(xhr, status, error));
        },
        success: function (data) {
            alert("O usuário foi autorizado! " + data.nome);
        }
    });
};