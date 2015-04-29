package mwm.mcm.entities;

import java.io.Serializable;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * To create ID generator sequence "SALE_ID_SEQ_GEN":
 * CREATE SEQUENCE "SALE_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Sale.findAll", query = "select o from Sale o") })
@SequenceGenerator(name = "Sale_Id_Seq_Gen", sequenceName = "SALE_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class Sale implements Serializable {
    private static final long serialVersionUID = -6104855011406978088L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sale_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    private String status = "activo";
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy="sale", cascade=CascadeType.ALL)
    private List<SaleLine> saleLines;

    public Sale() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public List<SaleLine> getSaleLines(){
        return saleLines;
    }
    
    public void setSaleLines(List<SaleLine> saleLines){
        this.saleLines = saleLines;
    }
}
