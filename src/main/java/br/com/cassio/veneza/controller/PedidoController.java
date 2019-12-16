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

import br.com.cassio.veneza.model.Pedido;
import br.com.cassio.veneza.repository.RepositoryPedido;

@CrossOrigin
@RestController
@RequestMapping(value = "/pedidos", produces = "application/json")
public class PedidoController {
    private final Logger logger = getLogger(PedidoController.class);

    private final RepositoryPedido repository;

    public PedidoController(final RepositoryPedido repository) {
        this.repository = repository;
    }

    @GetMapping(produces = "application/json")
    public List<Pedido> index() {
    	logger.info("Recuperando clientes, método index.");
    	return repository.findAll();
    }

    @GetMapping(value = "/{_id}")
    public Pedido show(@PathVariable final String _id) {
    	logger.info("Recuperando cliente {}, método show.", _id);
        return repository.findBy_id(_id);
    }

    @PostMapping
    public Pedido create(@RequestBody final Pedido pedido) {
    	logger.info("Criando pedido.");
        return repository.save(pedido);
    }

    @PutMapping(value = "/{_id}")
    public Pedido update(@RequestBody final Pedido pedido, @PathVariable final String _id) {
    	logger.info("Atualizando pedido {}.", _id);
        return repository.save(pedido);
    }

}
