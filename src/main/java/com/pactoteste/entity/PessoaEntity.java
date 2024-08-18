package com.pactoteste.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PESSOA")
public class PessoaEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String matricula;

    @Column(nullable = false)
    private String nomeCompleto;
    @Column(nullable = false)
    private String cpf;
    private Date dataCadastro;
    private Date dataNascimento;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TelefoneEntity> telefones;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EnderecoEntity> enderecos;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EmailEntity> emails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<TelefoneEntity> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneEntity> telefones) {
		this.telefones = telefones;
	}

	public List<EnderecoEntity> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoEntity> enderecos) {
		this.enderecos = enderecos;
	}

	public List<EmailEntity> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailEntity> emails) {
		this.emails = emails;
	}
    
    
    
	    

}
