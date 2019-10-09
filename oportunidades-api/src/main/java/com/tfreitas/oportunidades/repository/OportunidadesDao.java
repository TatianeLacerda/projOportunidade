package com.tfreitas.oportunidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfreitas.oportunidades.model.OportunidadeModel;

public interface OportunidadesDao extends JpaRepository<OportunidadeModel, Long> {

}
