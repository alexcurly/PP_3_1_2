package PP_3_1_2.Project2Boot.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @NotBlank(message = "Строка с именем не может быть пустой.")
//    @Pattern(regexp = "^[A-Za-z\\-]+$", message = "Только буквы.")
    @Column(name = "name")
    private String name;

//    @NotBlank(message = "Строка с фамилией не может быть пустой.")
//    @Pattern(regexp = "^[A-Za-z\\-]+$", message = "Только буквы.")
    @Column(name = "lastname")
    private String lastName;
//    @NotBlank(message = "Строка с возрастом не может быть пустой.")
    @Column(name = "age")
    private String age;

}
