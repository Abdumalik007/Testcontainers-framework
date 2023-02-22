package demo.system.testcontainers.repository;


import demo.system.testcontainers.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
