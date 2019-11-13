package baeldung;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    // write test cases here
    @Test
    public void whenFindId_thenReturnEmployee() {
        // given
        Employee toto = new Employee("toto");
        entityManager.persist(toto);
        entityManager.flush();

        // when
        Optional<Employee> found = employeeRepository.findById(toto.getId());

        // then
        Assertions.assertThat(found.get().getId())
                .isEqualTo(toto.getId());
    }

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee alex = new Employee("alex");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName(alex.getName());

        // then
        Assertions.assertThat(found.getName())
                .isEqualTo(alex.getName());
    }

    @Test
    public void whenFindByNameAndSurname_thenReturnEmployee() {
        // given
        Employee alex = new Employee("alex", "jules");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByNameAndSurname(alex.getName(), alex.getSurname());
        //Employee found = employeeRepository.findByNameAndSurname("alex", "jules");
        Employee expected = new Employee(alex.getName(), alex.getSurname());
        // then
        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(found)
                        .describedAs("Object").isEqualToIgnoringNullFields(expected),
                () -> Assertions.assertThat(found.getName())
                        .describedAs("name")
                        .isEqualTo(expected.getName()),
                () -> Assertions.assertThat(found.getSurname())
                        .describedAs("surname")
                        .isEqualTo(expected.getSurname())
        );
    }
}