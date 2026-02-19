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

    @PostMapping
    public FuncionariosModel salvarFuncionario(@RequestBody FuncionariosModel funcionarios) {
        return funcionariosRepository.save(funcionarios);
    }

    @GetMapping
    public List<FuncionariosModel> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }

    @GetMapping
    public FuncionariosModel acharPorId(@PathVariable Long id) {
        return funcionariosRepository.findById(id).orElseThrow();
    }

    @PutMapping
    public FuncionariosModel atualizarPorId(@RequestBody FuncionariosModel funcionariosAtualizados, @PathVariable Long id) {
        FuncionariosModel funcionarios = funcionariosRepository.findById(id).orElseThrow();

        funcionarios.setNome(funcionariosAtualizados.getNome());
        funcionarios.setCargo(funcionariosAtualizados.getCargo());
        funcionarios.setSalario(funcionariosAtualizados.getSalario());
        funcionarios.setSetor(funcionariosAtualizados.getSetor());

        return funcionariosRepository.save(funcionarios);
    }

    @DeleteMapping
    public void deletarPorId (Long id) {
        if (funcionariosRepository.existsById(id)) {
            funcionariosRepository.deleteById(id);
        }
    }


}
