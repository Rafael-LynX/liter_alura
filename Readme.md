<div align="center">
  <h1 align="center">
    Liter Alura
    <br />
    <br />
    <a href="https://github.com/Rafael-LynX/conversor-moeda#">
      <img src="/assets/icon.png" alt="Conversor de Moeda">
    </a>
  </h1>
</div>

<p align="center">
  <a href="#license"><img src="https://img.shields.io/github/license/sourcerer-io/hall-of-fame.svg?colorB=ff0000"></a>
</p>

## 📖 About The Project

<img src="/assets/img.png" alt="Liter Alura">

O projeto foi feito devido a um desafio do curso da Alura do programa Oracle-ONE, esse projeto visa trabalhar o uso de API
e json para aprendizado. No meu código acabei criando algumas classes principais, como ConsumoApi e Principal:

* `ConsumoApi` Seria a classe para consumir a API.
* `Principal` Seria a classe para ter todos os métodos e funções para o código.

Código foi feito com simplicidade somente para o aprendizado, mas meu foco sempre é aprender Java junto com o curso,
sempre pensando na segurança dele, ainda está muito longe do ideal. Melhorias que poderia ter acontecido:

* Poderiamos ter um controle de limite de requisição para um API pública e os resultados podem ser armazenados em cache
ou no banco para evitar isso.
* Validar a entrada com `@Valid` e `@NotNull` para evitar salvar livros e autores com campos faltando.
* Sanitizar a entrada do usuário para evitar SQL Injection.

Essas são somente algumas que eu poderiam ter sido implementadas.

### 🔑 Key-Features
- `AutorRepository`: Seria para tratar algumas funções com os autores, como buscar autores vivos em determinado ano com ela.
- `RepostaApi`: Usada para lidar com a resposta da API, ela continha os dados buscados dentro de uma lista.

## 🚀 Getting Started

Liter Alura é uma aplicação para consumir a API Gutendex, ela pega os títulos de livros e armazena no banco de dados,
e com isso podemos consultar os livros e autores no banco, além disso podemos consultar dados específicos como livros 
filtrados por idioma e se autor está ou não vivo em determinado ano.

### 📋 Prerequisites

Os requisitos são que você tenha um banco de dados PostgreeSQL, e utilize suas variáveis de ambiente.
É necessário que você tenha `USER`, `PASSWORD`, `HOST`, `DB_NAME` e Atualize `application.properties`

### 🔧 Installation

Para sua instalação precisamos somente clonar o repositorio e acessar API Gutendex

1. [Gutendex](https://gutendex.com/)

2. Clone o repositório:
   ```sh
   git clone https://github.com/Rafael-LynX/liter_alura.git
   ```

## 🛠️ Built With

Ele foi construido apenas com Java.

* [![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/pt-BR/)

## 📄 License

Conversor de Moedas é distribúido sob a Licença [MIT licensed](./LICENSE).

## 🏆 Autor

[<img loading="lazy" src="https://avatars.githubusercontent.com/u/109623407?s=400&u=19dac11507a1cbd81c5c6ceb1526c24eb6033cce&v=4" width=115><br><sub>Rafael Vieira</sub>](https://github.com/Rafael-LynX) 



