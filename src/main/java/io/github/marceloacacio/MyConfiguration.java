package io.github.marceloacacio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class MyConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Teste");
        };
    }

    @Bean("applicationName")
    public String applicationName(){
        return "Sistema de vendas";
    }

}
