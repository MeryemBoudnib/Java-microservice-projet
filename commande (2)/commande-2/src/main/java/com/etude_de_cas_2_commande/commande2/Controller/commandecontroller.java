package com.etude_de_cas_2_commande.commande2.Controller;

import com.etude_de_cas_2_commande.commande2.Service.commandeservice;
import com.etude_de_cas_2_commande.commande2.Model.commandemodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/commandes")
public class commandecontroller {

    @Autowired
    private commandeservice commandeService;

    // Récupérer toutes les commandes
    @GetMapping
    public List<commandemodel> getCommandes() {
        return commandeService.getCommandesLastDays();
    }

    // Récupérer une commande par ID
    @GetMapping("/{id}")
    public commandemodel getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    // Créer une nouvelle commande
    @PostMapping
    public commandemodel createCommande(@RequestBody commandemodel commande) {
        commande.setLocaldate(LocalDate.now());
        return commandeService.createCommande(commande);
    }

    // Mettre à jour une commande
    @PutMapping("/{id}")
    public commandemodel updateCommande(@PathVariable Long id, @RequestBody commandemodel commande) {
        return commandeService.updateCommande(id, commande);
    }

    // Supprimer une commande par ID
    @DeleteMapping("/{id}")
    public String deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return "Commande avec l'ID " + id + " supprimée avec succès.";
    }
}
