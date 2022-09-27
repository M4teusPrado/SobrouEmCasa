package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.dto.DoacaoDTO;
import com.server.sobrouemcasa.dto.DoadorDTO;
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

    public void deleteDoacao(Long id) {
        getDoacaoById(id);
        doacaoRepository.deleteById(id);
    }

    public Doacao cadastrarDoacao(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    public Doacao updateDoacao(Long id, DoacaoDTO doacaoDTO) {
        Doacao doacao = getDoacaoById(id);
        setValuesDTO(doacaoDTO, doacao);
        return cadastrarDoacao(doacao);
    }

    public void setValuesDTO(DoacaoDTO doacaoDTO, Doacao doacao) {
        if(doacaoDTO.getNome() != null) doacao.setNome(doacaoDTO.getNome());
        if(doacaoDTO.getDescricao() != null) doacao.setDescricao(doacaoDTO.getDescricao());
    }
}
