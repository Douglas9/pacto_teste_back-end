package com.pactoteste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactoteste.entity.PessoaEntity;
import com.pactoteste.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repositorio;
    
	public PessoaEntity salvar(PessoaEntity pessoa){
		if(!verificaClienteImportado(pessoa.getCpf())) {
			return repositorio.save(pessoa);
		}else {
			return null;
		}
		
	}
	
	private boolean verificaClienteImportado(String cpf) {
		return repositorio.existeCPF(cpf);
	}
	
}
