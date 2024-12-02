# language: pt
Funcionalidade: API - Cliente

  Cenário: Registrar um novo cliente
    Quando submeter o registro de um novo cliente
    Então o cliente deve ser registrado com sucesso

  Cenário: Consulta um cliente
    Quando submeter uma consulta por um cpf ja cadastrado
    Entao deve conseguir localizar o cliente