package web.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import web.repository.UserRepository;

import java.util.List;

@Service
public class UserDaoImpl  implements UserDAO{


     final private UserRepository userRepository;

     @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void addUser(User user) {
       userRepository.save(user);
    }

    @Override
    @Transactional
    public User getUser(int i) {
        return userRepository.getOne(i);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
