package com.pactoteste.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactoteste.entity.ClienteEntity;
import com.pactoteste.entity.PessoaEntity;
import com.pactoteste.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;
	
	
	public ClienteEntity salvarCliente(PessoaEntity pessoa,
			String plano, Date dataLancamento, Date dataInicio, Date dataFim) {
		
		ClienteEntity cliente = new ClienteEntity();
		cliente.setPessoa(pessoa);
		cliente.setPlanoDescricao(plano);
		cliente.setDataLancamento(dataLancamento);
		cliente.setDataInicio(dataInicio);
		cliente.setDataFim(dataFim);
		return repositorio.save(cliente);
	}
	
	
}
