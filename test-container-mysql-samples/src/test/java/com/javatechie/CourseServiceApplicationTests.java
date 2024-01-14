package com.javatechie;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.entity.Course;
import com.javatechie.repository.CourseRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseServiceApplicationTests {

    @LocalServerPort
    private Integer port;

    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:latest");

    @BeforeAll
    static void beforeAll() {
        mysql.start();
    }

    @AfterAll
    static void afterAll() {
        mysql.stop();
    }


    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Autowired
    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        courseRepository.deleteAll();
    }

    @Test
    public void addNewCourseTest() {

        //build request body
        Course course = Course.builder()
                .name("test-course")
                .price(100)
                .duration("0 month")
                .build();
        //call controller endpoints
        given()
                .contentType(ContentType.JSON) // Set the content type of the request
                .body(asJsonString(course)) // Set the request payload
                .when()
                .post("/courses") // Specify the endpoint for the POST request
                .then()
                .statusCode(201) // Assert the expected HTTP status code
                .body("name", equalTo("test-course")); // Assert a specific condition in the response body

    }


    @Test
    public void getAllTheCoursesTest()  {
        Course course1 = Course.builder()
                .name("test-course-1")
                .price(100)
                .duration("1 month")
                .build();
        Course course2 = Course.builder()
                .name("test-course-2")
                .price(200)
                .duration("2 month")
                .build();
        List<Course> courses = List.of(course1, course2);
        courseRepository.saveAll(courses);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/courses")
                .then()
                .statusCode(200)
                .body(".",hasSize(2))
                .body("[0].price",equalTo(100.0f))
                .body("[1].name",equalTo("test-course-2"));

    }

    private String asJsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
