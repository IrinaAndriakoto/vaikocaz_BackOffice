package com.Vaik.ocaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vaik.ocaz.model.Modele;

public interface ModeleRepository  extends JpaRepository<Modele, Long>{
    boolean existsByIdmodele(int idmodele);
}
