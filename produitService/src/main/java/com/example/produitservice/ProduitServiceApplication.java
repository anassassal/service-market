package com.example.produitservice;

import com.example.produitservice.config.GlobalConfig;
import com.example.produitservice.config.ProduitConfig;
import com.example.produitservice.entities.Produit;
import com.example.produitservice.respositories.ProduitRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
@EnableConfigurationProperties({ProduitConfig.class, GlobalConfig.class})
public class ProduitServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProduitRespository produitRespository){
        return args -> {
            produitRespository.save(Produit.builder().desc("ballone f-500").prix(149L).quantite(1).marque("kipsta").build());
            produitRespository.save(Produit.builder().desc("gant de gardient").prix(850L).quantite(2).marque("adidas").build());
            produitRespository.save(Produit.builder().desc("tenu d'entrainement de foot").prix(280L).quantite(3).marque("nike").build());
        };

    }

}
