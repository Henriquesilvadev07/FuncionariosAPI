package com.funcionarios.Funcionarios.repository;

import com.funcionarios.Funcionarios.model.FuncionariosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<FuncionariosModel, Long> {
}
