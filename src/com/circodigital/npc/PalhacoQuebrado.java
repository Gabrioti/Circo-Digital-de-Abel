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
            
            // Recebe a letra 'M'
            Pista pistaM = new Pista("M", "Letra 'M' do Palhaço");
            jogador.adicionarPista(pistaM);
            
            System.out.println("\n[PALHAÇO QUEBRADO] *sorri fracamente* Obrigado... A primeira letra é MEU, é MINHA dor...");
            itemEntregue = true;
        } else if (!itemEntregue) {
            System.out.println("\n[PALHAÇO QUEBRADO] Sem presentes... Sem esperança...");
        } else {
            System.out.println("\n[PALHAÇO QUEBRADO] Já nos conhecemos... O presente já foi dado.");
        }
    }
}
