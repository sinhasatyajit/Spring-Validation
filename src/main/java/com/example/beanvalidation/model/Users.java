package com.example.beanvalidation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.annotation.sql.DataSourceDefinition;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    private int id;
    @NotBlank(message = "cannot be blank")
    private String name;
}
