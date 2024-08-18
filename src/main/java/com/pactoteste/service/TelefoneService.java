package com.pactoteste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactoteste.entity.PessoaEntity;
import com.pactoteste.entity.TelefoneEntity;
import com.pactoteste.repository.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repositorio;
	
	public TelefoneEntity salvarTelefones (PessoaEntity pessoa, String numero, String tipo){
		
		TelefoneEntity telefoneEntidade =  new TelefoneEntity();
		telefoneEntidade.setPessoa(pessoa);
		telefoneEntidade.setNumero(numero);
		telefoneEntidade.setTipo(tipo);
		return repositorio.save(telefoneEntidade);
		
		
	}
	
}
