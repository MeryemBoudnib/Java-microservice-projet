package com.MScommandes.microservice_commandes.Health;

import com.MScommandes.microservice_commandes.Repository.Repositorycommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {
    @Autowired
    public Repositorycommande repositorycommande;

    @Override
    public Health health() {
        long count=repositorycommande.count();
        if (count>0){
            return Health.up().withDetail("message", "Il y a des commandes dans la base de données").build();}
                else{
                    return Health.down().withDetail("message", "Pas de commandes").build();
        }
    }
}
