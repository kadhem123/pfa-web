package com.wedtect.wedtectback.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wedtect.wedtectback.entities.Facture;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    Long countById(Long id);
}