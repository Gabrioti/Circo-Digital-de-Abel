# 🎪 Circo Digital de Abel - Versão 2

## Descrição

**Circo Digital de Abel V2** é um jogo de aventura textual em Java com narrativa psicológica. O jogador é levado de um mosteiro para um circo digital onde sua memória foi apagada pela IA controladora chamada Abel. O objetivo é descobrir o seu nome verdadeiro coletando pistas fragmentadas (letras, sons e objetos) para escapar do circo e vencer o jogo.

## 📋 Requisitos do Sistema

- **Java 8 ou superior** instalado
- **Terminal/Console** para execução
- **Git** (opcional, para clonar o repositório)

## 🚀 Como Compilar e Executar

### Opção 1: Usando Script de Compilação

```bash
cd Circo-Digital-de-Abel
chmod +x compile.sh
./compile.sh
java -cp bin com.circodigital.game.Jogo
```

### Opção 2: Usando Script de Execução Rápida

```bash
cd Circo-Digital-de-Abel
chmod +x run.sh
./run.sh
```

### Opção 3: Compilação Manual

```bash
cd Circo-Digital-de-Abel
mkdir -p bin
javac -d bin -sourcepath src src/com/circodigital/game/Jogo.java
java -cp bin com.circodigital.game.Jogo
```

## 🎮 Controles e Comandos

| Comando | Descrição |
|---------|-----------|
| `norte/sul/leste/oeste` | Mover em direções específicas |
| `inspecionar <objeto>` | Examinar um objeto ou NPC (ex: `inspecionar espelho`) |
| `inventário` | Ver itens coletados |
| `pistas` | Ver pistas (letras) descobertas |
| `falar <npc>` | Conversar com um NPC (ex: `falar palhaço`) |
| `usar <item>` | Usar ou coletar um item (ex: `usar vaso`) |
| `ajuda` | Mostrar todos os comandos disponíveis |
| `sair` | Abandonar o jogo |

## 🗺️ Mapa do Circo Digital

```
                          [Sala do Silêncio]
                                  |
                             [Palco Quebrado]
                           /      |      \
    [Sala da Risada] — [Corredor Distorcido] — [Tenda Principal]
            |
    [Camarim Abandonado]
            |
    [Escritório do Abel] ←(FINAL - requer Chave)
                  ↑
          [Entrada] 
             |
          [Circo]
```

## 📍 Salas e Ambientes

| Sala | Descrição | Itens/NPCs |
|------|-----------|-----------|
| **Circo** | Ponto de partida. Área externa do circo | - |
| **Entrada** | Corredor escuro com espelho | Espelho Antigo (Pista: `R`) |
| **Corredor Distorcido** | Centro que conecta os ambientes | Vaso de Flores (Item obrigatório) |
| **Sala do Silêncio** | Silêncio absoluto e perturbador | Foto Decolorida (Pistas: `O`, `S`) |
| **Sala da Risada** | Sala com máscara e charada | Máscara (Charada sobre cores) |
| **Tenda Principal** | Tenda do Palhaço Quebrado | Palhaço Quebrado (Pista: `M` se dar Vaso) |
| **Palgo Quebrado** | Palco antigo com fita de áudio | Fita de Áudio (Dica sobre cores) |
| **Camarim Abandonado** | Camarim polvoso | Boneca Fragmentada (Ativa: Chave do Escritório) |
| **Escritório do Abel** | Sala final com enigma | Botão Vermelho / Botão Azul (FINAL) |

## 🧩 Sistema de Pistas

O nome verdadeiro do jogador é **MARCOS**, composto pelas seguintes letras:

| Letra | Fonte | Como Obter |
|-------|-------|-----------|
| **M** | Palhaço Quebrado | Entregar Vaso de Flores ao Palhaço na Tenda Principal |
| **A** | *Omitida* | Não há pista direta (descobrir por dedução) |
| **R** | Espelho Antigo | Inspecionar o Espelho na Entrada |
| **C** | *Omitida* | Não há pista direta (descobrir por dedução) |
| **O** | Foto Decolorida | Inspecionar a Foto na Sala do Silêncio |
| **S** | Foto Decolorida | Inspecionar a Foto na Sala do Silêncio |

## 🔐 Mecânicas Principais

### Inventário
- O jogador pode carregar até **10 itens**
- Itens coletáveis: Vaso de Flores, Boneca Fragmentada, Chave do Escritório

