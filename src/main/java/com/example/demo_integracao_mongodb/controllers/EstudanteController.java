package com.example.demo_integracao_mongodb.controllers;

import com.example.demo_integracao_mongodb.models.Estudante;
import com.example.demo_integracao_mongodb.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteRepository estudanteRepository;

    @PostMapping
    public void gravar(@RequestBody  Estudante estudante) {
        this.estudanteRepository.save(estudante);
    }

    @GetMapping
    public List<Estudante> buscarTodos() {
        return this.estudanteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Estudante buscarPorId(@PathVariable String id) {
        return this.estudanteRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Estudante estudante) {
        if (this.estudanteRepository.existsById(id)) {
            estudante.setId(id);
            this.estudanteRepository.save(estudante);
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        this.estudanteRepository.deleteById(id);
    }
}
