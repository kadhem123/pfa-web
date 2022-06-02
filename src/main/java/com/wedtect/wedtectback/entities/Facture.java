package com.wedtect.wedtectback.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="factures")
public class Facture {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//generate auto by db
    private Long id;
    //liaison FactureProduct

    @ManyToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="factures_products",
            joinColumns= @JoinColumn(
                    name="facture_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="product_id", referencedColumnName = "id"))
    private Collection<Product> products;

    // liaison FactureClient
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "client_id") //, nullable = false
    @JsonIgnoreProperties("factures")
    private Client client;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_DateTime;

    @Temporal(TemporalType.DATE)
    private
    Date payment_Date;

    private Integer qte_art;

    private Integer total_price;

    public Facture() {
        super();
    }
    public Facture(Long id, Date creation_DateTime, Date payment_Date,Integer qte_art, Integer total_price,Collection<Product> products, Client client ){
        super();
        this.id = id;
        this.creation_DateTime = creation_DateTime;
        this.payment_Date = payment_Date;
        this.qte_art = qte_art;
        this.total_price = total_price ;
        this.products=products;
        this.client=client;

    }


    public Long getCode_facture() {
        return id;
    }

    public void setCode_facture(Long id) {
        this.id = id;
    }

    public Date getCreation_DateTime() {
        return creation_DateTime;
    }

    public void setCreation_DateTime(Date creation_DateTime) {
        this.creation_DateTime = creation_DateTime;
    }

    public Date getPayment_Date() {
        return payment_Date;
    }

    public void setPayment_Date(Date payment_Date) {
        this.payment_Date = payment_Date;
    }

    public Integer getQte_art() {
        return qte_art;
    }

    public void setQte_art(Integer qte_art) {
        this.qte_art = qte_art;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }
    //getters setters facture client
    public Client getClient(){
        return client ;
    }
    public void setClient(Client client){
        this.client=client;
    }
    // getters setters factureproduct
    public Collection<Product> getProducts(){
        return products ;
    }
    public void setProducts(Collection<Product> products){
        this.products=products;
    }
}
