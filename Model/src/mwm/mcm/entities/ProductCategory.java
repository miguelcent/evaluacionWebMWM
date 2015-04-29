package mwm.mcm.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

/**
 * To create ID generator sequence "PRODUCTCATEGORY_ID_SEQ_GEN":
 * CREATE SEQUENCE "PRODUCTCATEGORY_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ProductCategory.findAll", query = "select o from ProductCategory o") })
@SequenceGenerator(name = "ProductCategory_Id_Seq_Gen", sequenceName = "PRODUCTCATEGORY_ID_SEQ_GEN",
                   allocationSize = 50, initialValue = 50)
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = -319886989438473226L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductCategory_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    private String categoryName;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID")
    Product product;

    public ProductCategory() {
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public Product getProduct(){
        return product;
    }
    
    public void setProduct(Product product){
        this.product = product;
    }
}
