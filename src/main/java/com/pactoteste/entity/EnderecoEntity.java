package com.pactoteste.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class EnderecoEntity {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 	@Column(name = "id", updatable = false, nullable = false)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "id_pessoa", nullable = false)
	    private PessoaEntity pessoa;
	    private String logradouro;
	    private String numero;
	    private String complemento;
	    private String bairro;
	    private String cep;
	    private String cidade;
	    private String estado;
	    private String pais;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public PessoaEntity getPessoa() {
			return pessoa;
		}

		public void setPessoa(PessoaEntity pessoa) {
			this.pessoa = pessoa;
		}

		public String getLogradouro() {
			return logradouro;
		}

		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}
	    
	    

}
