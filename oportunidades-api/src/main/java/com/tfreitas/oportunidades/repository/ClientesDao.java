package com.tfreitas.oportunidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfreitas.oportunidades.model.ClienteModel;

public interface ClientesDao extends JpaRepository<ClienteModel, Long> {

}
