package com.example.acheteurservice;

import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.respositories.AcheteurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AcheteurServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcheteurServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(AcheteurRepository acheteurRepository){
        return args -> {

            acheteurRepository.save(Acheteur.builder().nom("ASSAL").ville("sale").build());
            acheteurRepository.save(Acheteur.builder().nom("DAROUICH").ville("sale").build());
            acheteurRepository.save(Acheteur.builder().nom("TOUIJER").ville("sale").build());
//            List<Acheteur> l=acheteurRepository.findAll();
//            for (Acheteur a : l){
//
//                System.out.println("================");
//                System.out.println("nom :"+a.getNom());
//                System.out.println("ville :"+a.getVille());
//            }




        };
    }

}
