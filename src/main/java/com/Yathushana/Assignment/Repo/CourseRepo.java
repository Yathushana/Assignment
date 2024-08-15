package com.Yathushana.Assignment.Repo;

import com.Yathushana.Assignment.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@EnableJpaRepositories
public interface CourseRepo extends JpaRepository<Course, String> {


}
