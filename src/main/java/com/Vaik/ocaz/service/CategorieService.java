package com.Vaik.ocaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vaik.ocaz.model.Categorie;
import com.Vaik.ocaz.repository.CategorieRepository;

@Service
public class CategorieService {
    private final CategorieRepository catRep;

    @Autowired
    public CategorieService(CategorieRepository catrep){
        this.catRep = catrep;
    }

    public List<Categorie> getAllCategories(){
        return catRep.findAll();
    }

    public Categorie getCategorieById(Long id){
        return catRep.findById(id).orElse(null);
    }

    public Categorie createCategorie(Categorie cat){
        return catRep.save(cat);
    }
    
    public void deleteCategorie(Long id){
        catRep.deleteById(id);
    }
}
