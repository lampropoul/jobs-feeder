package org.lampropoul.jobsfeeder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class JobsFeederApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobsFeederApplication.class, args);
    }

}
