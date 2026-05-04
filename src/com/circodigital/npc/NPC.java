package com.circodigital.npc;

import com.circodigital.model.*;

/**
 * Classe abstrata que representa um NPC (personagem não-jogável).
 */
public abstract class NPC {
    protected String nome;
    protected String descricao;
    protected String dialogo;
    protected boolean jafaloiu;
    protected Item itemSolicitado;
    protected Item itemRetorno;
    
    public NPC(String nome, String descricao, String dialogo) {
        this.nome = nome;
        this.descricao = descricao;
        this.dialogo = dialogo;
        this.jafaloiu = false;
        this.itemSolicitado = null;
        this.itemRetorno = null;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void falar() {
        System.out.println("\n[" + nome.toUpperCase() + "] " + dialogo);
        jafaloiu = true;
    }
    
    public abstract void interagir(Jogador jogador);
    
    public void setItemSolicitado(Item item) {
        this.itemSolicitado = item;
    }
    
    public void setItemRetorno(Item item) {
        this.itemRetorno = item;
    }
    
    public Item getItemSolicitado() {
        return itemSolicitado;
    }
    
    public Item getItemRetorno() {
        return itemRetorno;
    }
}
