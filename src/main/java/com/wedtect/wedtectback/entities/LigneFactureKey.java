package com.wedtect.wedtectback.entities;

import javax.persistence.Column;
import java.io.Serializable;

public class LigneFactureKey implements Serializable {
    private static final long serialVersionUID= 4722352116317893282L;
    @Column(name="facture_id")
    private Integer factureId;

    @Column(name="product_id")
    private Integer produitId;
}
