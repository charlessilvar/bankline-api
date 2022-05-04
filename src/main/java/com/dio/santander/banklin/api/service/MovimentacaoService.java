package com.dio.santander.banklin.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.banklin.api.dto.MovimentacaoDTO;
import com.dio.santander.banklin.api.model.Correntista;
import com.dio.santander.banklin.api.model.Movimentacao;
import com.dio.santander.banklin.api.model.MovimentacaoTipo;
import com.dio.santander.banklin.api.repository.ICorrentistaRepository;
import com.dio.santander.banklin.api.repository.IMovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private IMovimentacaoRepository repository;

	@Autowired
	private ICorrentistaRepository repositoryCorrentista;

	public void save(MovimentacaoDTO movimentacaoDTO) {
		Movimentacao movimentacao = new Movimentacao();
		Double valor = movimentacaoDTO.getTipo() == MovimentacaoTipo.RECEITA ? movimentacaoDTO.getValor()
				: movimentacaoDTO.getValor() * (-1);

		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(movimentacaoDTO.getDescricao());
		movimentacao.setIdConta(movimentacaoDTO.getIdConta());
		movimentacao.setTipo(movimentacaoDTO.getTipo());
		movimentacao.setValor(valor);

		Correntista correntista = repositoryCorrentista.findById(movimentacaoDTO.getIdConta()).orElse(null);
		if (correntista == null) {
			
		} else {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			repositoryCorrentista.save(correntista);
			repository.save(movimentacao);
		}
	}
}
