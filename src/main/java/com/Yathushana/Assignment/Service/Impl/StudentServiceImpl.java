package com.Yathushana.Assignment.Service.Impl;

import com.Yathushana.Assignment.DTO.RequestDTO.RequestStudentDTO;
import com.Yathushana.Assignment.DTO.ResponseDTO.ResponseStudentDTO;
import com.Yathushana.Assignment.Entity.Student;
import com.Yathushana.Assignment.Repo.StudentRepo;
import com.Yathushana.Assignment.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
  public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String saveStudent(RequestStudentDTO dto) {

        Student student = new Student(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getCourse()
        );

        studentRepo.save(student);
        return (dto.getFirstName()+" " + dto.getLastName());
    }

    @Override
    public List<ResponseStudentDTO> getAll() {
        List<ResponseStudentDTO> list = new ArrayList<>();

        List<Student> students = studentRepo.findAll();
        for (Student e : students) {
            list.add(new ResponseStudentDTO(
                    e.getId(),
                    e.getFirstName(),
                    e.getLastName(),
                    e.getEmail(),
                    e.getCourse()
            ));
        }
        return list;
    }

    @Override
    public String deleteStudent(long id) {
        Optional<Student> student= studentRepo.findById(id);
        if (student.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        studentRepo.delete(student.get());

        return student.get().getFirstName()+" "+student.get().getLastName();
    }

    @Override
    public String updateStudent(RequestStudentDTO dto, long id) {
        Optional<Student> student = studentRepo.findById(id);
        if (student.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        student.get().setFirstName(dto.getFirstName());
        student.get().setLastName(dto.getLastName());
        student.get().setEmail(dto.getEmail());
        student.get().setCourse(dto.getCourse());

        studentRepo.save(student.get());
        return student.get().getFirstName()+" "+student.get().getLastName();
    }
}
