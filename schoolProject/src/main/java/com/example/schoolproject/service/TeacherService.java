package com.example.schoolproject.service;

import com.example.schoolproject.dto.TeacherAddressDTO;
import com.example.schoolproject.exception.ApiException;
import com.example.schoolproject.model.Address;
import com.example.schoolproject.model.Teacher;
import com.example.schoolproject.repository.AddressRepository;
import com.example.schoolproject.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List getAllTeacher(){
        return teacherRepository.findAll();
    }

    public List getAllAddress(){
        return addressRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
         teacherRepository.save(teacher);
    }

    public void addTeacherAddress(TeacherAddressDTO teacherAddress){
        Teacher teacher=teacherRepository.findTeacherById(teacherAddress.getTeacherId());
        if (teacher==null){
            throw new ApiException("Teacher not found");
        }

        Address address=new Address(null, teacherAddress.getName(),teacher);
        teacher.setAddress(address);
        addressRepository.save(address);
    }

    public void updateTeacher(Teacher teacher , UUID id){
        Teacher oldTeacher=teacherRepository.findTeacherById(id);
        if (oldTeacher==null){
            throw new ApiException("Teacher not found");
        }
        teacher.setId(id);
        teacher.setAddress(oldTeacher.getAddress());
        teacher.setSubjects(oldTeacher.getSubjects());
        teacherRepository.save(teacher);
    }

    public void updateTeacherAddress(TeacherAddressDTO teacherAddress){
        Address address=addressRepository.findAddressById(teacherAddress.getTeacherId());
        if (address==null){
            throw new ApiException("Teacher not found");
        }
//        Teacher teacher=teacherRepository.findTeacherById(teacherAddress.getTeacherId());
//        if (teacher==null){
//            throw new ApiException("Teacher not found");
//        }

         address.setName(teacherAddress.getName());
        addressRepository.save(address);
    }

    public  void deleteTeacher(UUID id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(teacher);
    }

    public  void deleteTeacherAddress(UUID id){
        Address address=addressRepository.findAddressById(id);
        if (address==null){
            throw new ApiException("Teacher not found");
        }
        System.out.println(address.getName());
        addressRepository.deleteById(id);
    }

}
