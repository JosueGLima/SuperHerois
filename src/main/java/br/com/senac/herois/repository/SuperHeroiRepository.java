package br.com.senac.herois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.herois.entity.Equipe;
import br.com.senac.herois.entity.SuperHeroi;
import java.util.ArrayList;

public interface SuperHeroiRepository extends JpaRepository<SuperHeroi, Integer> {
    ArrayList<SuperHeroi> findByNomeLike(String nome);

    ArrayList<SuperHeroi> findByApelidoLike(String apelido);

    ArrayList<SuperHeroi> findBySuperPoderLike(String superPoder);

    ArrayList<SuperHeroi> findByFraquezaLike(String fraqueza);

    ArrayList<SuperHeroi> findByEquipe(Equipe equipe);
}
