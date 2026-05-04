## 🎪 COMECE AQUI - Circo Digital de Abel V2

Bem-vindo ao **Circo Digital de Abel V2**! Aqui está tudo que você precisa saber para começar.

---

## ⚡ INÍCIO RÁPIDO (30 segundos)

```bash
# 1. Compile o projeto
./compile.sh

# 2. Execute o jogo
java -cp bin com.circodigital.game.Jogo
```

Ou simplesmente:
```bash
./run.sh
```

---

## 📖 LEIA PRIMEIRO

### 1️⃣ Para Jogadores
👉 **[README.md](README.md)** - Manual do jogo, controles e mecânicas

### 2️⃣ Para Jogadores Que Querem Dicas
👉 **[WALKTHROUGH.md](WALKTHROUGH.md)** - Guia completo (com spoilers!)

### 3️⃣ Para Desenvolvedores
👉 **[DEVELOPMENT.md](DEVELOPMENT.md)** - Como estender o jogo

### 4️⃣ Para Visão Geral do Projeto
👉 **[PROJECT_SUMMARY.md](PROJECT_SUMMARY.md)** - Arquitetura e estatísticas

---

## 🎮 PRIMEIRO COMANDO

Quando o jogo iniciar, tente:
```
> ajuda
```

Isso mostrará todos os comandos disponíveis.

---

## 🗺️ MAPA VISUAL

```
              🏛️ Sala do Silêncio
                      |
                 🎭 Palago Quebrado
                   /    |    \
    🎪 Sala da Risada—🎪Corredor🎪—🎪Tenda
            |
    🎬 Camarim Abandonado
            |
    📖 Escritório de Abel (FINAL)
         ↑
    🚪 Entrada
       |
    🎪 Circo (INÍCIO)
```

---

## 🎯 OBJETIVO DO JOGO

1. Explore o Circo Digital
2. Colete PISTAS (letras) espalhadas
3. Descubra seu nome verdadeiro
4. Enfrente o enigma final
5. VENÇA o jogo! 🏆

---

## 🧩 O QUE VOCÊ PRECISA FAZER

✅ Encontrar 6 letras que formam seu nome  
✅ Identificar 2 itens importantes  
✅ Falar com 4 personagens  
✅ Resolver 2 enigmas finais  

---

## 💾 REQUISITOS TÉCNICOS

- Java 8 ou superior
- Terminal/Console
- 2MB de espaço em disco

---

## 🚀 COMO EXECUTAR

### Opção 1: Script Automático (Recomendado)
```bash
./run.sh
```

### Opção 2: Compilação Manual
```bash
# Compilar
javac -d bin -sourcepath src src/com/circodigital/game/Jogo.java

# Executar
java -cp bin com.circodigital.game.Jogo
```

---

## 🎮 CONTROLES BÁSICOS

| Comando | O que faz |
|---------|-----------|
| `norte` | Move para cima |
| `sul` | Move para baixo |
| `leste` | Move para direita |
| `oeste` | Move para esquerda |
| `inventário` | Mostra itens |
| `pistas` | Mostra letras |
| `inspecionar [objeto]` | Examina algo |
| `ajuda` | Lista todos os comandos |

---

## ⚠️ DICAS IMPORTANTES

1. **Explore tudo** - Inspecione cada objeto que encontrar
2. **Converse com NPCs** - Use comando `falar`
3. **Colete itens** - Use comando `usar` para pegar itens
4. **Preste atenção em cores** - Menções a cores são importantes!
5. **Descubra por si só** - O melhor é descobrir sem dicas!

---

## 🤔 FICOU PRESO?

Se ficar preso:
1. Tente `ajuda` para ver todos os comandos
2. Tente todos os commands em uma sala
3. Consulte [WALKTHROUGH.md](WALKTHROUGH.md) para dicas

---

## 📁 ESTRUTURA DO PROJETO

```
.
├── README.md              ← Leia isto primeiro!
├── WALKTHROUGH.md         ← Guia com spoilers
├── DEVELOPMENT.md         ← Para desenvolvedores
├── PROJECT_SUMMARY.md     ← Resumo técnico
│
├── compile.sh             ← Compilar
├── run.sh                 ← Executar
│
├── src/                   ← Código fonte
│   └── com/circodigital/
│       ├── model/         ← Item, Sala, Jogador, etc
│       ├── npc/           ← NPCs (Palhaço, Espelho, etc)
│       └── game/          ← Jogo e Mapa principais
│
└── bin/                   ← Executáveis (criado ao compilar)
```

---

## ✨ CARACTERÍSTICAS DO JOGO

🎪 **Narrativa Psicológica**: Tema de identidade e controle  
🗺️ **Mapa Estático**: 9 salas bem construídas  
🤖 **NPCs Inteligentes**: Com comportamentos condicionais  
🧩 **Enigmas**: Dois enigmas finais para resolver  
⚡ **Performance**: Tempo real, sem lags  
💻 **Orientado a Objetos**: Código profissional em Java  

---

## 🎓 O QUE VOCÊ APRENDERÁ

Se estiver estudando desenvolvimento de jogos:
- Arquitetura MVC
- Padrões de design
- Lógica de jogo
- Narrativa interativa
- Java OO puro

---

## 🐛 ENCONTROU UM BUG?

1. Tente recompilar: `./compile.sh`
2. Verifique Java: `java -version`
3. Consulte [DEVELOPMENT.md](DEVELOPMENT.md)
4. Se ainda não funcionar, tente em um terminal nativo (não IDE)

---

## 🏆 META FINAL

Você VENCEU se conseguir:
1. ✅ Digitar seu nome correto
2. ✅ Escolher a cor correta
3. ✅ Escapar do Circo Digital

---

## 🎬 COMECE AGORA!

```bash
./run.sh
```

ou

```bash
java -cp bin com.circodigital.game.Jogo
```

---

## 📞 SUPORTE

| Problema | Solução |
|----------|---------|
| "Comando não encontrado" | Use `chmod +x *.sh` |
| "Java not found" | Instale Java 8+ |
| "Caracteres estranhos" | Configure UTF-8: `export LANG=pt_BR.UTF-8` |
| "Scanner não funciona" | Use terminal nativo, não IDE |

---

**Boa diversão! Descubra a verdade sobre MARCOS! 🎪✨**

---

*Última atualização: Maio 2026*  
*Versão: 2.0*  
*Status: COMPLETO E FUNCIONAL ✅*
