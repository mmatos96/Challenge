Para executar o projeto é necessário fazer download e de seguida abrir com o IntelliJ, depois disso é executar o projeto.

A API irá ficar a disponivel em http://localhost:8080/

Para testar os métodos desponibilizados pela API podemos usar o PostMan.

Exemplos de pedidos:

**Ir buscar todos os Filmes**

GET - http://localhost:8080/api/movie/

**Filtrar filmes pela data de lançamento**

GET - http://localhost:8080/api/movie/filterByDate/{releaseDate}

**Ir buscar um filme pelo nome**

GET - http://localhost:8080/api/movie/{name}

**Apagar um filme**

DELETE - http://localhost:8080/api/movie/{name}

**Adiconar um novo Filme**

POST - http://localhost:8080/api/movie/

BODY - ```json
{
"title":"Avatar",
"releaseDate":"2009-12-19",
"revenue":2847305509,
"rank":7.8
}```

**Atualizar um Filme existente**

PUT - http://localhost:8080/api/movie/

BODY - ```json
{
"title":"Avatar",
"releaseDate":"2009-12-19",
"revenue":2847305509,
"rank":8.8
}```

