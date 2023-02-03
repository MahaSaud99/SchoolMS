package com.example.schoolproject.service;

import com.example.schoolproject.exception.ApiException;
import com.example.schoolproject.model.Student;
import com.example.schoolproject.model.Subject;
import com.example.schoolproject.model.Teacher;
import com.example.schoolproject.repository.StudentRepository;
import com.example.schoolproject.repository.SubjectRepository;
import com.example.schoolproject.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    public List getAllSubject(){
       return subjectRepository.findAll();
    }

    public void addSubject(Subject subject){
        System.out.println(subject.getTeacher());

        subjectRepository.save(subject);
    }


    public void updateSubject(UUID id,Subject subject){
        Subject subject1=subjectRepository.findSubjectById(id);
        if (subject1==null){
            throw new ApiException("Subject Not Found!");
        }
        subject.setId(id);
        subject.setTeacher(subject1.getTeacher());
        subjectRepository.save(subject);
    }


    public void deleteSubject(UUID id){
        Subject subject=subjectRepository.findSubjectById(id);
        if (subject==null){
            throw new ApiException("Subject Not Found!");
        }
        subjectRepository.delete(subject);
    }

//    public void enrolledStudentToSubject(UUID studentId, UUID subjectId){
//        Student student=studentRepository.findStudentById(studentId);
//        Subject subject=subjectRepository.findSubjectById(subjectId);
//        Set<Student> studentSet=subject.getStudents();
//        studentSet.add(student);
//        subject.setStudents(studentSet);
//        subjectRepository.save(subject);
//    }

    public void assignTeacherToSubject(UUID teacherId , UUID subjectId){
        Teacher teacher=teacherRepository.findTeacherById(teacherId);
        Subject subject=subjectRepository.findSubjectById(subjectId);

        if (teacher==null){
            throw new ApiException("teacher Not Found!");
        }else if (subject==null){
            throw new ApiException("Subject Not Found!");
        }

        subject.setTeacher(teacher);
        subjectRepository.save(subject);
    }
}
