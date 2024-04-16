package com.example.RajeshDemoJp.cucumber.Services;

import com.example.RajeshDemoJp.cucumber.utils.RestAssuredAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Component
public class GetService {

    @Autowired
    RestAssuredAPI restAssuredAPI;

    Response resp;
    public void makeGetRequest(String endpoint){

        try{
            resp=restAssuredAPI.GetRequest(endpoint);
            System.out.println("The get request was successfull");

        }catch (Exception e){
            System.out.println();
            System.out.println("The get request was NOT successfull");
            e.printStackTrace();
        }


    }

    public void validateGetResponse(){

            resp.then().assertThat().statusCode(200);

            JsonPath js = new JsonPath(resp.asString());
            String firstElemeneName = js.get("[0].name");
            assertEquals("Leanne Graham",firstElemeneName );

    }


    // this method will write the user list to a json file
    public void writeResponseToJsonFile() {
        String responseString = resp.getBody().asString();
        try (FileWriter fileWriter = new FileWriter("src/test/resources/JsonFiles/UsersList.json")) {
            fileWriter.write(responseString);
            System.out.println("The body was copied to the json file successfully");
        } catch (IOException e) {

            System.out.println("The body was NOT copied to the json file successfully");
            e.printStackTrace();
        }
    }
}
