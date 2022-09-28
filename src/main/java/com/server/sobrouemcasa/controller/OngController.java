package com.server.sobrouemcasa.controller;

import com.server.sobrouemcasa.model.Ong;
import com.server.sobrouemcasa.service.OngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ong")
public class OngController {

    @Autowired
    private OngService ongService;

    @PostMapping("{id}/ong")
    public ResponseEntity<Ong> cadastroDoacao(@PathVariable Long id, @RequestBody Ong ong) {
        return ResponseEntity.ok().body(ongService.cadastrarOng(id,ong));
    }



    
    @GetMapping("{id}")
    public ResponseEntity<Ong> getOngId(@PathVariable Long id){
        return ResponseEntity.ok().body(ongService.getOngById(id));
    }
}
