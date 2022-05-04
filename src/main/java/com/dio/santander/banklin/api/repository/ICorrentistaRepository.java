package com.dio.santander.banklin.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.banklin.api.model.Correntista;

public interface ICorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
