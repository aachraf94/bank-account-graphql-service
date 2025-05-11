# Bank Account GraphQL Service
A Spring Boot application that provides a GraphQL API for managing bank accounts.


## Overview

This service demonstrates how to build a GraphQL API with Spring Boot for a simple bank account management system. It uses Spring Data JPA with an H2 in-memory database.

## Features

- CRUD operations for bank accounts via GraphQL API
- In-memory H2 database with sample data
- GraphiQL interface for testing queries

## Technologies

- Java 17
- Spring Boot 3.4.5
- Spring GraphQL
- Spring Data JPA
- H2 Database

## Running the Application

```bash
# Run with Maven
./mvnw spring-boot:run

# Or on Windows
mvnw.cmd spring-boot:run
```

The application will start on port 8000.

## Exploring the API

- GraphiQL interface: http://localhost:8000/graphiql
- H2 Database console: http://localhost:8000/h2-console (JDBC URL: `jdbc:h2:mem:bankgraphqldb`, username: `sa`, password: `password`)

## Sample GraphQL Queries

### Query all accounts
```graphql
query {
  recupererComptes {
    id
    proprietaire
    solde
    type
  }
}
```

### Query one account
```graphql
query {
  recupererCompte(id: "C001") {
    id
    proprietaire
    solde
    type
  }
}
```

### Create an account
```graphql
mutation {
  ajouterCompte(compte: {
    id: "C004",
    proprietaire: "Amina Ben Salah",
    solde: 7500,
    type: "Epargne"
  }) {
    id
    proprietaire
  }
}
```

### Update an account
```graphql
mutation {
  modifierCompte(
    id: "C001", 
    compte: {
      proprietaire: "Ali Ben Mohamed",
      solde: 6000,
      type: "Courant"
    }
  ) {
    id
    proprietaire
    solde
  }
}
```

### Delete an account
```graphql
mutation {
  supprimerCompte(id: "C001")
}
