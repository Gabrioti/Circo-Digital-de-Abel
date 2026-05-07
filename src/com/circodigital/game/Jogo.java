package com.circodigital.game;

import com.circodigital.model.*;
import com.circodigital.npc.*;
import java.util.Scanner;

/*
// Cores de texto
System.out.println("\033[31mTexto em Vermelho\033[0m");
System.out.println("\033[32mTexto em Verde\033[0m");
System.out.println("\033[33mTexto em Amarelo\033[0m");
System.out.println("\033[34mTexto em Azul\033[0m");
System.out.println("\033[35mTexto em Magenta\033[0m");
System.out.println("\033[36mTexto em Ciano\033[0m");

// Cores claras
System.out.println("\033[91mVermelho Claro\033[0m");
System.out.println("\033[92mVerde Claro\033[0m");

// Texto em negrito
System.out.println("\033[1;31mVermelho em Negrito\033[0m");

// Background colorido
System.out.println("\033[41mFundo Vermelho\033[0m");
System.out.println("\033[42mFundo Verde\033[0m");

*/

/**
 * Classe principal do jogo Circo Digital de Abel V2.
 * Gerencia o fluxo completo do jogo, processamento de comandos e lógica de jogo.
 */
public class Jogo {
    private Mapa mapa;
    private Jogador jogador;
    private Sala salaAtual;
    private Scanner scanner;
    private boolean jogoAtivo;
    private boolean jogoVencido;
    private boolean jogoFinalizado;
    
    public Jogo() {
        this.mapa = new Mapa();
        this.jogador = new Jogador(10);
        this.salaAtual = mapa.obterSala("Circo");
        this.scanner = new Scanner(System.in);
        this.jogoAtivo = true;
        this.jogoVencido = false;
        this.jogoFinalizado = false;
        
        jogador.setPosicaoAtual(salaAtual.getNome());
    }
    
    /**
     * Inicia o jogo com a introdução narrativa.
     */
    public void iniciarJogo() {
        limparTela();
        exibirIntroducao();
        exibirDescricaoSala();
        loopPrincipal();
    }
    
    /**
     * Exibe a introdução do jogo.
     */
    private void exibirIntroducao() {
        System.out.println("╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   CIRCO DIGITAL DE ABEL - VERSÃO 2                     ║");
        System.out.println("║                      Uma Jornada Psicológica                           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        System.out.println("\n" +
            "Você acorda em um circo... mas não se lembra como chegou aqui.\n" +
            "A memória está apagada. Em branco. Vazio.\n" +
            "\n" +
            "Uma voz ecoa pelos alto-falantes:\n" +
            "\"Bem-vindo ao Circo Digital. Eu sou Abel. Sua memória... foi necessário apagá-la.\n" +
            "Para escapar, você precisa descobrir uma verdade. Uma verdade pessoal.\n" +
            "Procure por pistas. Letras, sons, objetos. Descubra seu nome verdadeiro.\n" +
            "Nada é por acaso. Cores revelam a verdade. E a verdade não é vermelha.\"\n");

        try { Thread.sleep(2000); } catch (InterruptedException e) {}   
            
        System.out.println("CONTROLES:\n" +
            "  - norte/sul/leste/oeste: Mover\n" +
            "  - usar <item>: Usar um item do inventário\n" +
            "  - inspecionar <objeto>: Examinar algo\n" +
            "  - inventario: Ver itens\n" +
            "  - pistas: Ver pistas descobertas\n" +
            "  - falar <npc>: Interagir com NPCs\n" +
            "  - pegar <item>: Pegar um item da sala\n" +
            "  - ajuda: Mostrar lista completa de comandos\n" +
            "  - sair: Abandonar jogo\n");

        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
        limparTela();
    }
    
    /**
     * Loop principal do jogo.
     */
    private void loopPrincipal() {

        while (jogoAtivo && !jogoFinalizado) {
            System.out.print("\n> ");
            String entrada = scanner.nextLine().trim().toLowerCase();
            processarComando(entrada);
        }
    }
    
