## 🎮 GUIA DE JOGO - Circo Digital de Abel V2

### ⚠️ AVISO: Este guia contém spoilers!

Se você quer descobrir sozinho, pare de ler agora! 🚨

---

## 📖 Resumo da Trama

Você acordou em um circo digital. Uma IA chamada Abel apagou sua memória. Para escapar, você precisa descobrir seu nome verdadeiro (MARCOS) coletando pistas fragmentadas (letras, sons, objetos). No final, você enfrentará dois enigmas:
1. Digitar seu nome correto
2. Escolher a cor certa (não vermelha)

---

## 🗺️ WALKTHROUGH PASSO A PASSO

### Fase 1: Exploração Inicial (Circo → Entrada)

```
1. norte          → Vai para Entrada
2. inspecionar espelho → Descobre PISTA: "R"
3. inventário     → Confirma que não tem itens ainda
4. pistas         → Mostra: "R"
```

**O que aprender**: Você tem a primeira letra. Existem mais 5 letras para encontrar.

---

### Fase 2: Centro do Circo (Corredor Distorcido)

```
1. norte          → Vai para Corredor Distorcido
2. inspecionar vaso → Examina o Vaso de Flores
3. usar vaso      → Coleta o Vaso de Flores
4. inventário     → Mostra: Vaso de Flores
5. inspecionar parede → Lê mensagem: "CORES REVELAM A VERDADE"
```

**Importante**: A mensagem sobre cores será crucial no final!

---

### Fase 3: Coletando Todas as Pistas

#### 3.1 Sala do Silêncio (pistas: O, S)

```
De Corredor Distorcido:
1. norte          → Vai para Sala do Silêncio
2. inspecionar foto → Descobre PISTAS: "O" e "S"
3. pistas         → Mostra: "R", "O", "S" (3 de 6 letras)
```

#### 3.2 Tenda Principal (pista: M)

```
De Sala do Silêncio:
1. sul            → Volta para Corredor Distorcido
2. leste          → Vai para Tenda Principal
3. falar palhaço  → Palhaço reclama que não tem presente
```

**Problema**: O Palhaço quer o Vaso! Volte e pega a estratégia correta:

```
De Tenda Principal:
1. oeste          → Volta para Corredor Distorcido
2. norte          → Volta para Sala do Silêncio
3. sul            → Volta para Corredor Distorcido (pegou o Vaso aqui)
4. leste          → Tenda Principal (já tem o Vaso!)
5. falar palhaço  → Entrega o Vaso, Palhaço dá PISTA: "M"
6. pistas         → Mostra: "R", "O", "S", "M" (4 de 6 letras)
```

#### 3.3 Palco Quebrado (informação: sobre cores)

```
De Tenda Principal:
1. norte          → Vai para Palgo Quebrado
2. inspecionar fita → Ouve: "Abel prefere vermelho, mas a verdade não é dele"
```

**Crítico**: Essa dica é a chave para o enigma final! A verdade NÃO é vermelha!

---

### Fase 4: Letras Faltantes (Dedução)

Até agora você tem: **R, O, S, M** (4 letras)

Faltam 2 letras para formar: **MARCOS**

- Letra faltante 1: **A** (entre M e R)
- Letra faltante 2: **C** (entre R e O)

Você deve DEDUZIR estas letras pensando no contexto da narrativa e nos enigmas.

---

### Fase 5: Obtendo a Chave (Boneca Fragmentada)

```
De Palgo Quebrado:
1. leste          → Vai para Camarim Abandonado
2. inspecionar boneca → Examina a Boneca Fragmentada
3. usar boneca    → Coleta a Boneca
4. [EVENTO] A boneca brilha! Recebe: CHAVE DO ESCRITÓRIO
5. inventário     → Mostra: Chave do Escritório
```

---

### Fase 6: O Enigma da Sala da Risada (Opcional)

Se quiser mais contexto:

```
De Camarim Abandonado:
1. oeste          → Vai para Sala da Risada
2. inspecionar máscara → Ouve charada sobre cores
3. sul            → Volta para Camarim
```

**Charada**: "Quando Abel vê cores, cores não veem Abel. Qual cor ele prefere?"

**Resposta**: Abel prefere VERMELHO, mas a verdade não é dele = verdade é AZUL.

---

### Fase 7: O Enigma Final (Escritório de Abel)

```
De Camarim Abandonado:
1. sul            → Vai para Escritório do Abel
   ↓ [AUTOMÁTICO - Enigma Final Ativado]
```

**Enigma 1: Digitar o Nome**

Sistema pede: "Digite seu nome verdadeiro:"

Você digitou: **MARCOS**

```
Letras descobertas:
M - Palhaço Quebrado
A - DEDUZIR (não há pista)
R - Espelho Antigo
C - DEDUZIR (não há pista)
O - Foto Decolorida
S - Foto Decolorida
```

Se acertar:
```
[ABEL] Nome... correto? Você se lembra!? Seu nome é MARCOS!
```

