package com.pactoteste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactoteste.entity.EmailEntity;
import com.pactoteste.entity.PessoaEntity;
import com.pactoteste.repository.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository repositorio;
	
	public EmailEntity salvarEmail(PessoaEntity pessoa, String email) {
		
		EmailEntity emailEntidade = new EmailEntity();
		emailEntidade.setPessoa(pessoa);
		emailEntidade.setEnderecoEmail(email);
		return repositorio.save(emailEntidade);
		
		
	}
	

}
