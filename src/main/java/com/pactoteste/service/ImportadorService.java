package com.pactoteste.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactoteste.dto.DtoDadosCliente;
import com.pactoteste.entity.ClienteEntity;
import com.pactoteste.entity.PessoaEntity;
import com.pactoteste.utils.Utils;

import io.micrometer.common.util.StringUtils;

@Service
public class ImportadorService {

	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ContratoService contratoService;

	private static Logger logger = LogManager.getLogger(DtoDadosCliente.class.getName());
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public void salvar(List<DtoDadosCliente> listaDtoCliente) throws ParseException {
		int index = 1;
		for (DtoDadosCliente dados : listaDtoCliente) {

			if (validar(dados, index)) {
				PessoaEntity pessoaSalva = pessoaService.salvar(dados);
				
				if (pessoaSalva != null) {
					ClienteEntity clienteSalvo = clienteService.salvarCliente(pessoaSalva, dados.getPlanoDescricao(),
							formatter.parse(dados.getDataLancamento()),
							formatter.parse(dados.getDataInicio()), formatter.parse(dados.getDataFim()));

					contratoService.salvarContrato(clienteSalvo, dados.getPlanoDescricao(),
							formatter.parse(dados.getDataInicio()), formatter.parse(dados.getDataFim()));
				} else {
					logger.error("CLIENTE COM O CPF " + dados.getCpf() + " JÁ IMPORTADA ANTERIORMENTE");
					System.out.println("CLIENTE COM O CPF " + dados.getCpf() + " JÁ IMPORTADA ANTERIORMENTE");
				}
			}
			index++;
		}

	}

	private boolean validar(DtoDadosCliente dadosImportacao, int linha) {
		logger.info("Processando planilha");

		if (StringUtils.isBlank(dadosImportacao.getNomeCompleto())) {
			logger.error(" Erro: Nome do cliente não informado na linha " + linha);
			System.out.println("Erro: Nome do cliente não informado na linha " + linha);
			return false;
		}

		if (dadosImportacao.getCpf().isEmpty()) {
			logger.error(" Erro: Cpf não informado erro na linha " + linha);
			System.out.println("Erro: Cpf não informado erro na linha " + linha);
			return false;
		}

		if (!Utils.validaCpf(dadosImportacao.getCpf())) {
			logger.error(" Erro: CPF invalido erro na linha " + linha);
			System.out.println("Erro: CPF invalido erro na linha " + linha);
			return false;
		}
		if (!Utils.validaEmail(dadosImportacao.getEmail()) && dadosImportacao.getEmail() != null) {
			logger.error("Erro: Email invalido na linha + " + linha);
			System.out.println("Erro: Email invalido na linha + " + linha);
			return false;
		}

		if (!Utils.validaTelefone(dadosImportacao.getTelefoneCelular())
				&& dadosImportacao.getTelefoneCelular() != null) {
			logger.error("Erro: telefone celular invalido na linha + " + linha);
			System.out.println("Erro: telefone celular invalido na linha + " + linha);
			return false;
		}

		if (!Utils.validaTelefone(dadosImportacao.getTelefoneResidencial())
				&& dadosImportacao.getTelefoneResidencial() != null) {
			logger.error("Erro: telefone Residencial invalido na linha + " + linha);
			System.out.println("Erro: telefone Residencial invalido na linha + " + linha);
			return false;
		}

		if (!Utils.validarData(dadosImportacao.getDataCadastro())) {
			logger.error("Erro: Data de Cadastro no formato invalido na linha + " + linha);
			System.out.println("Erro: Data de Cadastro no formato invalido na linha + " + linha);
			return false;
		}

		if (!Utils.validarData(dadosImportacao.getDataInicio())) {
			logger.error("Erro: Data de Inicio no formato invalido na linha + " + linha);
			System.out.println("Erro: Data de Inicio no formato invalido na linha + " + linha);
			return false;
		}

		if (!Utils.validarData(dadosImportacao.getDataFim())) {
			logger.error("Erro: Data Fim no formato invalido na linha + " + linha);
			System.out.println("Erro: Data Fim no formato invalido na linha + " + linha);
			return false;
		}

		if (!Utils.validarData(dadosImportacao.getDataLancamento())) {
			logger.error("Erro: Data de Lançamento no formato invalido na linha + " + linha);
			System.out.println("Erro: Data de Lançamento no formato invalido na linha + " + linha);
			return false;
		}

		if (!Utils.validarData(dadosImportacao.getDataNascimento())) {
			logger.error("Erro: Data de Nascimento no formato invalido na linha + " + linha);
			System.out.println("Erro: Data de Nascimento no formato invalido na linha + " + linha);
			return false;
		}

		return true;
	}

}
