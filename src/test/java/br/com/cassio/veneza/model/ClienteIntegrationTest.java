package br.com.cassio.veneza.model;

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
    public void testSaveCliente() {
		final Cliente cliente = new Cliente("11048916979");
        assertNotNull(repository.save(cliente));
    }

    @Test
    public void testRetrieve() {
    	final Cliente cliente = repository.findFirstByCpf("11048916979");
    	assertNotNull(cliente);
    }
}
