package com.MScommandes.microservice_commandes.Conroller;
import com.MScommandes.microservice_commandes.Model.Commande;
import com.MScommandes.microservice_commandes.Service.Commandeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Value("${mes-config-ms.commandes-last}")
    private int commandesLastDays;

    @Autowired
    private Commandeservice commandeService;

    @GetMapping
    public List<Commande> getCommandes() {
        return commandeService.getCommandesLastDays(commandesLastDays);
    }


    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        System.out.println("Commande reçue : " + commande);
        commande.setLocaldate(LocalDate.now());
        System.out.println("La date a été définie à aujourd'hui : " + commande.getLocaldate());
        return commandeService.createCommande(commande);
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande commande) {
        return commandeService.updateCommande(id, commande);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }

    @GetMapping("/lastDays/{days}")
    public List<Commande> getCommandesLastDays(@PathVariable int days) {
        return commandeService.getCommandesLastDays(days);
    }
}
