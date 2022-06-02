package com.wedtect.wedtectback.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wedtect.wedtectback.entities.Facture;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//generate auto by db
    private Integer id;

    @Column(length=45, nullable=false, name="libellé")
    private String name;

    @Column(length=45, nullable=false, name="type")
    private String type;

    @Column(length=500, nullable=false, name="description")
    private String description;

    @Lob
    @Column(columnDefinition="MEDIUMBLOB")
    private String photo;

    private Integer cost;

    private Integer stock;

    // liaison ProductFacture
    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("products")
    private Collection<Facture> factures = new ArrayList<>();
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String lib_article) {
        this.name = lib_article;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDesciption(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    // Getters setters liaison ProductFacture
    public Collection<Facture> getFactures(){
        return factures ;
    }
    public void setFactures(Collection<Facture> factures){
        this.factures= factures ;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                ", cost=" + cost +
                ", stock=" + stock +
                '}';
    }
}
