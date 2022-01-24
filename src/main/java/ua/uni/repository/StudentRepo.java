package ua.uni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.uni.repository.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
