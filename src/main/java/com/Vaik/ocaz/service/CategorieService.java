package com.Vaik.ocaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vaik.ocaz.model.Categorie;
import com.Vaik.ocaz.repository.CategorieRepository;

import jakarta.persistence.EntityNotFoundException;

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

        public Categorie updateCategorie(Categorie cat) {
        // Vérifiez si l'entité existe dans la base de données
        if (cat.getIdcategorie() != 0 && catRep.existsByIdcategorie(cat.getIdcategorie())) {
            // Si elle existe, utilisez save pour mettre à jour l'entité
            return catRep.save(cat);
        } else {
            // Sinon, elle n'existe pas, vous pouvez choisir de gérer cela en conséquence,
            // par exemple, lever une exception ou retourner null
            throw new EntityNotFoundException("La catégorie avec l'ID " + cat.getIdcategorie() + " n'existe pas");
        }
    }
}
