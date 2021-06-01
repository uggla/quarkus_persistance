package fr.uggla;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.panache.mock.PanacheMock;
import org.junit.platform.commons.annotation.Testable;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Testcontainers
@QuarkusTest
public class PersistenceTest {

    @Test
    public void testHelloEndpoint() {
//        PanacheMock.mock(Person.class);
//
//
//        // Mocked classes always return a default value
//        Assertions.assertEquals(0, Person.count());

        given()
                .body("\"name\":\"toto\",\"birth\":\"2000-01-01\",\"status\":\"Alive\"")
                .when()
                .post("/hello")
                .then()
                .statusCode(201);

        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("[\"toto\"]"));
    }

}