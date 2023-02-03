package com.example.schoolproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor @Entity
public class Address {

    @Id
    private UUID id= UUID.randomUUID();
    @NotEmpty(message = "Name must not be null")
    @Column(nullable = false)
    private String name;

    @OneToOne(optional = false)
    @JoinColumn(name = "teacher_id" , referencedColumnName = "id")
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
