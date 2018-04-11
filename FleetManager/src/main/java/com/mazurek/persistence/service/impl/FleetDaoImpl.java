package com.mazurek.persistence.service.impl;

import com.mazurek.persistence.entity.Flota;
import com.mazurek.persistence.entity.Pozycja;
import com.mazurek.persistence.service.FleetDao;
import com.mazurek.persistence.service.PersistenceManager;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class FleetDaoImpl implements FleetDao {

    EntityManager em = PersistenceManager.INSTANCE.getEntityManager();

    @Override
    public void save(Flota flota) {
        List<Pozycja> pozycje = new ArrayList<>(flota.getPozycje());
        flota.setPozycje(new ArrayList<>());

        pozycje.forEach(pozycja -> {
            try{
                em.getTransaction().begin();
                em.persist(pozycja);
                em.getTransaction().commit();
                flota.getPozycje().add(pozycja);
            }
            catch(Exception ex){
                em.getTransaction().rollback();
                ex.printStackTrace();
                System.out.println("Error while saving Pozycja: " + pozycja.getId() + ". Element skipped.");
            }
        });
        em.getTransaction().begin();
        em.persist(flota);
        em.getTransaction().commit();
    }
}
