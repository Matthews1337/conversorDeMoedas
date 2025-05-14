# 💱 Conversor de Moedas - Java + ExchangeRate-API

Este é um projeto simples em Java que permite converter valores entre diferentes moedas em tempo real, utilizando a [ExchangeRate-API](https://www.exchangerate-api.com/).

---

## 🚀 Funcionalidades

- Conversão de moedas via linha de comando (CMD).
- Integração com API REST usando `HttpClient`.
- Leitura de variáveis de ambiente via arquivo `.env`.
- Código limpo com tratamento de exceções e mensagens amigáveis.

---

## 📁 Estrutura de Pastas

├── .env
├── Main.java
├── README.md
├── lib/
│ └── gson-2.10.1.jar
└── br/
└── com/
└── alura/
└── conversor/
├── API.java
├── Currency.java
├── ConversorMoedas.java
└── EnvLoader.java


---

## ⚙️ Pré-requisitos

- Java 11 ou superior
- Biblioteca [Gson](https://github.com/google/gson)

Você pode baixar o `gson-2.10.1.jar` [aqui](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar)

---

## 🔐 Configuração da API Key

Crie um arquivo `.env` na raiz do projeto com sua chave da ExchangeRate API:

```env
EXCHANGE_API_KEY=sua_api_key_aqui
```

## 💻 Exemplo de Uso

=== Conversor de Moedas ===

Digite a moeda de origem (ex: BRL) ou 'sair': brl
Digite a moeda de destino (ex: USD): usd
Digite o valor a ser convertido: 100
Resultado: 100.00 BRL = 20.00 USD


## 📦 Dependências
com.google.code.gson:gson:2.10.1

## 🧠 Dica
.env
