package com.wedtect.wedtectback.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wedtect.wedtectback.entities.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Long> {


    Projet findByTitre(String titre);

    List<Projet> findAllByTitre(String titre);

}
