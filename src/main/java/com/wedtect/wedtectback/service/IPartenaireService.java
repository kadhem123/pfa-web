package com.wedtect.wedtectback.service;
import java.util.List;
import com.wedtect.wedtectback.entities.Partenaire;


public interface IPartenaireService {
    public Partenaire addPartenaire(Partenaire p);
    public void deletePartenaire(Long id);
    public Partenaire updatePartenaire(Partenaire p);
    public Partenaire findPartenaire(Long id);
    public List<Partenaire> findAll();
    public Partenaire findByMatFisc(Long matFisc);
    public List<Partenaire> findByNom(String nom);
}
