package com.pa.sobrouemcasa.service;

import com.pa.sobrouemcasa.model.Doador;
import com.pa.sobrouemcasa.repository.DoadorRepository;
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
