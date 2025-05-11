package com.example.bankaccountgraphql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Compte {

    @Id
    private String id;
    private String proprietaire;
    private double solde;
    private String type;

    // Default constructor required by JPA
    public Compte() {
    }

    public Compte(String id, String proprietaire, double solde, String type) {
        this.id = id;
        this.proprietaire = proprietaire;
        this.solde = solde;
        this.type = type;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id='" + id + '\'' +
                ", proprietaire='" + proprietaire + '\'' +
                ", solde=" + solde +
                ", type='" + type + '\'' +
                '}';
    }
}