package PP_3_1_2.Project2Boot.repository;



import PP_3_1_2.Project2Boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
