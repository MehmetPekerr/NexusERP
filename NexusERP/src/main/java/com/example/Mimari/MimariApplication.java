package com.example.Mimari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.error.ErrorWebFluxAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(
    scanBasePackages = "com.example.Mimari",
    exclude = {
        ErrorWebFluxAutoConfiguration.class, 
        ErrorMvcAutoConfiguration.class,
        WebFluxAutoConfiguration.class, // WebFlux yapılandırmasını devre dışı bırakıyoruz
        HttpHandlerAutoConfiguration.class // WebFlux için kullanılan HTTP handler'ı da devre dışı bırakıyoruz
    }
)
@EntityScan("model")
@EnableJpaRepositories("repository")
public class MimariApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MimariApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MimariApplication.class);
    }
}
