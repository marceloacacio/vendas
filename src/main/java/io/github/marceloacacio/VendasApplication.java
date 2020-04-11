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

import javax.xml.transform.sax.SAXSource;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

     @Bean
     public CommandLineRunner into(@Autowired ClientesRepository clientesRepository){
         return args -> {
             System.out.println("Salvando Clientes");
             clientesRepository.salvar(new Cliente("Marcelo"));
             clientesRepository.salvar(new Cliente("João"));
             clientesRepository.salvar(new Cliente("Outro cliente"));

             System.out.println("Buscando todos os clientes");
             List<Cliente> todosClientes = clientesRepository.obterTodos();
             todosClientes.forEach(System.out::println);

//             System.out.println("Atualizando todos os clientes");
//             todosClientes.forEach(c -> {
//                 c.setNome(c.getNome()+" Atualizado");
//                 clientesRepository.atualizar(c);
//             });
//
//             todosClientes = clientesRepository.obterTodos();
//             todosClientes.forEach(System.out::println);
//
//             System.out.println("Buscando cliente por nome");
//             clientesRepository.buscarPorNome("cli").forEach(System.out::println);
//
//             System.out.println("Deletar clientes");
//             clientesRepository.obterTodos().forEach(c -> {
//                 clientesRepository.deletar(c);
//             });
//
//             todosClientes = clientesRepository.obterTodos();
//             if(todosClientes.isEmpty()){
//                 System.out.println("Nenhun cliente encontrado");
//             }else{
//                 todosClientes.forEach(System.out::println);
//             }

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
