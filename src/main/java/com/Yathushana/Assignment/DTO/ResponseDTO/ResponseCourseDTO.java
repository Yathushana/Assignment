package com.Yathushana.Assignment.DTO.ResponseDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCourseDTO {

        private long Id;

        private String courseName;

        private String lastName;

        private String description;

        private int duration;

}

