## 📚 Guia de Desenvolvimento - Circo Digital de Abel V2

Este documento descreve a arquitetura, design patterns e como estender o jogo.

---

## 🏗️ Arquitetura do Projeto

### Padrão de Projeto: MVC (Model-View-Controller)

- **Model** (`com.circodigital.model`): Classes que representam dados (Item, Sala, Jogador, Inventario, Pista)
- **View** (`com.circodigital.game.Jogo`): Apresentação para o console (texto)
- **Controller** (`com.circodigital.game.Jogo`): Lógica de jogo e processamento de comandos

### Padrão de Projeto: Strategy

- Diferentes tipos de NPCs implementam a interface `NPC` com comportamento específico no método `interagir()`

### Padrão de Projeto: Singleton (implícito)

- `Jogo` é executado uma única vez por sessão
- `Jogador` e `Mapa` são instanz únicos durante o jogo

---

## 🔐 Estrutura de Classes

### Package: `com.circodigital.model`

```
Item
├── Atributos: nome, descricao, coletavel
├── Métodos: getNome(), getDescricao(), isColetavel()
└── Uso: Representa objetos do jogo que podem ser coletados

Pista
├── Atributos: conteudo, descricao, descoberta
├── Métodos: getConteudo(), descobrir(), isDescoberta()
└── Uso: Representa as letras do nome

Inventario
├── Atributos: itens (List<Item>), capacidade
├── Métodos: adicionarItem(), removerItem(), possuiItem(), listarItens()
└── Uso: Gerencia os itens do jogador

Jogador
├── Atributos: nomeRealDesconhecido, inventario, pistasDescobertas, posicaoAtual
├── Métodos: adicionarPista(), getPistasDescobertas(), construirNomeFromPistas()
└── Uso: Representa o Player com estado

Sala
├── Atributos: nome, descricao, descricaoDetalhada, conexoes (Map), itens, pistas, bloqueada
├── Métodos: adicionarConexao(), adicionarItem(), adicionarPista(), bloquearComItem()
└── Uso: Representa um ambiente navegável

```

### Package: `com.circodigital.npc`

```
NPC (Abstract)
├── Atributos: nome, descricao, dialogo, itemSolicitado, itemRetorno
├── Métodos: falar(), interagir() [abstract]
└── Uso: Classe base para todos os NPCs

├── PalhacoQuebrado extends NPC
├── EspelhoAntigo extends NPC
├── FotoDecolorida extends NPC
└── FitaDeAudio extends NPC

```

### Package: `com.circodigital.game`

```
Mapa
├── Atributos: salas (Map<String, Sala>), npcs (Map<String, NPC>)
├── Métodos: obterSala(), obterNPC(), irParaDirecao()
└── Uso: Inicializa e gerencia todo o mapa estático

Jogo
├── Atributos: mapa, jogador, salaAtual, scanner, jogoAtivo, jogoVencido
├── Métodos: iniciarJogo(), loopPrincipal(), processarComando(), moverJogador(), entrarEscritorio()
└── Uso: Classe principal que controla o fluxo do jogo
```

---

## 🔄 Fluxo de Execução

```
main() 
  ↓
Jogo()  // Cria instâncias de Mapa, Jogador, Sala
  ↓
iniciarJogo()
  ├─ exibirIntroducao()
  ├─ exibirDescricaoSala()
  └─ loopPrincipal()
      ├─ Aguarda entrada do usuário
      ├─ processarComando()
      │  ├─ moverJogador()
      │  ├─ inspecionar()
      │  ├─ usarItem()
      │  ├─ falarComNPC()
      │  └─ Outros comandos...
      ├─ Se em "Escritório do Abel" → entrarEscritorio()
      └─ Se jogoFinalizado → finalizarJogo()
```

---

## 📝 Como Adicionar Novas Salas

1. **Crie a sala no método `construirMapa()`**:

```java
Sala novaSala = new Sala(
    "Nome da Sala",
    "Descrição curta",
    "Descrição detalhada com múltiplas linhas..."
);
salas.put("Nome da Sala", novaSala);
```

2. **Conecte com outras salas**:

```java
novaSala.adicionarConexao("norte", outraSala);
novaSala.adicionarConexao("sul", outraSala);
```

