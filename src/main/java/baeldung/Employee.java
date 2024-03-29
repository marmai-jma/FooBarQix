package baeldung;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20)
    private String name;

    @Size(min = 3, max = 20)
    private String surname;

    public Employee() {}

    public Employee(@Size(min = 3, max = 20) String name, @Size(min = 3, max = 20) String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee(@Size(min = 3, max = 20) String name) {
        this.name = name;
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

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

}
