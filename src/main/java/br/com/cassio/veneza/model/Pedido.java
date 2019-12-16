package br.com.cassio.veneza.model;

import static java.time.LocalDateTime.now;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedidos")
public class Pedido {
    @Id
    private String _id;

    private String cpf;

    private Tipo tipo;
    
    private BigDecimal valor;
    
    private Boolean pago;
    
    private LocalDateTime criadoEm = now();

	@Deprecated
	public Pedido() {
		this(null, null, null, null);
	}

	public Pedido(final String cpf, final Tipo tipo, final BigDecimal valor, final Boolean pago) {
		this.cpf = cpf;
		this.tipo = tipo;
		this.valor = valor;
		this.pago = pago;
    }

    public String get_id() {
        return _id;
    }

    public String getCpf() {
    	return cpf;
    }
    
    public Tipo getTipo() {
    	return tipo;
    }
    
    public BigDecimal getValor() {
    	return valor;
    }
    
    public Boolean getPago() {
    	return pago;
    }
    
    public LocalDateTime getCriadoEm() {
    	return criadoEm;
    }
    
    public void pay() {
    	pago = true;
    }
    
    public enum Tipo {
    	COMPRA, CONSERTO
    }
}
