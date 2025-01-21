package com.MScommandes.microservice_commandes.Service;

import com.MScommandes.microservice_commandes.Model.Commande;
import com.MScommandes.microservice_commandes.Repository.Repositorycommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.HttpStatus;

@Service
public class Commandeservice {

    @Autowired
    private Repositorycommande repositorycommande;

    /**
     * Create a new Commande
     */
    public Commande createCommande(Commande commande) {
        if (commande.getLocaldate() == null) {
            commande.setLocaldate(LocalDate.now());
            System.out.println("La date a été définie à aujourd'hui : " + commande.getLocaldate());
        }
        return repositorycommande.save(commande);
    }

    /**
     * Get Commande by ID
     */
    public Commande getCommandeById(Long id) {
        return repositorycommande.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande not found"));
    }

    /**
     * Update an existing Commande
     */
    public Commande updateCommande(Long id, Commande updatedCommande) {
        Commande existingCommande = repositorycommande.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande not found"));
        // Update fields
        existingCommande.setDescription(updatedCommande.getDescription());
        existingCommande.setQuantité(updatedCommande.getQuantité());
        existingCommande.setMontant(updatedCommande.getMontant());
        existingCommande.setLocaldate(updatedCommande.getLocaldate());
        return repositorycommande.save(existingCommande);
    }

    /**
     * Delete a Commande by ID
     */
    public void deleteCommande(Long id) {
        if (!repositorycommande.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Commande not found");
        }
        repositorycommande.deleteById(id);
    }

    /**
     * Get recent Commandes within a specific number of days
     */
    public List<Commande> getCommandesLastDays(int commandesLastDays) {
        LocalDate date = LocalDate.now().minusDays(commandesLastDays);
        return repositorycommande.findByLocaldateAfter(date);  // Utilisation de l'instance 'repositorycommande'
    }
}
