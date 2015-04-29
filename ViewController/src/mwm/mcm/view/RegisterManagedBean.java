package mwm.mcm.view;

import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import mwm.mcm.UserBeanLocal;
import mwm.mcm.entities.UserMCM;

@ManagedBean(name = "RegisterBean")
@RequestScoped
public class RegisterManagedBean {
    private FacesContext context;
    @EJB
    private UserBeanLocal usuarioBean;
    private UserMCM usuario;
    private String repassword;
    
    public RegisterManagedBean() {
        usuario = new UserMCM();
        context = FacesContext.getCurrentInstance();
    }
    public UserMCM getUsuario() {
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
            UserMCM u = usuarioBean.persistUser( usuario );
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
