package com.etude_de_cas_2_produit.produit2.Service;

import com.etude_de_cas_2_produit.produit2.Model.produitmodel;
import com.etude_de_cas_2_produit.produit2.Repository.produitrepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class produitservice {

    @Autowired
    private produitrepository produitRepository;

    /**
     * Méthode protégée par un Circuit Breaker, simulant un appel avec délai.
     */
    @CircuitBreaker(name = "produitService", fallbackMethod = "fallbackProduit")
    public String getProduit(Long id) throws InterruptedException {
        System.out.println("ProduitService.getProduit(): Begin to sleep for 2 seconds");
        Thread.sleep(2000); // Simule un délai de 5 secondes
        return "Produit " + id + ": End from sleep for 2 seconds";
    }

    public String fallbackProduit(Long id, Throwable throwable) {
        return "Produit " + id + ": Fallback message (Service temporairement indisponible)";
    }





    /**
     * Méthode de repli appelée par le Circuit Breaker en cas de délai ou d'erreur.
     */
    private String myHistrixbuildFallbackMessage(Long id, Throwable throwable) {
        return "Produit " + id + ": Fallback message (after timeout of 1 second)";
    }

    /**
     * Récupérer tous les produits.
     */
    public List<produitmodel> getAllProduits() {
        return produitRepository.findAll();
    }

    /**
     * Créer un nouveau produit.
     */
    public produitmodel createProduit(produitmodel produit) {
        return produitRepository.save(produit);
    }

    /**
     * Mettre à jour un produit existant.
     */
    public produitmodel updateProduit(Long id, produitmodel produit) {
        Optional<produitmodel> produitOptional = produitRepository.findById(id);
        if (produitOptional.isPresent()) {
            produit.setId(id);
            return produitRepository.save(produit);
        } else {
            throw new RuntimeException("Produit non trouvé avec l'ID: " + id);
        }
    }

    /**
     * Supprimer un produit par son ID.
     */
    public void deleteProduit(Long id) {
        Optional<produitmodel> produitOptional = produitRepository.findById(id);
        if (produitOptional.isPresent()) {
            produitRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produit non trouvé avec l'ID: " + id);
        }
    }
}
