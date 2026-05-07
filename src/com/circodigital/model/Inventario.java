package com.circodigital.model;

import java.util.*;

/**
 * Classe que gerencia o inventário do jogador.
 */
public class Inventario {
    private List<Item> itens;
    private int capacidade;
    
    public Inventario(int capacidade) {
        this.itens = new ArrayList<>();
        this.capacidade = capacidade;
    }
    
    public boolean adicionarItem(Item item) {
        if (itens.size() < capacidade && item.isColetavel()) {
            itens.add(item);
            return true;
        }
        return false;
    }
    
    public boolean removerItem(String nomeItem) {
        return itens.removeIf(item -> item.getNome().equalsIgnoreCase(nomeItem));
    }
    
    public Item obterItem(String nomeItem) {
        return itens.stream()
            .filter(item -> item.getNome().equalsIgnoreCase(nomeItem))
            .findFirst()
            .orElse(null);
    }
    
    public boolean possuiItem(String nomeItem) {
        return itens.stream()
            .anyMatch(item -> item.getNome().equalsIgnoreCase(nomeItem));
    }
    
    public List<Item> listarItens() {
        return new ArrayList<>(itens);
    }
    
    public void exibirInventario() {
        if (itens.isEmpty()) {
            System.out.println("\n[INVENTÁRIO] Vazio");
            

        } else {
            System.out.println("\n[INVENTÁRIO]");
            for (int i = 0; i < itens.size(); i++) {
                System.out.println("  " + (i + 1) + ". " + itens.get(i).getNome());
            }
        }
    }
    
    public int getTamanho() {
        return itens.size();
    }
}