    /**
     * Processa os comandos do jogador.
     */
    private void processarComando(String comando) {
        if (comando.isEmpty()) {
            return;
        }
        
        String[] partes = comando.split(" ", 2);
        String acao = partes[0];
        String argumento = partes.length > 1 ? partes[1] : "";
        
        switch (acao) {
            case "norte":
            case "sul":
            case "leste":
            case "oeste":
                moverJogador(acao);
                break;
            case "inspecionar":
                limparTela();
                inspecionar(argumento);
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
                limparTela();
                jogador.setPosicaoAtual(salaAtual.getNome());
                exibirDescricaoSala();
                break;
            case "inventario":
                limparTela();
                jogador.getInventario().exibirInventario();
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
                limparTela();
                jogador.setPosicaoAtual(salaAtual.getNome());
                exibirDescricaoSala();

                break;
            case "pistas":
                jogador.exibirPistas();
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
                limparTela();
                jogador.setPosicaoAtual(salaAtual.getNome());
                exibirDescricaoSala();
                break;
            case "falar":
                falarComNPC(argumento);
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
                limparTela();
                jogador.setPosicaoAtual(salaAtual.getNome());
                exibirDescricaoSala();
                break;
            case "usar":
                usarItem(argumento);
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
                limparTela();
                jogador.setPosicaoAtual(salaAtual.getNome());
                exibirDescricaoSala();
                break;
            case "pegar":
                pegarItem(argumento);
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
                limparTela();
                jogador.setPosicaoAtual(salaAtual.getNome());
                exibirDescricaoSala();
                break;
            case "ajuda":
                limparTela();
                exibirAjuda();
                System.out.println("\nPressione ENTER para continuar...");
                scanner.nextLine();
                limparTela();
                jogador.setPosicaoAtual(salaAtual.getNome());
                exibirDescricaoSala();
                break;
            case "sair":
                finalizarJogo(false);
                break;
            default:
                System.out.println("[SISTEMA] Comando desconhecido. Digite 'ajuda' para ver os comandos disponíveis.");
        }
    }
    
    /**
     * Move o jogador para uma direção.
     */
    private void moverJogador(String direcao) {
        Sala salaDestino = mapa.irParaDirecao(salaAtual, direcao);
        
        if (salaDestino == null) {
            System.out.println("[SISTEMA] Você não pode ir para " + direcao + " daqui.");
            return;
        }
        
        // Verifica se a sala está bloqueada
        if (salaDestino.estaBloqueada() && 
            !jogador.getInventario().possuiItem(salaDestino.getItemBloqueio())) {
            System.out.println("[SISTEMA] O caminho para " + salaDestino.getNome() + 
                             " está bloqueado. Você precisa de: " + salaDestino.getItemBloqueio());
            return;
        }
        
        // Move o jogador
        salaAtual = salaDestino;
        jogador.setPosicaoAtual(salaAtual.getNome());
        limparTela();
        exibirDescricaoSala();
        
        // Verifica se entrou no Escritório de Abel (ativa o enigma final)
        if (salaAtual.getNome().equals("Escritório do Abel")) {
            entrarEscritorio();
        }
    }
    
    /**
     * Exibe a descrição completa da sala atual.
     */
    private void exibirDescricaoSala() {
        salaAtual.exibirDescricaoCompleta();
    }
    
    /**
     * Inspeciona um objeto na sala.
     */
    private void inspecionar(String nomeObjeto) {
        if (nomeObjeto.isEmpty()) {
            System.out.println("[SISTEMA] Inspecionar o quê?");
            return;
        }
        
        nomeObjeto = nomeObjeto.toLowerCase();
        
        // Verifica NPCs que podem ser inspecionados
        NPC npcInspeccionar = null;
        switch (salaAtual.getNome()) {
            case "Entrada":
                if (nomeObjeto.contains("espelho")) {
                    npcInspeccionar = mapa.obterNPC("Entrada_Espelho");
                }
                break;
            case "Sala do Silêncio":
                if (nomeObjeto.contains("foto")) {
                    npcInspeccionar = mapa.obterNPC("Sala do Silêncio_Foto");
                }
                break;
            case "Palco Quebrado":
                if (nomeObjeto.contains("fita")) {
                    npcInspeccionar = mapa.obterNPC("Palco Quebrado_Fita");
                }
                break;
        }
        
        if (npcInspeccionar != null) {
            npcInspeccionar.interagir(jogador);
            return;
        }
        
        // Verifica itens
        Item item = salaAtual.obterItem(nomeObjeto);
        if (item != null) {
            System.out.println("\n[" + item.getNome().toUpperCase() + "]");
            System.out.println(item.getDescricao());
            
            if (item.isColetavel()) {
                System.out.println("\n[SISTEMA] Você pode coletar este item com o comando: pegar " + item.getNome());
            }
            return;
        }
        if (salaAtual.getNome().equals("Corredor Distorcido") && nomeObjeto.contains("parede")) {
            System.out.println("\n[PAREDE]");
            System.out.println("Você lê a mensagem vermelha: \"CORES REVELAM A VERDADE\"");
            return;
        }
        
        if (salaAtual.getNome().equals("Sala da Risada") && nomeObjeto.contains("máscara")) {
            System.out.println("\n[MÁSCARA]");
            return;
        }
        
        System.out.println("[SISTEMA] Não há nada assim por aqui para inspecionar.");
    }
    
