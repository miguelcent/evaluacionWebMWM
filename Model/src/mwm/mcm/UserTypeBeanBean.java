package mwm.mcm;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mwm.mcm.entities.UserType;

@Stateless(name = "UserTypeBean", mappedName = "evaluacionWeb-Model-UserTypeBean")
public class UserTypeBeanBean implements UserTypeBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "lybesShop")
    private EntityManager em;

    public UserTypeBeanBean() {
    }

    public UserType persistUserType(UserType userType) {
        em.persist(userType);
        return userType;
    }

    public UserType mergeUserType(UserType userType) {
        return em.merge(userType);
    }

    public void removeUserType(UserType userType) {
        userType = em.find(UserType.class, userType.getId());
        em.remove(userType);
    }

    /** <code>select o from UserType o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<UserType> getUserTypeFindAll() {
        return em.createNamedQuery("UserType.findAll", UserType.class).getResultList();
    }
}
