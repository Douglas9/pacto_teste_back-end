package com.pactoteste.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactoteste.dto.DtoDadosCliente;
import com.pactoteste.entity.EmailEntity;
import com.pactoteste.entity.EnderecoEntity;
import com.pactoteste.entity.PessoaEntity;
import com.pactoteste.entity.TelefoneEntity;
import com.pactoteste.enums.TipoDeTelefone;
import com.pactoteste.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private static Logger logger = LogManager.getLogger(PessoaService.class.getName());
	
	@Autowired
	private PessoaRepository repositorio;
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
	public PessoaEntity salvar(DtoDadosCliente dados) throws ParseException{
		
		PessoaEntity pessoa = new PessoaEntity();
		pessoa.setMatricula(dados.getMatricula());
		pessoa.setNomeCompleto(dados.getNomeCompleto());
		pessoa.setCpf(dados.getCpf());
		pessoa.setDataNascimento(formatter.parse(dados.getDataNascimento()));
		pessoa.setDataCadastro(formatter.parse(dados.getDataCadastro()));
		
		EmailEntity emailEntidade = new EmailEntity();
		emailEntidade.setPessoa(pessoa);
		emailEntidade.setEnderecoEmail(dados.getEmail());
		
		TelefoneEntity telefoneCelular =  new TelefoneEntity();
		telefoneCelular.setPessoa(pessoa);
		telefoneCelular.setNumero(dados.getTelefoneCelular());
		telefoneCelular.setTipo(TipoDeTelefone.CELULAR.toString());
		
		TelefoneEntity telefoneResidencial =  new TelefoneEntity();
		telefoneResidencial.setPessoa(pessoa);
		telefoneResidencial.setNumero(dados.getTelefoneResidencial());
		telefoneResidencial.setTipo(TipoDeTelefone.RESIDENCIAL.toString());
		
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setPessoa(pessoa);
		endereco.setBairro(dados.getBairro());
		endereco.setCep(dados.getCep());
		endereco.setCidade(dados.getCidade());
		endereco.setComplemento(dados.getComplemento());
		endereco.setEstado(dados.getEstado());
		endereco.setNumero(dados.getNumero());
		endereco.setLogradouro(dados.getLogradouro());
		endereco.setPais(dados.getPais());
		
		pessoa.setEnderecos(Arrays.asList(endereco));
		
		pessoa.setTelefones(Arrays.asList(telefoneCelular, telefoneResidencial));				
		pessoa.setEmails(Arrays.asList(emailEntidade));	
		
		
		
		if(!verificaClienteImportado(pessoa.getCpf())) {
			return repositorio.save(pessoa);
		}else {
			logger.error("CLIENTE COM O CPF " + dados.getCpf() + " JÁ IMPORTADA ANTERIORMENTE");
			System.out.println("CLIENTE COM O CPF " + dados.getCpf() + " JÁ IMPORTADA ANTERIORMENTE");
			return null;
		}
		
	}
	
	private boolean verificaClienteImportado(String cpf) {
		return repositorio.existeCPF(cpf);
	}
	
}
