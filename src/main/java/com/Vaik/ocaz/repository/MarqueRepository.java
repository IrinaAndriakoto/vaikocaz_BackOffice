package com.Vaik.ocaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vaik.ocaz.model.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
    boolean existsByIdmarque(int idmarque);

}
