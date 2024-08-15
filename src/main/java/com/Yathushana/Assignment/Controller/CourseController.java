package com.Yathushana.Assignment.Controller;
import com.Yathushana.Assignment.DTO.RequestDTO.RequestCourseDTO;
import com.Yathushana.Assignment.Service.CourseService;
import com.Yathushana.Assignment.Util.StandardResponseCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/save-course")
    private ResponseEntity<StandardResponseCourse> saveCourse(
            @RequestBody RequestCourseDTO dto
    ) {
        return new ResponseEntity<>(new StandardResponseCourse(
                300,
                "Course Record Saved",
                courseService.saveCourse(dto)
        ), HttpStatus.OK);
    }

    @GetMapping("/getAll-course")
    private ResponseEntity<StandardResponseCourse> getAllCourse() {
        return new ResponseEntity<>(new StandardResponseCourse(
                300,
                "All Record Retrived",
                courseService.getAllCourse()
        ), HttpStatus.OK);
    }

    @DeleteMapping(path="/delete/{id}")
    private ResponseEntity<StandardResponseCourse> deleteCourse(
            @PathVariable int id
    ){
        return new ResponseEntity<>(new StandardResponseCourse(
                206,
                " Record Delected",
                courseService.deleteCourse(id)
        ),HttpStatus.OK);
    }


    @PutMapping(path="/update/{id}")
    private ResponseEntity<StandardResponseCourse> updateCourse(
            @RequestBody RequestCourseDTO dto,
            @PathVariable long id)
    {
        return new ResponseEntity<>(new StandardResponseCourse(
                200,
                "Student Record Updated",
                courseService.updateCourse( dto ,id)
        ), HttpStatus.OK);
    }
}