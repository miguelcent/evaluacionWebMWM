package mwm.mcm;

import java.util.List;

import javax.ejb.Local;

import mwm.mcm.entities.UserMCM;


@Local
public interface UserBeanLocal {
    UserMCM persistUser(UserMCM user);

    UserMCM mergeUser(UserMCM user);

    void removeUser(UserMCM user);

    List<UserMCM> getUserFindAll();
    
    UserMCM getUserUsernamePassword(String username, String password);
}
