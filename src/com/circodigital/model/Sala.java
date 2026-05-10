package com.circodigital.model;

import java.util.*;

/**
 * Classe que representa uma sala/ambiente no jogo.
 */
public class Sala {
    private String nome;
    private String descricao;
    private String descricaoDetalhada;
    private Map<String, Sala> conexoes; // norte, sul, leste, oeste
    private List<Item> itensPresentes;
    private List<Pista> pistasPresentes;
    private boolean bloqueada;
    private String itemBloqueio; // Item necessário para acessar (ex: "Chave do Escritório")
    private String asciiArt; // Arte ASCII exibida ao entrar na sala
    
    public Sala(String nome, String descricao, String descricaoDetalhada) {
        this.nome = nome;
        this.descricao = descricao;
        this.descricaoDetalhada = descricaoDetalhada;
        this.conexoes = new HashMap<>();
        this.itensPresentes = new ArrayList<>();
        this.pistasPresentes = new ArrayList<>();
        this.bloqueada = false;
        this.itemBloqueio = null;
        this.asciiArt = null;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public String getDescricaoDetalhada() {
        return descricaoDetalhada;
    }
    
    public void exibirDescricaoCompleta() {
        System.out.println("\n========================================");
        System.out.println("[" + nome.toUpperCase() + "]");
        System.out.println("========================================");
        if (asciiArt != null && !asciiArt.isEmpty()) {
            System.out.println(asciiArt);
            System.out.println();
        }
        System.out.println(descricaoDetalhada);

        if (!itensPresentes.isEmpty()) {
            System.out.println("\n[ITENS PRESENTES]");
            for (Item item : itensPresentes) {
                System.out.println("  - " + item.getNome() + ": " + item.getDescricao());
            }
        }
        //exibirConexoes();
    }
    /*
    private void exibirConexoes() {
        System.out.println("\n[SAÍDAS DISPONÍVEIS]");
        if (conexoes.isEmpty()) {
            System.out.println("  Nenhuma saída disponível.");
        } else {
            for (String direcao : conexoes.keySet()) {
                System.out.println("  - " + direcao.toUpperCase() + " -> " + conexoes.get(direcao).getNome());
            }
        }
    }
    */
    
    public void adicionarConexao(String direcao, Sala sala) {
        conexoes.put(direcao.toLowerCase(), sala);
    }
    
    public Sala obterConexao(String direcao) {
        return conexoes.get(direcao.toLowerCase());
    }
    
    public boolean temConexao(String direcao) {
        return conexoes.containsKey(direcao.toLowerCase());
    }
    
    public void adicionarItem(Item item) {
        itensPresentes.add(item);
    }
    
    public void removerItem(String nomeItem) {
        itensPresentes.removeIf(item -> item.getNome().equalsIgnoreCase(nomeItem));
    }
    
    public Item obterItem(String nomeItem) {
        return itensPresentes.stream()
            .filter(item -> item.getNome().equalsIgnoreCase(nomeItem))
            .findFirst()
            .orElse(null);
    }
    
    public List<Item> getItensPresentes() {
        return new ArrayList<>(itensPresentes);
    }
    
    public void adicionarPista(Pista pista) {
        pistasPresentes.add(pista);
    }
    
    public List<Pista> getPistasPresentes() {
        return new ArrayList<>(pistasPresentes);
    }
    
    public void bloquearComItem(String itemNecessario) {
        this.bloqueada = true;
        this.itemBloqueio = itemNecessario;
    }
    
    public void setAsciiArt(String asciiArt) {
        this.asciiArt = asciiArt;
    }
    
    public String getAsciiArt() {
        return asciiArt;
    }
    
    public boolean estaBloqueada() {
        return bloqueada;
    }
    
    public String getItemBloqueio() {
        return itemBloqueio;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
