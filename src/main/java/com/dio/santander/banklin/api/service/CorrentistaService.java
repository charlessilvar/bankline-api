package com.dio.santander.banklin.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banklin.api.dto.CorrentistaDTO;
import com.dio.santander.banklin.api.model.Conta;
import com.dio.santander.banklin.api.model.Correntista;
import com.dio.santander.banklin.api.repository.ICorrentistaRepository;

@Service
public class CorrentistaService {

	@Autowired
	private ICorrentistaRepository repository;
	
	public void save(CorrentistaDTO correntistaDTO) {
		Correntista correntista = new Correntista();
		
		correntista.setNome(correntistaDTO.getNome());
		correntista.setCpf(correntistaDTO.getCpf());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		repository.save(correntista);
	}
}
