package dev.cretara.spring3newfeatures.configuration;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@Slf4j
@EnableJpaAuditing
public class RestConfiguration {

    @Autowired
    public RestConfiguration() {
        // this is intentional
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}