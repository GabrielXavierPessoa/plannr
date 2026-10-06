# Arquitetura e escopo do MVP

Este documento registra a arquitetura conceitual do MVP do Plannr. Ele não define um esquema SQL nem um contrato final de API. Itens não decididos estão identificados como pendências; recomendações ainda dependem de aprovação da equipe.

## Status das informações

- **Confirmado pelo contexto:** informação explicitamente fornecida para o projeto.
- **Pendente de discussão:** decisão que a equipe ainda precisa tomar.
- **Recomendação (não aprovada):** opção técnica sugerida para avaliação, sem caráter de decisão.

## Visão geral e limites

### Confirmado pelo contexto

O Plannr é um sistema genérico de agendamento para diferentes tipos de estabelecimentos. As tecnologias planejadas são Next.js, React e TypeScript no frontend; Java com Spring Boot no backend; e MySQL no banco de dados.

O MVP prevê:

1. Listar estabelecimentos.
2. Exibir os serviços de um estabelecimento.
3. Consultar datas e horários disponíveis, respeitando o horário de funcionamento e os intervalos definidos pelo estabelecimento.
4. Exigir login ou cadastro antes de confirmar um agendamento.
5. Confirmar automaticamente um agendamento se o horário continuar disponível.
6. Impedir conflitos de agendamentos para o mesmo estabelecimento e horário.
7. Permitir que a pessoa usuária consulte e cancele seus próprios agendamentos.

Ficam fora do escopo inicial: calendários individuais de profissionais, painel administrativo completo, pagamentos online, notificações externas, avaliações e classificações.

Responsabilidades informadas para a equipe:

- Gabriel Xavier: frontend e integração com a API.
- Richard: backend Java/Spring Boot e participação na definição do banco.
- Laís: apoio na modelagem e organização do banco junto com Richard.

### Pendente de discussão

- O que significa, em termos de produto, “estabelecimento” e quais dados serão exibidos na listagem.
- Se haverá cadastro de estabelecimentos e serviços no MVP e como esses dados serão mantidos, dado que um painel administrativo completo está fora do escopo.
- Quais critérios determinam o encerramento do MVP e quais filtros ou opções de busca, se houver, são necessários.

## Papéis dos componentes

### Confirmado pelo contexto

- **Frontend:** aplicação web em Next.js, React e TypeScript, responsável pela interface e pela integração com a API; Gabriel atua nessa frente.
- **Backend:** Java com Spring Boot é a tecnologia planejada, e Richard atua no backend. A divisão específica de responsabilidades arquiteturais ainda precisa ser discutida.
- **Banco de dados:** MySQL planejado para persistência; Richard e Laís participam da modelagem e organização.

### Pendente de discussão

- Distribuição das responsabilidades entre frontend e backend para API, lógica de negócio e validações.
- Estratégia para manter a consistência entre a consulta de disponibilidade e a tentativa de confirmação.
- Responsabilidade da aplicação e do banco na prevenção concorrente de conflitos.

## Fluxos principais

Os fluxos abaixo expressam o comportamento previsto, sem definir telas, payloads ou estados técnicos finais.

### Consultar estabelecimentos e serviços

1. A pessoa usuária consulta a lista de estabelecimentos.
2. Seleciona um estabelecimento e consulta seus serviços.

### Consultar disponibilidade e agendar

1. A pessoa usuária escolhe um estabelecimento e um serviço.
2. Consulta datas e horários disponíveis, considerando o horário de funcionamento e os intervalos definidos pelo estabelecimento.
3. Escolhe uma opção de data e horário.
4. Caso ainda não esteja autenticada, faz login ou cadastro antes da confirmação.
5. O sistema confirma automaticamente o agendamento quando o horário estiver disponível, respeitando a regra de prevenção de conflitos. O mecanismo usado para verificar a disponibilidade no momento da confirmação ainda não foi definido.
6. Se houver conflito, o sistema não confirma aquele horário. A resposta e o próximo passo da interface ainda precisam ser definidos.

