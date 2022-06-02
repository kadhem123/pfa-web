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
import com.wedtect.wedtectback.entities.Partenaire;
import com.wedtect.wedtectback.service.IPartenaireService;

@RestController
public class PartenaireController {
    @Autowired
    IPartenaireService iPartenaireService;
    @GetMapping(value = "/partenaires")
    public List<Partenaire> findAllPartenaire(){
        return iPartenaireService.findAll();
    }
    @GetMapping(value = "/partenaires/{idPartenaire}")
    public Partenaire findonePartenaire(@PathVariable Long idPartenaire)
    {
        return iPartenaireService.findPartenaire(idPartenaire);
    }
    @PostMapping(value = "/partenaires")
    public Partenaire addPartenaire(@RequestBody Partenaire S)
    {
        return iPartenaireService.addPartenaire(S);
    }
    @PutMapping(value="/partenaires/{idPartenaire}")
    public Partenaire updatePartenaire(@PathVariable Long idPartenaire, @RequestBody Partenaire S)
    {
        S.setIdPartenaire(idPartenaire);
        return iPartenaireService.updatePartenaire(S);
    }
    @DeleteMapping(value="/partenaires/{idPartenaire}")
    public void deletePartenaire(@PathVariable Long idPartenaire)
    {
        iPartenaireService.deletePartenaire(idPartenaire);
    }

}
