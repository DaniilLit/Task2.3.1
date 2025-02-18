package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    void addUser(User user);

    User getUser (int i);
    void deleteUser (int id);
}
