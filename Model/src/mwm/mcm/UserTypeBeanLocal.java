package mwm.mcm;

import java.util.List;

import javax.ejb.Local;

import mwm.mcm.entities.UserType;

@Local
public interface UserTypeBeanLocal {
    UserType persistUserType(UserType userType);

    UserType mergeUserType(UserType userType);

    void removeUserType(UserType userType);

    List<UserType> getUserTypeFindAll();
}
