package com.wedtect.wedtectback.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wedtect.wedtectback.entities.Societe;

public interface SocieteRepository extends JpaRepository<Societe, Long> {


    Societe findByMatFisc(Long matFisc);


    List<Societe> findByNomStartingWith(String nom);

}

