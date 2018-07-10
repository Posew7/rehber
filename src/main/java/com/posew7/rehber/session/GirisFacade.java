package com.posew7.rehber.session;

import com.posew7.rehber.entity.Giris;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GirisFacade extends AbstractFacade<Giris> {

    @PersistenceContext(unitName = "com.posew7_rehber_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GirisFacade() {
        super(Giris.class);
    }

    public boolean girisKontrol(String p_kullanici, String p_sifre) {

        try {
            Giris g = em.createNamedQuery("Giris.girisKontrol", Giris.class).setParameter("kullanici", p_kullanici).setParameter("sifre", p_sifre).getSingleResult();
            
            if (g != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

}
