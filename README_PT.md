## Documentação da API do Robô de Navegação

### Visão Geral

#### Desafio Backend Java para a empresa Conta Azul.

A API do Robô de Navegação permite controlar um robô em um ambiente bidimensional, com capacidade de movimento e rotação. O objetivo principal é enviar comandos para o robô e obter sua posição final.

### Endpoints

#### 1. Enviar Comandos para o Robô

- **URL**: `/api/rest/mars/{commands}`
- **Método HTTP**: POST
- **Descrição**: Este endpoint permite enviar uma sequência de comandos para controlar o robô e retorna sua posição final.

**Exemplo de Requisição:**

```bash
curl -X POST http://localhost:8080/api/rest/mars/MMRMMRMM
```

**Resposta de Sucesso (Status 200 OK)**:

```json
{
    "x": 2,
    "y": 0,
    "direction": "S"
}
```

**Resposta de Erro (Status 400 Bad Request)**:

- Se os comandos forem inválidos:

```json
"Invalid Command"
```

- Se a posição final estiver fora do limite (0 a 4 para ambas as coordenadas `x` e `y`):

```json
"Invalid Position"
```

### Comandos Aceitos

- 'L': Gire o robô 90 graus à esquerda.
- 'R': Gire o robô 90 graus à direita.
- 'M': Mova o robô uma unidade para frente na direção atual.

### Exemplos de Uso

- **Exemplo 1**: Mova o robô para frente e gire para a direita.

```bash
curl -X POST http://localhost:8080/api/rest/mars/MMRMMRMM
```

- **Exemplo 2**: Mova o robô para frente várias vezes.

```bash
curl -X POST http://localhost:8080/api/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM
```

- **Exemplo 3**: Mova o robô duas vezes para frente e depois gire à esquerda.

```bash
curl -X POST http://localhost:8080/api/rest/mars/MML
```

- **Exemplo 4**: Comando inválido.

```bash
curl -X POST http://localhost:8080/api/rest/mars/AAA
```

### Limitações

- O ambiente é uma grade de 5x5, representada pelas coordenadas (0 a 4 para `x` e `y`).
- Os comandos aceitos são 'L', 'R' e 'M'.
- O robô não pode sair dos limites da grade; comandos que o levariam para fora da grade são ignorados.

### Como rodar o projeto

Para implantar o serviço do Robô de Navegação em seu ambiente, siga estas etapas:

1. **Clonar o Repositório**: Clone o repositório do projeto em seu sistema.

2. **Construir e Executar**: Use o Maven como por exemplo: **mvn clean compile** e **mvn install** para construir o projeto e execute-o.

3. **Testar**: Use a ferramenta da sua IDE para rodar os testes do serviço.
