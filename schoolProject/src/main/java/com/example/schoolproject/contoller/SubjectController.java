package com.example.schoolproject.contoller;

import com.example.schoolproject.dto.ApiResponse;
import com.example.schoolproject.dto.TeacherAddressDTO;
import com.example.schoolproject.model.Subject;
import com.example.schoolproject.service.SubjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController @RequiredArgsConstructor @RequestMapping("/api/v1/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping("/")
    public ResponseEntity getAllSubject(){
        return ResponseEntity.status(200).body(subjectService.getAllSubject());
    }

    @PostMapping("/")
    public ResponseEntity addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
        return ResponseEntity.status(201).body(new ApiResponse("Added!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSubject(@RequestBody @Valid Subject subject , @PathVariable UUID id){
        subjectService.updateSubject(id,subject);
        return ResponseEntity.status(200).body(new ApiResponse("Updated!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeacher(@PathVariable UUID id){
        subjectService.deleteSubject(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted!"));
    }

    @PutMapping("/{subjectId}/teacher/{teacherId}")
    public ResponseEntity assignTeacherToSubject(@PathVariable UUID subjectId , @PathVariable UUID teacherId){
        subjectService.assignTeacherToSubject(teacherId,subjectId);
        return ResponseEntity.status(200).body(new ApiResponse("Teacher assign to subject"));
    }
//
//    @PutMapping("/{subjectId}/student/{studentId}")
//    public ResponseEntity enrolledStudentToSubject(@PathVariable UUID subjectId ,@PathVariable UUID studentId){
//        subjectService.enrolledStudentToSubject(studentId , subjectId);
//        return ResponseEntity.status(200).body(new apiResponse("Student enrolled!"));
//    }

}
