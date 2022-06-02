package com.wedtect.wedtectback.service;
import java.util.List;

import com.wedtect.wedtectback.dao.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedtect.wedtectback.entities.Societe;

@Service
public class SocieteServiceImpl implements ISocieteService{

    @Autowired
    SocieteRepository societeRepository;

    public Societe addSociete(Societe s){
        return societeRepository.save(s);
    }
    public void deleteSociete(Long idSociete) {
        if(societeRepository.findById(idSociete).isPresent())
            societeRepository.deleteById(idSociete);
    }
    public Societe updateSociete(Societe p) {
        return societeRepository.saveAndFlush(p);
    }
    public Societe findSociete(Long idSociete) {
        return societeRepository.findById(idSociete).get();
    }
    public List<Societe> findAll() {
        return societeRepository.findAll();
    }
    public Societe findByMatFisc(Long matFisc) {

        return societeRepository.findByMatFisc(matFisc);

    }
    public List<Societe> findByNom(String nom) {
        return societeRepository.findByNomStartingWith(nom);
    }
}
