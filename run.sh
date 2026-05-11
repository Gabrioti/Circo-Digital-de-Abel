#!/bin/bash

# Script para compilar e executar o Circo Digital de Abel V2

# Cores para output
GREEN='\033[0;32m'
BLUE='\033[0;34m'
RED='\033[0;31m'
NC='\033[0m' # No Color

echo -e "${BLUE}================================${NC}"
echo -e "${BLUE}Circo Digital de Abel V2${NC}"
echo -e "${BLUE}================================${NC}"

# Diretórios
SRC_DIR="src"
BIN_DIR="bin"

# Criar diretório bin se não existir
if [ ! -d "$BIN_DIR" ]; then
    mkdir -p "$BIN_DIR"
    echo -e "${GREEN}✓ Diretório $BIN_DIR criado${NC}"
fi

# Compilar o projeto
echo -e "${BLUE}Compilando projeto...${NC}"
JAVA_FILES=$(find "$SRC_DIR" -name '*.java' | sort)
javac -d "$BIN_DIR" -sourcepath "$SRC_DIR" $JAVA_FILES

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✓ Compilação concluída com sucesso!${NC}"
else
    echo -e "${RED}✗ Erro na compilação!${NC}"
    exit 1
fi

# Executar o jogo
echo -e "${BLUE}Iniciando jogo...${NC}"
echo -e "${GREEN}========================================${NC}\n"

java -cp "$BIN_DIR" com.circodigital.game.Jogo

echo -e "\n${GREEN}========================================${NC}"
echo -e "${BLUE}Obrigado por jogar Circo Digital de Abel!${NC}"
