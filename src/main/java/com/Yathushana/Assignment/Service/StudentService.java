package com.Yathushana.Assignment.Service;

import com.Yathushana.Assignment.DTO.RequestDTO.RequestStudentDTO;
import com.Yathushana.Assignment.DTO.ResponseDTO.ResponseStudentDTO;

import java.util.List;

public interface StudentService {
     String saveStudent(RequestStudentDTO dto);

   List<ResponseStudentDTO> getAll();

   String deleteStudent(long id);

    String updateStudent(RequestStudentDTO dto, long id);
}
