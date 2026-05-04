#!/bin/bash

# Script para compilar o Circo Digital de Abel V2

SRC_DIR="src"
BIN_DIR="bin"

# Criar diretório bin se não existir
mkdir -p "$BIN_DIR"

# Compilar all classes
javac -d "$BIN_DIR" -sourcepath "$SRC_DIR" \
    "$SRC_DIR"/com/circodigital/model/Item.java \
    "$SRC_DIR"/com/circodigital/model/Inventario.java \
    "$SRC_DIR"/com/circodigital/model/Pista.java \
    "$SRC_DIR"/com/circodigital/model/Jogador.java \
    "$SRC_DIR"/com/circodigital/model/Sala.java \
    "$SRC_DIR"/com/circodigital/npc/NPC.java \
    "$SRC_DIR"/com/circodigital/npc/PalhacoQuebrado.java \
    "$SRC_DIR"/com/circodigital/npc/EspelhoAntigo.java \
    "$SRC_DIR"/com/circodigital/npc/FotoDecolorida.java \
    "$SRC_DIR"/com/circodigital/npc/FitaDeAudio.java \
    "$SRC_DIR"/com/circodigital/game/Mapa.java \
    "$SRC_DIR"/com/circodigital/game/Jogo.java

if [ $? -eq 0 ]; then
    echo "Compilação bem-sucedida!"
    echo "Para executar, use: java -cp bin com.circodigital.game.Jogo"
else
    echo "Erro na compilação!"
    exit 1
fi
