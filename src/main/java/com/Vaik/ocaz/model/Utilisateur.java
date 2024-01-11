package com.Vaik.ocaz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUtilisateur;
    private String nom;
    private String password;

    
    public String getNom() {
        return nom;
    }
    public void setNom(String user) {
        this.nom = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getIdUser() {
        return idUtilisateur;
    }
    public void setIdUser(int idUser) {
        this.idUtilisateur = idUser;
    }

    
}
