package com.Yathushana.Assignment.Util;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponseCourse  {

    private int code;

    private String message;

    private Object data;
}
