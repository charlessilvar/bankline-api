package com.dio.santander.banklin.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.banklin.api.dto.CorrentistaDTO;
import com.dio.santander.banklin.api.model.Correntista;
import com.dio.santander.banklin.api.repository.ICorrentistaRepository;
import com.dio.santander.banklin.api.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

	@Autowired
	private ICorrentistaRepository repository;
	
	@Autowired
	private CorrentistaService service;
	
	@GetMapping
	public List<Correntista> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody CorrentistaDTO correntista) {
		service.save(correntista);
	}
}
