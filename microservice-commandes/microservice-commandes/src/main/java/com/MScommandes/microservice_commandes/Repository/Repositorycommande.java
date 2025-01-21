package com.MScommandes.microservice_commandes.Repository;

import com.MScommandes.microservice_commandes.Model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface Repositorycommande extends JpaRepository<Commande, Long> {
    List<Commande> findByLocaldateAfter(LocalDate date); // Assurez-vous que 'localdate' est en minuscules ici
}
