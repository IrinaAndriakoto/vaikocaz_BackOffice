package com.Vaik.ocaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vaik.ocaz.model.Marque;
import com.Vaik.ocaz.repository.MarqueRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MarqueService {
    private final MarqueRepository marqueRepository;

    @Autowired
    public MarqueService(MarqueRepository marqueRepository){
        this.marqueRepository = marqueRepository;
    }
    public List<Marque> getAllMarques() {
        return marqueRepository.findAll();
    }

    public Marque getMarqueById(Long id) {
        return marqueRepository.findById(id).orElse(null);
    }

    // Ajoutez une méthode pour créer une marque
    public Marque createMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    // Ajoutez une méthode pour mettre à jour une marque
    public Marque updateMarque(Marque marque) {
        if (marque.getIdmarque() != 0 && marqueRepository.existsByIdmarque(marque.getIdmarque())) {
            return marqueRepository.save(marque);
        } else {
            throw new EntityNotFoundException("La marque avec l'ID " + marque.getIdmarque() + " n'existe pas");
        }
    }

    // Ajoutez une méthode pour supprimer une marque
    public void deleteMarque(Long id) {
        marqueRepository.deleteById(id);
    }
}
