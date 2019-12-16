package br.com.cassio.veneza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.cassio.veneza.model.Pedido;

public interface RepositoryPedido extends MongoRepository<Pedido, String> {

    public Pedido findBy_id(final String _id);

    public Pedido findFirstByCpf(final String cpf);

}
