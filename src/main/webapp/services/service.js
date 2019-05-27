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

function authorize(requestData) {
    var me = this;
    global.request({
        type: 'POST',
        url: String.format('/Eleicao/autorizar'),
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

function warehouse(requestData) {
    var me = this;
    global.request({
        type: 'GET',
        url: String.format('/Eleicao/autorizar', requestData.data),
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
