package mwm.mcm.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "menuBean")
@RequestScoped
public class MenuManagedBean {
    public MenuManagedBean() {
    }
    
    public String toLogin(){
        return "login";
    }
    public String toRegister(){
        return "register";
    }
}
