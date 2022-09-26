package com.server.sobrouemcasa.controller;

import com.server.sobrouemcasa.model.Doacao;
import com.server.sobrouemcasa.service.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {


    @Autowired
    private DoacaoService doacaoService;


    @GetMapping("{id}")
    public ResponseEntity<Doacao> getDoacaoById(@PathVariable Long id){
        return ResponseEntity.ok().body(doacaoService.getDoacaoById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDoacao(@PathVariable Long id) {
        doacaoService.deleteDoacao(id);
        return ResponseEntity.noContent().build();
    }
}
