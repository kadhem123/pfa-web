package com.wedtect.wedtectback.controller;

import com.wedtect.wedtectback.entities.Projet;
import com.wedtect.wedtectback.service.IProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class ProjetController {
    @Autowired
    IProjetService iProjetService;
    @GetMapping(value = "/projets")
    public List<Projet> findAllProjet(){
        return iProjetService.findAll();
    }
    @GetMapping(value = "/projets/{idProjet}")
    public Projet findoneProjet(@PathVariable Long idProjet)
    {
        return iProjetService.findProjet(idProjet);
    }
    @PostMapping(value = "/projets")
    public Projet addProjet(@RequestBody Projet p)
    {
        return iProjetService.addProjet(p);
    }
    @PutMapping(value="/projets/{idProjet}")
    public Projet updateProjet(@PathVariable Long idProjet, @RequestBody Projet p)
    {
        p.setIdProjet(idProjet);
        return iProjetService.updateProjet(p);
    }
    @DeleteMapping(value="/projets/{idProjet}")
    public void deleteProjet(@PathVariable Long idProjet)
    {
        iProjetService.deleteProjet(idProjet);
    }

}
