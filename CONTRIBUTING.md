# Como contribuir com o projeto

Este documento define o fluxo de trabalho utilizado no projeto **Bancada Smart 4.0**.

## Branch principal

A branch principal do projeto é:

```text
main
```

A `main` deve representar a versão mais estável do projeto.

> Não realize alterações diretamente na `main`.

## 1. Criar uma branch

Antes de iniciar uma tarefa, crie uma nova branch a partir da `main`.

Para novas funcionalidades, utilize:

```text
feature/nome-da-funcionalidade
```

Exemplos:

```text
feature/login
feature/cadastro-usuarios
feature/dashboard
feature/modelo-banco
```

Para correções de problemas, utilize:

```text
fix/nome-do-problema
```

Exemplos:

```text
fix/erro-login
fix/validacao-pedido
```

## 2. Desenvolver a tarefa

Todas as alterações relacionadas à tarefa devem ser realizadas na branch criada.

## 3. Fazer commits

Durante o desenvolvimento, registre as alterações utilizando commits com mensagens claras.

Exemplos:

```text
feat: adiciona tela de login
feat: cria endpoint de usuários
fix: corrige validação do formulário
docs: atualiza documentação do banco
```

## 4. Enviar a branch para o GitHub

Após realizar os commits, envie a branch para o repositório remoto.

## 5. Criar um Pull Request

Ao concluir a tarefa, abra um **Pull Request** da sua branch para:

```text
main
```

O Pull Request deve explicar resumidamente o que foi desenvolvido.

## 6. Revisão

O código deve ser revisado antes de ser incorporado à `main`.

Caso sejam solicitadas alterações, elas devem ser realizadas na mesma branch.

## 7. Merge

Após a revisão, o Pull Request poderá ser incorporado à `main`.

## Fluxo resumido

```text
main
  ↓
criar branch
  ↓
desenvolver
  ↓
commit
  ↓
push
  ↓
Pull Request
  ↓
revisão
  ↓
merge na main
```

## Regra principal

**Nunca desenvolver diretamente na `main`.**

Cada tarefa deve possuir sua própria branch.
