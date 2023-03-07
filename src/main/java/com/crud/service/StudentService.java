package com.crud.service;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import com.crud.dto.StudentDto;
import com.crud.entity.Student;


@ApplicationScoped
public class StudentService{

    @Transactional
    public List<Student> listStudent(){
        return Student.listAll();
    }

    
    public Student saveStudent(StudentDto dto){

        Student student = new Student();

        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setRegNumber(dto.getRegNumber());

        student.persist();
        return student;
    }

    @Transactional
    public void updateStudent(Long id, StudentDto dto) {

        Student student = new Student();

        Optional<Student> studentOp = Student.findByIdOptional(id);

        if(studentOp.isEmpty()){
            
                throw new NullPointerException("Student not found");
           
        }

        student = studentOp.get();

        student.setName(dto.getName());
        student.setSurname(dto.getSurname());
        student.setRegNumber(dto.getRegNumber());

        student.persist();
    }

    @Transactional
    public void removeStudent(Long id){

     Optional<Student> studentOp = Student.findByIdOptional(id);

     if(studentOp.isEmpty()){
   
            throw new NullPointerException("Student not found");
       }

       Student student = studentOp.get();
    student.delete();


    }
}
