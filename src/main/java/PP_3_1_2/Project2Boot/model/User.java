package PP_3_1_2.Project2Boot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Строка с именем не может быть пустой.")
    @Pattern(regexp = "^[A-Za-z\\-]+$", message = "Только буквы.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Строка с фамилией не может быть пустой.")
    @Pattern(regexp = "^[A-Za-z\\-]+$", message = "Только буквы.")
    @Column(name = "lastname")
    private String lastName;
    @NotBlank(message = "Строка с возрастом не может быть пустой.")
    @Column(name = "age")
    private String age;

    public User(String name, String lastName, String age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
