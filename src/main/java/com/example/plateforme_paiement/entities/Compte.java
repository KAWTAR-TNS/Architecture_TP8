package com.example.plateforme_paiement.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;


import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;

    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

    public Compte(Double solde, Date dateCreation, TypeCompte type) {
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.type = type;
    }

}
