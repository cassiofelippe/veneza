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
    
    private String nome;

    private String telefone;
    
    private LocalDateTime criadoEm = now();

	@Deprecated
	public Cliente() {
		this(null, null, null);
	}

	public Cliente(final String cpf, final String nome, final String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.criadoEm = now();
    }

    public String get_id() {
        return _id;
    }

    public String getCpf() {
    	return cpf;
    }
    
    public String getNome() {
    	return nome;
    }
    
    public String getTelefone() {
    	return telefone;
    }
    
    public void setNome(final String nome) {
    	this.nome = nome;
    }
    
    public LocalDateTime getCriadoEm() {
    	return criadoEm;
    }
    
}
