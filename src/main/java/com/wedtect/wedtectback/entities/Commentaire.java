package com.wedtect.wedtectback.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity

@Table(name= "commentaires")
public class Commentaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;
    @NonNull
    private String nom;
    @NonNull
    private String prenom;

    private String contenu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    @JoinColumn(name = "id") //, nullable = false
    @JsonIgnoreProperties("User")
    private User user ;


    public Commentaire() {
        super();
    }
    public Commentaire(Long idComment, String nom, String prenom, String contenu){
        super();
        this.setIdComment(idComment);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setContenu(contenu);

    }
    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @NonNull
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(@NonNull String prenom) {
        this.prenom = prenom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

