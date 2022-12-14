package com.server.sobrouemcasa.controller;

import com.google.maps.errors.ApiException;
import com.server.sobrouemcasa.dto.RetFiltroDoacaoDTO;
import com.server.sobrouemcasa.model.Ong;
import com.server.sobrouemcasa.service.OngService;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ong")
public class OngController {

    @Autowired
    private OngService ongService;


    @GetMapping("{id}/filtro")
    public ResponseEntity<List<RetFiltroDoacaoDTO>> getDoacao(@PathVariable Long id, @RequestParam(value = "distancia") int distancia ) throws Exception {
        return ResponseEntity.ok(ongService.getDoacaoByDistance(id, distancia));
    }

    @GetMapping("{id}")
    public ResponseEntity<Ong> getOngId(@PathVariable Long id){
        return ResponseEntity.ok().body(ongService.getOngById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOng(@PathVariable Long id) {
        ongService.deleteOng(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Ong> updateDoacao(@PathVariable Long id,  @RequestBody Ong ong) {
        return ResponseEntity.ok().body(ongService.updateOng(id,ong));
    }

}
