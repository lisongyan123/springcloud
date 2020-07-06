package com.example.elasticsearch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class Employee {
    private String id;
    private Long version;
    String firstName;
    String lastName;
    String age;
    String[] interests;
}