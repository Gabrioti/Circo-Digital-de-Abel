package com.circodigital.npc;

import com.circodigital.model.*;

/**
 * NPC do Espelho na Entrada.
 * Revela a pista da letra 'R' quando inspecionado.
 */
public class EspelhoAntigo extends NPC {
    private boolean pistaRevelada;
    
    public EspelhoAntigo() {
        super(
            "Espelho Antigo",
            "Um espelho rachado e embaçado com as bordas corroídas",
            "Seu reflexo parece distorcido... Há algo escrito na borda inferior."
        );
        this.pistaRevelada = false;
    }
    
    @Override
    public void interagir(Jogador jogador) {
        if (!pistaRevelada) {
            System.out.println("\n[ESPELHO ANTIGO]");
            System.out.println("Você se aproxima do espelho e consegue ler:\"R\" gravado na borda.");
            
            Pista pistaR = new Pista("R", "Letra 'R' do Espelho");
            jogador.adicionarPista(pistaR);
            pistaRevelada = true;
        } else {
            System.out.println("\n[ESPELHO ANTIGO]");
            System.out.println("Já viu o que tinha para ver: a letra 'R' na borda.");
        }
    }
}
