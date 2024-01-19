package com.Vaik.ocaz.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="marques")
public class Marque {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idmarque")
    private int idmarque;

    @Column(name="marque")
    private String nomMarque;

    @ManyToOne
    @JoinColumn(name="idcategorie")
    private Categorie categorie;

    
    public int getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    
}
