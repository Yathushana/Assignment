package com.Yathushana.Assignment.Service;

import com.Yathushana.Assignment.DTO.RequestDTO.RequestCourseDTO;
import com.Yathushana.Assignment.DTO.RequestDTO.RequestStudentDTO;
import com.Yathushana.Assignment.DTO.ResponseDTO.ResponseCourseDTO;

import java.util.List;

public interface CourseService {
    String saveCourse(RequestCourseDTO dto);

    List<ResponseCourseDTO> getAllCourse();

    String deleteCourse(long id);

    String updateCourse(RequestCourseDTO dto, long id);
}
