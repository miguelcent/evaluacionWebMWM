package mwm.mcm;

import java.util.List;

import javax.ejb.Local;

import mwm.mcm.entities.Product;

@Local
public interface ProductBeanLocal {
    Product persistProduct(Product product);

    Product mergeProduct(Product product);

    void removeProduct(Product product);

    List<Product> getProductFindAll();
}
