package com.example.venteservice.web;

import com.example.venteservice.acheteur.AcheteurOpenFeign;
import com.example.venteservice.entities.Vente;
import com.example.venteservice.model.Acheteur;
import com.example.venteservice.model.Produit;
import com.example.venteservice.produit.ProduitOpenFeign;
import com.example.venteservice.respositories.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class ControlerRest {
    @Autowired
    VenteRepository venteRepository;
    @Autowired
    ProduitOpenFeign produitOpenFeign;
    @Autowired
    AcheteurOpenFeign acheteurOpenFeign;
    @GetMapping("/ventes")
    public List<Vente> gettAll(){
        List<Vente> lv=venteRepository.findAll();
        List<Acheteur> la=acheteurOpenFeign.getAll();
        List<Produit> lp=produitOpenFeign.getAll();
        for (Vente v:lv){
//           for (Acheteur a:la){
//               if (v.getIdA()==a.getId())v.setAcheteur(a);break;
//           }
//           for (Produit p:lp){
//               if (v.getIdP()==p.getIdProduit())v.setProduit(p);break;
//           }
            v.setProduit(produitOpenFeign.produitById(v.getIdP()));
            v.setAcheteur(acheteurOpenFeign.getAcheteurById(v.getIdA()));
        }
        return lv;
    }
    @DeleteMapping("/ventes/{id}")
    public void supprimer(@PathVariable("id") Integer id){venteRepository.deleteById(id);}
    @PostMapping("/ventes")
    public void add(@RequestBody Vente vente){venteRepository.save(vente);}
    @GetMapping("/ventes/{id}")
    public Vente getVenteById(@PathVariable("id") Integer id){
        Vente v=venteRepository.findById(id).get();
        v.setProduit(produitOpenFeign.produitById(v.getIdP()));
        v.setAcheteur(acheteurOpenFeign.getAcheteurById(v.getIdA()));
        return v;
    }
    @PutMapping("/ventes/{id}")
    public void modify(@PathVariable("id")Integer id,@RequestBody Vente vente){
        Vente vr=venteRepository.findById(id).get();
        if (vente.getIdA()!=null)vr.setIdA(vente.getIdA());
        if (vente.getIdP()!=null)vr.setIdP(vente.getIdP());
        venteRepository.save(vr);

    }



}
