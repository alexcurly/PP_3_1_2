package PP_3_1_2.Project2Boot.service;

import PP_3_1_2.Project2Boot.model.User;

import java.util.List;

public interface UserService {


    public User getUser(long id);


    public List<User> getAllUsers();

    public User saveUser(User user);


    public void deleteUser(long id);

}