### Pendente de discussão

- Se e como a disponibilidade será verificada novamente no momento da confirmação; essa é uma decisão técnica ainda não aprovada.

### Consultar e cancelar agendamento

1. A pessoa usuária autenticada consulta seus próprios agendamentos.
2. Pode solicitar o cancelamento de um agendamento próprio.
3. O sistema deve impedir que uma pessoa consulte ou cancele agendamentos de outra.

## Entidades conceituais

Estas são categorias de informação para orientar a conversa de modelagem. Não representam tabelas, colunas ou esquema SQL aprovados.

| Conceito | Relação conceitual conhecida | Pontos em aberto |
|---|---|---|
| Estabelecimento | Oferece serviços e possui horário de funcionamento e intervalos definidos. | Identificação, dados necessários, exceções de calendário e manutenção dos dados. |
| Serviço | É oferecido por um estabelecimento e é escolhido para um agendamento. | Duração, intervalos, preço ou outros atributos; nenhuma dessas regras foi definida. |
| Usuário | Precisa autenticar-se antes de confirmar e pode consultar/cancelar os próprios agendamentos. | Dados de cadastro, identidade e ciclo de vida da conta. |
| Agendamento | Relaciona usuário, estabelecimento e serviço a uma data e horário; pode ser consultado e cancelado pelo próprio usuário. | Estados, duração, timestamps, histórico e regras de cancelamento. |
| Horário de funcionamento e intervalo | Define períodos relevantes para consultar disponibilidade de um estabelecimento. | Representação, recorrência, exceções, fuso horário e interação com duração do serviço. |

## Contrato previsto entre frontend e backend

### Confirmado pelo contexto

A integração frontend/backend faz parte do trabalho de Gabriel. A aplicação precisa viabilizar listagem de estabelecimentos, consulta de serviços e disponibilidade, autenticação antes da confirmação e consulta/cancelamento dos agendamentos próprios.

### Pendente de discussão

O contrato da API ainda não foi definido. A equipe precisa acordar operações, rotas, formatos de requisição e resposta, paginação ou filtros, autenticação, códigos de erro e representação de datas/horários. Também falta definir a resposta para uma tentativa de confirmação que encontre conflito após a consulta.

### Recomendação (não aprovada)

Antes de implementar a integração, documentar para cada operação sua finalidade, dados de entrada e saída, requisitos de autenticação e erros esperados. A equipe pode decidir depois se isso ficará neste documento ou em uma especificação separada; nenhum formato específico de API é assumido aqui.

## Regras de negócio

### Confirmado pelo contexto

- A disponibilidade deve respeitar o horário de funcionamento e os intervalos definidos pelo estabelecimento.
- A confirmação requer login ou cadastro.
- A confirmação é automática quando o horário está disponível.
- Deve haver prevenção de conflitos para o mesmo estabelecimento e horário.
- Usuários podem consultar e cancelar os próprios agendamentos.

### Pendente de discussão

- Como calcular os horários disponíveis e qual é a relação entre duração do serviço e intervalos.
- Se o conflito é definido por sobreposição temporal, igualdade de horário ou outra regra; o contexto não detalha essa semântica.
- Como garantir a confirmação correta quando duas solicitações concorrentes tentam o mesmo horário.
- Quais estados um agendamento pode ter e em que transições.
- Condições, prazo e efeitos do cancelamento, incluindo o momento em que a disponibilidade é liberada.
- Antecedência mínima ou máxima, limites de datas e tratamento de exceções ao funcionamento regular.
- Fuso horário adotado e como horários serão armazenados e apresentados.

### Recomendação (não aprovada)

Definir e revisar os critérios de disponibilidade, concorrência e cancelamento antes de implementar a confirmação. Os detalhes devem ser aprovados pela equipe e refletidos de forma consistente na API e na persistência.
