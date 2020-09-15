package dev.grabros.osikdang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OSikdangApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(OSikdangApplication.class);
//        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

}
