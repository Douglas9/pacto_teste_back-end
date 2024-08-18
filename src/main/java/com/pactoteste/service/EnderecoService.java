package com.pactoteste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactoteste.entity.EnderecoEntity;
import com.pactoteste.entity.PessoaEntity;
import com.pactoteste.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repositorio;
	
	public EnderecoEntity salvarEndereco(PessoaEntity pessoa, EnderecoEntity dadosDoEndereco) {
		
		EnderecoEntity endereco = new EnderecoEntity();
		endereco.setPessoa(pessoa);
		endereco.setBairro(dadosDoEndereco.getBairro());
		endereco.setCep(dadosDoEndereco.getCep());
		endereco.setCidade(dadosDoEndereco.getCidade());
		endereco.setComplemento(dadosDoEndereco.getComplemento());
		endereco.setEstado(dadosDoEndereco.getEstado());
		endereco.setNumero(dadosDoEndereco.getNumero());
		endereco.setLogradouro(dadosDoEndereco.getLogradouro());
		endereco.setPais(dadosDoEndereco.getPais());
		
		return repositorio.save(endereco);
		
	}

}
