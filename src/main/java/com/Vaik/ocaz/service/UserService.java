package com.Vaik.ocaz.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Vaik.ocaz.model.Utilisateur;
import com.Vaik.ocaz.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserService {
    private final UserRepository userrepo;
    
    // @Value("${app.jwtSecret}")
    // private String jwtSecret;

    // @Value("${app.jwtExpirationMs}")
    // private long jwtExpirationMs;

    // public String generateToken(String username) {
    //     Date now = new Date();
    //     Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

    //     return Jwts.builder()
    //             .setSubject(username)
    //             .setIssuedAt(now)
    //             .setExpiration(expiryDate)
    //             .signWith(SignatureAlgorithm.HS512, jwtSecret)
    //             .compact();
    // }

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

