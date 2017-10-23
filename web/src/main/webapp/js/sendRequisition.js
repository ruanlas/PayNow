function enviarRequisicao(url, object) {
    return function () {
        var request = new XMLHttpRequest();
        request.open('POST', url);
        request.setRequestHeader('Content-Type', 'application/json')
        request.send(JSON.stringify(object));
    }
}

