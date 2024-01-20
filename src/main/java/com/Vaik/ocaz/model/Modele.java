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
@Table(name="modele")
public class Modele {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idmodele")
    private int idmodele;

    @Column(name="modele")
    private String modele;

    @ManyToOne
    @JoinColumn(name="idmarque")
    private Marque marque;

    @Column(name="motorisation")
    private String motorisation;

    @Column(name="puissance")
    private String puissance;

    @Column(name="annee")
    private String annee;

    @Column(name="kilometrage")
    private String kilometrage;

    @Column(name="boitedevitesse")
    private String boitedeVitesse;

    @Column(name="energie")
    private String energie;

    @Column(name="prix")
    private String prix;

    @Column(name="isVendu")
    private boolean isVendu;

    public int getIdmodele() {
        return idmodele;
    }

    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getMotorisation() {
        return motorisation;
    }

    public void setMotorisation(String motorisation) {
        this.motorisation = motorisation;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getBoitedeVitesse() {
        return boitedeVitesse;
    }

    public void setBoitedeVitesse(String boitedeVitesse) {
        this.boitedeVitesse = boitedeVitesse;
    }

    public String getEnergie() {
        return energie;
    }

    public void setEnergie(String energie) {
        this.energie = energie;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public boolean isVendu() {
        return isVendu;
    }

    public void setVendu(boolean isVendu) {
        this.isVendu = isVendu;
    }

    
    
}
