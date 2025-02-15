package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import web.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDaoImpl  implements UserDAO{


    EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
