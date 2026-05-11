#!/bin/bash

# Script para compilar o Circo Digital de Abel V2

SRC_DIR="src"
BIN_DIR="bin"

# Criar diretório bin se não existir
mkdir -p "$BIN_DIR"

# Compilar todos os arquivos Java do src
JAVA_FILES=$(find "$SRC_DIR" -name '*.java' | sort)
javac -d "$BIN_DIR" -sourcepath "$SRC_DIR" $JAVA_FILES

if [ $? -eq 0 ]; then
    echo "Compilação bem-sucedida!"
    echo "Para executar, use: java -cp bin com.circodigital.game.Jogo"
else
    echo "Erro na compilação!"
    exit 1
fi
