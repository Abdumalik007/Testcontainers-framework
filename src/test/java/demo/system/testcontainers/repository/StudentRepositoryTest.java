package demo.system.testcontainers.repository;

import demo.system.testcontainers.AbstractContainerBaseTest;
import demo.system.testcontainers.entity.Student;
import demo.system.testcontainers.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest extends AbstractContainerBaseTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void givenStudentObject_whenSave_thenReturnSavedStudent(){

        // given - setup or precondition
        Student student = Student.builder().firstName("Ramesh")
                .lastName("fadatare").email("ramesh@gmail.com").build();

        // when - action or the testing
        Student savedStudent = studentRepository.save(student);

        // then - very output
        Assertions.assertNotNull(savedStudent);

    }

    // JUnit for save student operation - BDD style
    @Test
    public void givenStudentId_whenfindbyId_thenReturnSavedStudent(){

        // given - setup or precondition
        Student student = Student.builder().firstName("Ramesh")
                .lastName("fadatare").email("ramesh@gmail.com").build();
        Student savedStudent = studentRepository.save(student);

        // when - action or the testing
        Student studentDB = studentRepository.findById(student.getId()).get();

        // then - very output
        Assertions.assertNotNull(studentDB);
    }

}