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
 * To create ID generator sequence "USERTYPE_ID_SEQ_GEN":
 * CREATE SEQUENCE "USERTYPE_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "UserType.findAll", query = "select o from UserType o") })
@SequenceGenerator(name = "UserType_Id_Seq_Gen", sequenceName = "USERTYPE_ID_SEQ_GEN", allocationSize = 50,
                   initialValue = 50)
public class UserType implements Serializable {
    private static final long serialVersionUID = -4082963982634153857L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserType_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    private String typeName = "visitante";
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID")
    User user;

    public UserType() {
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }   
}
