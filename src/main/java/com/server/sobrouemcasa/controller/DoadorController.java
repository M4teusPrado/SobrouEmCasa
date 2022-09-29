package com.server.sobrouemcasa.controller;

import com.server.sobrouemcasa.dto.DoadorDTO;
import com.server.sobrouemcasa.model.Doacao;
import com.server.sobrouemcasa.model.Doador;
import com.server.sobrouemcasa.service.DoacaoService;
import com.server.sobrouemcasa.service.DoadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doador")
public class DoadorController {

    @Autowired
    private DoadorService doadorService;

    @Autowired
    private DoacaoService doacaoService;

    @PostMapping("{id}/doacao")
    public ResponseEntity<Doacao> cadastroDoacao(@PathVariable Long id, @RequestBody Doacao doacao) {
        return ResponseEntity.ok().body(doacaoService.cadastrarDoacao(id,doacao));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDoador(@PathVariable Long id) {
        doadorService.deleteDoador(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Doador> updateDoador(@PathVariable Long id, @RequestBody DoadorDTO doador) {
        return ResponseEntity.ok().body(doadorService.updateDoador(id,doador));
    }

    @GetMapping("{id}")
    public ResponseEntity<Doador> getDoadorById(@PathVariable Long id){
        return ResponseEntity.ok().body(doadorService.getDoadorById(id));
    }
}
