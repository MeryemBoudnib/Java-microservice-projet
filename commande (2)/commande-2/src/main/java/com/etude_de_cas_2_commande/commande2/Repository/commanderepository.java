package com.etude_de_cas_2_commande.commande2.Repository;

import com.etude_de_cas_2_commande.commande2.Model.commandemodel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface commanderepository extends JpaRepository<commandemodel, Long> {
    List<commandemodel> findByLocaldateAfter(LocalDate date); // Assurez-vous que 'localdate' est en minuscules ici
}


