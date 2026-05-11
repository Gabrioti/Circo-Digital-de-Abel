package com.circodigital.npc;

import com.circodigital.model.*;

/**
 * NPC do Palhaço Quebrado na Tenda Principal.
 * Requer Vaso de Flores para entregar a letra 'M'.
 */

/*  Cores de texto
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
public class PalhacoQuebrado extends NPC {
    private boolean itemEntregue;
    
    public PalhacoQuebrado() {
        super(
            "Palhaço Quebrado",
            "Um palhaço com maquiagem borrada e olhar triste",
            "Há tanto tempo ninguém me traz um presente... Você teria algo para mim?"
        );
        this.itemEntregue = false;
    }
    
    @Override
    public void interagir(Jogador jogador) {
        falar();
        
        if (!itemEntregue && jogador.getInventario().possuiItem("Vaso de Flores")) {
            System.out.println("\n[SISTEMA] Você entregou o Vaso de Flores ao Palhaço.");
            jogador.getInventario().removerItem("Vaso de Flores");

            System.out.println("\n[PALHAÇO QUEBRADO] Oh... um presente... Isso é tão raro para mim...");

            try { Thread.sleep(2000); } catch (InterruptedException e) {} 

            System.out.println("\n[PALHAÇO QUEBRADO] *olha para o vaso com um sorriso triste* Obrigado...\n");

            try { Thread.sleep(2000); } catch (InterruptedException e) {} 

            System.out.println("[PALHAÇO QUEBRADO] Ouvir dizer que você está atrás do seu nome, não é?\nBem, eu sei qual é o seu nome...");

            try { Thread.sleep(2000); } catch (InterruptedException e) {}   

            System.out.println("O seu nome é M...");

            try { Thread.sleep(2000); } catch (InterruptedException e) {} // som de morte matada

            System.out.println("\033[91m[ABEL] Você NÃO deve revelar essas coisas para ele...\033[0m");

            try { Thread.sleep(2000); } catch (InterruptedException e) {} 

            System.out.println("[SISTEMA] O Palhaço simplismente desapareceu...");
            
            // Recebe a letra 'M'
            Pista pistaM = new Pista("M", "Letra 'M' do Palhaço");
            jogador.adicionarPista(pistaM);
            
            itemEntregue = true;
        } else if (!itemEntregue) {
            System.out.println("\n[PALHAÇO QUEBRADO] Sem presentes... Sem esperança...");
        } else {
            System.out.println("\n[PALHAÇO QUEBRADO] Já nos conhecemos... O presente já foi dado.");
        }
    }
}
