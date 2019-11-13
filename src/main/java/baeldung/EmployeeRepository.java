package baeldung;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByName(String name);
    public Employee findByNameAndSurname(String name, String surname);
    //public Optional<Employee> findById(Long id); Existe déjà ne pas coder!

}