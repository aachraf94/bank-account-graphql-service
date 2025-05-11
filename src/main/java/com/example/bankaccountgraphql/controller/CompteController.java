package com.example.bankaccountgraphql.controller;

import com.example.bankaccountgraphql.dto.CompteInput;
import com.example.bankaccountgraphql.model.Compte;
import com.example.bankaccountgraphql.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompteController {

    private final CompteService compteService;

    @Autowired
    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @QueryMapping
    public List<Compte> recupererComptes() {
        return compteService.recupererComptes();
    }

    @QueryMapping
    public Compte recupererCompte(@Argument String id) {
        return compteService.recupererCompte(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé avec l'id: " + id));
    }

    @MutationMapping
    public Compte ajouterCompte(@Argument("compte") CompteInput compteInput) {
        Compte compte = new Compte();
        compte.setId(compteInput.getId());
        compte.setProprietaire(compteInput.getProprietaire());
        compte.setSolde(compteInput.getSolde());
        compte.setType(compteInput.getType());

        return compteService.ajouterCompte(compte);
    }

    @MutationMapping
    public Compte modifierCompte(@Argument String id, @Argument("compte") CompteInput compteInput) {
        Compte compte = new Compte();
        compte.setProprietaire(compteInput.getProprietaire());
        compte.setSolde(compteInput.getSolde());
        compte.setType(compteInput.getType());

        return compteService.modifierCompte(compte, id);
    }

    @MutationMapping
    public boolean supprimerCompte(@Argument String id) {
        return compteService.supprimerCompte(id);
    }
}