package io.github.marceloacacio.service;

import io.github.marceloacacio.model._Cliente;
import io.github.marceloacacio.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    public void salvarCliente(_Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(_Cliente cliente){
        //Aplica validações
    }
}
