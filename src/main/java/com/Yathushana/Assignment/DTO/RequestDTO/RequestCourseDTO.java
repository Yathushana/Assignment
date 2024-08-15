package com.Yathushana.Assignment.DTO.RequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestCourseDTO {
        private Long Id;

        private String courseName;

        private String lastName;

        private String description;

        private int duration;

    }

