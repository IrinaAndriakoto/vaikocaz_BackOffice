package com.Vaik.ocaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vaik.ocaz.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    // Categorie findByNom(String nom);
}
