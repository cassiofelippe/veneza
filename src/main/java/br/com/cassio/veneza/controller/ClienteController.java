package br.com.cassio.veneza.controller;

import static org.apache.logging.log4j.LogManager.getLogger;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cassio.veneza.model.Cliente;
import br.com.cassio.veneza.repository.RepositoryCliente;

@CrossOrigin
@RestController
@RequestMapping(value = "/clientes", produces = "application/json")
public class ClienteController {
    private final Logger logger = getLogger(ClienteController.class);

    private final RepositoryCliente repository;

    public ClienteController(final RepositoryCliente repository) {
        this.repository = repository;
    }

    @GetMapping(produces = "application/json")
    public List<Cliente> index() {
    	logger.info("Recuperando clientes, método index.");
    	return repository.findAll();
    }

    @GetMapping(value = "/{_id}")
    public Cliente show(@PathVariable final String _id) {
    	logger.info("Recuperando cliente {}, método show.", _id);
        return repository.findBy_id(_id);
    }

    @PostMapping
    public Cliente create(@RequestBody final Cliente cliente) {
    	logger.info("Criando cliente.");
        return repository.save(cliente);
    }

    @PutMapping(value = "/{_id}")
    public Cliente update(@RequestBody final Cliente cliente, @PathVariable final String _id) {
    	logger.info("Atualizando cliente {}.", _id);
        return repository.save(cliente);
    }

}
