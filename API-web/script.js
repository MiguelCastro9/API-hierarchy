document.getElementById("salvarGestor").addEventListener("click", function() {
    var nome = document.getElementById("gestor").value;
    var senha = document.getElementById("senhaGestor").value;

    var data = {
        nome: nome,
        senha: senha
    };

    var jsonData = JSON.stringify(data);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/gestor/salvar", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function() {
        if (xhr.status === 200) {
            console.log("Requisição bem-sucedida!");
            alert('salvo com sucesso!')
            console.log(xhr.responseText);
        } else {
            console.log("Ocorreu um erro na requisição. Código: " + xhr.status);
        }
    };
    xhr.send(jsonData);
});

document.getElementById("salvarColaborador").addEventListener("click", function() {
    var nome = document.getElementById("colaborador").value;
    var senha = document.getElementById("senhaColaborador").value;

    var data = {
        nome: nome,
        senha: senha,
        gestor: {
            id: id,
            nome: nome,
            senha: senha
        }
    };

    var jsonData = JSON.stringify(data);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/colaborador/salvar", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function() {
        if (xhr.status === 200) {
            console.log("Requisição bem-sucedida!");
            alert('salvo com sucesso!')
            console.log(xhr.responseText);
        } else {
            console.log("Ocorreu um erro na requisição. Código: " + xhr.status);
        }
    };
    xhr.send(jsonData);
});