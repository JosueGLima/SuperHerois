package br.com.senac.herois.controller;

import br.com.senac.produto.entity.SuperHeroi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Date;


@RestController
public class SuperHeroiController {

    ArrayList<SuperHeroi> superHerois = new ArrayList<SuperHeroi>(); 

    @GetMapping("/superHeroi")    
    public ResponseEntity<?> getDadosSuperheroi(@RequestParam int id) {        
        Optional<Produto> superHeroiPesquisado =  superHerois
                                                .stream()
                                            .filter(superHeroi -> superHeroi.getId() == id)
                                            .findFirst();

        if (superHeroiPesquisado.isPresent())
            return new ResponseEntity<>(superHeroiPesquisado.get(), HttpStatus.OK); 
        
        return new ResponseEntity<>("Super Heroi nao encontrado!", HttpStatus.NOT_FOUND); 
    }


    @GetMapping("/superHerois")    
    public String getDadosSuperheroi() {
        
        String resultado = "";

        for (int index = 0; index < superHerois.size(); index++) {
            resultado += " | " + superHerois.get(index).exibeDados();
        }        
        
        return resultado;
    }

    @PostMapping("/superHeroi")
    @ResponseStatus(HttpStatus.CREATED)
    public String setNomeSuperHeroi(@RequestParam int id, 
                                    @RequestParam String nome, 
                                    @RequestParam String apelido;
                                    @RequestParam String superPoder;
                                    @RequersParam String fraqueza;
                                    @RequestParam String historiaOrigem;
                                    @RequestParam Date primeiraAparicao) {
        SuperHeroi sh = new SuperHeroi();
        sh.setId(id);
        sh.setNome(nome);
        sh.setApelido(apelido); 
        sh.setSuperPoder(superPoder);
        sh.setFraqueza(fraqueza);
        sh.setHistoriaOrigem(historiaOrigem);
        sh.setPrimeAparicao(primeiraAparicao);       
        //adicionei no array
        superHerois.add(sh);

        return "Super Heroi cadastrado! Nome = " + sh.getNome() + 
                ", Apelido = " + sh.getApelido();    
    }    


    @PutMapping("/superHeroi")
    public String alterarProduto(@RequestParam int id, 
                                 @RequestParam String nome, 
                                 @RequestParam String apelido;
                                 @RequestParam String superPoder;
                                 @RequersParam String fraqueza;
                                 @RequestParam String historiaOrigem;
                                 @RequestParam Date primeiraAparicao) {

        //pesquisar no array o super heroi 
        //com o ID == ao do parametro informado
        for (int i = 0; i < superHerois.size(); i++) {
            SuperHeroi sh = superHerois.get(i);
            if (sh.getId() == id) {
                sh.setNome(nome);
                sh.setApelido(apelido); 
                sh.setSuperPoder(superPoder);
                sh.setFraqueza(fraqueza);
                sh.setHistoriaOrigem(historiaOrigem);
                sh.setPrimeAparicao(primeiraAparicao); 
                superHerois.set(i, p);
                break;
            }
        }
        return "Super heroi alterado!";
    }


    @DeleteMapping("/superHeroi")
    public ResponseEntity<?> deleteSuperHeroi(@RequestParam int id) {
        //pesquisar no array o Super heroi
        //com o ID informado e entao excluir o Super heroi
        boolean excluido = false;
        for (int i = 0; i < superHerois.size(); i++) {
            Produto sh = superHerois.get(i);
            if (sh.getId() == id) {
                superHerois.remove(i);
                excluido = true;
                break;
            }
        }

        if (excluido) {
            return new ResponseEntity<>("Registro excluido",HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>("Registro nao encontrado",HttpStatus.NOT_FOUND);
    }
    
}