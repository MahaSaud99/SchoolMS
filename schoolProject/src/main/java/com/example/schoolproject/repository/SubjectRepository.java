package com.example.schoolproject.repository;

import com.example.schoolproject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, UUID> {
    Subject findSubjectById(UUID id);
}
