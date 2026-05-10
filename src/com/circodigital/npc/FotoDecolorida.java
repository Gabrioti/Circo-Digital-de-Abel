package com.circodigital.npc;

import com.circodigital.model.*;

/**
 * NPC da Foto na Sala do Silêncio.
 * Revela as letras 'O' e 'S' quando inspecionada.
 */
public class FotoDecolorida extends NPC {
    private boolean pistaRevelada;
    
    public FotoDecolorida() {
        super(
            "Foto Descolorida",
            "Uma foto antiga e embaçada em uma parede de madeira apodrecida",
            "Parece ser um retrato de alguém importante, mas o tempo a dannificou."
        );
        this.pistaRevelada = false;
    }
    
    @Override
    public void interagir(Jogador jogador) {
        if (!pistaRevelada) {
            System.out.println("\n[FOTO DECOLORIDA]");
            System.out.println("Você examina a foto com atenção e consegue ler no verso:");
            System.out.println("\"Cores revelam a verdade...");
            System.out.println("\nA verdade está inscrita: O, S\"");
            
            Pista pistaO = new Pista("O", "Letra 'O' da Foto");
            Pista pistaS = new Pista("S", "Letra 'S' da Foto");
            jogador.adicionarPista(pistaO);
            jogador.adicionarPista(pistaS);
            pistaRevelada = true;
        } else {
            System.out.println("\n[FOTO DECOLORIDA]");
            System.out.println("Já viu o que tinha para ver: as letras 'O' e 'S'.");
        }
    }
}
