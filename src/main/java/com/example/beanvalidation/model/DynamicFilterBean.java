package com.example.beanvalidation.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonFilter("BeanFilter")
public class DynamicFilterBean {
    private String field1;
    private String field2;
    private String field3;
}
