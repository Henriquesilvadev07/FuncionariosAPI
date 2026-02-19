package com.funcionarios.Funcionarios.service;

import com.funcionarios.Funcionarios.model.FuncionariosModel;
import com.funcionarios.Funcionarios.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;


    public FuncionariosModel salvarFuncionario(FuncionariosModel funcionarios) {
        return funcionariosRepository.save(funcionarios);
    }


    public List<FuncionariosModel> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }


    public FuncionariosModel acharPorId(Long id) {
        return funcionariosRepository.findById(id).orElseThrow();
    }


    public FuncionariosModel atualizarPorId(FuncionariosModel funcionariosAtualizados, Long id) {
        FuncionariosModel funcionarios = funcionariosRepository.findById(id).orElseThrow();

        funcionarios.setNome(funcionariosAtualizados.getNome());
        funcionarios.setCargo(funcionariosAtualizados.getCargo());
        funcionarios.setSalario(funcionariosAtualizados.getSalario());
        funcionarios.setSetor(funcionariosAtualizados.getSetor());

        return funcionariosRepository.save(funcionarios);
    }


    public void deletarPorId (Long id) {
        if (funcionariosRepository.existsById(id)) {
            funcionariosRepository.deleteById(id);
        }
    }


}
