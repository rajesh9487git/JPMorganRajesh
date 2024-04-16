package com.example.RajeshDemoJp.cucumber.utils;

import com.example.RajeshDemoJp.cucumber.Pojo.MakeComment;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class RestAssuredAPI {

public Response postRequest(String endpoint){

    return RestAssured.given().contentType("application/json; charset=UTF-8").log().all().when().post(endpoint).then().log().all()
            .extract().response();
}


public Response postComment(String endpoint, MakeComment makeComment){

    return RestAssured.given().contentType("application/json; charset=UTF-8").log().all().body(makeComment).when().post(endpoint).then().log().all()
            .extract().response();
}

    public Response postComment(String endpoint){

        return RestAssured.given().contentType("application/json; charset=UTF-8").log().all().when().post(endpoint).then().log().all()
                .extract().response();
    }


public Response GetRequest(String endpoint){

    return RestAssured.given().contentType("application/json; charset=UTF-8").log().all().when().get(endpoint).then().log().all()
            .extract().response();
}



}
