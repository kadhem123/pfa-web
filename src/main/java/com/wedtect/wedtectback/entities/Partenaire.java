package com.wedtect.wedtectback.entities;
import java.io.Serializable ;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.lang.NonNull;
import javax.persistence.Table;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

@Table(name= "partenaires")
public class Partenaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartenaire;
    // liaison PartenaireSociete
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "partenaire_id") //, nullable = false
    @JsonIgnoreProperties("societe")
    private Societe societe ;
    // liaison PartenaireProjet
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "PartenaireProjet",
            joinColumns = { @JoinColumn(name = "idProjet") },
            inverseJoinColumns = { @JoinColumn(name = "idPartenaire") })
    private Collection<Projet> projets = new ArrayList<>();
    @NonNull
    private Long matFisc;
    @NonNull
    private String nom;
    private byte[] logo;


    public Partenaire() {
        super();
    }
    public Partenaire(Long idPartenaire, Long matFisc, String nom, byte[] logo, Collection<Projet> projets, Societe societe){
        super();
        this.idPartenaire = idPartenaire;
        this.matFisc = matFisc;
        this.nom = nom;
        this.logo = logo;
        this.projets = projets ;
        this.societe = societe ;

    }
    public Long getIdPartenaire() {
        return idPartenaire;
    }

    public void setIdPartenaire(Long idPartenaire) {
        this.idPartenaire = idPartenaire;
    }
    public Long getMatFisc() {
        return matFisc;
    }

    public void setMatFisc(Long matFisc) {
        this.matFisc = matFisc;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public byte[] getLogo() {
        return logo;
    }
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    //getters setters liaison Parentaire Societe
    public Societe getSociete(){
        return societe ;
    }
    public void setSociete(Societe societe){
        this.societe= societe;
    }

    //getters setters liaison Parentaire projet
    public Collection<Projet> getProjets()
    {
        return projets;
    }
    public void setProjets(Collection<Projet> projets){
        this.projets = projets  ;
    }

}
