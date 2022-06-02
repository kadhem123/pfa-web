package com.wedtect.wedtectback.entities;
import java.io.Serializable ;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.lang.NonNull;
import javax.persistence.Table;
import javax.persistence.*;

@Entity

@Table(name= "societes")
public class Societe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSociete;
    //Liaison SocietePartenaire
    @OneToMany(mappedBy = "societe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Partenaire> partenaires = new ArrayList<>() ;
    //Liaison SocieteClient
    @OneToMany(mappedBy = "societe", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Client> clients = new ArrayList<>() ;
    @NonNull
    private Long matFisc;
    @NonNull
    private String nom;
    @NonNull
    private String adresse;

    @NonNull
    private String mail;

    @NonNull
    private Long numero;

    private byte[] logo;

    public Societe() {
        super();
    }
    public Societe(Long idSociete, Long matFisc, String nom, String adresse, String mail, Long numero, byte[] logo, List<Partenaire> partenaires ,List<Client> clients ) {
        super();
        this.idSociete = idSociete;
        this.matFisc = matFisc;
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
        this.numero = numero ;
        this.logo = logo ;
        this.partenaires =  partenaires;
        this.clients = clients ;
    }
    public Long getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(Long idSociete) {
        this.idSociete = idSociete;
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
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
    public byte[] getLogo() {
        return logo;
    }
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    // getters setters SocietePartenaire
    public Collection<Partenaire> getPartenaires()
    {
        return partenaires;
    }
    public void setPartenaires(Collection<Partenaire> parteniares){
        this.partenaires = partenaires ;
    }
    // getters setters SocieteClient
    public Collection<Client> getClients()
    {
        return clients;
    }
    public void setClients(Collection<Client> clients){
        this.clients = clients ;
    }





}
