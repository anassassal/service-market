package com.example.acheteurservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString@Data@Builder
public class Acheteur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String ville;
}
