package com.pa.sobrouemcasa.repository;

import com.pa.sobrouemcasa.model.Doador;
import com.pa.sobrouemcasa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {
    Optional<Doador> findById(Long id);


}