# Desenvolvimento local

Este guia registra o estado conhecido da configuração local do Plannr. Como backend e banco ainda não têm implementação/configuração no repositório, não há instruções completas de execução para o sistema.

## Estado atual

### Confirmado pelo contexto e pelos arquivos existentes

- O frontend está em `frontend/` e contém um projeto Next.js com React e TypeScript.
- O `frontend/package.json` declara scripts `dev`, `build`, `start` e `lint`.
- O backend Java/Spring Boot e o banco MySQL são tecnologias planejadas, mas `backend/` e `database/` atualmente contêm apenas `.gitkeep`.

Este documento não instrui a instalar dependências nem afirma que os scripts foram executados ou verificados.

## Pendências antes de completar as instruções

- Definir as versões de Java, Spring Boot, ferramenta de build Java e MySQL.
- Definir como o MySQL será disponibilizado localmente e como o backend se conectará a ele.
- Definir a configuração necessária para frontend e backend se comunicarem em desenvolvimento.
- Definir nomes das variáveis de ambiente, valores de exemplo seguros e quais arquivos locais serão ignorados pelo Git.
- Definir se haverá dados iniciais ou migrações e como serão aplicados.
- Definir os comandos aprovados pela equipe para preparar e executar cada componente.

## Estrutura prevista do guia

Após essas decisões, completar este documento com pré-requisitos, configuração local sem segredos, preparação do banco, inicialização do backend e frontend, e passos para conferir a comunicação entre eles. Até lá, versões, comandos e procedimentos permanecem pendentes e não devem ser inferidos a partir deste guia.
