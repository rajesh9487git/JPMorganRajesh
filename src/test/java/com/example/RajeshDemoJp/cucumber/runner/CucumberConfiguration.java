package com.example.RajeshDemoJp.cucumber.runner;

import com.example.RajeshDemoJp.cucumber.RajeshDemoJpApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = RajeshDemoJpApplication.class)
public class CucumberConfiguration
{
}
