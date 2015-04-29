package mwm.mcm;

import java.util.List;

import javax.ejb.Local;

import mwm.mcm.entities.ProductCategory;

@Local
public interface ProductCategoryBeanLocal {
    ProductCategory persistProductCategory(ProductCategory productCategory);

    ProductCategory mergeProductCategory(ProductCategory productCategory);

    void removeProductCategory(ProductCategory productCategory);

    List<ProductCategory> getProductCategoryFindAll();
}
