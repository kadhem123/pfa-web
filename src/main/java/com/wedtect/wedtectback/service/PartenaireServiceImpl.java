package com.wedtect.wedtectback.service;
import java.util.List;
import com.wedtect.wedtectback.dao.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wedtect.wedtectback.entities.Partenaire;

@Service
public class PartenaireServiceImpl implements IPartenaireService{

    @Autowired
    PartenaireRepository partenaireRepository;

    public Partenaire addPartenaire(Partenaire p){
        return partenaireRepository.save(p);
    }
    public void deletePartenaire(Long id) {
        if(partenaireRepository.findById(id).isPresent())
            partenaireRepository.deleteById(id);
    }
    public Partenaire updatePartenaire(Partenaire p) {
        return partenaireRepository.saveAndFlush(p);
    }
    public Partenaire findPartenaire(Long id) {
        return partenaireRepository.findById(id).get();
    }
    public List<Partenaire> findAll() {
        return partenaireRepository.findAll();
    }
    public Partenaire findByMatFisc(Long matFisc) {

        return partenaireRepository.findByMatFisc(matFisc);
    }
    public List<Partenaire> findByNom(String nom) {
        return partenaireRepository.findByNomStartingWith(nom);
    }
}
