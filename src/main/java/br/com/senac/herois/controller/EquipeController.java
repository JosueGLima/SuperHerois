package br.com.senac.herois.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.herois.entity.Equipe;
import br.com.senac.herois.repository.EquipeRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class EquipeController {
    
    private EquipeRepository equipeRepository;

    public EquipeController(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }
    //pesquisa os dados de todas as equipes
    @GetMapping("/equipes")
    public ResponseEntity<?> getEquipes() {        
        return new ResponseEntity<>(equipeRepository.findAll(), HttpStatus.OK);
    }
    //pesquisa os dados de uma equipe especifica pelo ID
    @GetMapping("/equipes/{id}")
    public ResponseEntity<?> getEquipeId(@PathVariable int id) {
        return new ResponseEntity<>(equipeRepository.findById(id),HttpStatus.OK);
    }
    //pesquisa os dados de uma equipe especifica pelo NOME
    @GetMapping("/equipes/nome/{nome}")
    public ResponseEntity<?> getEquipeNome(@PathVariable String nome) {
        return new ResponseEntity<>(equipeRepository.findByNomeLike("%" + nome + "%"),HttpStatus.OK);
    }
    //cria dados novos de uma equipe
    @PostMapping("/equipes")
    public ResponseEntity<?> salvarEquipe(@RequestBody Equipe entity) {
        Equipe equipeSalva;
        try {
            equipeSalva = equipeRepository.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao salvar equipe",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Equipe>(equipeSalva,HttpStatus.OK);
    }
    //atualiza os dados de uma equipe
    @PutMapping("/equipes/{id}")
    public ResponseEntity<?> atualizaEquipe(@PathVariable int id, @RequestBody Equipe entity) {

        Optional<Equipe> equipeAtualizar = equipeRepository.findById(id);
        Equipe eq = null;

        if (equipeAtualizar.isPresent()) {
            eq = equipeAtualizar.get();

            eq.setNome(entity.getNome());

            try {
                eq = equipeRepository.save(eq);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao atualizar a equipe",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Equipe>(eq,HttpStatus.OK); 

        } else {
            return new ResponseEntity<String>("Equipe nao encontrado",HttpStatus.BAD_REQUEST);
        }             
    }
    //deleta o heroi
    @DeleteMapping("/equipes/{id}")
    public ResponseEntity<?> deleteEquipe(@PathVariable int id) {

        Optional<Equipe> equipeExcluir = equipeRepository.findById(id);
        Equipe eq = null;

        if (equipeExcluir.isPresent()) {
            eq = equipeExcluir.get();
            
            try {
                equipeRepository.delete(eq);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao excluir a equipe",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Equipe>(eq,HttpStatus.OK); 

        } else {
            return new ResponseEntity<String>("Equipe nao encontrado",HttpStatus.BAD_REQUEST);
        } 
    }
}
