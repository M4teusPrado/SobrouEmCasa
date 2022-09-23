package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.model.Doacao;
import com.server.sobrouemcasa.model.Doador;
import com.server.sobrouemcasa.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    @Autowired
    private DoadorService doadorService;

    public Doacao cadastrarDoacao(Long id, Doacao doacao) {
        Doador doador = doadorService.getDoadorById(id);
        doacao.setDoador(doador);
        doador.addDoacao(doacao);
        doadorService.cadastrarDoador(doador);
        return doacaoRepository.save(doacao);
    }

    public Doacao getDoacaoById(Long id) {
        Optional<Doacao> opDoacao = doacaoRepository.findById(id);
        return opDoacao.orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "Doacao  não encontrado"));
    }
}
