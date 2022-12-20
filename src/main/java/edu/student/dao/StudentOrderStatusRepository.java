package edu.student.dao;

import edu.student.domain.StudentOrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentOrderStatusRepository extends JpaRepository<StudentOrderStatus, Long> {
}
