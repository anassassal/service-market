package com.example.acheteurservice.web;

import com.example.acheteurservice.entities.Acheteur;
import com.example.acheteurservice.respositories.AcheteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
//@RequestMapping("/api")
public class ControlerRest {
    @Autowired
    AcheteurRepository acheteurRepository;
    @GetMapping("/acheteurs/{id}")
    public Acheteur getAcheteurById(@PathVariable("id") Integer id){return acheteurRepository.findById(id).get();}
    @GetMapping("/acheteurs")
    public List<Acheteur> getAll(){
        return acheteurRepository.findAll();
    }
    @PostMapping("/acheteurs")
    public void  add(@RequestBody Acheteur acheteur){
        acheteurRepository.save(acheteur);
    }

    @DeleteMapping("/acheteurs/{id}")
    public  void supprimer(@PathVariable("id") Integer id){
        acheteurRepository.deleteById(id);
    }
    @PutMapping("/acheteurs/{id}")
    public void modifay(@PathVariable("id") Integer id,@RequestBody Acheteur acheteur){
        Acheteur ach=acheteurRepository.findById(id).get();
        if(acheteur.getNom()!=null)ach.setNom(acheteur.getNom());
        if (acheteur.getVille()!=null)ach.setVille(acheteur.getVille());
        acheteurRepository.save(ach);
    }

}
