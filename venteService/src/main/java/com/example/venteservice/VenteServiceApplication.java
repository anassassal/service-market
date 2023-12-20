package com.example.venteservice;

import com.example.venteservice.entities.Vente;
import com.example.venteservice.respositories.VenteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
@EnableFeignClients
@SpringBootApplication
public class VenteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VenteServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(VenteRepository venteRepository){
        return args -> {
            venteRepository.save(Vente.builder().idA(1).idP(2).build());
            venteRepository.save(Vente.builder().idA(2).idP(3).build());
            venteRepository.save(Vente.builder().idA(3).idP(1).build());
        };
    }

}
