package com.Vaik.ocaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vaik.ocaz.repository.UserRepository;

@Service
public class StatService {
    @Autowired
    private UserRepository utilisateurRepository;

    public long getNombreUtilisateursAvecAnnonce() {
        return utilisateurRepository.countByAnnoncesIsNotNull();
    }
}