    /**
     * Fala com um NPC.
     */
    private void falarComNPC(String nomeNPC) {
        if (nomeNPC.isEmpty()) {
            System.out.println("[SISTEMA] Falar com quem?");
            return;
        }
        
        nomeNPC = nomeNPC.toLowerCase();
        
        // Verifica qual NPC existe na sala atual
        NPC npcAtual = null;
        switch (salaAtual.getNome()) {
            case "Tenda Principal":
                if (nomeNPC.contains("palhaço") || nomeNPC.contains("palhaco")) {
                    npcAtual = mapa.obterNPC("Tenda Principal_Palhaço");
                }
                break;
        }
        
        if (npcAtual != null) {
            npcAtual.interagir(jogador);
        } else {
            System.out.println("[SISTEMA] Não há ninguém assim para conversar aqui.");
        }
    }
    
    /**
     * Pega um item da sala e o coloca no inventário.
     */
    private void pegarItem(String nomeItem) {
        if (nomeItem.isEmpty()) {
            System.out.println("[SISTEMA] Pegar qual item?");
            return;
        }
        
        nomeItem = nomeItem.toLowerCase();
        
        // Caso especial: Vaso de Flores
        if (nomeItem.contains("vaso")) {
            Item vaso = salaAtual.obterItem("Vaso de Flores");
            if (vaso != null) {
                if (jogador.getInventario().adicionarItem(vaso)) {
                    salaAtual.removerItem("Vaso de Flores");
                    limparTela();
                    System.out.println("[SISTEMA] Você coletou o Vaso de Flores!");
                    return;
                }
            }
        }
        
        // Caso especial: Boneca Fragmentada
        if (nomeItem.contains("boneca")) {
            Item boneca = salaAtual.obterItem("Boneca Fragmentada");
            if (boneca != null) {
                if (jogador.getInventario().adicionarItem(boneca)) {
                    salaAtual.removerItem("Boneca Fragmentada");
                    limparTela();
                    System.out.println("[SISTEMA] Você coletou a Boneca Fragmentada!");
                    System.out.println("\n[EVENTO ESPECIAL]");
                    System.out.println("Ao tocar a boneca, ela brilha intensamente.");
                    System.out.println("Uma chave dourada aparece em suas mãos!");
                    System.out.println("Você recebeu a CHAVE DO ESCRITÓRIO!");
                    
                    // Cria a chave
                    Item chaveEscritorio = new Item("Chave do Escritório", "A chave para o Escritório de Abel", true);
                    jogador.getInventario().adicionarItem(chaveEscritorio);
                    return;
                }
            } else if (jogador.getInventario().possuiItem("Boneca Fragmentada")) {
                limparTela();
                System.out.println("[SISTEMA] Você já usou a boneca. A chave foi obtida.");
                return;
            }
        }
        
        // Caso especial: Máscara
        if (nomeItem.contains("máscara") || nomeItem.contains("mascara")) {
            Item mascara = salaAtual.obterItem("Máscara");
            if (mascara != null) {
                if (jogador.getInventario().adicionarItem(mascara)) {
                    salaAtual.removerItem("Máscara");
                    limparTela();
                    System.out.println("[SISTEMA] Você coletou a Máscara!");
                    return;
                }
            }
        }
        
        // Se não conseguir coletar da sala, tenta usar do inventário
        usarItem(nomeItem);
    }
    
    /**
     * Usa um item do inventário.
     */
    private void usarItem(String nomeItem) {
        if (nomeItem.isEmpty()) {
            System.out.println("[SISTEMA] Usar qual item?");
            return;
        }
        
        String nomeItemLower = nomeItem.toLowerCase();
        
        if (nomeItemLower.contains("máscara") || nomeItemLower.contains("mascara")) {
            if (jogador.getInventario().possuiItem("Máscara")) {
                System.out.println("Ao colocar a máscara, você ouve uma voz sussurrar: Quando Abel vê cores, cores não veem Abel.\nEle prefere verMELHo... Mas a verdade não é dele.");
                return;
            }
        }
        
        Item item = jogador.getInventario().obterItem(nomeItem);
        if (item != null) {
            System.out.println("[SISTEMA] Você usa " + item.getNome() + ", mas nada acontece.");
            return;
        }
        
        System.out.println("[SISTEMA] Você não consegue usar ou pegar " + nomeItem + ".");
    }
    
