# 📋 SUMÁRIO DO PROJETO

## Circo Digital de Abel V2

**Versão**: 2.0  
**Data**: Maio 2026  
**Linguagem**: Java 8+  
**Paradigma**: Orientação a Objetos (OO)  
**Tipo**: Jogo de Aventura Textual (Adventure Game)

---

## ✨ Status do Projeto: COMPLETO

### Funcionalidades Implementadas ✅

- [x] **Sistema de Navegação**: Movimento em 4 direções (norte, sul, leste, oeste)
- [x] **Mapa Estático**: 8 salas + 1 sala final (Escritório) = 9 ambientes totais
- [x] **Inventário**: Sistema de coleta e armazenamento de itens (limite 10)
- [x] **Sistema de Pistas**: Coleta fragmentada de letras (6 caracteres)
- [x] **NPCs Interativos**: 4 NPCs com comportamentos específicos
- [x] **Interações Condicionais**: Palhaço requer Vaso antes de entregar pista
- [x] **Bloqueio de Acesso**: Escritório bloqueado até obter Chave
- [x] **Sistema de Enigmas**: 2 enigmas finais
- [x] **Vitória/Derrota**: Lógica completa de fim de jogo
- [x] **Sistema de Comandos**: 8+ comandos para interação
- [x] **Narrativa Psicológica**: Temas de identidade e controle

---

## 📂 Estrutura de Arquivos

```
Circo-Digital-de-Abel/
│
├── README.md                           (Documentação principal)
├── DEVELOPMENT.md                      (Guia para desenvolvedores)
├── WALKTHROUGH.md                      (Guia de jogo com spoilers)
├── PROJECT_SUMMARY.md                  (Este arquivo)
│
├── compile.sh                          (Script de compilação)
├── run.sh                              (Script de execução)
│
├── src/                                (Código fonte)
│   └── com/circodigital/
│       ├── model/                      (Camada de Dados)
│       │   ├── Item.java
│       │   ├── Inventario.java
│       │   ├── Pista.java
│       │   ├── Jogador.java
│       │   └── Sala.java
│       │
│       ├── npc/                        (NPCs)
│       │   ├── NPC.java                (Abstract base class)
│       │   ├── PalhacoQuebrado.java
│       │   ├── EspelhoAntigo.java
│       │   ├── FotoDecolorida.java
│       │   └── FitaDeAudio.java
│       │
│       └── game/                       (Lógica de Jogo)
│           ├── Mapa.java
│           └── Jogo.java               (Classe principal)
│
└── bin/                                (Arquivos compilados - gerado)
    └── com/circodigital/
        └── [arquivos .class]
```

---

## 🎮 Salas Implementadas

| # | Sala | Descrição | Conexões | NPCs/Itens |
|---|------|-----------|----------|-----------|
| 1 | Circo | Ponto de partida | ↑ norte | - |
| 2 | Entrada | Corredor com espelho | ↓ sul / ↑ norte | Espelho (R) |
| 3 | Corredor Distorcido | Centro | ↓ sul / ↑ norte / ↔ leste-oeste | Vaso |
| 4 | Sala do Silêncio | Silêncio absoluto | ↓ sul / → leste | Foto (O,S) |
| 5 | Sala da Risada | Máscara e charada | ↔ leste / ↓ sul | Máscara |
| 6 | Tenda Principal | Palhaço | ← oeste / ↑ norte | Palhaço (M) |
| 7 | Palco Quebrado | Palco antigo | ↓ sul / ← oeste / → leste | Fita de áudio |
| 8 | Camarim Abandonado | Camarim polvoso | ↑ norte / ← oeste / ↓ sul | Boneca |
| 9 | Escritório de Abel | Sala final | ↑ norte | Botões (FINAL) |

---

## 🤖 NPCs e Interações

### 1. Espelho Antigo (Entrada)
- **Tipo**: Objeto/NPC passivo
- **Interação**: `inspecionar espelho`
- **Resultado**: Revela pista "R"
- **Uma vez**: Sim (pista não se repete)

### 2. Palhaço Quebrado (Tenda Principal)
- **Tipo**: NPC ativo com condição
- **Interação**: `falar palhaço`
- **Condição**: Exige Vaso de Flores no inventário
- **Resultado**: Revela pista "M"
- **Uma vez**: Sim

### 3. Foto Decolorida (Sala do Silêncio)
- **Tipo**: Objeto/NPC passivo
- **Interação**: `inspecionar foto`
- **Resultado**: Revela pistas "O" e "S" (2 letras)
- **Uma vez**: Sim

### 4. Fita de Áudio (Palco Quebrado)
- **Tipo**: Objeto/NPC passivo (informativo)
- **Interação**: `inspecionar fita`
- **Resultado**: Revela dica crucial: "Abel prefere vermelho, mas a verdade não é dele"
- **Uma vez**: Não (pode ouvir múltiplas vezes)

---

## 🎯 Sistema de Enigmas

### Enigma 1: O Nome Verdadeiro

**Objetivo**: Digitar seu nome verdadeiro

**Pistas Diretas**:
- R (Espelho)
- M (Palhaço)
- O (Foto)
- S (Foto)

**Pistas Indiretas (Dedução)**:
- A (letra vocálica comum após M)
- C (letra comum em nomes portugueses/espanhóis)

**Resposta Correta**: MARCOS (6 caracteres)

**Penalidade**: Derrota instantânea se errar

---

### Enigma 2: Cores e Verdade

**Objetivo**: Escolher o botão correto

**Dicas Fornecidas**:
1. Parede: "CORES REVELAM A VERDADE"
2. Fita: "Abel prefere vermelho, mas a verdade não é dela"
3. Charada: Reflexão sobre cores

