package PP_3_1_2.Project2Boot.service;


import PP_3_1_2.Project2Boot.model.User;
import PP_3_1_2.Project2Boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @Override
    public User getUser(long id) {
        return userRepository.getOne(id);
    }

//    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

//    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }



//    public void updateUser(User user) {
//        userDao.updateUser(user);
//    }
}
