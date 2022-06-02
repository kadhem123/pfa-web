package com.wedtect.wedtectback.service;
import com.wedtect.wedtectback.Facture.BillNotFoundException;
import com.wedtect.wedtectback.entities.Facture;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface FactureService {
    Facture save(Facture facture);

    List<Facture> findAll();

    Facture get(Long id) throws BillNotFoundException ;

    void delete(Long id) throws BillNotFoundException ;


}

