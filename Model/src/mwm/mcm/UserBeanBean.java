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

import mwm.mcm.entities.User;

@Stateless(name = "UserBean", mappedName = "evaluacionWeb-Model-UserBean")
public class UserBeanBean implements UserBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "lybesShop")
    private EntityManager em;

    public UserBeanBean() {
    }

    public User persistUser(User user) {
        em.persist(user);
        return user;
    }

    public User mergeUser(User user) {
        return em.merge(user);
    }

    public void removeUser(User user) {
        user = em.find(User.class, user.getId());
        em.remove(user);
    }

    /** <code>select o from User o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<User> getUserFindAll() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    @Override
    public User getUserUsernamePassword(String username, String password) {
        User res = null;
        
        Query q = em.createNamedQuery("User.findByUsernamePassword", User.class);
        q.setParameter("u", username);
        q.setParameter("p", password);
        
        res = (User) q.getSingleResult();
        
        return res;
    }
}