3. **Adicione itens ou pistas** (opcional):

```java
Item novoItem = new Item("Nome", "Descrição", true);
novaSala.adicionarItem(novoItem);

Pista novaPista = new Pista("L", "Letra L");
novaSala.adicionarPista(novaPista);
```

---

## 🤖 Como Adicionar Novos NPCs

1. **Crie uma nova classe que herda de NPC**:

```java
package com.circodigital.npc;

public class MeuNPC extends NPC {
    public MeuNPC() {
        super("Nome", "Descrição", "Diálogo inicial");
    }
    
    @Override
    public void interagir(Jogador jogador) {
        falar();
        
        // Lógica de interação específica
        if (condicao) {
            // Dar pista ou item
            Pista p = new Pista("X", "Descrição");
            jogador.adicionarPista(p);
        }
    }
}
```

2. **Registre no método `construirMapa()` da classe `Mapa`**:

```java
MeuNPC npc = new MeuNPC();
npcs.put("MinhaSala_MeuNPC", npc);
```

3. **Adicione lógica de interação no método `processarComando()` da classe `Jogo`**:

```java
case "falar":
    falarComNPC(argumento);
    // Adicione um novo case em falarComNPC()
    if (salaAtual.getNome().equals("Minha Sala")) {
        if (nomeNPC.contains("meupc")) {
            npcAtual = mapa.obterNPC("MinhaSala_MeuNPC");
        }
    }
    break;
```

---

## 🎮 Como Adicionar Novos Comandos

1. **No método `processarComando()`**:

```java
case "meucomando":
    meuComando(argumento);
    break;
```

2. **Implemente o método**:

```java
private void meuComando(String argumento) {
    if (argumento.isEmpty()) {
        System.out.println("[SISTEMA] Fazer o quê?");
        return;
    }
    
    // Lógica do comando
    System.out.println("[SISTEMA] Você fez algo!");
}
```

3. **Adicione na ajuda**:

```java
private void exibirAjuda() {
    System.out.println("  meucomando <arg>      - Descrição do comando");
}
```

---

## 🧪 Testes Recomendados

### Teste de Fluxo Completo
1. Explorar todas as salas
2. Coletar todos os itens
3. Falar com todos os NPCs
4. Verificar pistas descobertas
5. Entrar no Escritório e resolver o enigma

### Teste de Edge Cases
1. Tentar acessar sala bloqueada sem item
2. Tentar usar item inexistente
3. Entrar no escritório sem nome correto
4. Entrar no escritório com nome correto + botão errado

---

## 🚀 Possíveis Extensões

### Curto Prazo
- [ ] Sistema de save/load de jogo
- [ ] Mais NPCs com diálogos
- [ ] Sistema de moedas/economia
- [ ] Mais enigmas intermediários

### Médio Prazo
- [ ] Sistema de combate/desafios
- [ ] Gráficos ASCII melhorados
- [ ] Sistema de som/efeitos sonoros
- [ ] Dificuldades diferentes

### Longo Prazo
- [ ] Interface gráfica com Swing/JavaFX
- [ ] Geração procedural limitada
- [ ] Sistema de progressão/leveling
- [ ] Multiplayer / Online

---

## 📦 Dependências

- **Java 8+** (sem dependências externas)
- Scanner do `java.util` para entrada

---

## 🐛 Debug e Troubleshooting

### Problema: "Classe não encontrada"
**Solução**: Certifique-se de compilar com o path correto:
```bash
javac -d bin -sourcepath src src/com/circodigital/game/Jogo.java
```

### Problema: "Scanner não funciona"
**Solução**: Verifique se o Console suporta leitura. Em alguns IDEs, pode ser necessário usar stdin manualmente.

### Problema: Caracteres especiais não aparecem
**Solução**: Configure a codificação UTF-8:
```bash
export LANG=pt_BR.UTF-8
java -cp bin com.circodigital.game.Jogo
```

---

## 📖 Recursos Adicionais

- [Java Documentation](https://docs.oracle.com/javase/)
- [Design Patterns em Java](https://refactoring.guru/design-patterns/java)
- [Game Architecture Patterns](https://gameprogrammingpatterns.com/)

---

**Última atualização**: Maio de 2026
**Versão**: 2.0
