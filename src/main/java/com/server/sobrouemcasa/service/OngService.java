package com.server.sobrouemcasa.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import com.server.sobrouemcasa.dto.RetFiltroDoacaoDTO;
import com.server.sobrouemcasa.model.Doacao;
import com.server.sobrouemcasa.model.Ong;
import com.server.sobrouemcasa.repository.OngRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.lang.Math;

@Service
public class OngService {

    @Autowired
    private OngRepository ongRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DoacaoService doacaoService;

    public Ong saveOng(Ong ong) {
        return ongRepository.save(ong);
    }

    public Ong cadastroOng(Ong ong) {
        return saveOng(ong);
    }

    public void deleteOng(Long id) {
        getOngById(id);
        ongRepository.deleteById(id);
    }
    
    public Ong getOngById(Long id) {
        Optional<Ong> opOng = ongRepository.findById(id);
        return opOng.orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "ONG  não encontrada"));
    }

    public Ong updateOng(Long id, Ong ong) {
        Ong ongAntes = getOngById(id);
        ongAntes.setCnpj(ong.getCnpj());
        ongAntes.setDataConstituicao(ong.getDataConstituicao());
        ongAntes.setEmail(ong.getEmail());
        ongAntes.setFinalidadeInstitucional(ong.getFinalidadeInstitucional());

        return ongRepository.save(ongAntes);
    }

    public List<RetFiltroDoacaoDTO> getDoacaoByDistance(Long idOng, int filtroKM) throws ApiException, InterruptedException, IOException{
        
        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBSPbsdPrzd9w6chbNpIXqQ4-cj29hHjk8").build();
        
        //Ong que será considerada no filtro
        Ong ong = getOngById(idOng);

        String enderecoOng = ong.getEndereco().getLogradouro() + ", " + ong.getEndereco().getNumero();
        GeocodingResult[] resultsOng =  GeocodingApi.geocode(context, enderecoOng).await();

        Double latOng = resultsOng[0].geometry.location.lat;
        Double lngOng = resultsOng[0].geometry.location.lng;

        //Lista de doações armazenadas
        List<Doacao> doacoes = doacaoService.getAllDoacoes();
        List<RetFiltroDoacaoDTO> doacoesFiltradas = new ArrayList<RetFiltroDoacaoDTO>();

        for(Doacao doacao : doacoes){
            String enderecoDoacao = doacao.getDoador().getEndereco().getLogradouro() + ", " + doacao.getDoador().getEndereco().getNumero();
            GeocodingResult[] resultsDoacao =  GeocodingApi.geocode(context, enderecoDoacao).await();
            Double latDoacao = resultsDoacao[0].geometry.location.lat;
            Double lngDoacao = resultsDoacao[0].geometry.location.lng;
            Double difLat = Math.abs(latOng - latDoacao) * 111.1;
            Double difLng = Math.abs(lngOng - lngDoacao) * 96.2;
            Double distPontos = Math.sqrt(Math.pow(difLat, 2) + Math.pow(difLng, 2));

            if(distPontos <= filtroKM)
                doacoesFiltradas.add(new RetFiltroDoacaoDTO(doacao, distPontos));
        }
        return doacoesFiltradas;
    }
}
