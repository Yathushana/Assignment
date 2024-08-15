package com.Yathushana.Assignment.Service.Impl;

import com.Yathushana.Assignment.DTO.RequestDTO.RequestCourseDTO;
import com.Yathushana.Assignment.DTO.ResponseDTO.ResponseCourseDTO;
import com.Yathushana.Assignment.Entity.Course;
import com.Yathushana.Assignment.Repo.CourseRepo;
import com.Yathushana.Assignment.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String saveCourse(RequestCourseDTO dto) {
        Course course = new Course(
         dto.getCourseName(),
         dto.getDescription(),
         dto.getDuration()
        );
        courseRepo.save(course);
        return dto.getCourseName();
    }

    @Override
    public List<ResponseCourseDTO> getAllCourse() {
        List<ResponseCourseDTO>list = new ArrayList<>();

        List<Course> course = courseRepo.findAll();
        for (Course c : course) {
            list.add(new ResponseCourseDTO(
                    c.getId(),
                    c.getCourseName(),
                    c.getDescription(),
                    c.getDuration()
            ));

        }
            return list;

    }

    @Override
    public String deleteCourse(long Id) {
        Optional<Course> course = courseRepo.findById(String.valueOf(Id));
        if (course.isEmpty()) {
           throw new RuntimeException("Course not found");
        }
        courseRepo.delete(course.get());
        return course.get().getCourseName();
    }

    @Override
    public String updateCourse(RequestCourseDTO dto, long id) {
     Optional<Course> course = courseRepo.findById(String.valueOf(id));
     if (course.isEmpty()) {
         throw new RuntimeException("Course not found");
     }
       course.get().setCourseName(dto.getCourseName());
       course.get().setDescription(dto.getDescription());
       course.get().setDuration(dto.getDuration());

       courseRepo.save(course.get());
       return dto.getCourseName();
    }
}
