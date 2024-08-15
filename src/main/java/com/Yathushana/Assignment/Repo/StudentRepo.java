package com.Yathushana.Assignment.Repo;

import com.Yathushana.Assignment.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface StudentRepo  extends JpaRepository<Student, Long> {


}
