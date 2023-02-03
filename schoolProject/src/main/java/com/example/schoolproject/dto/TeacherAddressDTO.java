package com.example.schoolproject.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor @Data
public class TeacherAddressDTO {
    @NotNull
    private UUID teacherId;
    @NotEmpty(message = "Name must not be null")
    private String name;
}
