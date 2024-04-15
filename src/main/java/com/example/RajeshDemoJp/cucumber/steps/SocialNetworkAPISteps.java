package com.example.RajeshDemoJp.cucumber.steps;

import com.example.RajeshDemoJp.cucumber.datasets.RunConfiguration;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SocialNetworkAPISteps {



@Autowired
RunConfiguration runConfiguration;

    @Given("an API endpoint to make a post")
    public void anAPIEndpointToMakeAPost() {

        System.out.println("Hi this is my first code");

        String url=runConfiguration.getAppUrl();

        System.out.println("the url is this "+url);



    }
}