Se errar:
```
[ABEL] Nome errado. A memória continua apagada...
[FIM DE JOGO] VOCÊ PERDEU!
```

**Enigma 2: Escolher o Botão Correto**

Sistema pede: "Agora escolha com sabedoria:
  1 - Pressionar o botão VERMELHO
  2 - Pressionar o botão AZUL"

Você escolhe: **2** (Botão AZUL)

**Dicas para acertar**:
- Mensagem na parede: "CORES REVELAM A VERDADE"
- Fita de áudio: "Abel prefere vermelho, mas a verdade não é dele"
- **Conclusão**: A verdade é AZUL, não vermelha!

---

## ✅ VITÓRIA - Condições

```
Se você fez TUDO correto:
✓ Digitou "MARCOS"
✓ Escolheu botão "AZUL"

Resultado:
[ABEL] O botão azul... Sábio! A verdade não é vermelha!
As paredes do escritório desaparecem...
Você vê seu verdadeiro nome: M A R C O S
Você desapareceu do Circo Digital.
PARABÉNS! VOCÊ VENCEU!
```

---

## ❌ DERROTA - Como Perder

Você perde se:
1. ❌ Digitar nome errado (não "MARCOS")
2. ❌ Digitar nome certo, mas escolher botão VERMELHO
3. ❌ Abandonar o jogo com comando "sair"

---

## 🎯 MAPA COMPLETO COM NAVEGAÇÃO

```
CIRCO (início)
  ↓ norte
ENTRADA (Espelho → pista R)
  ↓ norte
CORREDOR DISTORCIDO (centro)
  ├─ norte → SALA DO SILÊNCIO (Foto → pistas O,S)
  │            └─ leste → PALCO QUEBRADO (Fita → dica cores)
  │                         └─ leste → CAMARIM ABANDONADO (Boneca → Chave!)
  │                                      └─ sul → ESCRITÓRIO (FINAL!)
  ├─ leste → TENDA PRINCIPAL (Palhaço → pista M se der Vaso)
  └─ oeste → SALA DA RISADA (Máscara → charada)
               └─ sul → CAMARIM ABANDONADO
```

---

## 📋 CHECKLIST DE PISTAS E ITENS

### Itens a Coletar
- [ ] Vaso de Flores (Corredor Distorcido)
- [ ] Boneca Fragmentada (Camarim Abandonado)
- [ ] Chave do Escritório (obtida ao usar Boneca)

### Pistas a Descobrir
- [ ] R - Espelho Antigo (Entrada)
- [ ] M - Palhaço Quebrado (Tenda Principal)
- [ ] O - Foto Decolorida (Sala do Silêncio)
- [ ] S - Foto Decolorida (Sala do Silêncio)
- [ ] A - DEDUZIR
- [ ] C - DEDUZIR

### Dicas Importantes
- [ ] "CORES REVELAM A VERDADE" (parede do Corredor)
- [ ] "Abel prefere vermelho, mas a verdade não é dele" (Fita de Áudio)
- [ ] Charada da Máscara (Sala da Risada)

---

## 💡 DICAS E TRUQUES

### 1. Se Ficar Preso
- Type `ajuda` para ver os comandos
- Type `pistas` para ver o que descobriu
- Type `inventário` para ver os itens

### 2. Ordem Recomendada de Exploração
1. Entrada (pega Pista R)
2. Corredor Distorcido (pega Vaso)
3. Sala do Silêncio (pega Pistas O,S)
4. Tenda Principal (entrega Vaso, pega Pista M)
5. Palco Quebrado (coleta informação sobre cores)
6. Camarim Abandonado (pega Boneca → Chave)
7. Escritório (FINAL)

### 3. Nome Correto
Não tente: Gabriel, Carlos, Fernando, André, Paulo, Marcus, etc.

O nome é: **M-A-R-C-O-S** (exatamente 6 letras)

### 4. Botão Correto
- ❌ Vermelho = Perdeu (Abel prefere vermelho)
- ✅ Azul = Venceu (verdade é azul)

---

## 🎪 DICAS NARRATIVAS

- **Abel** é a IA controladora que apagou sua memória
- O **Circo Digital** é uma metáfora para ilusão e controle
- As **cores** representam verdade (azul) vs mentira (vermelho)
- O seu nome **MARCOS** pode significar "pontos de referência" da vida
- Cada pista que coleta é parte de sua identidade recuperada

---

## 🏆 FATOS INTERESSANTES

1. **Letras Omitidas**: As letras A e C não têm pista direta porque você deve deduzir (refletir sobre a narrativa)
2. **Enigma das Cores**: Toda a narrativa gira em torno das cores
3. **NPC Padrão**: O Palhaço só interage se você trouxer o Vaso (condicional)
4. **Mapa Estático**: Não muda dinamicamente, apenas perspectivas mudam
5. **Sem Respawns**: Itens coletados desaparecem

---

**Boa sorte descubrindo a verdade sobre MARCOS! 🎪✨**

*Última atualização: Maio de 2026*
