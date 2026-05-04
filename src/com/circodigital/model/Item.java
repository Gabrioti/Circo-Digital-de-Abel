package com.circodigital.model;

/**
 * Classe que representa um item colecionável no jogo.
 */
public class Item {
    private String nome;
    private String descricao;
    private boolean coletavel;
    
    public Item(String nome, String descricao, boolean coletavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.coletavel = coletavel;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public boolean isColetavel() {
        return coletavel;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
