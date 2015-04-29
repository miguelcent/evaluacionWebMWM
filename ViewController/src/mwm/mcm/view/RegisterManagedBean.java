package mwm.mcm.view;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import mwm.mcm.UserBeanLocal;
import mwm.mcm.entities.User;

@ManagedBean(name = "RegisterBean")
@RequestScoped
public class RegisterManagedBean {
    private FacesContext context;
    @EJB
    private UserBeanLocal usuarioBean;
    private User usuario;
    private String repassword;
    
    public RegisterManagedBean() {
        usuario = new User();
        context = FacesContext.getCurrentInstance();
    }
    public User getUsuario() {
        return usuario;
    }
    public String getRepassword() {
        return repassword;
    }
    public void setRepassword( String repassword ) {
        this.repassword = repassword;
    }
    public String register() {
        String res = validate();
        if ( !res.equals( "ERROR" ) ) {
            User u = usuarioBean.persistUser( usuario );
            if ( u == null ) {
                context.addMessage( null, new
                FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "No se ha " +
                    "podido crear el usuario." ) );
                res = "ERROR";
            }
            else {
                context.addMessage(null, new
                FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "El usuario ha " +
                    "sido creado."));
            }
        }
        return res;
    }
    private String validate() {
        String res = "OK";
        if ( !usuario.getPassword().equals( repassword ) ) {
            context.addMessage( null, new
            FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Las " +
                "contraseñas no son iguales." ));
            res = "ERROR";
        }
        return res;
    }
}
