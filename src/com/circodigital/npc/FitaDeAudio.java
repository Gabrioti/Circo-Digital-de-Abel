package com.circodigital.npc;

import com.circodigital.model.*;

/**
 * NPC da Fita de Áudio no Palco Quebrado.
 * Revela a dica sobre "Abel prefere vermelho, mas a verdade não é dele".
 */
public class FitaDeAudio extends NPC {
    private boolean pistaRevelada;
    
    public FitaDeAudio() {
        super(
            "Fita de Áudio",
            "Uma fita de áudio antiga e enrolada, ainda funcional",
            "A fita parece estar recolhida, talvez contenha conteúdo importante."
        );
        this.pistaRevelada = false;
    }
    
    @Override
    public void interagir(Jogador jogador) {
        if (!pistaRevelada) {
            System.out.println("\n[FITA DE ÁUDIO]");
            System.out.println("Você coloca a fita no leitor e ouve uma voz distorcida que diz:");
            System.out.println("\"Abel prefere vermelho, mas a verdade não é dele...\"");
            pistaRevelada = true;
        } else {
            System.out.println("\n[FITA DE ÁUDIO]");
            System.out.println("Já ouviu a mensagem: 'Abel prefere vermelho, mas a verdade não é dele...'");
        }
    }
}
