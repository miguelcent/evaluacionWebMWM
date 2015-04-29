package mwm.mcm.view;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import mwm.mcm.UserBeanLocal;
import mwm.mcm.entities.User;

@ManagedBean
@RequestScoped
public class LoginManagedBean {
    
    private FacesContext context;
    @EJB
    private UserBeanLocal userBean;
    private User user;
    
    public LoginManagedBean() {
        user = new User();
        context = FacesContext.getCurrentInstance();
    }
    
    public User getUuario(){
        return user;
    }
            
    public String login(){ 
        String res = "OK";
        User u = userBean.getUserUsernamePassword(user.getUsername(), user.getPassword());
        if(u == null){
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No existe ningún usuario" +
                " para estas credenciales."));
            res = "ERROR";
        } else {
            context.getExternalContext().getSessionMap().put("user", u);
        }
        
        return res;
    }
}
