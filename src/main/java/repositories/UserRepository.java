package repositories;

import entities.User;
import exceptions.NoSuchUserFoundException;

/**
 * Created by Szymon on 2015-04-25.
 */
public interface UserRepository {

    public void saveUser(User user);
    public User findUserByUsername(String username) throws NoSuchUserFoundException;
}
