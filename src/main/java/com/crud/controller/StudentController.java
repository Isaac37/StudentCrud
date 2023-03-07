package com.crud.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import com.crud.dto.StudentDto;
import com.crud.entity.Student;
import com.crud.service.StudentService;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class StudentController {
    
    @Inject
    StudentService service;

    @GET
    public Response listStudents(){
     List<Student> students =  service.listStudent();
     return Response.ok(students).build();
    }

   @POST
    public Response saveStudent(StudentDto dto){
        Student student = service.saveStudent(dto);
        return Response.ok(student).status(201).build();
    }


    @PUT
    @Path("{id}")
    public Response updateStudent(@PathParam("id") Long id, StudentDto dto) {
        service.updateStudent(id, dto);
        return Response.status(204).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeStudent(@PathParam("id") Long id){
        service.removeStudent(id);
        return Response.status(204).build();
    }
}

