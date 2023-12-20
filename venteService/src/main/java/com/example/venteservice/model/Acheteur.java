package com.example.venteservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data@Builder

public class Acheteur {
    private Integer id;
    private String nom;
    private String ville;
}