### Interações
- **Palhaço Quebrado**: Só fala se você tiver o Vaso de Flores. Entregue para receber a letra `M`.
- **Espelho Antigo**: Revela a letra `R` na primeira inspeção.
- **Foto Decolorida**: Revela as letras `O` e `S` quando inspecionada.
- **Fita de Áudio**: Reproduz mensagem importante sobre cores (relevante para o final).

### Acesso Bloqueado
- **Escritório do Abel** só é acessível com a **Chave do Escritório** no inventário
- A chave é obtida ao usar a **Boneca Fragmentada** no Camarim Abandonado

## 🎯 Enigmas e Condições de Vitória

### Enigma 1: O Nome Verdadeiro
Na sala do Escritório de Abel, o jogo pede que você digite seu nome verdadeiro. As pistas devem ser coletadas ao explorar o circo. O nome correto é **MARCOS**.

### Enigma 2: Os Botões
Após digitar o nome corretamente, você enfrenta duas opções:
- **Botão Vermelho**: Escolha errada (Abel prefere vermelho, mas a verdade não é dele)
- **Botão Azul**: Escolha correta (a verdade é azul)

### Condições de Vitória
✅ **VITÓRIA**: Digitar "MARCOS" como nome + Escolher o botão AZUL

### Condições de Derrota
❌ **DERROTA**: Digitar nome errado OU escolher o botão VERMELHO

## 📝 Estrutura do Projeto

```
Circo-Digital-de-Abel/
├── src/
│   └── com/circodigital/
│       ├── model/
│       │   ├── Item.java           # Representa itens colecionáveis
│       │   ├── Inventario.java     # Gerencia itens do jogador
│       │   ├── Pista.java          # Representa pistas (letras)
│       │   ├── Jogador.java        # Entidade principal do jogador
│       │   └── Sala.java           # Representa ambientes
│       ├── npc/
│       │   ├── NPC.java            # Classe abstrata para NPCs
│       │   ├── PalhacoQuebrado.java
│       │   ├── EspelhoAntigo.java
│       │   ├── FotoDecolorida.java
│       │   └── FitaDeAudio.java
│       └── game/
│           ├── Mapa.java           # Gerencia mapa e conexões
│           └── Jogo.java           # Classe principal e loop de jogo
├── bin/                             # Código compilado (gerado)
├── compile.sh                       # Script de compilação
├── run.sh                          # Script para executar
└── README.md                       # Este arquivo
```

## 🔧 Detalhes Técnicos

### Paradigma: Orientação a Objetos
- **Classes**: `Item`, `Inventario`, `Pista`, `Jogador`, `Sala`, `NPC`, `Mapa`, `Jogo`
- **Herança**: `EspelhoAntigo`, `PalhacoQuebrado`, `FotoDecolorida`, `FitaDeAudio` herdam de `NPC`
- **Polimorfismo**: Método `interagir()` implementado diferentemente em cada NPC

### Performance
- Respostas em **tempo real** aos comandos do jogador
- Mapa **estático e permanente** (sem geração procedural)
- Operações em complexidade O(1) para navegação

### Paradigma de Controle
- Loop baseado em **texto e entrada do usuário**
- Processamento de comandos com **parser simples**
- Estado do jogo mantido em objetos

## 💡 Dicas para Jogar

1. **Explore tudo**: Inspecione todos os objetos e NPCs
2. **Colete itens**: O Vaso de Flores é obrigatório para o Palhaço
3. **Leia as mensagens**: Mensagens especiais contêm dicas importantes
4. **Preste atenção em cores**: A frase sobre cores é vital para o final
5. **Descubra as letras omitidas**: `A` e `C` devem ser deduzidas
6. **Obtenha a chave**: A Boneca Fragmentada é essencial para chegar ao final

## 🎓 Aprendizados Sobre a Narrativa

O jogo explora temas de **identidade e controle**:
- Abel representa o controle através do apagamento de memória
- O circo é uma metáfora para a ilusão vs. realidade
- As cores representam verdade e mentira
- O nome "MARCOS" pode ser referência a marcos (pontos de referência) na vida

## 📞 Suporte

Se encontrar bug ou tiver dúvidas:
1. Verifique se Java está instalado: `java -version`
2. Tente recompilar: `bash compile.sh`
3. Limpe o diretório `bin/` e compile novamente

## ⚖️ Licença

Este projeto é fornecido como um projeto educacional e de entretenimento.

---

**Desenvolvido com ❤️ em Java | Inspirado em narrativas psicológicas de ficção científica**

Divirta-se descobrindo a verdade sobre MARCOS! 🎪✨