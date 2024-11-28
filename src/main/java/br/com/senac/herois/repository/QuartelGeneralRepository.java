package br.com.senac.herois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senac.herois.entity.QuartelGeneral;

public interface QuartelGeneralRepository extends JpaRepository<QuartelGeneral, Integer> {
    
}
