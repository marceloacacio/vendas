package io.github.marceloacacio;

import io.github.marceloacacio.domain.entity.Cliente;
import io.github.marceloacacio.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

     @Bean
     public CommandLineRunner into(@Autowired ClientesRepository clientesRepository){
         return args -> {
             clientesRepository.salvar(new Cliente("Marcelo"));
             clientesRepository.salvar(new Cliente("João"));

             List<Cliente> todosClientes = clientesRepository.obterTodos();
             todosClientes.forEach(System.out::println);

         };
     }


    //@Autowired
    //@Qualifier("applicationName")
    //private String applicationName;

//    @Cachorro
//    private Animal animal;
//
//    @Bean(name = "executarAnimal")
//    public CommandLineRunner executar(){
//        return args -> {
//            this.animal.fazerBarulho();
//        };
//    }


//    @Value("${application.name}")
//    private String applicationName;
//
//    @GetMapping("/hello")
//    public String helloWorld(){
//        return applicationName;
//    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class,args);
    }

}
