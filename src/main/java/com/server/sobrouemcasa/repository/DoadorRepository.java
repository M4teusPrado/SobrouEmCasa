package com.server.sobrouemcasa.repository;

import com.server.sobrouemcasa.model.Doador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoadorRepository extends JpaRepository<Doador, Long> {
    Optional<Doador> findById(Long id);

}