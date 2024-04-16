package com.example.RajeshDemoJp.cucumber.Services;

import com.example.RajeshDemoJp.cucumber.utils.RestAssuredAPI;


import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MakePostService {

    @Autowired
    RestAssuredAPI restAssuredAPI;


Response resp;
    public void makePost(String endpoint) throws IOException {

        try{

            resp=restAssuredAPI.postRequest(endpoint);
            System.out.println("The post request for comments is successful");

        }catch (Exception e){

            System.out.println("The post request for comments is NOT successful");
            e.printStackTrace();

        }
    }

    public void validateStatusCode(int statscode){


            resp.then().log().all().assertThat().statusCode(statscode);
            System.out.println("The validation of status code is successfull");

    }
}
