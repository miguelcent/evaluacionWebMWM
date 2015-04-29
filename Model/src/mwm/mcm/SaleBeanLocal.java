package mwm.mcm;

import java.util.List;

import javax.ejb.Local;

import mwm.mcm.entities.Sale;

@Local
public interface SaleBeanLocal {
    Sale persistSale(Sale sale);

    Sale mergeSale(Sale sale);

    void removeSale(Sale sale);

    List<Sale> getSaleFindAll();
}
