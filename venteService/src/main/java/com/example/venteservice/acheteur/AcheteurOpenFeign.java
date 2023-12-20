package com.example.venteservice.acheteur;

import com.example.venteservice.model.Acheteur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ACHETEUR-SERVICE")
public interface AcheteurOpenFeign {
    @GetMapping("/acheteurs/{id}")
    public Acheteur getAcheteurById(@PathVariable("id") Integer id);
    @GetMapping("/acheteurs")
    public List<Acheteur> getAll();
}
