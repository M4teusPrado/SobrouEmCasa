package com.server.sobrouemcasa.service;

import com.server.sobrouemcasa.dto.DoadorDTO;
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

    public Doador updateDoador(Long id, DoadorDTO doadorDTO) {
        Doador doador = getDoadorById(id);
        setValuesDTO(doadorDTO, doador);
        return cadastrarDoador(doador);
    }
    public void setValuesDTO(DoadorDTO doadorDTO, Doador doador) {
        if(doadorDTO.getNome() != null) doador.setNome(doadorDTO.getNome());
        if(doadorDTO.getDescricao() != null) doador.setDescricao(doadorDTO.getDescricao());
        if(doadorDTO.getEndereco() != null) doador.setEndereco(doadorDTO.getEndereco());
        if(doadorDTO.getSenha() != null) doador.setSenha(doadorDTO.getSenha());
    }
}
