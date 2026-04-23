# Projeto LAB III - Sistema de Cadastro de Fórmulas e Gnomos

Projeto dividido em duas partes: **API** (backend) e **Web** (frontend).

## 📁 Estrutura

```
goblinsforms/
├── api/                    # Backend - Servidor Express com API REST
│   ├── app.js
│   ├── package.json
│   ├── src/
│   │   ├── controllers/
│   │   ├── routes/
│   │   └── services/
│   └── data/
└── db/                     # Banco de Dados - postgres
|    └── .Dockerfile
|    └── init.sql    
│
└── web/                    # Frontend - Consumidor da API
    ├── server.js
    ├── package.json
    ├── public/
    │   ├── index.html
    │   ├── style.css
    │   └── app.js
    └── .gitignore
```

## 🚀 Instalação e Execução

### 1️⃣ Instalar dependências da API

```bash
cd api
npm install
```

### 2️⃣ Instalar dependências do Web

```bash
cd web
npm install
```

### 3️⃣ Rodar a API (Terminal 1)

```bash
cd api
npm start
```

A API estará disponível em: **http://localhost:3000**

### 4️⃣ Rodar o Frontend (Terminal 2)

```bash
cd web
npm start
```

O frontend estará disponível em: **http://localhost:3001**

## 💡 Como usar o Frontend

1. Acesse http://localhost:3001
2. Clique nos botões para testar cada endpoint
3. O resultado será exibido no textarea
4. Adicione novos usuários usando o formulário
5. Busque usuários por ID ou cidade

## 🔗 Arquitetura

```
Frontend (web:3001)
      ↓
  server.js (proxy com axios)
      ↓
  Backend API (api:3000)
      ↓
  Controllers → Services → Data
```

O frontend faz requisições HTTP para o servidor `web`, que atua como proxy e encaminha para a API no backend.

## 📦 Dependências

### API
- express: ^5.2.1

### Web
- express: ^5.2.1
- axios: ^1.6.2

## 🛠️ Scripts disponíveis

### API
```bash
npm start    # Inicia o servidor na porta 3000
npm run dev  # Mesmo que start
```

### Web
```bash
npm start    # Inicia o servidor na porta 3001
npm run dev  # Mesmo que start
```

## 📧 Suporte

Este projeto foi desenvolvido para fins educacionais do LAB III.
