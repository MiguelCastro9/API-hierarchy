function atualizarPagina() {
    location.reload();
}

document.getElementById("atualizar").addEventListener("click", atualizarPagina);

document.querySelectorAll(".password-toggle").forEach(button => {
  button.addEventListener("click", function() {
    var targetId = this.getAttribute("data-target");
    var targetInput = document.getElementById(targetId);

    if (targetInput.type === "password") {
      targetInput.type = "text";
      this.textContent = "Ocultar";
    } else {
      targetInput.type = "password";
      this.textContent = "Mostrar";
    }
  });
});

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

function getGestorId() {
    var selectElement = document.getElementById("selectGestor");
    var gestorId = selectElement.value;
    return gestorId;
  }
  
  function salvarColaborador() {
    var nomeColaborador = document.getElementById("colaborador").value;
    var senhaColaborador = document.getElementById("senhaColaborador").value;
    var gestorId = getGestorId();
  
    var data = {
      nome: nomeColaborador,
      senha: senhaColaborador,
      gestor: {
        id: gestorId
      }
    };
  
    var jsonData = JSON.stringify(data);
  
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/colaborador/salvar", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.onload = function() {
      if (xhr.status === 200) {
        console.log("Requisição bem-sucedida!");
        alert('Salvo com sucesso!');
        console.log(xhr.responseText);
      } else {
        console.log("Ocorreu um erro na requisição. Código: " + xhr.status);
      }
    };
    xhr.send(jsonData);
  }

document.getElementById("salvarColaborador").addEventListener("click", salvarColaborador);

function listarGestores() {
    fetch("http://localhost:8080/gestor/listar")
        .then(response => response.json())
        .then(gestores => {
            console.log("Requisição bem-sucedida!");
            var tabela = document.getElementById("tabelaGestores");
            var tbody = tabela.getElementsByTagName("tbody")[0];
            tbody.innerHTML = "";

            gestores.forEach(gestor => {
                var nome = gestor.nome;
                var score_senha = gestor.score_senha;

                var row = tbody.insertRow();
                var cellNome = row.insertCell(0);
                var cellScoreSenha = row.insertCell(1);

                cellNome.innerHTML = nome;
                cellScoreSenha.innerHTML = score_senha + '%';

                if (score_senha >= 0 && score_senha <= 30) {
                    cellScoreSenha.classList.add("cor-vermelha");
                }
                if (score_senha >= 31 && score_senha <= 59) {
                    cellScoreSenha.classList.add("cor-amarela");
                }
                if (score_senha >= 60 && score_senha <= 100) {
                    cellScoreSenha.classList.add("cor-verde");
                }
            });
        })
        .catch(error => {
            console.log("Ocorreu um erro na requisição: ", error);
        });
}

listarGestores();

function listarGestoresNoSelect() {
    var selectElement = document.getElementById("selectGestor");
  
    fetch("http://localhost:8080/gestor/listar")
      .then(response => response.json())
      .then(gestores => {
        console.log("Requisição bem-sucedida!");
  
        gestores.forEach(gestor => {
          var option = document.createElement("option");
          option.value = gestor.id;
          option.textContent = gestor.nome;
          selectElement.appendChild(option);
        });
      })
      .catch(error => {
        console.log("Ocorreu um erro na requisição: ", error);
      });
  }
  
listarGestoresNoSelect();

function listarColaboradores() {
    fetch("http://localhost:8080/colaborador/listar")
      .then(response => response.json())
      .then(colaboradores => {
        console.log("Requisição bem-sucedida!");
        var tabela = document.getElementById("tabelaColaboradores");
        var tbody = tabela.getElementsByTagName("tbody")[0];
        tbody.innerHTML = "";
  
        colaboradores.forEach(colaborador => {
          var nome = colaborador.nome;
          var score_senha = colaborador.score_senha
          var gestor = colaborador.gestor.nome;
  
          var row = tbody.insertRow();
          var cellNome = row.insertCell(0);
          var cellScoreSenha = row.insertCell(1);
          var cellGestor = row.insertCell(2);
  
          cellNome.innerHTML = nome;
          cellScoreSenha.innerHTML = score_senha + '%';
          cellGestor.innerHTML = gestor;

          if (score_senha >= 0 && score_senha <= 30) {
            cellScoreSenha.classList.add("cor-vermelha");
        }
        if (score_senha >= 31 && score_senha <= 59) {
            cellScoreSenha.classList.add("cor-amarela");
        }
        if (score_senha >= 60 && score_senha <= 100) {
            cellScoreSenha.classList.add("cor-verde");
        }
          
        });
      })
      .catch(error => {
        console.log("Ocorreu um erro na requisição: ", error);
      });
  }

  listarColaboradores();