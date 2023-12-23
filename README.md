# Projeto Zelda API

O Projeto Zelda API é uma aplicação baseada em Spring Boot composta por três microserviços dedicados aos fãs da franquia Zelda. Os serviços fornecem funcionalidades específicas para gerenciar usuários, consultar informações sobre jogos da franquia Zelda e atuam como um gateway para a comunicação entre os serviços.

## Microserviços

### 1. API de Usuários
- Este serviço permite a busca, cadastro e gerenciamento de usuários através de requisições HTTP.
- Desenvolvido em Java JDK 17 e implementado com Spring Boot, o serviço utiliza o PostgreSQL como banco de dados para armazenar informações dos usuários.
- A migração do banco de dados é realizada de maneira controlada e automatizada por meio do Flyway.

### 2. API de Consulta de Jogos Zelda
- Essa API consulta e retorna informações sobre os jogos da franquia Zelda a partir da API externa disponível em [FanAPIs Zelda](https://docs.zelda.fanapis.com/).
- Utiliza Spring Boot em conjunto com Maven para integração e consulta dos dados dos jogos.

### 3. API de Gateway (v1)
- A API de Gateway atua como um intermediário entre as APIs de Usuários e de Consulta de Jogos Zelda, facilitando a comunicação entre esses dois serviços.
- Na versão 1, o gateway foi implementado para permitir o roteamento e a comunicação eficiente entre as APIs de Usuários e Consulta de Jogos Zelda.
- Desenvolvida em Spring Boot, permite a integração e roteamento de solicitações entre as APIs.

## Funcionalidades Futuras
- Implementação de um sistema de token de segurança para garantir a autenticação e autorização adequadas.
- Introdução de um mecanismo de cache para otimizar o desempenho e reduzir o tempo de resposta das consultas.

## Tecnologias Utilizadas
- Linguagem: Java JDK 17
- Framework: Spring Boot
- Ferramentas de Gerenciamento de Dependências: Maven
- Banco de Dados: PostgreSQL (utilizando migração controlada pelo Flyway)
- IDE: IntelliJ IDEA

## Executando o Projeto
Para executar este projeto, siga as instruções abaixo:

1. Clone este repositório.
2. Certifique-se de ter o Java JDK 17 instalado em seu ambiente.
3. Configure as dependências Maven conforme descrito no arquivo `pom.xml`.
4. Garanta que o PostgreSQL esteja instalado e configurado corretamente, conforme as configurações do projeto.
5. Execute os serviços desejados (API de Usuários, API de Consulta de Jogos Zelda e API de Gateway) individualmente.

Certifique-se de consultar a documentação de cada serviço para obter informações detalhadas sobre os endpoints disponíveis e como utilizá-los.

**Observação:** Este projeto agora inclui a API de Gateway na versão 1. Novas atualizações serão feitas conforme o progresso do desenvolvimento, incluindo funcionalidades de segurança com token e cache, além de outras melhorias planejadas.

## Integrantes do Projeto

- [Eduardo Ferrão dos Santos](https://github.com/efsedu)
- [Pedro Lobato Toralles](https://github.com/PedroLobatoToralles)
- [David Silva Teixeira](https://github.com/davsteixeira)
- [Maria Fernanda Alves Moreno](https://github.com/OSorvete)
- [Gabriel Kretzmann](https://github.com/Kretzmann01)

