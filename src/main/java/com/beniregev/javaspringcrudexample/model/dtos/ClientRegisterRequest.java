package com.beniregev.javaspringcrudexample.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRegisterRequest {
    private String username;
    private String password;
    private String email;
}
