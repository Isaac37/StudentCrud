package com.crud;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

    // @Test
    // public void testSaveStundent(){
    //     final Student student = new Student();
    //     student.setName("Isaac");
    //     student.setSurname("Kumbula");
    //     student.setRegNumber("r155659c");

    //     given() 
    //         .body(student)
    //         .when()
    //         .post("/students")
    //         .then()
    //         .statusCode(204)
    //         .header("location", "http://localhost:8080/students");
    // }

}