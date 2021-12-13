package com.bigProject.RealEstate.controller.integration;

import com.bigProject.RealEstate.Repository.FloorRepository;
import com.bigProject.RealEstate.dto.FloorDto;
import com.bigProject.RealEstate.model.Floor;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class FloorControllerIntTest {


    private ObjectMapper objectMapper;

    @Autowired
    private FloorRepository floorRepository;

    @Test
    public void saveFloor() {
        FloorDto floorDto = FloorDto.builder().number(5).build();
        String jsonRequest = objectMapper.writeValueAsString(floorDto);

        given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                    .when()
                        .post("http://localhost:8081/floors")
                            .then()
                                .statusCode(200)
                .body("id", equalTo(1))
                .body("number" , equalTo(5));
    }


    @Test
    public void updatedFloor() throws Exception {
        FloorDto floorDto = FloorDto.builder().number(4).id(1L).build();
        floorRepository.save(Floor.builder().number(1).build());

        String jsonRequest = objectMapper.writeValueAsString(floorDto);

        given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .when()
                .put("http://localhost:8081/floors/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("number" , equalTo(5));

    }

    @Test
    public void findByNumber() throws Exception {
        floorRepository.save(Floor.builder().number(1).build());

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:8081/floors/number/1")
                .then()
                .statusCode(200)
                .body("id",equalTo(1))
                .body("number",equalTo(1));
    }



}
