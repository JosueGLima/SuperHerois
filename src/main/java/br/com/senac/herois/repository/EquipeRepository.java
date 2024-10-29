package br.com.senac.herois.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.herois.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    ArrayList<Equipe> findByNomeLike(String nome);
}