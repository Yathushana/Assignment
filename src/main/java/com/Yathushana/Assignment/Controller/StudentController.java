package com.Yathushana.Assignment.Controller;

import com.Yathushana.Assignment.DTO.RequestDTO.RequestStudentDTO;
import com.Yathushana.Assignment.Service.StudentService;
import com.Yathushana.Assignment.Util.StandardResponse;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")

public class StudentController {

    @Autowired
    private StudentService studentService;

     @PostMapping(path="/save")
    private ResponseEntity<StandardResponse> saveStudent(
            @RequestBody RequestStudentDTO dto)
    {
        return new ResponseEntity<>(new StandardResponse(
                200,
                "Student Record Saved",
                studentService.saveStudent(dto)
        ), HttpStatus.OK);
    }
    @GetMapping("/get-all")
    private ResponseEntity<StandardResponse> getAllStudents(){
        return new ResponseEntity<>(new StandardResponse(
         200,
          "All Record Retrived",
                studentService.getAll()
        ), HttpStatus.OK);
    }

    @DeleteMapping(path="/delete/{id}")
    private ResponseEntity<StandardResponse> deleteStudent(
            @PathVariable long id
         ){
         return new ResponseEntity<>(new StandardResponse(
                 206,
                 "Record Delected",
                  studentService.deleteStudent(id)
         ),HttpStatus.OK);
    }

    @PutMapping(path="/update/{id}")
    private ResponseEntity<StandardResponse> updateStudent(
            @RequestBody RequestStudentDTO dto,
            @PathVariable long id)
    {
        return new ResponseEntity<>(new StandardResponse(
                200,
                "Student Record Updated",
                studentService.updateStudent(dto ,id)
        ), HttpStatus.OK);
    }
}
