package com.etude_de_cas_2_produit.produit2.Controller;

import com.etude_de_cas_2_produit.produit2.Model.produitmodel;
import com.etude_de_cas_2_produit.produit2.Service.produitservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class produitcontroller {

    @Autowired
    private produitservice produitService;

    // Récupérer tous les produits
    @GetMapping
    public List<produitmodel> getProduits() {
        return produitService.getAllProduits();
    }

    // Récupérer un produit par son ID
    @GetMapping("/{id}")
    public String getProduit(@PathVariable Long id) throws InterruptedException {
        return produitService.getProduit(id); // Appel à la méthode getProduit dans le service
    }

    // Créer un nouveau produit
    @PostMapping
    public produitmodel createProduit(@RequestBody produitmodel produit) {
        return produitService.createProduit(produit);
    }

    // Mettre à jour un produit existant
    @PutMapping("/{id}")
    public produitmodel updateProduit(@PathVariable Long id, @RequestBody produitmodel produit) {
        return produitService.updateProduit(id, produit);
    }

    // Supprimer un produit par son ID
    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
}
