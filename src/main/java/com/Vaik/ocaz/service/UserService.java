package com.Vaik.ocaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vaik.ocaz.model.Utilisateur;
import com.Vaik.ocaz.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userrepo;

    @Autowired
    public UserService(UserRepository userrep){
        this.userrepo = userrep;
    }

    public List<Utilisateur> getAllUsers(){
        return userrepo.findAll();
    }
    
    public Utilisateur getUserById(Long id){
        return userrepo.findById(id).orElse(null);
    }

    public boolean isValidLogin(String nom, String password) {
        Utilisateur utilisateur = userrepo.findByNom(nom);

        return utilisateur != null && utilisateur.getPassword().equals(password);
    }

}

