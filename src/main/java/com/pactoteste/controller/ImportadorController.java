package com.pactoteste.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactoteste.dto.DtoDadosCliente;
import com.pactoteste.service.ImportadorService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/importador")
public class ImportadorController {


	@Autowired
	private ImportadorService importadorService;
	
	@PostMapping()
	public ResponseEntity<String> importar(@RequestBody List<DtoDadosCliente> listaDtoCliente) throws ParseException {
		importadorService.salvar(listaDtoCliente);	
		return ResponseEntity.ok("Dados importador com sucesso verifique os logs para analisar erros!");
	}


}
