package mwm.mcm;

import java.util.List;

import javax.ejb.Local;

import mwm.mcm.entities.SaleLine;

@Local
public interface SaleLineBeanLocal {
    SaleLine persistSaleLine(SaleLine saleLine);

    SaleLine mergeSaleLine(SaleLine saleLine);

    void removeSaleLine(SaleLine saleLine);

    List<SaleLine> getSaleLineFindAll();
}