**Opções**:
- Botão 1 (VERMELHO): Errado ❌ → Abel prefere, mentira
- Botão 2 (AZUL): Correto ✅ → Verdade

**Penalidade**: Derrota se escolher vermelho

---

## 📊 Estatísticas do Projeto

| Métrica | Valor |
|---------|-------|
| **Classes** | 11 |
| **Packages** | 4 |
| **Salas** | 9 |
| **NPCs** | 4 |
| **Itens Colecionáveis** | 3 |
| **Pistas Diretas** | 4 |
| **Enigmas** | 2 |
| **Comandos** | 8+ |
| **Linhas de Código** | ~1500 |
| **Tempo Médio de Jogo** | 30-60 minutos |

---

## 🔐 Requisitos Funcionais (Concluídos)

### RF-01: Movimentação
✅ Jogador navega com comandos textuais (norte, sul, leste, oeste)

### RF-02: Visão
✅ Descrição automática ao entrar em sala ou comando `inspecionar`

### RF-03: Inventário
✅ Sistema de armazenamento com limite de 10 itens

### RF-04: Interação
✅ Interações condicionais com NPCs (Palhaço requer Vaso)

### RF-05: Pistas
✅ Coleta de strings de letras (M, A, R, C, O, S)

### RF-06: Acesso Bloqueado
✅ Escritório bloqueado sem Chave do Escritório

### RF-07: Mapa Estático
✅ Mapa permanente sem geração procedural

### RF-08: Performance
✅ Respostas em tempo real aos comandos

---

## 🎓 Padrões de Design Utilizados

1. **MVC (Model-View-Controller)**
   - Model: Classes em `model/`
   - View: Sistema de output em `Jogo.java`
   - Controller: Lógica em `Jogo.java`

2. **Strategy Pattern**
   - NPCs implementam comportamentos diferentes
   - Interface `NPC` com método `interagir()` polimórfico

3. **Builder Pattern** (implícito)
   - Mapa construído no método `construirMapa()`

4. **Singleton Pattern** (implícito)
   - Uma instância de `Jogo`, `Jogador`, `Mapa` por sessão

---

## 🚀 Como Executar

### Pré-requisitos
- Java 8 ou superior
- Terminal com suporte UTF-8 (para caracteres especiais)

### Execução

```bash
# Método 1: Script automático
cd Circo-Digital-de-Abel
./run.sh

# Método 2: Compilar e executar manualmente
chmod +x compile.sh
./compile.sh
java -cp bin com.circodigital.game.Jogo
```

---

## 📈 Evolução Possível

### Fase 2 (Extensões Futuras)
- [ ] Sistema de save/load
- [ ] Mais ambientes
- [ ] Puzzles adicionais
- [ ] Sistema de moedas
- [ ] Mais NPCs com diálogos profundos

### Fase 3 (Melhorias)
- [ ] Interface gráfica (Swing/JavaFX)
- [ ] Efeitos sonoros
- [ ] Múltiplas dificuldades
- [ ] Sistema de combate

### Fase 4 (Avançado)
- [ ] Multiplayer
- [ ] Geração procedural limitada
- [ ] Sistema de leveling
- [ ] Achievements

---

## 🧪 Testes Realizados

✅ Compilação sem erros  
✅ Navegação entre salas  
✅ Coleta de itens  
✅ Sistema de inventário  
✅ Interação com NPCs  
✅ Pistas descobertas  
✅ Bloqueio de acesso  
✅ Enigma final (nome e botões)  
✅ Vitória e derrota  

---

## 📝 Documentação

| Arquivo | Conteúdo |
|---------|----------|
| README.md | Manual de usuário |
| DEVELOPMENT.md | Guia para desenvolvedores |
| WALKTHROUGH.md | Guia completo com spoilers |
| PROJECT_SUMMARY.md | Este arquivo |

---

## 🎪 Características Únicas

1. **Narrativa Psicológica**: Temas de identidade e controle
2. **Mapa Estático Bem Construído**: Cada sala tem propósito narrativo
3. **Enigmas Integrados**: Não são quebra-cabeças aleatórios
4. **Design Orientado a Objetos**: Código limpo e extensível
5. **Sem Dependências Externas**: Apenas Java padrão

---

## 📞 Suporte Técnico

### Problema: Caracteres especiais não aparecem
```bash
export LANG=pt_BR.UTF-8
java -cp bin com.circodigital.game.Jogo
```

### Problema: Scanner não funciona no IDE
Use terminal nativo ao invés de IDE integrado

### Problema: Compilação falha
Verifique se Java 8+ está instalado:
```bash
java -version
javac -version
```

---

## ✅ Checklist de Entrega

- [x] Código completo em Java com OO
- [x] 9 salas mapeadas
- [x] 4 NPCs implementados
- [x] Sistema de pistas funcionando
- [x] Sistema de itens/inventário
- [x] Enigmas implementados
- [x] Vitória/derrota funcionando
- [x] Mapa estático permanente
- [x] Performance em tempo real
- [x] Documentação completa
- [x] Scripts de compilação e execução
- [x] Código comentado

---

## 🏆 Conclusão

**Circo Digital de Abel V2** é um projeto completo de jogo de aventura textual que demonstra:

✅ Proficiência em Java OO  
✅ Design de software estruturado  
✅ Criação de narrativas interativas  
✅ Engenharia de jogo (game design)  
✅ Documentação técnica profissional  

O projeto está **100% funcional** e pronto para jogar!

---

**Desenvolvido por**: Engenheiro de Software Sênior  
**Especialização**: Java + Game Design  
**Status**: COMPLETO ✅  
**Versão**: 2.0  
**Data**: Maio 2026

---

*Divirta-se no Circo Digital! Descubra a verdade sobre MARCOS! 🎪✨*
