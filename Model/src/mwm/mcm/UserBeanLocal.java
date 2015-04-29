package mwm.mcm;

import java.util.List;

import javax.ejb.Local;

import mwm.mcm.entities.User;

@Local
public interface UserBeanLocal {
    User persistUser(User user);

    User mergeUser(User user);

    void removeUser(User user);

    List<User> getUserFindAll();
    
    User getUserUsernamePassword(String username, String password);
}
