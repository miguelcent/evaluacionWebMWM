package mwm.mcm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

/**
 * To create ID generator sequence "SALELINE_ID_SEQ_GEN":
 * CREATE SEQUENCE "SALELINE_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "SaleLine.findAll", query = "select o from SaleLine o") })
@SequenceGenerator(name = "SaleLine_Id_Seq_Gen", sequenceName = "SALELINE_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class SaleLine implements Serializable {
    private static final long serialVersionUID = 4270074800498830350L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SaleLine_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    
    @ManyToOne
    private Sale sale;
    
    @ManyToOne
    private Product product;
    
    public SaleLine() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    public Sale getSale(){
        return sale;
    }
    
    public void setSale(Sale sale){
        this.sale = sale;
    }
    
    public Product getProduct(){
        return product;
    }
    
    public void setProduct(Product product){
        this.product = product;
    }
}
