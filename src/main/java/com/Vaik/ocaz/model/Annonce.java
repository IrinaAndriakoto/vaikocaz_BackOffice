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
@Table(name="annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idannonce")
    private int idannonce;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="idcategorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name="idmodele")
    private Modele modele;

    @Column(name="isValid")
    private boolean isValid;

    public int getIdAnnonce() {
        return idannonce;
    }

    public void setIdAnnonce(int idAnonnce) {
        this.idannonce = idAnonnce;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }


}
