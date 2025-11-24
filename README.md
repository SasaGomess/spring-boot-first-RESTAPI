# 🏷️Flow Orders — REST API

Uma API REST construída com Spring Boot focada no gerenciamento de usuários, produtos e pedidos, seguindo boas práticas de arquitetura em camadas, tratamento elegante de erros e exploração completa de relacionamentos JPA.

## 🛍️ Sobre o Projeto

Flow Orders é uma API que simula um sistema de pedidos, permitindo consultar usuários, produtos, categorias e pedidos — além de executar operações CRUD completas nas principais entidades.

O projeto foi desenvolvido para praticar conceitos fundamentais de backend com Java + Spring Boot, incluindo:

- Arquitetura em camadas (resource → service → repository)

- Relacionamentos avançados JPA

- Perfis de execução (dev e test)

- Tratamento de exceções customizado

- Popular dados automaticamente no H2 para testes

- Estrutura limpa e de fácil manutenção

## ⚙️ Tecnologias

- Java 17+

- Spring Boot (Web, Data JPA)

- PostgreSQL (profile: dev)

- H2 (em memória no profile: test)

- Maven (gerenciador de dependências)
  
- Postman (Teste de endpoints)

## 🏛️ Arquitetura do Sistema

### **O projeto é organizado em camadas independentes:**

  - 🎛️ resource/      #controladores REST

  - 🧠 service/       #lógica de negócio e validações

  - 🗃️ repository/    #interfaces JPA e operações de banco

  - 🙎🏻 entities/      #modelo de domínio (JPA)

  - ❌ exception/     #handlers, erros padronizados e exceções customizadas

  - ⚙️ config/        #configurações e seed para H2 (profile test)

**💡Essa separação garante clareza, testabilidade e facilidade de evolução.**

## 🗄️ Perfis da Aplicação
### 🔹 dev

- Usando PostgreSQL

- Ideal para rodar localmente com banco real

- Ajustável via application-dev.properties

``Use spring.profiles.active=dev. -> para ativar o perfil de desenvolvimento``

### 🔹 test

- Usando H2 em memória

- Banco populado automaticamente ao iniciar

- Ótimo para testes rápidos e desenvolvimento inicial

- `` Use spring.profiles.active=test. -> para ativar o perfil de testes``

## ⚙️ Funcionalidades
### ✨ CRUD Completo

### ✅ CRUD completo para:

- Produto (CREATE / READ / UPDATE / DELETE)

- Usuário (CREATE / READ / UPDATE / DELETE)

### ✅ Operações READ (somente findById / findAll) para outras entidades:

- Order (Pedido)

- Category (Categoria)

- OrderItem / Payment — dependendo do escopo: consultas por id / listagem

### ✅ Tratamento de exceções:

- ResourceNotFoundException — exceção personalizada para recursos não encontrados.

- HandlerException — classe que captura exceções e retorna StandardError no body, evitando erro 500 genérico quando um usuário/entidade não for encontrada.

- StandardError — formato uniforme para respostas de erro (timestamp, status, mensagem, path).

### ✅ Relacionamentos JPA explorados:

- @OneToOne (ex.: Order ↔ Payment)

- @OneToMany / @ManyToOne (ex.: User → Orders)

- @ManyToMany com entidade associativa (OrderItem) e classe para representar PK composta

### ✅ Camada de configuração para popular banco H2 no perfil test (seed data).

### ❌ Tratamento de erros

- StandardError → resposta formatada

- ResourceNotFoundException → erro específico para entidade inexistente

- HandlerException → intercepta exceções e retorna status correto

## 🌐 Endpoints Exemplos

````👤 Usuários
GET    /users
GET    /users/{id}
POST   /users
PUT    /users/{id}
DELETE /users/{id}
````

````
📦 Produtos
GET    /products
GET    /products/{id}
POST   /products
PUT    /products/{id}
DELETE /products/{id}
````

````
📑 Pedidos
GET /orders
GET /orders/{id}
````

## ▶️ Como Executar

#### 1) Clone o Repositório
````
git clone https://github.com/SasaGomess/spring-boot-first-RESTAPI.git
cd spring-boot-first-RESTAPI
````
#### 2) Configure o Perfil escolhido no ``src/main/resources/application.properties``

#### 3) Caso tenha escolhido o perfil Dev atualize o ``src/main/resources/application-dev.properties``:
````
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_SEU_db
spring.datasource.username=SEU_usuario
spring.datasource.password=SUA_senha
spring.jpa.hibernate.ddl-auto=update
````
#### 3) Caso tenha escolhido o perfil Test acesse no navegador o endereco: 
``http://localhost:8080/h2-console``

#### 5) Execute o programa e utilize a ferramenta Postman para testar os endpoints.

## 📌 Exemplo do Tratamento de erros

Quando um recurso não é encontrado, a API retorna um corpo padronizado StandardError com:

- timestamp

- status (HTTP)

- mensagem (ex.: "Resource not found")

- path (endpoint requisitado)

***Isso evita respostas 500 genéricas e possibilita frontends clientes a lidarem corretamente com erros 404/400.***

## 🎯 Melhorias Futuras

- Autenticação & autorização (JWT)

- DTOs e validações com Bean Validation

- Documentação com Swagger

- Docker Compose com Postgres

## 🤝 Contribuição

Sinta-se à vontade para abrir issues, propor melhorias ou enviar PRs!

***Feito por Sabrina Gomes & Dev Superior***
