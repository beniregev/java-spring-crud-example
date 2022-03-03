package com.beniregev.javaspringcrudexample.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
public class ClientUpdateRequest {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String ip;
}
