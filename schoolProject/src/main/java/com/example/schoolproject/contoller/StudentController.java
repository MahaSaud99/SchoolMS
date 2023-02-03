package com.example.schoolproject.contoller;

import com.example.schoolproject.dto.ApiResponse;
import com.example.schoolproject.model.Student;
import com.example.schoolproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity getAllStudent(){
        return ResponseEntity.status(200).body(studentService.getAllStudent());
    }

    @PostMapping("/")
    public ResponseEntity addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Added!"));
    }

}
