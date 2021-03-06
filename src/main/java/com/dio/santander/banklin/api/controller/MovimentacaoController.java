package com.dio.santander.banklin.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banklin.api.dto.MovimentacaoDTO;
import com.dio.santander.banklin.api.model.Movimentacao;
import com.dio.santander.banklin.api.repository.IMovimentacaoRepository;
import com.dio.santander.banklin.api.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

	@Autowired
	private IMovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody MovimentacaoDTO movimentacao) {
		service.save(movimentacao);
	}
}
