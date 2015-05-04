package repositories;

import entities.User;
import exceptions.NoSuchUserFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Szymon on 2015-04-25.
 */
@Repository
public class HibernateUserRepository implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    public User findUserByUsername(String username) throws NoSuchUserFoundException {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from User where username = :username");
        query.setParameter("username", username);

        List<User> result = query.list();

        session.getTransaction().commit();
        session.close();

        if(result.isEmpty())
            throw new NoSuchUserFoundException(String.format("Użytkownik '%s' nie istnieje", username));
        else
            return result.get(0);
    }
}
