package mwm.mcm.entities;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
 * To create ID generator sequence "USER_ID_SEQ_GEN":
 * CREATE SEQUENCE "USER_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "select o from User o"),
                @NamedQuery(name = "User.findByUsernamePassword", query = "select o" +
                " from User o where o.username =: u and o.password =: p") })
@SequenceGenerator(name = "User_Id_Seq_Gen", sequenceName = "USER_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class UserMCM implements Serializable {
    private static final long serialVersionUID = -2334604735075642955L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Id_Seq_Gen")
    private Integer id;
    @Version
    private Integer version;
    @Column(nullable = false)
    private Integer zip;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    
    @OneToOne(fetch=FetchType.LAZY, mappedBy="user")
    private UserType userType;
    
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Sale> sales;

    public UserMCM() {
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

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public UserType getUserType(){
        return userType; 
    }
    
    public void setUserType(UserType userType){
        this.userType = userType;
    }
    
    public List<Sale> getSales(){
        return sales;
    }
    
    public void setSales(List<Sale> sales){
        this.sales = sales;
    }
}
