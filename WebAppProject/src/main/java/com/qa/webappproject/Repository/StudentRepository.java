// Abstracts communication with the database
package com.qa.webappproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.webappproject.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
