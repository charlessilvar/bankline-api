package com.dio.santander.banklin.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.banklin.api.model.Movimentacao;

public interface IMovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}
