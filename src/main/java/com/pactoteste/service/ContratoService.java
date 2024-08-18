package com.pactoteste.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactoteste.entity.ClienteEntity;
import com.pactoteste.entity.ContratoEntity;
import com.pactoteste.repository.ContratoRepository;

@Service
public class ContratoService {

	@Autowired
	private ContratoRepository repositorio;
	
	
	public ContratoEntity salvarContrato(ClienteEntity clienteDoContrato, String descricao,
			Date dataInicio, Date dataFim) {
		
		ContratoEntity contrato = new ContratoEntity();
		contrato.setCliente(clienteDoContrato);
		contrato.setDescricao(descricao);
		contrato.setDataInicio(dataInicio);
		contrato.setDataFim(dataFim);
		return repositorio.save(contrato);
		
	}
	
	
}
