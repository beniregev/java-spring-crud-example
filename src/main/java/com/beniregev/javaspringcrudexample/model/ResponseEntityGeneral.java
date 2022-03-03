package com.beniregev.javaspringcrudexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntityGeneral {
    private HttpStatus httpStatus;
    private boolean success;
    private Object result;

}
