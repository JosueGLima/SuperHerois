package br.com.senac.herois.entity;

import java.util.Date;

public class SuperHeroi {
    private int id;
    private String nome;
    private String apelido;
    private String superPoder;
    private String fraqueza;
    private String historiaOrigem;
    private Date primeiraAparicao;

    public String exibeDados() {
        return getId() + ", " + getNome() + ", " + getApelido() + ", " + 
               getSuperPoder() + ", " + getFraqueza() + ", " + 
               getHistoriaOrigem() + ", " + getPrimeAparicao();
    }
    //-----------------------------------------
    public void getId() {
        return this.id;
    }

    public int setId(int id) {
        this.id = id;
    }
    //-----------------------------------------
    public void getNome() {
        return this.nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
    }
    //-----------------------------------------
    public void getApelido() {
        return this.apelido;
    }

    public String setApelido(String apelido) {
        this.apelido = apelido
    }
    //-----------------------------------------
    public void getSuperPoder() {
        return this.superPoder;
    }

    public String setSuperPoder(String superPoder) {
        this.superPoder = superPoder;
    }
    //-----------------------------------------
    public void getFraqueza() {
        return this.fraqueza;
    }

    public String setFraqueza(String fraqueza) {
        this.fraqueza = fraqueza;
    }
    //-----------------------------------------
    public void getHistoriaOrigem() {
        return this.historiaOrigem;
    }

    public String setHistoriaOrigem(String historiaOrigem) {
        this.historiaOrigem = historiaOrigem;
    }
    //-----------------------------------------
    public void getPrimeAparicao() {
        return this.primeiraAparicao;
    }

    public Date setPrimeAparicao() {
        this.primeiraAparicao = primeiraAparicao;
    }
}