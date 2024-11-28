//RECUPERA A INFORMACAO DE TODOS OS 
//PRODUTOS CADASTRADOS NO SISTEMA
function getAllHerois() {

    axios.get('http://localhost:8080/heroi')
    .then(function (response) {
        console.log(response);

        var jsonData = response.data;
        var tableBody = $("table tbody");

        jsonData.forEach(heroi => {
            
            var markup = "<tr>" +
                         "<td>" + heroi.id + "</td>" +
                         "<td>" + heroi.nome + "</td>" +
                         "<td>" + heroi.apelido + "</td>" +
                         "<td>" + heroi.superPoder + "</td>" +
                         "<td>" + heroi.fraqueza + "</td>" +
                         "<td>" + heroi.historiaOrigem + "</td>" +
                         "<td>" + heroi.primeiraAparicao + "</td>" +
                         "<td>" + (heroi.categoria ? heroi.categoria.nome : "") + "</td>";

                         "<td> <button type='button' class='btn btn-danger' onclick='excluirHeroi(" + heroi.id 
                         + ")'>Excluir</button> </td>" +

                         "</tr>";

            tableBody.append(markup);            
        });
    })
    .catch(function (error) {
        // handle error
        console.log(error);
    });

} //fim function


function excluirHeroi(idHeroi) {
    
    axios.delete("http://localhost:8080/heroi/" + idHeroi)
    .then()
    .catch();

}


function getAllEquipes() {
    
}
