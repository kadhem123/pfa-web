package com.wedtect.wedtectback.service;
import java.util.List;

import com.wedtect.wedtectback.dao.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedtect.wedtectback.entities.Projet;

@Service
public class ProjetServiceImpl implements IProjetService{

    @Autowired
    ProjetRepository projetRepository;

    public Projet addProjet(Projet p){
        return projetRepository.save(p);
    }

    public void deleteProjet(Long idProjet) {
        if(projetRepository.findById(idProjet).isPresent())
            projetRepository.deleteById(idProjet);
    }
    public Projet updateProjet(Projet p) {
        return projetRepository.saveAndFlush(p);
    }
    public Projet findProjet(Long idProjet) {
        return projetRepository.findById(idProjet).get();
    }
    public List<Projet> findAll() {
        return projetRepository.findAll();
    }
    public Projet findByTitre(String titre) {
        return projetRepository.findByTitre(titre);

    }

}
