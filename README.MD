# SMS API

API REST para gerenciamento de status de mensagens SMS, desenvolvida com Spring Boot e PostgreSQL.

## Tecnologias Utilizadas

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- MapStruct
- Lombok
- SpringDoc OpenAPI (Swagger)
- Bean Validation

## Como Executar

### Pré-requisitos

- Java 21
- PostgreSQL instalado e rodando
- Maven

### Configuração do Banco de Dados

Crie um banco de dados no PostgreSQL:

```sql
CREATE DATABASE db_sms;
```

### Configuração do application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/db_sms
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=false
```

### Rodando a Aplicação

```bash
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

A documentação Swagger estará disponível em: `http://localhost:8080/swagger-ui/index.html`

---

## Endpoints da Aplicação

### SMS

- **POST /api/sms**
    - Cadastra uma nova mensagem SMS.
    - Body: `{ "phoneNumber": "85999999999" }`
    - Resposta: `201 Created`
    - Erro: `400 Bad Request` — dados inválidos.

- **PUT /api/sms/{id}**
    - Atualiza o status de uma mensagem SMS pelo ID.
    - Body: `{ "status": "RECEBIDO" }`
    - Resposta: `200 OK`
    - Erro: `404 Not Found` — mensagem não encontrada.
    - Erro: `400 Bad Request` — status inválido.

- **GET /api/sms/relatorio?status={status}**
    - Retorna todas as mensagens com o status especificado das últimas 24 horas.
    - Parâmetro: `status` — valores aceitos: `ENVIADO`, `RECEBIDO`, `ERRO_DE_ENVIO`
    - Resposta: `200 OK`

---

## Regras de Negócio

- IDs são puramente numéricos gerados automaticamente.
- Status válidos: `ENVIADO`, `RECEBIDO`, `ERRO_DE_ENVIO`.
- Ao cadastrar uma mensagem, o status inicial é definido automaticamente como `ENVIADO`.
- O relatório filtra mensagens pelo status informado nas últimas 24 horas.

---

## Estrutura do Projeto

```
src/main/java/com/alan/api_sms
├── controller      # Endpoints REST
├── service         # Regras de negócio
├── repository      # Acesso ao banco de dados
├── entity          # Entidades JPA
├── dto             # Objetos de transferência de dados
├── enums           # Enum de status do SMS
├── mapper          # Conversão entre DTOs e entidades (MapStruct)
└── exception       # Exceções customizadas e handler global
```

---

## Padrão de Erros

Todos os erros retornam o seguinte formato JSON:

```json
{
  "status": 404,
  "mensagem": "Mensagem não encontrada",
  "timestamp": "05/05/2026 10:00:00"
}
```