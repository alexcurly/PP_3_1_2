package PP_3_1_2.Project2Boot.dao;

import PP_3_1_2.Project2Boot.model.User;


import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> getAllUsers();
    User getUser(long id);
    void updateUser(User user);
    void deleteUser(long id);

}