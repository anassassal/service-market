package com.example.venteservice.produit;

import com.example.venteservice.model.Produit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PRODUIT-SERVICE")
public interface ProduitOpenFeign {
    @GetMapping("/produits/{id}")
    public Produit produitById(@PathVariable("id") Integer id);
    @GetMapping("/produits")
    public List<Produit> getAll();
}
