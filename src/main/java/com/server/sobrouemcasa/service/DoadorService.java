package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.model.Doador;
import com.server.sobrouemcasa.repository.DoadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoadorService {

    @Autowired
    private DoadorRepository doadorRepository;

    public Doador cadastrarDoador(Doador doador) {
        return doadorRepository.save(doador);
    }

}
