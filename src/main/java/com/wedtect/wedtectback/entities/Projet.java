package com.wedtect.wedtectback.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity

@Table(name= "projets")
public class Projet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProjet;

    // liaison ProjetPartenaire
    @ManyToMany(mappedBy = "projets", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("projets")
    private Collection<Partenaire> partenaires = new ArrayList<>();

    @NonNull
    private String titre;
    private byte[] figure;

    public Projet() {
        super();
    }
    public Projet(Long idProjet, String titre, byte[] figure, Collection<Partenaire> partenaires){
        super();
        this.idProjet = idProjet;
        this.titre = titre;
        this.figure = figure;
        this.partenaires = partenaires;
    }
    public Long getIdProjet() {
        return idProjet;
    }
    public void setIdProjet(Long idProjet){
        this.idProjet= idProjet ;
    }
    public String getTitre(){
        return titre;
    }
    public void setTitre (String titre){
        this.titre= titre;
    }
    public byte[] getFigure (){
        return figure;
    }
    public void setFigure(byte[] figure){
        this.figure=figure;
    }
    // getters setters liaison ProjePartenaire
    public Collection<Partenaire> getPartenaires(){
        return partenaires;
    }
    public void setPartenaires (Collection<Partenaire> partenaires){
        this.partenaires=partenaires;
    }
}