package com.marchuk0;


import com.marchuk0.commands.CommandConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CommandConfiguration.class)
public class Main{
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
