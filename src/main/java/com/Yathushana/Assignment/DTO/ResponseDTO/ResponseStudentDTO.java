package com.Yathushana.Assignment.DTO.ResponseDTO;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseStudentDTO {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String course;

}