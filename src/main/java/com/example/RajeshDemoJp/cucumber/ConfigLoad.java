package com.example.RajeshDemoJp.cucumber;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:config/runconfiguration.properties"})
public class ConfigLoad {
}
