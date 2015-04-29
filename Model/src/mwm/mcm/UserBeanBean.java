package mwm.mcm;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import mwm.mcm.entities.UserMCM;

@Stateless(name = "UserBean", mappedName = "evaluacionWeb-Model-UserBean")
public class UserBeanBean implements UserBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "lybesShop")
    private EntityManager em;

    public UserBeanBean() {
    }

    public UserMCM persistUser(UserMCM user) {
        em.persist(user);
        return user;
    }

    public UserMCM mergeUser(UserMCM user) {
        return em.merge(user);
    }

    public void removeUser(UserMCM user) {
        user = em.find(UserMCM.class, user.getId());
        em.remove(user);
    }

    /** <code>select o from User o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<UserMCM> getUserFindAll() {
        return em.createNamedQuery("UserMCM.findAll", UserMCM.class).getResultList();
    }

    @Override
    public UserMCM getUserUsernamePassword(String username, String password) {
        UserMCM res = null;
        
        Query q = em.createNamedQuery("UserMCM.findByUsernamePassword", UserMCM.class);
        q.setParameter("u", username);
        q.setParameter("p", password);
        
        res = (UserMCM) q.getSingleResult();
        
        return res;
    }
}
