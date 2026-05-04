package com.circodigital.model;

/**
 * Classe que representa uma pista (letra ou informação fragmentada).
 */
public class Pista {
    private String conteudo;
    private String descricao;
    private boolean descoberta;
    
    public Pista(String conteudo, String descricao) {
        this.conteudo = conteudo;
        this.descricao = descricao;
        this.descoberta = false;
    }
    
    public String getConteudo() {
        return conteudo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public boolean isDescoberta() {
        return descoberta;
    }
    
    public void descobrir() {
        this.descoberta = true;
    }
    
    @Override
    public String toString() {
        return conteudo;
    }
}
