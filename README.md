<h1 align="center">Kit-Hexagonal</h1>

<br>

# 📖 Sobre
Projeto desenvolvido para ser utilizado como base para o desenvolvimento de projetos com arquitetura hexagonal.

# 📂 Estrutura de pacotes
  - A estrutura visa separar de maneira lógica os objetos que são classificados como de aplicação, infra e core. A estrutura pode evoluir mas deve manter a lógica 

<img alt="estrutura de pacotes" src="/hexa/hexagonal-estrutura-pacotes.drawio.png" width="150px"/>

# 🗃️ Diagrama de classes 
  - As classes devem ser serparadas conforme arquitetura abaixo e podem evluir seguindo a lógica da arquitetura e boas práticas 

<img alt="estrutura de pacotes" src="/hexa/hexagonal-diagrama de classes.drawio.png" width="380px"/>

# Estrutura do Projeto 

## Core 
  - As classes dentro do core da estrutura não devem possuir dependências de framework, então, por exemplo não dever
ter anotações do Spring Boot nem Jakarta. 

  - Anotações Lombok são aceitaveis.

  - Os **DTOs** do core pode ser utilizados em todo o ecossistema. Devem representar os dados de negócio. Não devem
representar as requisições de entrada ou saída nem formatos de modelos de dados ou áreas de transmissão.

  - Os **Services** devem implementar os InputPorts e rever por injeção no contrutor os OutputPorts. Responsáveis por 
definir o fluxo de negócio, usar UseCases e OutputPorts. 

  - Os **UseCases** recebem os Services e UseCases por injeção no contrutor. Aplicar as regras de negócio, podem usar 
OutputPorts.

  - Interfaces **InputPort** e **OutputPort**. Representam a entrada dos dados no core para processsamento e as saida
que o negócio precisa para processar.

## Adapters 

### InPort
  - Devem receber por injeção os InPorts. A injeção pode ser por contrutores ou por framework.

 ### OutPort
  - Devem receber por injeção os InPorts. A injeção pode ser por contrutores ou por outros frameworks, como Feign ou Spring Repository.

## Config 
  - As classes de configuração devem preparar e injetar as dependências nos Services, UseCases e Adapters quando necessitar.
  Utilizando as anotações do Spring algumas configurações de Adapters não precisam ser implementadas 

## Infra
  - Classes e componentes de uso global no microsserviço.
  - As configurações de infra contidas não devem influenciar no core.
  - As classes utilitárias podem fazer uma ponte funcional entre o core e dependências, mas não devem possuir interfarência no negócio.

# Tratamento de erro
## 2xx 
  - Uma vez que a requisição atingiu o core, todo tratamento de negócio deve gerar um status 200, salvo casos específicos que devem avaliar o uso por exemplo de status 204.
  - Caso o processamento gere um erro de negócio o status padrão deve ser 200 indicando que a requisição processou com sucesso, porém para o consumidor, no corpo da resposta deve
indicar que houve erro voltado ao negócio como não encontrar um registro ou não for possível efetivar uma inclusão devido ausência ou valor incosistente de algum campo.
## 4xx 
  - Devem representar erros relacionados à entrada. Todas as validações mínimas que ocorram no InputAdapter e gerem erro, como campos não preenchidos ou formatação errada, 
são exemplos de erro 400. Erros de negócio não devem gerar erro 400.
## 5xx
  - Devem representar erros não tratados nos microsserviços, erros de comunicação com entidades externas como conexões à base e outros microsserviços, ou quaisquer outros erros que não sejam de negócio.

docker run --detach --env 
MYSQL_ROOT_PASSWORD=password --env 
MYSQL_USER=hexa-user --env 
MYSQL_PASSWORD=password --env
 MYSQL_DATASE=hexa-database --name hexa --publish 3306:3306 mysql:8-oracle
