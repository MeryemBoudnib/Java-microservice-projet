package com.etude_de_cas_2_commande.commande2.Service;

import com.etude_de_cas_2_commande.commande2.Model.commandemodel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class commandeservice {

    private final List<commandemodel> commandes = new ArrayList<>();

    // Retourne toutes les commandes
    public List<commandemodel> getCommandesLastDays() {
        return commandes;
    }

    // Retourne une commande par son ID
    public commandemodel getCommandeById(Long id) {
        for (commandemodel commande : commandes) {
            if (commande.getId().equals(id)) {
                return commande;
            }
        }
        throw new RuntimeException("Commande avec ID " + id + " non trouvée.");
    }

    // Créer une nouvelle commande
    public commandemodel createCommande(commandemodel commande) {
        commande.setId((long) (commandes.size() + 1)); // Génère un ID fictif
        commandes.add(commande);
        return commande;
    }

    // Mettre à jour une commande
    public commandemodel updateCommande(Long id, commandemodel commande) {
        for (commandemodel existingCommande : commandes) {
            if (existingCommande.getId().equals(id)) {
                existingCommande.setDescription(commande.getDescription());
                existingCommande.setQuantité(commande.getQuantité());
                existingCommande.setMontant(commande.getMontant());
                existingCommande.setLocaldate(commande.getLocaldate());
                existingCommande.setId_produit(commande.getId_produit());
                return existingCommande;
            }
        }
        throw new RuntimeException("Commande avec ID " + id + " non trouvée.");
    }

    // Supprimer une commande par son ID
    public void deleteCommande(Long id) {
        commandes.removeIf(commande -> commande.getId().equals(id));
    }
}
