package com.mazurek.persistence.service.impl;

import com.mazurek.persistence.entity.Flota;
import com.mazurek.persistence.service.FleetDao;
import com.mazurek.persistence.service.PersistenceManager;

import javax.persistence.EntityManager;

public class FleetDaoImpl implements FleetDao {


    @Override
    public void save(Flota flota) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();

        flota.getPozycje().forEach(pozycja -> {
            try{
                em.persist(pozycja);
            }
            catch(Exception ex){
                ex.printStackTrace();
                System.out.println("Error while saving Pozycja: " + pozycja.getId() + ". Element skipped.");
            }
        });

        em.persist(flota);
        em.getTransaction().commit();
        em.close();
        PersistenceManager.INSTANCE.close();
    }
}
