package br.com.cassio.veneza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cassio.veneza.model.Cliente;

public interface RepositoryCliente extends MongoRepository<Cliente, String> {

    public Cliente findBy_id(final String _id);

    public Cliente findFirstByCpf(final String cpf);

}
