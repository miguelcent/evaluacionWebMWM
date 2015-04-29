package mwm.mcm;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mwm.mcm.entities.Sale;

@Stateless(name = "SaleBean", mappedName = "evaluacionWeb-Model-SaleBean")
public class SaleBeanBean implements SaleBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "lybesShop")
    private EntityManager em;

    public SaleBeanBean() {
    }

    public Sale persistSale(Sale sale) {
        em.persist(sale);
        return sale;
    }

    public Sale mergeSale(Sale sale) {
        return em.merge(sale);
    }

    public void removeSale(Sale sale) {
        sale = em.find(Sale.class, sale.getId());
        em.remove(sale);
    }

    /** <code>select o from Sale o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Sale> getSaleFindAll() {
        return em.createNamedQuery("Sale.findAll", Sale.class).getResultList();
    }
}
