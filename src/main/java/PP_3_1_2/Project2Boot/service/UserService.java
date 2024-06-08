package PP_3_1_2.Project2Boot.service;


import PP_3_1_2.Project2Boot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getAllUsers();
    User getUser(long id);
    void updateUser(User user);
    void deleteUser(long id);

}
