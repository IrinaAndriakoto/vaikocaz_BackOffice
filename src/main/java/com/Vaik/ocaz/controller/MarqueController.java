package com.Vaik.ocaz.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Vaik.ocaz.model.Marque;
import com.Vaik.ocaz.service.MarqueService;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/marque")
public class MarqueController {
    private final MarqueService service;

    @Autowired
    public MarqueController(MarqueService serv){
        this.service = serv;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marque> getMarqueById(@PathVariable Long id) {
        Marque cat = service.getMarqueById(id);
        if (cat != null) {
            return new ResponseEntity<>(cat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Marque>> getAllMarques() {
      List<Marque> cat = service.getAllMarques();
      if (cat != null && !cat.isEmpty()) {
          return new ResponseEntity<>(cat, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
      }
    }

    @PostMapping("/add")
    public ResponseEntity<Marque> createMarque(@RequestBody Marque m) {
        Marque savedCategory = service.createMarque(m);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Marque> updateMarque(@RequestBody Marque m) {
        Marque updatedCategory = service.updateMarque(m);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

        @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMarque(@PathVariable Long id) {
        service.deleteMarque(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
