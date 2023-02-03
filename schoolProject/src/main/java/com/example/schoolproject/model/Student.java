package com.example.schoolproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
public class Student {

    @Id
    private UUID id=UUID.randomUUID();
    private String name;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "students")
//    private Set<Subject> subjects=new HashSet<>();
}
