package com.Vaik.ocaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vaik.ocaz.model.Annonce;

public interface AnnonceRepo  extends JpaRepository<Annonce, Long> {
    boolean existsByIdannonce(int idannonce);
}
