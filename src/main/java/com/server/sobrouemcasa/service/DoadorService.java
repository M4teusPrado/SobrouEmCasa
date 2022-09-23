package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.model.Doador;
import com.server.sobrouemcasa.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository doadorRepository;

    public Doador cadastrarDoador(Doador doador) {
        return doadorRepository.save(doador);
    }

    public Doador getDoadorById(Long id) {
        Optional<Doador> opDoador = doadorRepository.findById(id);
        return opDoador.orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Doador não encontrado"));
    }
}
