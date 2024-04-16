package com.example.RajeshDemoJp.cucumber.steps;

import com.example.RajeshDemoJp.cucumber.Services.GetService;
import com.example.RajeshDemoJp.cucumber.Services.MakeComments;

import com.example.RajeshDemoJp.cucumber.Services.MakePostService;
import com.example.RajeshDemoJp.cucumber.datasets.RunConfiguration;
import com.example.RajeshDemoJp.cucumber.utils.Endpoints;
import com.example.RajeshDemoJp.cucumber.utils.RestAssuredAPI;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;


public class SocialNetworkAPISteps {

@Autowired
RunConfiguration runConfiguration;

@Autowired
MakePostService makePostService;

@Autowired
MakeComments makeComments;

@Autowired
GetService getService;


String endpoint="";

    @Given("an API endpoint to make a post")
    public void anAPIEndpointToMakeAPost() {
        endpoint=runConfiguration.getAppUrl()+ Endpoints.MAKE_POST;
        System.out.println("The endpoint to make post is "+endpoint);

    }


    @When("the user makes a post")
    public void theUserMakesAPost() throws IOException {

        makePostService.makePost(endpoint);

    }

    @Then("the post is created successfully with {int} status code")
    public void thePostIsCreatedSuccessfullyWithStatusCode(int statscode) {

        makePostService.validateStatusCode(statscode);

    }


    @Given("an API enpoint to post comments")
    public void anAPIEnpointToPostComments() {

        endpoint=runConfiguration.getAppUrl()+ Endpoints.MAKE_COMMENT;
        System.out.println("The endpoint to make comment is "+endpoint);
    }


    @When("the user makes a {string} with following details")
    public void theUserMakesAWithFollowingDetails(String comment) throws IOException {

        makeComments.makeComment(comment, endpoint);
    }

    @Then("the post should be created successfully with correct comment")
    public void thePostShouldBeCreatedSuccessfullyWithCorrectComment() {
        makeComments.validateMakeComment();
    }

    @Given("an API enpoint to get list of users")
    public void anAPIEnpointToGetListOfUsers() {
        endpoint=runConfiguration.getAppUrl()+ Endpoints.USERS;
        System.out.println("The endpoint to GET request is "+endpoint);

    }

    @When("the user makes a get request to fetch the list of users")
    public void theUserMakesAGetRequestToFetchTheListOfUsers() {

        getService.makeGetRequest(endpoint);

    }

    @Then("I validate the status code and first element name")
    public void iValidateTheStatusCodeAndFirstElementName() {
        getService.validateGetResponse();
    }

    @And("I copy the userslist to a json file")
    public void iCopyTheUserslistToAJsonFile() {
        getService.writeResponseToJsonFile();
    }
}