    /**
     * Exibe a lista de ajuda.
     */
    private void exibirAjuda() {
        System.out.println("\n[SISTEMA] COMANDOS DISPONÍVEIS:");
        System.out.println("  norte/sul/leste/oeste - Mover em direção");
        System.out.println("  inspecionar <objeto>  - Examinar um objeto ou NPC");
        System.out.println("  inventario            - Ver itens coletados");
        System.out.println("  pistas                - Ver pistas descobertas");
        System.out.println("  falar <npc>           - Conversar com um NPC");
        System.out.println("  usar <item>           - Usar um item do inventário");
        System.out.println("  pegar <item>          - Pegar um item da sala");
        System.out.println("  ajuda                 - Mostrar esta mensagem");
        System.out.println("  sair                  - Abandonar o jogo");

    }
    
    /**
     * Finaliza o jogo.
     */
    private void finalizarJogo(boolean vitoria) {
        jogoFinalizado = true;
        
        if (vitoria) {
            jogoVencido = true;
            System.out.println("\n╔════════════════════════════════════════════════════════════╗");
            System.out.println("║                      PARABÉNS! VOCÊ VENCEU!                ║");
            System.out.println("║                 Descobriu a verdade sobre seu nome.        ║");
            System.out.println("╚════════════════════════════════════════════════════════════╝");
        } else {
            System.out.println("\n╔════════════════════════════════════════════════════════════╗");
            System.out.println("║                        FIM DO JOGO                         ║");
            System.out.println("║             Você deixou o Circo Digital atrás...           ║");
            System.out.println("╚════════════════════════════════════════════════════════════╝");
        }
    }
    
    /**
     * Método para entrar no Escritório de Abel e resolver o enigma final.
     */
    public void entrarEscritorio() {
        if (!salaAtual.getNome().equals("Escritório do Abel")) {
            return;
        }
        
        limparTela();
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    VOCÊ ENTROU NO ESCRITÓRIO DE ABEL                   ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        
        salaAtual.exibirDescricaoCompleta();
        
        System.out.println("\n[SISTEMA] Digite seu nome verdadeiro:");
        System.out.print("> ");
        String nomeDigitado = scanner.nextLine().trim().toUpperCase();
        
        if (!nomeDigitado.equals("MARCOS")) {
            System.out.println("\n[ABEL] Nome errado. A memória continua apagada...");
            finalizarJogo(false);
            return;
        }
        
        System.out.println("\n[ABEL] Nome... correto? Você se lembra!? Seu nome é MARCOS!");
        
        System.out.println("\n[SISTEMA] Agora escolha com sabedoria:");
        System.out.println("  1 - Pressionar o botão VERMELHO");
        System.out.println("  2 - Pressionar o botão AZUL");
        System.out.print("\n> ");
        
        String escolhaDigitada = scanner.nextLine().trim();
        
        if (escolhaDigitada.equals("1")) {
            limparTela();
            System.out.println("\n[ABEL] Você escolheu o botão vermelho... Minha cor favorita...");
            System.out.println("A sala volta ao escuro. Abel risos ecoam.");
            System.out.println("Você permanece no Circo Digital. A verdade não era vermelha...");
            finalizarJogo(false);
        } else if (escolhaDigitada.equals("2")) {
            limparTela();
            System.out.println("\n[ABEL] O botão azul... Sábio! A verdade não é vermelha!");
            System.out.println("As paredes do escritório desaparecem em partículas de luz azul.");
            System.out.println("Você vê seu verdadeiro nome refletido nas paredes:");
            System.out.println("M A R C O S");
            System.out.println("\nVocê desapareceu do Circo Digital.");
            System.out.println("Você está livre. Sua memória voltou. Você é MARCOS.");
            finalizarJogo(true);
        } else {
            limparTela();
            System.out.println("\n[SISTEMA] Escolha inválida. Nada aconteceu...");
            System.out.println("Tente novamente:");
            entrarEscritorio();
        }
    }
    
    /**
     * Método para limpar o console usando códigos ANSI.
     */
    public static void limparTela() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }
    
    /**
     * Método principal para iniciar a aplicação.
     */
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.iniciarJogo();
    }
}
