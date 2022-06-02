package com.wedtect.wedtectback.service;
import java.util.List;
import com.wedtect.wedtectback.entities.Projet;


public interface IProjetService {
    public Projet addProjet(Projet p);
    public void deleteProjet(Long idProjet);
    public Projet updateProjet(Projet p);
    public Projet findProjet(Long idProjet);
    public List<Projet> findAll();
    public Projet findByTitre(String titre);

}