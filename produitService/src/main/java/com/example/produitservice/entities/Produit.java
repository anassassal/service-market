package com.example.produitservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity@AllArgsConstructor@NoArgsConstructor@Data@ToString@Builder
public class Produit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduit;
    private String marque;
    private String desc;
    private Long prix;
    private Integer quantite;
}
