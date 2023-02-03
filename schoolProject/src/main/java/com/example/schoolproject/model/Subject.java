package com.example.schoolproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data @AllArgsConstructor @Entity @NoArgsConstructor
public class Subject {
    @Id
    private UUID id=UUID.randomUUID();
    @NotNull(message = "Name must not be empty!")
    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id" , referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;




//    @ManyToOne(cascade = CascadeType.ALL)
//    private Teacher teacher;
//
//    @JsonIgnore
//    @ManyToMany(cascade = CascadeType.ALL)
//    private Set<Student> students=new HashSet<>();

}
