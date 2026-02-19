package com.funcionarios.Funcionarios.controller;

import com.funcionarios.Funcionarios.model.FuncionariosModel;
import com.funcionarios.Funcionarios.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FuncionariosController {

    @Autowired
    private FuncionariosService funcionariosService;

    @PostMapping("/salvar")
    public ResponseEntity<FuncionariosModel> salvarFuncionario (@RequestBody FuncionariosModel funcionarios) {
        return ResponseEntity.ok(funcionariosService.salvarFuncionario(funcionarios));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosModel> procurarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(funcionariosService.acharPorId(id));

    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionariosModel>> listarFuncionarios() {
        return ResponseEntity.ok(funcionariosService.listarFuncionarios());
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosModel> atualizarPorId (@RequestBody FuncionariosModel funcionarios,@PathVariable Long id) {
        return ResponseEntity.ok(funcionariosService.atualizarPorId(funcionarios, id));
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
       funcionariosService.deletarPorId(id);
    }



}
