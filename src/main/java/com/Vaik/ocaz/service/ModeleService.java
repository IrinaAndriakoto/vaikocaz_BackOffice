package com.Vaik.ocaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vaik.ocaz.model.Modele;
import com.Vaik.ocaz.repository.ModeleRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ModeleService {
    private final ModeleRepository mr;

    @Autowired
    public ModeleService(ModeleRepository m){
        this.mr=m;
    }

    public List<Modele> getAllModeles(){
        return mr.findAll();
    }
    public Modele getModeleById(Long id){
        return mr.findById(id).orElse(null);
    }
    public Modele createModele(Modele m){
        return mr.save(m);
    }
    public void deleteModele(Long id){
        mr.deleteById(id);
    }

    public Modele updateModele(Modele mod) {
        if (mod.getIdmodele() != 0 && mr.existsByIdmodele(mod.getIdmodele())) {
            return mr.save(mod);
        } else {
            throw new EntityNotFoundException("La catégorie avec l'ID " + mod.getIdmodele() + " n'existe pas");
        }
    }    
}
