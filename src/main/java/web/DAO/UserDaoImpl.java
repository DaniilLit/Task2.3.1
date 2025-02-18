package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDaoImpl  implements UserDAO{

    @PersistenceContext
   private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        List <User> users = entityManager.createQuery("from User", User.class).getResultList();
        return users;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public User getUser(int i) {
        return entityManager.find(User.class, i);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
