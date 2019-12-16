package br.com.cassio.veneza.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.cassio.veneza.repository.RepositoryCliente;

@SpringBootTest
@TestInstance(PER_CLASS)
@ExtendWith(SpringExtension.class)
public class ClienteIntegrationTest {

	@Autowired
	private RepositoryCliente repository;

	@BeforeAll
    public void testCreate() {
		final Cliente cliente = new Cliente("11048916979", "Cassio L Z F Felippe");
        assertNotNull(repository.save(cliente));
    }

    @Test
    public void testRetrieve() {
    	final Cliente cliente = repository.findFirstByCpf("11048916979");
    	assertNotNull(cliente);
    }
    
    @Test
    public void testUpdate() {
    	final Cliente cliente = repository.findFirstByCpf("11048916979");
    	assertEquals("11048916979", cliente.getCpf());
    	assertEquals("Cassio L Z F Felippe", cliente.getNome());
    	final String id = cliente.get_id();
    	cliente.setNome("Cassio Luis Zamignan Forte Felippe");
    	assertEquals("Cassio Luis Zamignan Forte Felippe", cliente.getNome());
    	repository.save(cliente);

    	assertEquals("Cassio Luis Zamignan Forte Felippe", repository.findBy_id(id).getNome());
    }
    
    @Test
    public void testCreateAndDelete() {
		final Cliente cliente = new Cliente("63263338730", "Alan Jackson");
        assertNotNull(repository.save(cliente));
        repository.delete(cliente);
    	assertEquals(null, repository.findFirstByCpf("63263338730"));
    }
}
