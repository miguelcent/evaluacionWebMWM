package mwm.mcm;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mwm.mcm.entities.ProductCategory;

@Stateless(name = "ProductCategoryBean", mappedName = "evaluacionWeb-Model-ProductCategoryBean")
public class ProductCategoryBeanBean implements ProductCategoryBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "lybesShop")
    private EntityManager em;

    public ProductCategoryBeanBean() {
    }

    public ProductCategory persistProductCategory(ProductCategory productCategory) {
        em.persist(productCategory);
        return productCategory;
    }

    public ProductCategory mergeProductCategory(ProductCategory productCategory) {
        return em.merge(productCategory);
    }

    public void removeProductCategory(ProductCategory productCategory) {
        productCategory = em.find(ProductCategory.class, productCategory.getId());
        em.remove(productCategory);
    }

    /** <code>select o from ProductCategory o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ProductCategory> getProductCategoryFindAll() {
        return em.createNamedQuery("ProductCategory.findAll", ProductCategory.class).getResultList();
    }
}
