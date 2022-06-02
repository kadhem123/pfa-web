package com.wedtect.wedtectback.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.wedtect.wedtectback.entities.Societe;
import com.wedtect.wedtectback.service.ISocieteService;

@RestController
public class SocieteController {
    @Autowired
    ISocieteService iSocieteService;
    @GetMapping(value = "/societes")
    public List<Societe> findAllSocietes(){
        return iSocieteService.findAll();
    }
    @GetMapping(value = "/societes/{idSociete}")
    public Societe findoneSociete(@PathVariable Long idSociete)
    {
        return iSocieteService.findSociete(idSociete);
    }
    @PostMapping(value = "/societes")
    public Societe addSociete(@RequestBody Societe S)
    {
        return iSocieteService.addSociete(S);
    }
    @PutMapping(value="/societes/{idSociete}")
    public Societe updateSociete(@PathVariable Long idSociete, @RequestBody Societe S)
    {
        S.setIdSociete(idSociete);
        return iSocieteService.updateSociete(S);
    }
    @DeleteMapping(value="/societes/{idSociete}")
    public void deleteSociete(@PathVariable Long idSociete)
    {
        iSocieteService.deleteSociete(idSociete);
    }


}
