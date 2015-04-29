package mwm.mcm.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

/**
 * To create ID generator sequence "PRODUCT_ID_SEQ_GEN":
 * CREATE SEQUENCE "PRODUCTMCM_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ProductMCM.findAll", query = "select o from ProductMCM o") })
@SequenceGenerator(name = "Product_Id_Seq_Gen", sequenceName = "PRODUCT_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class ProductMCM implements Serializable {
    private static final long serialVersionUID = 7939432488401771392L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Product_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    private Double price;
    private String description;
    private String productName;
    
    @OneToOne(fetch=FetchType.LAZY, mappedBy="product")
    private ProductCategory categoryProduct;
    
    @OneToMany(mappedBy="product", cascade=CascadeType.ALL)
    private List<SaleLine> saleLines;

    public ProductMCM() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public ProductCategory getCategoryProduct(){
        return categoryProduct;
    }
    
    public void setCategoryProduct(ProductCategory categoryProduct){
        this.categoryProduct = categoryProduct;
    }
    
    public List<SaleLine> getSaleLines(){
        return saleLines;
    }
    
    public void setSaleLines(List<SaleLine> saleLines){
        this.saleLines = saleLines;
    }
}
