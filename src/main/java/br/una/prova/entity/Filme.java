package br.una.prova.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer id;
	
    @NotBlank(message = "Preencha aqui")
    @NotNull
    private String nome;
    @NotNull
    private Integer ano;
    
    private String diretor;
    
    @Min(value=0)
	@Max(value=10)
	private int notaImdb;

    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public int getNotaImdb() {
		return notaImdb;
	}

	public void setNotaImdb(int notaImdb) {
		this.notaImdb = notaImdb;
	}

	
}
