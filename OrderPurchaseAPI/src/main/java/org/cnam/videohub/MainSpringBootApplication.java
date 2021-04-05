package org.cnam.videohub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan("org.cnam.videohub.repository.model")
@EnableJpaRepositories("org.cnam.videohub.repository")
@EnableTransactionManagement
@EnableAutoConfiguration
public class MainSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainSpringBootApplication.class, args);
    }
}


