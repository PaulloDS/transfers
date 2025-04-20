# PicPay Simplificado

## Descrição
Este projeto é uma versão simplificada da plataforma de pagamentos PicPay, com funcionalidades básicas de transferência entre usuários comuns e lojistas. O sistema permite que usuários realizem depósitos e transferências de dinheiro para outros usuários e lojistas, com a devida validação de saldo e consulta a um serviço de autorização externo. 

Além disso, o sistema envia notificações (simuladas por um mock de serviço externo) sempre que um pagamento é recebido, seja por um usuário comum ou lojista.

## Funcionalidades
- **Cadastro de usuários**: Cadastro de usuários comuns e lojistas com nome completo, CPF, e-mail e senha. CPF e e-mails são únicos no sistema.
- **Transferências**: Realização de transferências entre usuários e de usuários para lojistas.
- **Validação de saldo**: Verificação se o usuário tem saldo suficiente antes de realizar uma transferência.
- **Consulta ao serviço autorizador**: Antes de finalizar a transferência, é feita uma consulta a um serviço de autorização externo para garantir que a transação pode ser processada.
- **Transação e reversão**: A operação de transferência é transacional, ou seja, qualquer inconsistência na operação reverte a transferência.
- **Notificação de pagamento**: Envio de notificações (simuladas via API externa) para o usuário ou lojista sempre que um pagamento é recebido.
- **Sistema RESTful**: A aplicação segue os princípios de design RESTful.

## Tecnologias Utilizadas
- **Java** (ou outra linguagem escolhida)
- **Framework** (caso utilizado)
- **Banco de Dados**: Implementação de armazenamento dos dados dos usuários e transferências (pode ser MongoDB ou qualquer outro banco relacional ou não relacional, dependendo da escolha do desenvolvedor).
- **Mock de serviços externos**: 
  - Autorização: [https://util.devi.tools/api/v2/authorize](https://util.devi.tools/api/v2/authorize) (GET)
  - Notificação: [https://util.devi.tools/api/v1/notify](https://util.devi.tools/api/v1/notify) (POST)

## Requisitos de Sistema
- **Cadastro de Usuários**: Nome, CPF, e-mail, senha.
- **Transferência de Dinheiro**: Validação de saldo, consulta ao serviço autorizador, e transação reversível.
- **Notificação**: Envio de e-mails ou SMS simulados após a transferência.
