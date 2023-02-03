package com.example.schoolproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor @Entity
public class Teacher {

    @Id
    private UUID id= UUID.randomUUID();
    @NotEmpty(message = "Name must not be null")
    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(mappedBy = "teacher")
    private Set<Subject> subjects;









//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teacher_id" , referencedColumnName = "id")
//    private List<Subject> subjectList;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Address address;
//
//    @OneToMany(mappedBy = "teacher")
//    private Set<Subject> subjects=new HashSet<>();



}
