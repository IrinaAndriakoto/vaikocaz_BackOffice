package com.Vaik.ocaz.controller;

import java.util.Collections;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Vaik.ocaz.model.Categorie;
import com.Vaik.ocaz.model.Utilisateur;
import com.Vaik.ocaz.service.CategorieService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/categorie")
@CrossOrigin
public class CategorieController {
    private final CategorieService service;

    @Autowired
    public CategorieController(CategorieService serv){
        this.service = serv;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategoryById(@PathVariable Long id) {
        Categorie cat = service.getCategorieById(id);
        if (cat != null) {
            return new ResponseEntity<>(cat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Categorie>> getAllCategories() {
      List<Categorie> cat = service.getAllCategories();
      if (cat != null && !cat.isEmpty()) {
          return new ResponseEntity<>(cat, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
      }
    }

    @PostMapping("/add")
    public ResponseEntity<Categorie> createCategory(@RequestBody Categorie category) {
        Categorie savedCategory = service.createCategorie(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Categorie> updateCategory(@RequestBody Categorie category) {
        Categorie updatedCategory = service.updateCategorie(category);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

        @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategorie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
    

