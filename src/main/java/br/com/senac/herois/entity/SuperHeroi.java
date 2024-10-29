package br.com.senac.herois.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "heroi")
public class SuperHeroi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private String apelido;

    @Column
    private String superPoder;

    @Column
    private String fraqueza;

    @Column
    private String historiaOrigem;

    @Column
    private Date primeiraAparicao;

    @OneToOne
    @JoinColumn(name = "equipe_id", referencedColumnName = "id")
    private Equipe equipe;

    public String exibeDados() {
        return getId() + ", " + getNome() + ", " + getApelido() + ", " + 
               getSuperPoder() + ", " + getFraqueza() + ", " + 
               getHistoriaOrigem() + ", " + getPrimeAparicao();
    }
    //-----------------------------------------
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //-----------------------------------------
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    //-----------------------------------------
    public String getApelido() {
        return this.apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }
    //-----------------------------------------
    public String getSuperPoder() {
        return this.superPoder;
    }

    public void setSuperPoder(String superPoder) {
        this.superPoder = superPoder;
    }
    //-----------------------------------------
    public String getFraqueza() {
        return this.fraqueza;
    }

    public void setFraqueza(String fraqueza) {
        this.fraqueza = fraqueza;
    }
    //-----------------------------------------
    public String getHistoriaOrigem() {
        return this.historiaOrigem;
    }

    public void setHistoriaOrigem(String historiaOrigem) {
        this.historiaOrigem = historiaOrigem;
    }
    //-----------------------------------------
    public Date getPrimeAparicao() {
        return this.primeiraAparicao;
    }

    public void setPrimeAparicao(Date primeiraAparicao) {
        this.primeiraAparicao = primeiraAparicao;
    }
    //-----------------------------------------
    public Equipe getEquipe() {
        return this.equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}