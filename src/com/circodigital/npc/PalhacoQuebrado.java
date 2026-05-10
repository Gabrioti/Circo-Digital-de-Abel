package com.circodigital.npc;

import com.circodigital.model.*;

/**
 * NPC do Palhaço Quebrado na Tenda Principal.
 * Requer Vaso de Flores para entregar a letra 'M'.
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

            System.out.println("[ABEL] Você NÃO deve revelar essas coisas para ele...");

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
