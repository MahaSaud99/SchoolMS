package com.example.schoolproject.contoller;


import com.example.schoolproject.dto.ApiResponse;
import com.example.schoolproject.dto.TeacherAddressDTO;
import com.example.schoolproject.model.Teacher;
import com.example.schoolproject.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/")
    public ResponseEntity getAllTeacher(){
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }

    @GetMapping("/address")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(teacherService.getAllAddress());
    }

    @PostMapping("/")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new ApiResponse("Added!"));
    }

    @PostMapping("/teacherAddress")
    public ResponseEntity addTeacherAddress(@RequestBody @Valid TeacherAddressDTO teacherAddressDTO){
        teacherService.addTeacherAddress(teacherAddressDTO);
        return ResponseEntity.status(201).body(new ApiResponse("Added!"));
    }


    @PutMapping("/{id}")
    public ResponseEntity updateTeacher(@PathVariable UUID id , @RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body(new ApiResponse("Updated!"));
    }

    @PutMapping("/address")
    public ResponseEntity updateTeacherAddress(@RequestBody @Valid TeacherAddressDTO teacher){
        teacherService.updateTeacherAddress(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Updated!"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeacher(@PathVariable UUID id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted!"));
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity deleteTeacherAddress(@PathVariable UUID id){
        teacherService.deleteTeacherAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted!"));
    }
}
