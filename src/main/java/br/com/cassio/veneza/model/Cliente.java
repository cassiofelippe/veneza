package br.com.cassio.veneza.model;

import static java.time.LocalDateTime.now;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {
    @Id
    private String _id;

    private String cpf;
    
    private LocalDateTime criadoEm = now();

	@Deprecated
	public Cliente() {
		this(null);
	}

	public Cliente(final String cpf) {
		this.cpf = cpf;
		this.criadoEm = now();
    }

    public String get_id() {
        return _id;
    }

    public String getCpf() {
    	return cpf;
    }
    
    public LocalDateTime getCriadoEm() {
    	return criadoEm;
    }
    
}
