package com.etude_de_cas_2_produit.produit2.Repository;

import com.etude_de_cas_2_produit.produit2.Model.produitmodel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produitrepository extends JpaRepository<produitmodel, Long> {

}
