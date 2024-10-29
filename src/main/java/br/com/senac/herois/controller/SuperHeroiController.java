package br.com.senac.herois.controller;

import br.com.senac.herois.controller.SuperHeroiController;
import br.com.senac.herois.entity.Equipe;
import br.com.senac.herois.entity.SuperHeroi;
import br.com.senac.herois.repository.SuperHeroiRepository;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class SuperHeroiController {
    private SuperHeroiRepository superHeroiRepository;

    public SuperHeroiController(SuperHeroiRepository superHeroiRepository) {
        this.superHeroiRepository = superHeroiRepository;
    }
    //pesquisa todos os dados dos herois
    @GetMapping("/superHerois")
    public ResponseEntity<?> getDadosHeroi() {
        return new ResponseEntity<>(superHeroiRepository.findAll(),HttpStatus.OK);
    }
    //pesquisa os dados de um heroi especifico pelo ID
    @GetMapping("/superHerois/{id}")
    public ResponseEntity<?> getSuperHeroiId(@PathVariable int id) {
        return new ResponseEntity<>(superHeroiRepository.findById(id),HttpStatus.OK);
    }
    //pesquisa os dados de um heroi especifico pelo NOME
    @GetMapping("/superHerois/nome/{nome}")
    public ResponseEntity<?> getSuperHeroiNome(@PathVariable String nome) {
        return new ResponseEntity<>(superHeroiRepository.findByNomeLike("%" + nome + "%"),HttpStatus.OK);
    }
    //pesquisa os dados de um heroi especifico pelo APELIDO
    @GetMapping("/superHerois/apelido/{apelido}")
    public ResponseEntity<?> getSuperHeroiApelido(@PathVariable String apelido) {
        return new ResponseEntity<>(superHeroiRepository.findByApelidoLike("%" + apelido + "%"),HttpStatus.OK);
    }
    //pesquisa os dados de um heroi especifico pelo SUPER PODER
    @GetMapping("/superHerois/superPoder/{superPoder}")
    public ResponseEntity<?> getSuperHeroiSuperPoder(@PathVariable String superPoder) {
        return new ResponseEntity<>(superHeroiRepository.findBySuperPoderLike("%" + superPoder + "%"),HttpStatus.OK);
    }
    //pesquisa os dados de um heroi especifico pela FRAQUEZA
    @GetMapping("/superHerois/fraqueza/{fraqueza}")
    public ResponseEntity<?> getSuperHeroiFraqueza(@PathVariable String fraqueza) {
        return new ResponseEntity<>(superHeroiRepository.findByFraquezaLike("%" + fraqueza + "%"),HttpStatus.OK);
    }
    //pesquisa os dados de um heroi especifico pela EQUIPE
    @GetMapping("/superHerois/equipe/{equipe}")
    public ResponseEntity<?> getSuperHeroiEquipe(@RequestBody Equipe equipe) {
        return new ResponseEntity<>(superHeroiRepository.findByEquipe(equipe),HttpStatus.OK);
    }
    //cria dados novos de um heroi
    @PostMapping("/superHerois")
    public ResponseEntity<?> salvarSuperHeroi(@RequestBody SuperHeroi entity) {
        SuperHeroi superHeroiSalvo;
        try {
            superHeroiSalvo = superHeroiRepository.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao salvar super heroi",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<SuperHeroi>(superHeroiSalvo,HttpStatus.OK);
    }
    //atualiza os dados de um heroi
    @PutMapping("/superHerois/{id}")
    public ResponseEntity<?> atualizaSuperHeroi(@PathVariable int id, @RequestBody SuperHeroi entity) {

        Optional<SuperHeroi> superHeroiAtualizar = superHeroiRepository.findById(id);
        SuperHeroi sh = null;

        if (superHeroiAtualizar.isPresent()) {
            sh = superHeroiAtualizar.get();

            sh.setNome(entity.getNome());
            sh.setApelido(entity.getApelido());
            sh.setSuperPoder(entity.getSuperPoder());
            sh.setFraqueza(entity.getFraqueza());
            sh.setHistoriaOrigem(entity.getHistoriaOrigem());
            sh.setPrimeAparicao(entity.getPrimeAparicao());

            try {
                sh = superHeroiRepository.save(sh);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao atualizar o super heroi",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<SuperHeroi>(sh,HttpStatus.OK); 

        } else {
            return new ResponseEntity<String>("Super heroi nao encontrado",HttpStatus.BAD_REQUEST);
        }             
    }
    //deleta o heroi
    @DeleteMapping("/superHerois/{id}")
    public ResponseEntity<?> deleteSuperHeroi(@PathVariable int id) {

        Optional<SuperHeroi> superHeroiExcluir = superHeroiRepository.findById(id);
        SuperHeroi sh = null;

        if (superHeroiExcluir.isPresent()) {
            sh = superHeroiExcluir.get();
            
            try {
                superHeroiRepository.delete(sh);
            } catch (Exception e) {
                return new ResponseEntity<String>("Erro ao excluir o super heroi",HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<SuperHeroi>(sh,HttpStatus.OK); 

        } else {
            return new ResponseEntity<String>("Super heroi nao encontrado",HttpStatus.BAD_REQUEST);
        } 
    }
    
}