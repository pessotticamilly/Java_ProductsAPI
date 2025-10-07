# API REST de Produtos e Categorias

Projeto de API REST para gerenciar **produtos** e **categorias**, desenvolvido em **Java 17** com **Spring Boot**, utilizando banco **H2 em memória**.
A API permite: criar, listar, buscar, atualizar e excluir produtos e categorias, com respostas claras e didáticas.

---

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (em memória)
- Maven

---

## 🚀 Como rodar

1. Baixar e escompactar o arquivo zip ou clonar o repositório Git
2. Abrir o arquivo gerado com o IntelliJ IDE
3. Rodar o arquivo `ProductsApiApplication`, isso fará com que o projeto rode em `http://localhost:8080`

---

## 📌 Endpoints
Use o link abaixo para ter acesso à uma coleção do Postman, com todos os endpoints e exemplos de request:
`https://camillypessotti05-4726659.postman.co/workspace/Camilly-Pessotti's-Workspace~90f7a666-1e40-4a4c-8dee-5542f59bae8f/collection/49092169-e24e1bd3-3d91-48fe-ad80-685d1d93e5e1?action=share&creator=49092169`

---

## 📝 Observações
- A API utiliza DTOs (ProductResponseDTO) para respostas de produtos, mostrando apenas categoryId e categoryName.

---

## 🧪 Testando a API
Use Postman, Insomnia ou curl. Ordem recomendada:
- Criar categorias
- Criar produtos
- Listar, buscar, atualizar e excluir conforme necessário
