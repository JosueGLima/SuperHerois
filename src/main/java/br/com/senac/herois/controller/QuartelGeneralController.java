package br.com.senac.herois.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.herois.entity.QuartelGeneral;
import br.com.senac.herois.repository.QuartelGeneralRepository;

@RestController
public class QuartelGeneralController {

    private QuartelGeneralRepository quartelGeneralRepository;

    public QuartelGeneralController(QuartelGeneralRepository quartelGeneralRepository) {
        this.quartelGeneralRepository = quartelGeneralRepository;
    }

    @GetMapping("/quartelGeneral")
    public ResponseEntity<?>  getAllQuarteis() {
        return new ResponseEntity<>(quartelGeneralRepository.findAll(), HttpStatus.OK);
    }
    
    @PostMapping("/quartelGeneral")
    public ResponseEntity<?> salvaLoja(@RequestBody QuartelGeneral entity) {
        QuartelGeneral quartelGeneral;
        try {
            quartelGeneral = quartelGeneralRepository.save(entity);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao salvar o quartel general", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<QuartelGeneral>(quartelGeneral, HttpStatus.OK);
    }    
}
