package com.etude_de_cas_2_commande.commande2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity

public class commandemodel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private int quantité;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "localdate")
    private LocalDate localdate; // Updated to LocalDate
    private Double montant;
    private Long id_produit;

    public commandemodel() {
        this.localdate = LocalDate.now();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_produit(){return id;}
    public void setId_produit(Long id){ this.id_produit=id_produit;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public LocalDate getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDate localdate) {
        this.localdate = localdate;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }
}
