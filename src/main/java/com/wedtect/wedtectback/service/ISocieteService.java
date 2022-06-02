package com.wedtect.wedtectback.service;
import java.util.List;
import com.wedtect.wedtectback.entities.Societe;

public interface ISocieteService {

    public Societe addSociete(Societe s);
    public void deleteSociete(Long idSociete);
    public Societe updateSociete(Societe c);
    public Societe findSociete(Long idSociete);
    public List<Societe> findAll();
    public Societe findByMatFisc(Long matFisc);
    public List<Societe> findByNom(String nom);
}
