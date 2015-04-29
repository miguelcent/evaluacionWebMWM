package mwm.mcm;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mwm.mcm.entities.Product;

@Stateless(name = "ProductBean", mappedName = "evaluacionWeb-Model-ProductBean")
public class ProductBeanBean implements ProductBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "lybesShop")
    private EntityManager em;

    public ProductBeanBean() {
    }

    public Product persistProduct(Product product) {
        em.persist(product);
        return product;
    }

    public Product mergeProduct(Product product) {
        return em.merge(product);
    }

    public void removeProduct(Product product) {
        product = em.find(Product.class, product.getId());
        em.remove(product);
    }

    /** <code>select o from Product o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Product> getProductFindAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }
}
