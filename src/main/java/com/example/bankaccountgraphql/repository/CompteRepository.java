package com.example.bankaccountgraphql.repository;

import com.example.bankaccountgraphql.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {
    // Spring Data JPA provides all basic CRUD operations automatically
}