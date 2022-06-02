package com.wedtect.wedtectback.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wedtect.wedtectback.entities.Partenaire;

public interface PartenaireRepository  extends JpaRepository<Partenaire, Long> {

    Partenaire findByMatFisc(Long matFisc);

    List<Partenaire> findByNomStartingWith(String caractere);


}
