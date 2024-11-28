$( "button.btn-secondary" ).on( "click", function( event ) {
    document.location = '../index.html';
});

function carregarSelect() {
    axios.get('http://localhost:8080/equipe')
    .then(function (response) {
        var jsonData = response.data;
        var select = $('#equipe');

        jsonData.forEach(equipe => {
            optionText = equipe.nome;
            optionValue = equipe.id;
            let optionHTML = `
            <option value="${optionValue}">
                ${optionText}
            </option>`;
            select.append(optionHTML)
        });
    })
    .catch(function (error) {
        //handle error
        console.log(error);
    });
}

function cadastrarHeroi() {
    var nome = $('#nome').val();
    var apelido = $('#apelido').val();
    var superPoder = $('#superPoder').val();
    var fraqueza = $('#fraqueza').val();
    var historiaOrigem = $('#historiaOrigem').val();
    var primeiraAparicao = $('#primeiraAparicao').val();
    var equipe = $('#equipe').val();

    axios.post('http://localhost:8080/heroi',
    {
        "nome" : nome,
        "apelido" : apelido,
        "superPoder" : superPoder,
        "fraqueza" : fraqueza,
        "historiaOrigem" : historiaOrigem,
        "primeiraAparicao" : primeiraAparicao,

        "equipe" : {
            "id" : equipe
        }
    })
    .then(function (response) {
        alert('informação cadastrada');
        document.location = "listaProduto.html";
    })
    .catch(function (error) {
        //handle error
        console.log(error);
    })
}

carregarSelect();