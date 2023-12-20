package com.example.venteservice.entities;

import com.example.venteservice.model.Acheteur;
import com.example.venteservice.model.Produit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString@Data@Builder
public class Vente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idA;
    private Integer idP;
    @Transient
    private Produit produit;
    @Transient
    private Acheteur acheteur;
}
