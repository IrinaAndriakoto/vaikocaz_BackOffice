package com.Vaik.ocaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vaik.ocaz.model.Annonce;
import com.Vaik.ocaz.repository.AnnonceRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnnonceService {
    private final AnnonceRepo repo;

    @Autowired
    public AnnonceService(AnnonceRepo rep){
        this.repo = rep;
    }

    public List<Annonce> getAllAnnonces(){
        return repo.findAll();
    }
    public Annonce getAnnonceById(Long id){
        return repo.findById(id).orElse(null);
    }

    public Annonce createAnnonce(Annonce annonce) {
        return repo.save(annonce);
    }

    public Annonce updateAnnonce(Annonce ann){
        if(ann.getIdAnnonce() != 0 && repo.existsByIdannonce(ann.getIdAnnonce())){
            return repo.save(ann);
        }
        else{
            throw new EntityNotFoundException("L'annonce que vous voulez update n'existe pas");
        }
    }
    public void deleteAnnonce(Long id){
        repo.deleteById(id);
    }
}
