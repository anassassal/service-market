package com.example.produitservice.web;

import com.example.produitservice.config.GlobalConfig;
import com.example.produitservice.config.ProduitConfig;
import com.example.produitservice.entities.Produit;
import com.example.produitservice.respositories.ProduitRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class ControlerRest {
    @Autowired
    GlobalConfig globalConfig;
    @Autowired
    ProduitConfig produitConfig;
    @Autowired
    ProduitRespository produitRespository;
    //pour le global config
    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig(){
        return globalConfig;
    }
    //pour le produit config
    @GetMapping("/produitConfig")

    public ProduitConfig produitConfig(){
        return produitConfig;
    }

    @GetMapping("/produits")
    public List<Produit> getAll(){
        return produitRespository.findAll();
    }
    @GetMapping("/produits/{id}")
    public Produit getProduitById(@PathVariable("id")Integer id){
        return produitRespository.findById(id).get();
    }
    @DeleteMapping("/produits/{id}")
    public void supprimer(@PathVariable("id") Integer id){
        produitRespository.deleteById(id);
    }
    @PostMapping("/produits")
    public void add(@RequestBody Produit produit){
        produitRespository.save(produit);
    }
    @PutMapping("produits/{id}")
    public void modifay(@PathVariable("id") Integer id,@RequestBody Produit produit){
        Produit p=produitRespository.findById(id).get();
        if (produit.getDesc()!=null)p.setDesc(produit.getDesc());
        if (produit.getMarque()!=null)p.setMarque(produit.getMarque());
        if (produit.getPrix()!=null)p.setPrix(produit.getPrix());
        produitRespository.save(p);
    }
}
