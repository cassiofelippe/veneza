package br.com.cassio.veneza.model;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.cassio.veneza.model.Pedido.Tipo;
import br.com.cassio.veneza.repository.RepositoryPedido;

@SpringBootTest
@TestInstance(PER_CLASS)
@ExtendWith(SpringExtension.class)
public class PedidoIntegrationTest {

	@Autowired
	private RepositoryPedido repository;

	@BeforeAll
    public void testCreate() {
		final Pedido pedido = new Pedido("11048916979", Tipo.COMPRA, new BigDecimal("200.00"), FALSE);
        assertNotNull(repository.save(pedido));
    }

    @Test
    public void testRetrieve() {
    	final Pedido pedido = repository.findFirstByCpf("11048916979");
    	assertNotNull(pedido);
    }
    
    @Test
    public void testUpdate() {
    	final Pedido pedido = repository.findFirstByCpf("11048916979");
    	assertEquals(FALSE, pedido.getPago());
    	final String id = pedido.get_id();
    	pedido.pay();
    	assertEquals(TRUE, pedido.getPago());
    	repository.save(pedido);

    	assertEquals(TRUE, repository.findBy_id(id).getPago());
    }
    
    @Test
    public void testCreateAndDelete() {
		final Pedido pedido = new Pedido("63263338730", Tipo.CONSERTO, new BigDecimal("30.00"), TRUE);
        assertNotNull(repository.save(pedido));
        repository.delete(pedido);
    	assertEquals(null, repository.findFirstByCpf("63263338730"));
    }
}
