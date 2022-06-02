package com.wedtect.wedtectback.entities;
import java.io.Serializable ;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name= "clients")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

   //liaison ClientSociete
    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    @JoinColumn(name = "societe_id") //, nullable = false
    @JsonIgnoreProperties("clients")
    private Societe societe ;

    //liaison ClientFacture
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Collection<Facture> factures = new ArrayList<>() ;


    @NonNull
    private String nom;
    @NonNull
    private String prenom;

    @NonNull
    private String mail;

    @NonNull
    private Long numero;
    @NonNull
    private String pays;

    public Client() {
        super();
    }
    public Client(Long id, String nom, String prenom, String mail, Long numero, String pays, Collection<Facture> factures,Societe societe ) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numero = numero ;
        this.pays = pays;
        this.factures= factures;
        this.societe=societe;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long  id) {
        this.id= id;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    //getters setters liaison FactureClient
    public Collection<Facture> getFactures(){
        return factures ;
    }
    public void setFacture(Collection<Facture> factures){
        this.factures= factures ;
    }

    // getters setters liaison ClientSociete
    public Societe getSociete(){
        return societe ;
    }
    public void setSociete(Societe societe ) {
        this.societe = societe ;
    }
}