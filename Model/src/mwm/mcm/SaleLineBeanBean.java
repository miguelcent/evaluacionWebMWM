package mwm.mcm;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mwm.mcm.entities.SaleLine;

@Stateless(name = "SaleLineBean", mappedName = "evaluacionWeb-Model-SaleLineBean")
public class SaleLineBeanBean implements SaleLineBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "lybesShop")
    private EntityManager em;

    public SaleLineBeanBean() {
    }

    public SaleLine persistSaleLine(SaleLine saleLine) {
        em.persist(saleLine);
        return saleLine;
    }

    public SaleLine mergeSaleLine(SaleLine saleLine) {
        return em.merge(saleLine);
    }

    public void removeSaleLine(SaleLine saleLine) {
        saleLine = em.find(SaleLine.class, saleLine.getId());
        em.remove(saleLine);
    }

    /** <code>select o from SaleLine o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SaleLine> getSaleLineFindAll() {
        return em.createNamedQuery("SaleLine.findAll", SaleLine.class).getResultList();
    }
}
