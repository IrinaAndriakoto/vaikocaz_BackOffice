package com.Vaik.ocaz.repository;


import com.Vaik.ocaz.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByNom(String nom);
}