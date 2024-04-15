package com.example.RajeshDemoJp.cucumber.datasets;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class RunConfiguration {

    @Value("${app.url}")
    private String appUrl;
}
