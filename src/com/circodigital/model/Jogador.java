package com.circodigital.model;

import java.util.*;

/**
 * Classe que representa o jogador no jogo.
 */
public class Jogador {
    private String nomeRealDesconhecido;
    private Inventario inventario;
    private List<Pista> pistasDescobertas;
    private String posicaoAtual;
    
    public Jogador(int capacidadeInventario) {
        this.nomeRealDesconhecido = ""; // Nome a ser descoberto: MARCOS
        this.inventario = new Inventario(capacidadeInventario);
        this.pistasDescobertas = new ArrayList<>();
        this.posicaoAtual = "Circo";
    }
    
    public Inventario getInventario() {
        return inventario;
    }
    
    public void setPosicaoAtual(String nomeSala) {
        this.posicaoAtual = nomeSala;
    }
    
    public String getPosicaoAtual() {
        return posicaoAtual;
    }
    
    public void adicionarPista(Pista pista) {
        if (!pistasDescobertas.contains(pista)) {
            pista.descobrir();
            pistasDescobertas.add(pista);
            System.out.println("\n[PISTA DESCOBERTA] " + pista.getConteudo());
        }
    }
    
    public List<Pista> getPistasDescobertas() {
        return new ArrayList<>(pistasDescobertas);
    }
    
    public void exibirPistas() {
        if (pistasDescobertas.isEmpty()) {
            System.out.println("\n[PISTAS] Nenhuma pista descoberta ainda.");
        } else {
            System.out.print("\n[PISTAS DESCOBERTAS] ");
            StringBuilder sb = new StringBuilder();
            for (Pista pista : pistasDescobertas) {
                sb.append(pista.getConteudo());
            }
            System.out.println(sb.toString());
        }
    }
    
    public String construirNomeFromPistas() {
        StringBuilder sb = new StringBuilder();
        for (Pista pista : pistasDescobertas) {
            sb.append(pista.getConteudo());
        }
        return sb.toString();
    }
}
