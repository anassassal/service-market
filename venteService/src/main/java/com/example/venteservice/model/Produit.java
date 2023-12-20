package com.example.venteservice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Produit {
    private Integer idProduit;
    private String marque;
    private String desc;
    private Long prix;
    private Integer quantite;
}
