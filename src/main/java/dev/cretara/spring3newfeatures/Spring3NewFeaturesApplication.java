package dev.cretara.spring3newfeatures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Spring3NewFeaturesApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring3NewFeaturesApplication.class, args);
    }

}
